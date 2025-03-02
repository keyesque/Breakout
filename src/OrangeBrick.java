import java.awt.Color;

public class OrangeBrick extends Brick {
	public OrangeBrick(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.color = Color.orange;
		this.health = 5;
		this.points = 5;
	}

}
