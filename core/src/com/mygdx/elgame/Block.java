package com.mygdx.elgame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block extends Rectangle {
    int x, y, width, height;

    public Block(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}