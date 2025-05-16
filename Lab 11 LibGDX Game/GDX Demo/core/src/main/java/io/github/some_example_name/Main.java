package io.github.some_example_name;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.viewport.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main implements ApplicationListener {

    private Texture dogImage;
    private Texture background;
    private FitViewport viewport;
    //private Sprite dog;
    private Player dog;
    private SpriteBatch spriteBatch;
    private Ball ball;


    @Override
    public void create() {
        /// Prepare your application here.
        //dogImage = new Texture("dog.png");
        //dog = new Sprite(dogImage);
        //dog.setSize(1,1);
        dog = new Player();
        ball = new Ball();
        background = new Texture("background-clouds.jpg");
        viewport = new FitViewport(8, 5);  // 8x5 units
        spriteBatch = new SpriteBatch();
        playSound("Alternate Mix/Kara Square - 8-Bit Side-Scrolling Action (No Drums).wav");

    }

    @Override
    public void resize(int width, int height) {
        // Resize your application here. The parameters represent the new window size.
        viewport.update(width, height, true);

    }

    @Override
    public void render() {
        onCollision();
        // Draw your application here.
        ScreenUtils.clear(Color.BLACK);
        //move();
        dog.input(viewport);
        ball.update(viewport);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0,
            viewport.getWorldWidth(), viewport.getWorldHeight());
        dog.draw(spriteBatch);
        ball.draw(spriteBatch);
        spriteBatch.end();

    }

    public void onCollision() {
        Rectangle dogHitbox = dog.getBoundingRectangle();
        Rectangle battHitbox = ball.getBoundingRectangle();
        if (dogHitbox.overlaps(battHitbox))
        {
            System.out.println("Collision");
            ball.randomPosn(viewport);
            playSound("PP_Explosion_1_1.wav");
        }
    }

    ////////////////////////////PlaySound Function
    private void playSound(String soundFile) {
        try {
            File audioFile = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Adjust the volume
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-15.0f); // Reduce volume by decibels
            System.out.println("Sound Played"); /// Console logging purposes

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }



    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void dispose() {
        // Destroy application's resources here.
    }
}
