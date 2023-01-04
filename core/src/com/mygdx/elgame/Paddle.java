package com.mygdx.elgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    private float width;
    private float height = 10;
    private int x;
    private int y;

    public Paddle(float size) {
        this.width = size;
    }

    public void draw(ShapeRenderer shape) {
        x = Gdx.input.getX();
        y = -Gdx.input.getY() + Gdx.graphics.getHeight();
        int screenWidth = Gdx.graphics.getWidth();

        if (x > screenWidth - width) {
            shape.rect(screenWidth - width, y, width, height);
        } else {
            shape.rect(x, y, width, height);
        }

    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
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
}