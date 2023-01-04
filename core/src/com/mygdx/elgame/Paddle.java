package com.mygdx.elgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    float width;
    float height = 10;
    int x;
    int y;

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
}