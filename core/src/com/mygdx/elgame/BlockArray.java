package com.mygdx.elgame;

import java.util.ArrayList;

public class BlockArray {
    ArrayList<Rectangle> blocks = new ArrayList<>();

    public BlockArray(int rows, int columns, int rowHeight, int screenWidth, int screenHeight) {
        int blockWidth = screenWidth / columns;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                blocks.add(new Rectangle(j * blockWidth, screenHeight - rows * i, blockWidth - 5, rowHeight - 5));
            }
        }
    }

    public ArrayList<Rectangle> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Rectangle> blocks) {
        this.blocks = blocks;
    }
    
}