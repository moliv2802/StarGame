package com.star.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Background background;
    private Ship ship;

    public Ship getShip() {
        return ship;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Background(this);
        ship = new Ship();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch);
        ship.render(batch);
        batch.end();
    }

    public void update(float dt) {
        background.update(dt);
        ship.update(dt);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
