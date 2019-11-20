package com.star.app.game;

public class GameController {
    private Background background;
    private BulletController bulletController;
    private Ship ship;
    private AsteroidController asteroidController;

    public BulletController getBulletController() {
        return bulletController;
    }

    public Background getBackground() {
        return background;
    }

    public Ship getShip() {
        return ship;
    }

    public AsteroidController getAsteroidController() {
        return asteroidController;
    }

    public GameController() {
        this.background = new Background(this);
        this.ship = new Ship(this);
        this.bulletController = new BulletController();
        this.asteroidController = new AsteroidController();
    }

    public void update(float dt) {
        background.update(dt);
        ship.update(dt);
        bulletController.update(dt);
        asteroidController.update(dt);
//        checkCollisions();
    }

    // Заготовка под столкновение с астероидами (для ДЗ)
//    public void checkCollisions() {
//        for (int i = 0; i < asteroidController.getActiveList().size(); i++) {
//            Asteroid b = asteroidController.getActiveList().get(i);
//            if () { // 32.0f - примерно радиус корабля
//                // b.deactivate();
//                // считаем что столкнулись
//            }
//        }
//    }
}
