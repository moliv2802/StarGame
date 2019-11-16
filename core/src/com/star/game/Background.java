package com.star.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private class Star {
        private Vector2 position;
        private Vector2 velocity;
        private float scale; //масштаб звезды

        public Star() {
            this.position = new Vector2(MathUtils.random(0, ScreenManager.SCREEN_WIDTH), MathUtils.random(-200, ScreenManager.SCREEN_HEIGHT + 200));
            this.velocity = new Vector2(MathUtils.random(-40, -5), MathUtils.random(0));
            this.scale = Math.abs(velocity.x) / 40.0f * 0.7f;
        }

        public void update(float dt) {
            position.x += (velocity.x - game.getShip().getLastDisplacement().x * 15.0f) * dt; // движение звезд со смещением относительно корабля
            position.y += (velocity.y - game.getShip().getLastDisplacement().y * 15.0f) * dt;
            if (position.x < -20) { // возвращение звезды в начало
                position.x = ScreenManager.SCREEN_WIDTH + 20;
                position.y = MathUtils.random(-200, ScreenManager.SCREEN_HEIGHT + 200);// появление звезды рандомно в начале
                scale = Math.abs(velocity.x) / 40.0f * 0.7f; // скорость в зависимости от масштаба
            }
        }

    }

    private Texture textureCosmos;
    private Texture textureStar;
    private final int STARS_COUNT = 600;
    private StarGame game;
    private Star[] stars;

    public Background(StarGame game) {
        this.game = game;
        this.textureCosmos = new Texture("C:\\Users\\moliv\\OneDrive\\Рабочий стол\\StarGame\\core\\assets\\bg.png");
        this.textureStar = new Texture("C:\\Users\\moliv\\OneDrive\\Рабочий стол\\StarGame\\core\\assets\\star16.png");
        this.stars = new Star[STARS_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureCosmos, 0, 0);
        for (int i = 0; i < stars.length; i++) {

            batch.draw(textureStar, stars[i].position.x - 8, stars[i].position.y - 8, 8, 8, 16, 16, stars[i].scale, stars[i].scale, 0, 0, 0, 16, 16, false, false);
            if (MathUtils.random(0, 350) < 2) {
                batch.draw(textureStar, stars[i].position.x - 8, stars[i].position.y - 8, 8, 8, 16, 16, stars[i].scale * 2, stars[i].scale * 2, 0, 0, 0, 16, 16, false, false); //мигание
            }

        }

    }

    public void update(float dt) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(dt);


        }

    }


}
