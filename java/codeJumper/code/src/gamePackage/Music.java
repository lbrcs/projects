package gamePackage;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/***************************************************************************************
* 	@Authors: Esam Ahmed & Martin Eidler
* 	Date: 05-08-2021
***************************************************************************************/

/***************************************************************************************
*	Music taken from: 
*   Title: 8-bit Arcade - Fighting Dudes
*   Author: Frequently Asked Music
*   Availability: https://motionarray.com/royalty-free-music/8-bit-arcade-fighting-dudes-216339 
*   (royalty free music)
***************************************************************************************/

public class Music {
	
	public Clip clip;
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
    //https://materiamusicpub.com/youtube-faq/
	
    public void playSound() {
    	logger.setLevel(Level.ALL);
    	logger.getParent().getHandlers()[0].setLevel(Level.ALL);
    	
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("music/8-bit Arcade.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            int volume = 75;																		
            float range = control.getMinimum();
            float result = range * (1 - volume / 100.0f);			// reduces music volume
            control.setValue(result);
            clip.start();
            
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch(Exception ex) {
            ex.printStackTrace();
            logger.warning("There is a problem with the background music. Please check for correct file location (inside folder 'music').");
        }
    }
    
	public void stopSound() {
		clip.stop();
		clip.close();
		
	}
	
}
