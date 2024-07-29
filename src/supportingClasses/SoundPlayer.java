/**
 *
 * Member A:    Muhammad Aril Bin Mohamed Irwan (P2323275)
 * Member B:    See Yong Hong (P2323473)
 * Class:       DIT/FT/2B/21
 * 
 */

package supportingClasses;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;


public class SoundPlayer {
    public void playSound(String soundFile) {
        try {
            // Using ClassLoader to get the resource as a stream
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream audioSource = classLoader.getResourceAsStream(soundFile);

            if (audioSource == null) {
                System.out.println("File not found: " + soundFile);
                return;
            }

            // Convert the input to a BufferedInputStream
            InputStream bufferedInput = new java.io.BufferedInputStream(audioSource);

            // Get an audio input from the buffered input
            AudioInputStream soundStream = AudioSystem.getAudioInputStream(bufferedInput);

            // Get a clip resource
            Clip sound = AudioSystem.getClip();

            // Open the clip and load samples from the audio input stream
            sound.open(soundStream);

            // Start playing the audio clip
            sound.start();

            // Keep the program running to allow the music to play
            while (sound.isRunning()) {
                Thread.sleep(1000);
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
