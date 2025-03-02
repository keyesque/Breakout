import java.awt.Color;

public class RedBrick extends Brick {
	public RedBrick(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.color = Color.red;
		this.health = 6;
		this.points = 6;
	}

}
