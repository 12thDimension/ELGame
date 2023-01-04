package com.mygdx.elgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    private int x;
    private int y;
    private int radius;
    private int xSpeed;
    private int ySpeed;
    private Color color = Color.WHITE;
    boolean collision = false;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.radius = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x < 0 + radius || x > Gdx.graphics.getWidth() - radius) {
            xSpeed = -xSpeed;
        }
        if (y < 0 + radius || y > Gdx.graphics.getHeight() - radius) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, radius);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean b) {
        this.collision = b;
    }
}