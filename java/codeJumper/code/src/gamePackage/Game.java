package gamePackage;

import java.awt.Color;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;


import themes.Theme;
import themes.Jungle;
import themes.Desert;
import themes.Underwater;
import themes.Ice;
import themes.Volcano;
import themes.Graveyard;
import themes.Space;

import difficulties.Difficulty;
import difficulties.Normal;
import difficulties.Easy;
import difficulties.Hard;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

/***************************************************************************************
*	Methods inspired by:
*   Title: Programming Flappy Bird in Java! (Full Tutorial)
*   Author: Jaryt Bustard
*   Date: 25-01-2015
*   Availability: https://www.youtube.com/watch?v=I1qTZaUcFX0
*   
*   Background Pictures taken from:
*   Availability: www.freepik.com
*   Creators: valadzionak_volha (Jungle), brgfx (Desert, Ice, Volcano), upklyak (Underwater), macrovector (Graveyard), vectorpouch (Space)
*   
*   Player avatars taken from:
*   Availability: www.flaticon.com
*   Creators: xnimrodx (Ghost), Icongeek26 (Dragon), Flat Icons (Turtle), Freepik (Penguin, Monkey, Rocket, Vulture)
*   
*   Icons taken from:
*   Availability: www.flaticon.com
*   Creators: itim2101 (App icon), Freepik (Music icons)
***************************************************************************************/

