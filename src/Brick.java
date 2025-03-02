import java.awt.Color;
import java.awt.Graphics2D;

abstract class Brick extends Sprite {
	
	protected Color color;
	protected int health;
	protected int points;
	public Brick(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public int getHealth(){
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getPoints(){
		return this.points;
	}
	@Override
	public void update(Keyboard keyboard) {

		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

}
