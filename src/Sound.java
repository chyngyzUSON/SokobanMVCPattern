import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    public Clip load(String file) {
        Clip clip = null;
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource(file));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            System.out.println(e);
        }
        return clip;
    }

    public void play(Clip clip) {
        clip.start();
    }

    public void loop(Clip clip) {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(Clip clip) {
        clip.stop();
    }
}
