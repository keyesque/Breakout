import java.awt.Color;

public class GreenBrick extends Brick {
	public GreenBrick(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.color = Color.green;
		this.health = 3;
		this.points = 3;
	}

}
