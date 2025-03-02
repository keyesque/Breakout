import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Sprite {
	private int directionX;
	private int directionY;
	private int speed;
	private boolean isMoving = false;
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.directionX = -1;
		this.directionY = -1;
		this.speed = 5;
		isMoving = false;
	}

	@Override
	public void update(Keyboard keyboard) {
		if(!isMoving) {
			this.directionY = -1;
			setX(Game.player.getX() + (Game.player.getWidth() / 2));
			setY(Game.player.getY() - 30);
			
			if(keyboard.isKeyDown(Key.Space)) {
				isMoving = true;
			}
		}
		else {
		if(getX() > Game.screenWidth - getWidth()) directionX = -1;
		else if(getX() < 0) directionX = 1;
		if(getY() > Game.screenHeight) {
			Game.health--;
			isMoving = false;	
		}
		if(getY() < 0) directionY = 1;
		
		// Update position
		setX(getX() + speed * directionX);
		setY(getY() + speed * directionY);
		}
		
	}
	public int getDirectionX() {
		return directionX;
	}
	public int getDirectionY() {
		return directionY;
	}
	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}
	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}
	public boolean getIsMoving() {
		return isMoving;
	}
	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.white);
		graphics.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		
	}

}
