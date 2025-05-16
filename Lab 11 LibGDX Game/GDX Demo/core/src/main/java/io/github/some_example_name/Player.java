package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player extends Sprite {
    private float speed = 1.5f;
    private float velocityY = 0f;
    private final float gravity = -9.81f;
    private final float jumpVelocity = 5f;
    private boolean isGrounded = true;

    public Player() {
        super(new Texture("dog.png"));
        setSize(1,1);
    }

    public void input(Viewport viewport) {

        float delta = Gdx.graphics.getDeltaTime();

        /// MOVE RIGHT
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ||
            Gdx.input.isKeyPressed(Input.Keys.D)) {
            translateX(speed * delta);
        }
        /// MOVE LEFT
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
            Gdx.input.isKeyPressed(Input.Keys.A)) {
            translateX(-speed*delta);
        }

        /// JUMP USING SPACE
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && isGrounded) {
            velocityY = jumpVelocity;
            isGrounded = false;
        }

        /// JUMP USING UP
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && isGrounded) {
            velocityY = jumpVelocity;
            isGrounded = false;
        }

        velocityY += gravity * delta;
        this.translateY(velocityY * delta);
        // Check if you reached the ground at 0
        if (this.getY() <= 0) {
            this.setY(0);
            velocityY = 0;
            isGrounded = true;
        }

        this.setX(MathUtils.clamp(this.getX(),
            0, viewport.getWorldWidth() - this.getWidth()));
    }




}
