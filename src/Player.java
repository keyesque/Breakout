import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Player extends Sprite {
	static int speed = 20;
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(Keyboard keyboard) {
		// Move left and right
		if(keyboard.isKeyDown(Key.Right) && getX() < Game.screenWidth - getWidth()) {
			setX(getX() + speed);
		}
		if(keyboard.isKeyDown(Key.Left) && getX() > 0) {
			setX(getX() - speed);
		}
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.white);
		graphics.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		graphics.setColor(Color.white);
		Font font = new Font("Arial", Font.PLAIN, 10);
		graphics.setFont(font);
		graphics.drawString("KM",getX() + (getWidth() / 2), getY() + getHeight());
		
	}

}
