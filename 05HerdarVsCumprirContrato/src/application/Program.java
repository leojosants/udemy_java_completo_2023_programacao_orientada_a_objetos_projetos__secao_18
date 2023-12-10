/*--------------------packages section--------------------*/
package application;

/*--------------------imports section--------------------*/
import model.entities.AbstractShape;
import model.entities.Circle;
import model.entities.Rectangle;
import model.enums.Color;

/*--------------------Program class--------------------*/
public class Program {

	/*--------------------functions section--------------------*/
	private static AbstractShape generateInstanceCircle(Color color, Double radius) {
		return new Circle(color, radius);
	}
	
	private static AbstractShape generateInstanceRectangle(Color color, Double width, Double height) {
		return new Rectangle(color, width, height);
	}
	
	private static void execute() {
		Color color_shape_1 = Color.WHITE;
		double radius_shape_1 = 2.0;
		
		Color color_shape_2 = Color.BLACK;
		double width_shape_2 = 3.0;
		double height_shape_2 = 4.0;

		AbstractShape shape_1 = generateInstanceCircle(color_shape_1, radius_shape_1);
		AbstractShape shape_2 = generateInstanceRectangle(color_shape_2, width_shape_2, height_shape_2);
		
		System.out.println();
		System.out.printf("Cor do círculo ......: %s%n", shape_1.getColor());
		System.out.printf("Área do círculo .....: %.3f cm² %n", shape_1.area());
		System.out.printf("Cor do retângulo ....: %s%n", shape_2.getColor());
		System.out.printf("Área do retângulo ...: %.3f cm² %n", shape_2.area());
	}
	
	/*--------------------main method--------------------*/
	public static void main(String[] args) {
		execute();
	}
}
