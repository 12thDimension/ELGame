package com.mygdx.elgame;

import java.util.ArrayList;

public class BlockArray {
    ArrayList<Block> blocks = new ArrayList<>();

    public BlockArray(int rows, int columns, int rowHeight, int screenWidth, int screenHeight) {
        int blockWidth = screenWidth / columns;

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < columns; j++) {
                blocks.add(new Block(j * blockWidth, screenHeight - rowHeight * i, blockWidth - 5, rowHeight - 5));
            }
        }
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }
    
}