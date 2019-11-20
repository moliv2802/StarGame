package com.star.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.helpers.Poolable;
import com.star.app.screen.ScreenManager;

public class Asteroid implements Poolable {
    private Vector2 position;
    private Vector2 velocity;

    public Vector2 getPosition() {
        return position;
    }

    private boolean active;

    @Override
    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }


    public Asteroid() {

        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        this.active = false;
    }


    public void activate(float x, float y, float vx, float vy) {
        position.set(x, y);
        velocity.set(vx, vy);
        active = true;
    }


    public void update(float dt) {
        position.y += (float) MathUtils.random(100, 1000) * dt;

        if (position.y > ScreenManager.SCREEN_HEIGHT + 128) {
            position.x = MathUtils.random(128, ScreenManager.SCREEN_WIDTH - 128);
            position.y = -50;
            velocity.y = (float) MathUtils.random(100, 1000);

        }

    }


}
