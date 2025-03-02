import java.awt.Color;

public class BlueBrick extends Brick {
	public BlueBrick(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.color = Color.blue;
		this.health = 2;
		this.points = 2;
	}

}
