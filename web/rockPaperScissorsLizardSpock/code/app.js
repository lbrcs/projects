//var createError = require('http-errors');
var mysql = require('mysql');
var express = require('express');
var session = require('express-session');
const bodyParser = require('body-parser');
var path = require('path');
require('dotenv').config();


const PORT = process.env.PORT || 3000;
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

app.use(session({
	secret: 'E9A488751056C39625035C3680F7C829',
	resave: true,
	saveUninitialized: true
}));
app.use(bodyParser.urlencoded({extended : true}));
app.use(bodyParser.json());

module.exports = app;

//LOGIN 
var connection = mysql.createConnection({
	host     : process.env.DB_HOST,
	user     : process.env.DB_USER,
	database : process.env.DB_NAME
});

/*app.get('/', function(request, response) {
	response.sendFile(path.join(__dirname + '/login.html'));
});*/

app.post('/auth', function(request, response) {
	var username = request.body.username;
	var password = request.body.password;
	if (username && password) {
		connection.query('SELECT * FROM accounts WHERE username = ? AND password = ?', [username, password], function(error, results, fields) {
			if (results.length > 0) {
				request.session.loggedin = true;
				request.session.username = username;
				response.redirect('/admin');
			} else {
				response.send('Incorrect Username and/or Password!' + "<br><button style='margin-top: 15px; width: 20%; padding: 15px; background-color: #7f8386; border: 0; box-sizing: border-box; cursor: pointer; font-weight: bold; color: #000000;' onclick='window.open(`leaderboard.html`, `_parent`)'>Back to Leaderboard</button>");
			}			
			response.end();
		});
	} else {
		response.send('Please enter Username and Password!');
		response.end();
	}
});

app.get('/admin', function(request, response) {
	if (request.session.loggedin) {
		response.sendFile(path.join(__dirname , "public/admin.html"));
        
	} else {
		response.send('Please login to view this page!' + "<br><button style='margin-top: 15px; width: 20%; padding: 15px; background-color: #7f8386; border: 0; box-sizing: border-box; cursor: pointer; font-weight: bold; color: #000000;' onclick='window.open(`leaderboard.html`, `_parent`)'>Back to Leaderboard</button>");
	}
});

// DATABASE CONNECTION INFO
const MongoClient = require('mongodb').MongoClient;

const url = 'mongodb+srv://LBRCSadmin:jtzGaty4Gu9Y9on3@lbrcscluster.l0qsr.mongodb.net/lbrcsCluster';
let db;

app.get('/', function(req, res) {
    res.send('RPSLS Leaderboard API');
 });

 (async () => {
    let client = await MongoClient.connect(
        url,
        { useNewUrlParser: true }
    );
 
    db = client.db('Players');
 
    app.listen(PORT, async function() {
        console.log(`Listening on Port ${PORT}`);
        if (db) {
            console.log('Database is Connected!');
        }
    });
 })();

 // CREATE NEW PLAYER
app.post('/players', async function(req, res) {
    // get information of player from POST body data
    let {username, score, computerScore, winRate} = req.body;

const alreadyExisting = await db
    .collection('players')
    .findOne({username:username});

if (alreadyExisting) {
    await db
        .collection('players')
        .updateOne({ username }, { $set: { username, score, computerScore, winRate } });
    console.log(`Player ${username} already existing. Score updated to ${score}`);
    res.send({ status: true, msg: 'user already existing - player score updated' });
} else {
    // create the new player
    await db.collection('players').insertOne({ username, score, computerScore, winRate });
    console.log(`Created Player ${username}`);
    res.send({ status: true, msg: 'player created' });
    }
 });

 // UPDATE PLAYER SCORE
app.put('/players', async function(req, res) {
    let { username, score, computerScore, winRate } = req.body;
    // check if the username already exists
    const alreadyExisting = await db
        .collection('players')
        .findOne({ username: username });
    if (alreadyExisting) {
        // Update player object with the username
        await db
            .collection('players')
            .updateOne({ username }, { $set: { username, score, computerScore, winRate } });
        console.log(`Player ${username} score updated to ${score}`);
        res.send({ status: true, msg: 'player score updated' });
    } else {
        res.send({ status: false, msg: 'player username not found' });
    }
 });

 // DELETE PLAYER ENTRY 
app.delete('/players', async function(req, res) {
    let { username, score, computerScore, winRate } = req.body;
    // check if the username already exists
    const alreadyExisting = await db
        .collection('players')
        .findOne({ username: username });
 
    if (alreadyExisting) {
        await db.collection('players').deleteOne({ username });
        console.log(`Player ${username} deleted`);
        res.send({ status: true, msg: 'player deleted' });
    } else {
        res.send({ status: false, msg: 'username not found' });
    }
 });

 // ACCESSING LEADERBOARD
app.get('/players', async function(req, res) {
    // retrieve ‘lim’ from the query string info
    let { lim } = req.query;
    db.collection('players')
        .find()
        // -1 is for descending and 1 is for ascending
        .sort({ winRate: -1 })
        // Show only [lim] players
        .limit(parseInt(lim))
        .toArray(function(err, result) {
            if (err)
                res.send({ status: false, msg: 'failed to retrieve players' });
            console.log(Array.from(result));
            res.send({ status: true, msg: result });
        });
 });


 
 