public class Game extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

    private int WIDTH, HEIGHT, ticks, yMotion;
    private double score, previousScore, highScore;
    private Rectangle player;
    private ArrayList<Rectangle> columns;
    private Random random;
    private boolean gameOver, gameStarted, monkey=true, vulture, turtle, penguin, dragon, ghost, rocket;

    private Theme theme = new Jungle();
    private Difficulty difficulty = new Normal();
    private BufferedImage playerImage;
    private List<Double> playerScores = new ArrayList<Double>();
    
    Music music = new Music();
    Image iconImage = new ImageIcon(this.getClass().getResource("/Icon.png")).getImage();
    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //  CONSTRUCTOR

    public Game(int WIDTH, int HEIGHT) {
    	logger.setLevel(Level.ALL);
    	logger.getParent().getHandlers()[0].setLevel(Level.ALL);
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        
     	try {
			playerImage = ImageIO.read(new File("img/Monkey.png"));
		} catch (IOException e) {
			e.printStackTrace();
			logger.severe("Starting avatar not found. Please check for correct file location (inside folder 'img').");
		}

    }

    // METHODS
    
    // create game window, UI and initialize the game
    public void newGame(){
        JFrame jframe = new JFrame();
        Timer timer = new Timer(1, this);
        logger.setLevel(Level.ALL);
    	logger.getParent().getHandlers()[0].setLevel(Level.ALL);

        random = new Random();

        jframe.add(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setIconImage(iconImage); 
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setResizable(false);
        jframe.setTitle("Code Jumper Version 1.0");
        jframe.setVisible(true);
        jframe.addKeyListener(this);
        jframe.setState(Frame.ICONIFIED);
       
        
		JLabel lblNewLabel = new JLabel("Image");
		lblNewLabel.setBounds(0, 0, 1186, 831);
		Image jungleImage = new ImageIcon(this.getClass().getResource("/Jungle.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(jungleImage));
		jframe.getContentPane().add(lblNewLabel);
        
		//Create menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		jframe.setJMenuBar(menuBar);
		
		//Create Difficulty menu within menu bar 
		JMenu mnNewMenu = new JMenu("Difficulty");
		mnNewMenu.setBackground(Color.WHITE);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		//Create menu item
		JMenuItem mntmNewMenuItem = new JMenuItem("Easy");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = new Easy();
			}
		});
		mntmNewMenuItem.setBackground(Color.WHITE);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.add(mntmNewMenuItem);
		
		
		//Create menu item
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Normal");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = new Normal();
			}
		});
		mntmNewMenuItem_1.setBackground(Color.WHITE);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		//Create menu item
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Hard");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = new Hard();
			}
		});
		mntmNewMenuItem_2.setBackground(Color.WHITE);
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		
		//Create Music menu within menu bar
		JMenu mnNewMenu_1 = new JMenu("Music");
		mnNewMenu_1.setBackground(Color.WHITE);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		//Create menu item with image 
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("ON");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				music.playSound();
			}
		});
		mntmNewMenuItem_3.setBackground(Color.WHITE);
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		Image audioImage = new ImageIcon(this.getClass().getResource("/Music-ON.png")).getImage();
		mntmNewMenuItem_3.setIcon(new ImageIcon(audioImage));
		mntmNewMenuItem_3.setSelectedIcon(null);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		//Create menu item with image 
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("OFF");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				music.stopSound();
			}
		});
		mntmNewMenuItem_4.setBackground(Color.WHITE);
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 17));
		Image muteImage = new ImageIcon(this.getClass().getResource("/Music-OFF.png")).getImage();
		mntmNewMenuItem_4.setIcon(new ImageIcon(muteImage));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		////Create Themes menu within menu bar
		JMenu mnNewMenu_2 = new JMenu("Themes");
		mnNewMenu_2.setBackground(Color.WHITE);
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(mnNewMenu_2);
		
		//Create menu item with image and ActionListener with the method to change the background-image of the label
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Jungle");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image jungleImage = new ImageIcon(this.getClass().getResource("/Jungle.jpg")).getImage();
				lblNewLabel.setIcon(new ImageIcon(jungleImage));
				theme = new Jungle();

		     	try {
					playerImage = ImageIO.read(new File("img/Monkey.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
					logger.warning("Intended avatar could not be found! Please check for correct file location (inside folder 'img'). Using previous avatar.");
				}
		        monkey=true;
		        vulture=false;
		        turtle=false;
		        penguin=false;
		        dragon=false;
		        ghost=false;
		        rocket=false;
			}
		});
		mntmNewMenuItem_5.setBackground(Color.WHITE);
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		//Create menu item with image and ActionListener with the method to change the background-image of the label
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Desert");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			Image desertImage = new ImageIcon(this.getClass().getResource("/Desert.jpg")).getImage();
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setIcon(new ImageIcon(desertImage));
				theme = new Desert();
		     	try {
					playerImage = ImageIO.read(new File("img/Vulture.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
					logger.warning("Intended avatar could not be found! Please check for correct file location (inside folder 'img'). Using previous avatar.");
				}
		        monkey=false;
		        vulture=true;
		        turtle=false;
		        penguin=false;
		        dragon=false;
		        ghost=false;
		        rocket=false;
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mntmNewMenuItem_6.setBackground(Color.WHITE);
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		//Create menu item with image and ActionListener with the method to change the background-image of the label
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Underwater");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image underwaterImage = new ImageIcon(this.getClass().getResource("/Underwater.jpg")).getImage();
				lblNewLabel.setIcon(new ImageIcon(underwaterImage));
				theme = new Underwater();
		     	try {
					playerImage = ImageIO.read(new File("img/Turtle.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
					logger.warning("Intended avatar could not be found! Please check for correct file location (inside folder 'img'). Using previous avatar.");
				}
		        monkey=false;
		        vulture=false;
		        turtle=true;
		        penguin=false;
		        dragon=false;
		        ghost=false;
		        rocket=false;
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mntmNewMenuItem_7.setBackground(Color.WHITE);
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		//Create menu item with image and ActionListener with the method to change the background-image of the label
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Ice");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image iceImage = new ImageIcon(this.getClass().getResource("/Ice.jpg")).getImage();
				lblNewLabel.setIcon(new ImageIcon(iceImage));
				theme = new Ice();
		     	try {
					playerImage = ImageIO.read(new File("img/Penguin.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
					logger.warning("Intended avatar could not be found! Please check for correct file location (inside folder 'img'). Using previous avatar.");
				}
		        monkey=false;
		        vulture=false;
		        turtle=false;
		        penguin=true;
		        dragon=false;
		        ghost=false;
		        rocket=false;
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mntmNewMenuItem_9.setBackground(Color.WHITE);
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		//Create menu item with image and ActionListener with the method to change the background-image of the label
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Volcano");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image volcanoImage = new ImageIcon(this.getClass().getResource("/Volcano.jpg")).getImage();
				lblNewLabel.setIcon(new ImageIcon(volcanoImage));
				theme = new Volcano();
		     	try {
					playerImage = ImageIO.read(new File("img/Dragon.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
					logger.warning("Intended avatar could not be found! Please check for correct file location (inside folder 'img'). Using previous avatar.");
				}
		        monkey=false;
		        vulture=false;
		        turtle=false;
		        penguin=false;
		        dragon=true;
		        ghost=false;
		        rocket=false;
			}
		});
		mntmNewMenuItem_8.setBackground(Color.WHITE);
		mntmNewMenuItem_8.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		//Create menu item with image and ActionListener with the method to change the background-image of the label
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Graveyard");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			Image graveyardImage = new ImageIcon(this.getClass().getResource("/Graveyard.jpg")).getImage();
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setIcon(new ImageIcon(graveyardImage));
				theme = new Graveyard();
		     	try {
					playerImage = ImageIO.read(new File("img/Ghost.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
					logger.warning("Intended avatar could not be found! Please check for correct file location (inside folder 'img'). Using previous avatar.");
				}
		     	monkey=false;
		        vulture=false;
		        turtle=false;
		        penguin=false;
		        dragon=false;
		        ghost=true;
		        rocket=false;
			}
		});
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mntmNewMenuItem_10.setBackground(Color.WHITE);
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		//Create menu item with image and ActionListener with the method to change the background-image of the label
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Space");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image spaceImage = new ImageIcon(this.getClass().getResource("/Space.jpg")).getImage();
				lblNewLabel.setIcon(new ImageIcon(spaceImage));
				theme = new Space();
		     	try {
					playerImage = ImageIO.read(new File("img/Rocket.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
					logger.warning("Intended avatar could not be found! Please check for correct file location (inside folder 'img'). Using previous avatar.");
				}
		     	monkey=false;
		        vulture=false;
		        turtle=false;
		        penguin=false;
		        dragon=false;
		        ghost=false;
		        rocket=true;
			}
		});
		mntmNewMenuItem_11.setBackground(Color.WHITE);
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		/*
		//Create Name menu within menu bar
		JMenu mnNewMenu_3 = new JMenu("Name");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu_3.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu_3);
		
		//Create menu item
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Rename Player");
		mntmNewMenuItem_12.setBackground(Color.WHITE);
		mntmNewMenuItem_12.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu_3.add(mntmNewMenuItem_12);
		*/
        
		
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// create player character (hitbox only! change last to values for hitbox size)
        player = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 40, 60, 60);
        
        // create new list for obstacles
        columns = new ArrayList<>();

        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);

        timer.start();

    }

    // obstacle creation - startpoint + endpoint, width/height define hitbox size
    public void addColumn(boolean start) {
    	int spaceModifier = difficulty.setObstacleGapWidthValue();
        int space = spaceModifier - random.nextInt(20);		// space beetween top and bottom obstacle
        int width = 100;
        int heightModifier = difficulty.setObstacleGapPlacementValue();
        int height = 50 + random.nextInt(heightModifier);		// location of empty space along y-axis
        
        if(start) {
            columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 170, width, height));		// bottom obstacle
            columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space)); 	// top obstacle
        } else {
            columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 170, width, height));	// follow-up bottom obstacles after initial obstacles
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));			// follow-up top obstacles after initial obstacles
        }
    }

    // obstacle colorization
    public void paintColumn(Graphics g, Rectangle column) {
    	//Jungle jungle = new Jungle();
    	//Color obstacleOne = new Color(107, 65, 5);
    	Color obstacle = theme.setObstacle();
        g.setColor(obstacle);
        g.fillRect(column.x, column.y, column.width, column.height); 			// obstacle colors
        g.setColor(Color.black);												// obstacle border colors 
        g.fillRect(column.x, column.y + column.height-8, column.width+8, 8);
        g.setColor(Color.black);
        g.fillRect(column.x, column.y, column.width, 8);
        g.setColor(Color.black);
        g.fillRect(column.x, column.y, 8, column.height);
        g.setColor(Color.black);
        g.fillRect(column.x + column.width, column.y, 8, column.height);
    }

    // logic behind every player jump (when space bar is pressed) and restart (hitting space while game is over)
    public void jump() {		
        if (gameOver) {
            player = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 40, 60, 60);
            playerScores.add(score/2);
            columns.clear();			// obstacle arraylist gets cleared
            previousScore = score/2;	// score gets stored under "previousscore"
            score = 0;					// new score gets set to 0
            yMotion = 0;				// variable that is used for bird movement up/down gets set to 0
            highScore = Collections.max(playerScores);
            
            addColumn(true);
            addColumn(true);
            addColumn(true);
            addColumn(true);

            if (monkey) {
            	  try {
      				playerImage = ImageIO.read(new File("img/Monkey.png"));
      			} catch (IOException e1) {
      				e1.printStackTrace();
      				logger.severe("Intended avatar could not be found!");
      			}
  			} else if (vulture) {
            	  try {
      				playerImage = ImageIO.read(new File("img/Vulture.png"));
      			} catch (IOException e1) {
      				e1.printStackTrace();
      				logger.severe("Intended avatar could not be found!");
      			}
  			} else if (turtle) {
  				try {
      				playerImage = ImageIO.read(new File("img/Turtle.png"));
      			} catch (IOException e1) {
      				e1.printStackTrace();
      				logger.severe("Intended avatar could not be found!");
      			} 
  			} else if (penguin) {
				try {
      				playerImage = ImageIO.read(new File("img/Penguin.png"));
      			} catch (IOException e1) {
      				e1.printStackTrace();
      				logger.severe("Intended avatar could not be found!");
      			} 
  			} else if (dragon) {
				try {
      				playerImage = ImageIO.read(new File("img/Dragon.png"));
      			} catch (IOException e1) {
      				e1.printStackTrace();
      				logger.severe("Intended avatar could not be found!");
      			} 
  			} else if (ghost) {
  				try {
      				playerImage = ImageIO.read(new File("img/Ghost.png"));
      			} catch (IOException e1) {
      				e1.printStackTrace();
      				logger.severe("Intended avatar could not be found!");
      			} 
  			} else if (rocket) {
  				try {
      				playerImage = ImageIO.read(new File("img/Rocket.png"));
      			} catch (IOException e1) {
      				e1.printStackTrace();
      				logger.severe("Intended avatar could not be found!");
      			}
  			
  			}
            
            gameOver = false;
        }

        if (!gameStarted) {
            gameStarted = true;
     
          
        }

        if (yMotion > 0) {				// moves bird position back to 0
            yMotion = 0;
        }
        int yMotionModifier = difficulty.setPlayerJumpHeightValue();
        yMotion -= yMotionModifier;					// makes player "jump" 14px when space is pressed
        
    }

    // fill previously generated rectangles with color
    public void repaint(Graphics g) {
    	Color[] groundArray = theme.setGround();
    	Color ground = groundArray[0];
    	Color groundTop = groundArray[1];

        g.setColor(ground);
        g.fillRect(0, HEIGHT - 150, WIDTH, 150);

        g.setColor(groundTop);
        g.fillRect(0, HEIGHT - 170, WIDTH, 20);
        
        //player rectangle colorization
        /*g.setColor(Color.red);
        g.fillRect(player.x, player.y, player.width, player.height);*/


        // draw image on rectangle
        g.drawImage(playerImage, player.x, player.y, null);
        
        //for-each loop for the colorization of the obstacle rectangles (for-each because they are stored inside an arraylist)
        for (Rectangle column : columns) {
            paintColumn(g, column);
        }

        // text + numbers for point counter
        if (gameStarted || !gameOver) {
            g.setColor(Color.white);
            g.setFont(new Font("Bauhaus 93", 1, 35));
            g.drawString("Your points: " + score/2, WIDTH - 1900, HEIGHT - 116);
            g.setFont(new Font("Bauhaus 93", 1, 35));
            g.drawString("Your High Score: " + highScore, WIDTH - 1140, HEIGHT - 116);   
            g.setFont(new Font("Bauhaus 93", 1, 35));
            g.drawString("Your previous points: " + previousScore, WIDTH - 450, HEIGHT - 116);   
        }

        // "death" screen - colorization + text 
        if (gameOver) {
        	/*g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT - 150);*/		// death screen color
        	
            g.setColor(Color.red);
            g.setFont(new Font("Times New Roman", 1, 100));
            g.drawString("YOU DIED", WIDTH / 2 - 240, HEIGHT / 2 - 90);
            g.setColor(Color.red);
            g.setFont(new Font("Times New Roman", 1, 40));
            g.drawString("Press Space to try again", WIDTH / 2 - 200, HEIGHT / 2);
	     	
            try {
				playerImage = ImageIO.read(new File("img/Coffin.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.warning("Image representing game over state not found.");
			}
            
        }

    }

    // character movement logic | game tempo logic | obstacle creation/deletion 
    // actionPerformed method gets never called directly but defines what happens, when the action - in this case the game panel gets created - is performed.
    @Override
    public void actionPerformed(ActionEvent e) {
    	int tempoModifier = difficulty.setGameTempoValue();
        int tempo = tempoModifier;		// obstacle speed 
        ticks++;

        if(gameStarted) {
            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);
                column.x -= tempo;
            }

            if (ticks % 2 == 0 && yMotion < 15) {	// character movement up/down
                yMotion += 2;				
            }

            for (int i = 0; i < columns.size(); i++) {		
                Rectangle column = columns.get(i);
                if (column.x + column.width <= 0) {
                    columns.remove(column);				// remove obstacles on the left side
                    if (column.y == 0) {                    
                        addColumn(false);				// create obstacles on the right side
                    }
                }
            }

            player.y += yMotion;

            // point counter - if player crosses space between obstacles --> 1 point!
            for (Rectangle column : columns) {
            	double pointsMultiplier = difficulty.setMultiplierValue();
            	
            	if(tempo == 5) {
            		if (player.x + player.width / 2 > column.x + column.width / 2 - 5 && player.x + player.width / 2 < column.x + column.width / 2 + 5) {
            			score += 1*pointsMultiplier;
            		}
            	} else if (player.x + player.width / 2 > column.x + column.width / 2 - 10 && player.x + player.width / 2 < column.x + column.width / 2 + 10) {
            		score += 1*pointsMultiplier;
                }
                if (column.intersects(player)) {
                	gameOver = true;
                	player.x = column.x - (player.width);
                }     
            }
      

            if (player.y < 0 || player.y > HEIGHT - 230) {   	// if player touches window borders --> game over
                gameOver = true;
                if (player.y < 0) {
                    player.y = 0;
                } else if (player.y > HEIGHT - 230) {
                    player.y = HEIGHT -230;
                }
            }
        }

        this.repaint();				// implement background image and player + obstacle movement
        this.setOpaque(false);		// make background of panel transparent
        this.setSize(WIDTH, HEIGHT);
    }
    
    // method to draw on screen. is never called directly, will be called by the system. Graphics object = argument of the method and the 'drawing canvas' that will be displayed. 
    // to ask the system to refresh the display we need to call the repaint() method.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.repaint(g);			// implement player + obstacle movement
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){	// key action listenener --> SPACE = character jump
            jump();
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
