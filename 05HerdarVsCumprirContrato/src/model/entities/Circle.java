/*--------------------packages section--------------------*/
package model.entities;

/*--------------------imports section--------------------*/
import model.enums.Color;

/*--------------------Circle class--------------------*/
public class Circle extends Shape {

	/*--------------------attributes section--------------------*/
	private Double radius;
	
	/*--------------------constructors section--------------------*/
	public Circle(Color color, Double radius) {
		super(color);
		this.setRadius(radius);
	}
	
	/*--------------------getters and setters section--------------------*/
	public Double getRadius() {
		return this.radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	/*--------------------methods section--------------------*/
	@Override
	public double area() {
		double pi = Math.PI;
		double radius_exponentiation = Math.pow(this.getRadius(), 2);
		return pi * radius_exponentiation;
	}
}
