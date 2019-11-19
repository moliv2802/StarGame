package com.star.app.game;

public class GameController {
    private Background background;
    private BulletController bulletController;
    private Ship ship;

    public BulletController getBulletController() {
        return bulletController;
    }

    public Background getBackground() {
        return background;
    }

    public Ship getShip() {
        return ship;
    }

    public GameController() {
        this.background = new Background(this);
        this.ship = new Ship(this);
        this.bulletController = new BulletController();
    }

    public void update(float dt) {
        background.update(dt);
        ship.update(dt);
        bulletController.update(dt);
        checkCollisions();
    }

    // Заготовка под столкновение с астероидами (для ДЗ)
    public void checkCollisions() {
        for (int i = 0; i < bulletController.getActiveList().size(); i++) {
            Bullet b = bulletController.getActiveList().get(i);
            if (ship.getPosition().dst(b.getPosition()) < 32.0f) { // 32.0f - примерно радиус корабля
                // b.deactivate();
                // считаем что столкнулись
            }
        }
    }
}
