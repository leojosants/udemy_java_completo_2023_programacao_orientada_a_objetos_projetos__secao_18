/*--------------------packages section--------------------*/
package model.entities;

/*--------------------imports section--------------------*/
import model.enums.Color;

/*--------------------AbstractShape class--------------------*/
public abstract class AbstractShape implements Shape {

	/*--------------------attributes section--------------------*/
	private Color color;

	/*--------------------constructors section--------------------*/
	public AbstractShape(Color color) {
		this.setColor(color);
	}

	/*--------------------getters and setters section--------------------*/
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
