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
			checkCollision(paddle, ball);
			ball.update();
			ball.draw(shape);
		}
		paddle.draw(shape);
		shape.end();
	}

	public void checkCollision(Paddle paddle, Ball ball) {
        if(collidesWith(paddle, ball)){
            ball.color = Color.GREEN;
        }
        else{
            ball.color = Color.WHITE;
        }
    }

    private boolean collidesWith(Paddle paddle, Ball ball) {

		boolean a = ball.x + ball.radius >= paddle.x;
		boolean b = ball.x - ball.radius <= paddle.x + paddle.width;
		boolean c = ball.y + ball.radius >= paddle.y;
		boolean d = ball.y - ball.radius <= paddle.y + paddle.height;

		return a && b && c && d;

    }
}