package com.mygdx.elgame;

public class Block extends Rectangle{
    boolean destroyed = false;

    public Block(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}