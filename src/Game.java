import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	
	
	// Const
	public static final int fontSize = 40;
	public static final int brickOffsetX = 25;
	public static final int brickGapOffsetX = 100;
	public static final int brickOffsetY = 25;
	public static final int brickCount = 8;
	public static final int playerMaxHealth = 3;
	
	public static final int screenWidth = 800;
	public static final int screenHeight = 600;
	
	// Player
	private final int playerWidth = 100;
	private final int playerHeight = 10;
	
	// Ball
	private final int ballSize = 20;
	
	// Brick
	private final int brickWidth = 75;
	private final int brickHeight = 20;
	
	// Fonts
	Font fontScore = new Font("Arial", Font.PLAIN, 40);
	Font fontHealth = new Font("Arial", Font.PLAIN, 25);
	
	static Player player;
	Ball ball;
	ArrayList<Brick> bricks;
	ArrayList<Brick> bricksDestroyed;
	public static State state;
	static int highScore;
	public static int score;
	public static int health;
	
	public Game(GameBoard board) {
		state = State.Playing;
		score = 0;
		health = playerMaxHealth;
		player = new Player(screenWidth / 2, screenHeight- 2 * playerHeight, playerWidth, playerHeight);
		ball = new Ball(screenWidth / 2, screenHeight - 3 * playerHeight, ballSize, ballSize);
		bricks = new ArrayList<>();
		bricksDestroyed = new ArrayList<>();
		
		// Create bricks
		for(int i = 0; i < brickCount; i++) {
			Brick redBrick = new RedBrick((i * brickGapOffsetX) + brickOffsetX, brickOffsetY, brickWidth, brickHeight);
			Brick orangeBrick = new OrangeBrick((i * brickGapOffsetX) + brickOffsetX, brickOffsetY * 2, brickWidth, brickHeight);
			Brick yellowBrick = new YellowBrick((i * brickGapOffsetX) + brickOffsetX, brickOffsetY * 3, brickWidth, brickHeight);
			Brick greenBrick = new GreenBrick((i * brickGapOffsetX) + brickOffsetX, brickOffsetY * 4, brickWidth, brickHeight);
			Brick blueBrick = new BlueBrick((i * brickGapOffsetX) + brickOffsetX, brickOffsetY * 5, brickWidth, brickHeight);
			Brick purpleBrick = new PurpleBrick((i * brickGapOffsetX) + brickOffsetX, brickOffsetY * 6, brickWidth, brickHeight);
			bricks.addAll(Arrays.asList(redBrick, orangeBrick, yellowBrick, greenBrick, blueBrick, purpleBrick));
		}
	}
	
	public void update(Keyboard keyboard) {
		// While game is playing
		if(state == State.Playing) {
		player.update(keyboard);
		ball.update(keyboard);
		
		// Player collision
		if(ball.getX() + ballSize > player.getX() - (player.getWidth() / 2) &&
		ball.getX() - ballSize < player.getX() + (player.getWidth() / 2) &&
		ball.getY() + ballSize > player.getY() - (player.getHeight() / 2) &&
		ball.getY() - ballSize < player.getY() + (player.getHeight() / 2)) {
			ball.setDirectionY(ball.getDirectionY() * -1);
			ball.setY(player.getY() - (player.getHeight() / 2) - ballSize);
		}
			
		
		// Brick collision
		for(Brick brick : bricks) {
		    if(ball.getX() + ballSize > brick.getX() - (brick.getWidth() / 2) &&
		    ball.getX() - ballSize < brick.getX() + (brick.getWidth() / 2) &&
		    ball.getY() + ballSize > brick.getY() - (brick.getHeight() / 2) &&
		    ball.getY() - ballSize < brick.getY() + (brick.getHeight() / 2)) {
				
		    	// Update ball direction
		    	ball.setDirectionY(ball.getDirectionY() * -1);
		    	
				brick.setHealth(brick.getHealth() - 1);
				
				if(brick.getHealth() < 1) {
				bricksDestroyed.add(brick);
				score = score + brick.getPoints();
				}
			}
		}
		bricks.removeAll(bricksDestroyed);
		
		// Update score
		if(score > highScore)
			highScore = score;
		
		// Update state
		if(bricks.isEmpty())
			state = State.Win;
		
		if(health < 1)
			state = State.Lose;
		}
	}

	public void draw(Graphics2D graphics) {
		if(state == State.Playing) {
		graphics.setColor(Color.black);
		player.draw(graphics);
		ball.draw(graphics);
		for(Brick brick : bricks) {
			brick.draw(graphics);
		}
		
		// Draw text
		graphics.setColor(Color.white);
		graphics.setFont(fontScore);
		graphics.drawString(Integer.toString(score), screenWidth / 2, screenHeight / 2);
		graphics.setFont(fontHealth);
		graphics.drawString("Health: " + health, 25, screenHeight - 25);
		}
		if(state == State.Lose) {
			graphics.setColor(Color.white);
			Font font = new Font("Arial", Font.PLAIN, fontSize);
			graphics.setFont(font);
			graphics.drawString("You lose.", screenWidth / 2 - 40, screenHeight / 2);
			graphics.drawString("Score: " + score, screenWidth / 2 - fontSize, screenHeight - 100);
		}
		if(state == State.Win) {
			graphics.setColor(Color.white);
			Font font = new Font("Arial", Font.PLAIN, fontSize);
			graphics.setFont(font);
			graphics.drawString("You Win!", screenWidth / 2 - fontSize, screenHeight / 2);
			graphics.drawString("Score: " + score, screenWidth / 2 - fontSize, screenHeight - 100);
		}
	}
}
