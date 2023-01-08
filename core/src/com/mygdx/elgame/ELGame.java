package com.mygdx.elgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import java.util.ArrayList;
import java.util.Random;

public class ELGame extends ApplicationAdapter {
	ShapeRenderer shape;
	ArrayList<Ball> balls = new ArrayList<>();
	Paddle paddle = new Paddle(0,20,120, 10);
	Random r = new Random();
	ArrayList<Block> blockArrayList;

	

	@Override
	public void create() {
		shape = new ShapeRenderer();
		for (int i = 0; i < 1; i++) {
			balls.add(new Ball(50,
					50,
					10, 2, 2));
		}
		blockArrayList = new BlockArray(20, 20, 20, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()).getBlocks();
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);

		ArrayList<Block> blocksToDel = new ArrayList<>();
		for (Block block : blockArrayList){
			if(block.isDestroyed()){
				blocksToDel.add(block);
			}
			block.draw(shape);
		}
		blockArrayList.removeAll(blocksToDel);

		for (Ball ball : balls) {
			checkCollision(paddle, ball);

			for (Block block : blockArrayList){
				block.setDestroyed(collidesWith(block, ball));
				checkCollision(block, ball);
			}

			ball.update();
			ball.draw(shape);
		}
		paddle.draw(shape);
		shape.end();
	}

	public void checkCollision(Rectangle rectangle, Ball ball) {
		if (collidesWith(rectangle, ball)) {
			if (Boolean.FALSE.equals(ball.getCollision())) {
				ball.setYSpeed(-ball.getYSpeed());
				ball.setCollision(true);
			}
		} else {
			ball.setCollision(false);
		}
	}

	private boolean collidesWith(Rectangle rectangle, Ball ball) {

		boolean a = ball.getX() + ball.getRadius() >= rectangle.getX();
		boolean b = ball.getX() - ball.getRadius() <= rectangle.getX() + rectangle.getWidth();
		boolean c = ball.getY() + ball.getRadius() >= rectangle.getY();
		boolean d = ball.getY() - ball.getRadius() <= rectangle.getY() + rectangle.getHeight();

		return a && b && c && d;

	}
}