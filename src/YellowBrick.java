import java.awt.Color;

public class YellowBrick extends Brick {
	public YellowBrick(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.color = Color.yellow;
		this.health = 4;
		this.points = 4;
	}

}
