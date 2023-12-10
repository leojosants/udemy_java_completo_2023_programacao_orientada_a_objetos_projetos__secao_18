/*--------------------packages section--------------------*/
package model.entities;

/*--------------------imports section--------------------*/
import model.enums.Color;

/*--------------------Rectangle class--------------------*/
public class Rectangle extends Shape {

	/*--------------------attributes section--------------------*/
	private Double width;
	private Double height;

	/*--------------------constructors section--------------------*/
	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.setWidth(width);
		this.setHeight(height);
	}

	/*--------------------getters and setters section--------------------*/
	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	/*--------------------methods section--------------------*/
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
}
