/*--------------------packages section--------------------*/
package model.entities;

/*--------------------imports section--------------------*/
import model.enums.Color;

/*--------------------Shape class--------------------*/
public abstract class Shape {

	/*--------------------attributes section--------------------*/
	private Color color;

	/*--------------------constructors section--------------------*/
	public Shape(Color color) {
		this.setColor(color);
	}

	/*--------------------getters and setters section--------------------*/
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/*--------------------methods section--------------------*/
	public abstract double area();
}
