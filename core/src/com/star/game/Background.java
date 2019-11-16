package com.star.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private class Star {
        private Vector2 position;
        private Vector2 velocity;

        public Star() {
            this.position = new Vector2(MathUtils.random(0, ScreenManager.SCREEN_WIDTH), MathUtils.random(0, ScreenManager.SCREEN_HEIGHT));
            this.velocity = new Vector2(MathUtils.random(-40, -5), MathUtils.random(0));
        }

        public void update(float dt) {
            position.x += velocity.x * dt;
            position.y += velocity.y * dt;
            if (position.x < -20) { // возвращение звезды в начало
                position.x = ScreenManager.SCREEN_WIDTH + 20;
                position.y = MathUtils.random(0, ScreenManager.SCREEN_HEIGHT); // появление звезды рандомно в начале
            }
        }

    }

    private Texture textureCosmos;
    private Texture textureStar;
    private final int STARS_COUNT = 600;
    private Star[] stars;

    public Background() {
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
            float scl = 1f; //масштаб звезды
            batch.draw(textureStar, stars[i].position.x - 8, stars[i].position.y - 8, 8, 8, 16, 16, scl, scl, 0, 0, 0, 16, 16, false, false);

        }

    }

    public void update(float dt) {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(dt);
        }

    }


}
