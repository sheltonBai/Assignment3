/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 50;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

	private GRect paddle;
	
	public void mouseMoved(MouseEvent e) {
		paddle.move(e.getX(), 0);
	}

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		
		//Creating the brick rows
		for(int i = 0; i < NBRICK_ROWS; i ++){	
			for(int x = 0; x < NBRICKS_PER_ROW; x ++){
				GRect brick = new GRect((BRICK_SEP * x) + (x * BRICK_WIDTH), BRICK_Y_OFFSET + (BRICK_SEP * i)+ i * BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(false);
				add(brick);
				pause(25);
			}
		}
		
		
		//Creating the ball
		int ballX = 0;
		int ballY = 0;
		GOval ball = new GOval(APPLICATION_WIDTH / 2 - BALL_RADIUS / 2, APPLICATION_HEIGHT - (PADDLE_Y_OFFSET * 5), BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		add(ball);
		ballX = 2;
		ballY = 2;
		
		//Creating the paddle
		paddle = new GRect(APPLICATION_WIDTH / 2 - PADDLE_WIDTH / 2, APPLICATION_HEIGHT - (PADDLE_Y_OFFSET + PADDLE_HEIGHT), PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
		
		//Starting the game
		waitForClick();
		addMouseListeners();
		

		//Moving the Ball
		while(true){
				
			if(ball.getX() < 0) {
				ballX = 2;
			}

			if(ball.getY() < 0) {
				ballY = 2;
			}
			
			if(ball.getX() > APPLICATION_WIDTH){
				ballX = -2;
			}
			
			if(ball.getY() > APPLICATION_HEIGHT){
				ballY = -2;
			}
			
			ball.move(ballX, ballY);
			pause(30);
		}
		

		

		
	}

}
