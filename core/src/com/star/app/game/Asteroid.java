package com.star.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.screen.ScreenManager;

public class Asteroid {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;

    public Asteroid() {
        this.texture = new Texture("C:\\Users\\moliv\\OneDrive\\Рабочий стол\\StarGame\\core\\assets\\asteroid.png");
        this.position = new Vector2(MathUtils.random(128, ScreenManager.SCREEN_WIDTH), 0);
        this.velocity = new Vector2(MathUtils.random(0), MathUtils.random(100, 1000));
    }

    public void render(SpriteBatch batch) {

        batch.draw(texture, position.x, position.y - 128, 128, 128, 256, 256, 0.5f, 0.5f, 0, 0, 0, 256, 256, false, false);
    }

    public void update(float dt) {
        position.y += velocity.y * dt;
        if (position.y > ScreenManager.SCREEN_HEIGHT + 128) {
            position.x = MathUtils.random(128, ScreenManager.SCREEN_WIDTH - 128);
            position.y = -50;
            velocity.y = (float) MathUtils.random(100, 1000);
        }

    }


}
