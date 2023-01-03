package com.mygdx.elgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    float size;
    float height = 10;

    public Paddle(float size) {
        this.size = size;
    }

    public void draw(ShapeRenderer shape) {
        int x = Gdx.input.getX();
        int y = -Gdx.input.getY() + Gdx.graphics.getHeight();
        int width = Gdx.graphics.getWidth();

        if (x > width - size) {
            shape.rect(width - size, y, size, height);
        } else {
            shape.rect(x, y, size, height);
        }

    }
}