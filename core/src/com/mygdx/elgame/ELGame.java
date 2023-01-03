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
	Paddle paddle = new Paddle(120);
	Random r = new Random();

	@Override
	public void create() {
		shape = new ShapeRenderer();
		for (int i = 0; i < 1; i++) {
			balls.add(new Ball(400,
					300,
					40, 0, 0));
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shape.begin(ShapeRenderer.ShapeType.Filled);

		for (Ball ball : balls) {
			ball.update();
			ball.draw(shape);
		}
		paddle.draw(shape);
		shape.end();
	}
}