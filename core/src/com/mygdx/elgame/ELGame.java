package com.mygdx.elgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.Random;

public class ELGame extends ApplicationAdapter {
	ShapeRenderer shape;
	ArrayList<Ball> balls = new ArrayList<>();
	Paddle paddle = new Paddle(120);
	Random r = new Random();

	

	@Override
	public void create() {
		shape = new ShapeRenderer();
		for (int i = 0; i < 10; i++) {
			balls.add(new Ball(r.nextInt(70),
					r.nextInt(70),
					40, 12, 3));
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shape.begin(ShapeRenderer.ShapeType.Filled);

		for (Ball ball : balls) {
			checkCollision(paddle, ball);
			ball.update();
			ball.draw(shape);
		}
		paddle.draw(shape);
		shape.end();
	}

	public void checkCollision(Paddle paddle, Ball ball) {
		if (collidesWith(paddle, ball)) {
			if (!ball.getCollision()) {
				ball.setColor(Color.GREEN);
				ball.setXSpeed(-ball.getXSpeed());
				ball.setYSpeed(-ball.getYSpeed());
				ball.setCollision(true);
			}
		} else {
			ball.setColor(Color.WHITE);
			ball.setCollision(false);
		}
	}

	private boolean collidesWith(Paddle paddle, Ball ball) {

		boolean a = ball.getX() + ball.getRadius() >= paddle.getX();
		boolean b = ball.getX() - ball.getRadius() <= paddle.getX() + paddle.getWidth();
		boolean c = ball.getY() + ball.getRadius() >= paddle.getY();
		boolean d = ball.getY() - ball.getRadius() <= paddle.getY() + paddle.getHeight();

		return a && b && c && d;

	}
}