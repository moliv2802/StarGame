package com.star.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ship {
    private Texture texture;
    private Vector2 position;
    private Vector2 lastDisplacement;
    private float angle;

    public Vector2 getLastDisplacement() {
        return lastDisplacement;
    }

    public Ship() {
        this.texture = new Texture("C:\\Users\\moliv\\OneDrive\\Рабочий стол\\StarGame\\core\\assets\\ship.png");
        this.position = new Vector2(640, 360);
        this.lastDisplacement = new Vector2(0, 0);
        this.angle = 0.0f;
    }

    public void render(SpriteBatch batch) {

        batch.draw(texture, position.x - 32, position.y - 32, 32, 32, 64, 64, 1, 1, angle, 0, 0, 64, 64, false, false); //рисуем корабль с поворотом

    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angle += 180.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angle -= 180.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.x += (float) Math.cos(Math.toRadians(angle)) * 240.f * dt;
            position.y += (float) Math.sin(Math.toRadians(angle)) * 240.f * dt;
            lastDisplacement.set((float) Math.cos(Math.toRadians(angle)) * 240.f * dt, (float) Math.sin(Math.toRadians(angle)));
        } else {
            lastDisplacement.set(0, 0);
        }
        if (position.x < 0.0f) {                           // блокировка на границе экрана
            position.x = 0.0f;
        }
        if (position.x > ScreenManager.SCREEN_WIDTH) {
            position.x = ScreenManager.SCREEN_WIDTH;
        }
        if (position.y < 0.0f) {
            position.y = 0.0f;
        }
        if (position.y > ScreenManager.SCREEN_HEIGHT) {
            position.y = ScreenManager.SCREEN_HEIGHT;
        }


    }


}
