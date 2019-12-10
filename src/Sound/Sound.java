package Sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    public static Clip clip;
    public static final File backgroundSound = new File("res/sound/BackgroundSound.wav");
    public static final File mouseClickSound = new File("res/sound/MouseClickSound.mp3");
    public static final File normalBullet = new File("res/sound/NormalTowerSound.wav");
    public static final File machineBullet = new File("res/sound/MachineGunTowerSound.wav");
    public static final File sniperBullet = new File("res/sound/SniperTowerSound.wav");

    public static void play(File file){
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
