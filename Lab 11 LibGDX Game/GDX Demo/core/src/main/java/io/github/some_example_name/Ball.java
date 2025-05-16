package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Ball extends Sprite {
    private float speed = 3f;
    public Ball() {
        super(new Texture("ball.png"));
        setSize(1,1);
    }

    public void randomPosn(Viewport viewport)
    {
        float randomX = MathUtils.random(0,
            viewport.getWorldWidth() - getWidth());
        float randomY = MathUtils.random(0,
            viewport.getWorldHeight() - getHeight());
        setPosition(randomX, randomY);
    }

    public void update(Viewport v) {
        float delta = Gdx.graphics.getDeltaTime();
        if (getY() <=0 || getY() >= v.getWorldHeight() - getHeight())
        {
            speed = -1* speed;
        }
        translateY(speed*delta);
    }

}
