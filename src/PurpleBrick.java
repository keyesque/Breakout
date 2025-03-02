import java.awt.Color;

public class PurpleBrick extends Brick {
	public PurpleBrick(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.color = new Color(102, 0, 153);
		this.health = 1;
		this.points = 1;
	}

}
