/*--------------------packages section--------------------*/
package application;

/*--------------------imports section--------------------*/
import devices.ComboDevice;
import devices.ConcretePrinter;
import devices.ConcreteScanner;

/*--------------------Program class--------------------*/
public class Program {

	/*--------------------functions section--------------------*/
	private static ConcretePrinter generateInstancePrinter(String serial_number) {
		return new ConcretePrinter(serial_number);
	}
	
	private static ConcreteScanner generateInstanceScannerClass(String serial_number) {
		return new ConcreteScanner(serial_number);
	}
	
	private static void displayPrinter() {
		System.out.println("\n-> IMPRESSORA");
		ConcretePrinter printer = generateInstancePrinter("1080");
		printer.processDoc("Minha carta");
		printer.print("Minha carta");
	}
	
	private static void displayScanner() {
		System.out.println("\n-> SCANNER");		
		ConcreteScanner scanner = generateInstanceScannerClass("2000");
		scanner.processDoc("Meu email");
		System.out.printf("Resultado da digitalização ......: %s%n", scanner.scan());
	}
	
	private static void displayComboDevice() {
		System.out.println("\n-> COMBO");
		ComboDevice combo_device = new ComboDevice("2081");
		combo_device.processDoc("Minha dissertação");
		combo_device.print("Minha dissertação");
		System.out.printf("Resultado da digitalização ......: %s%n", combo_device.scan());
	}
	
	private static void execute() {		
		displayPrinter();		
		displayScanner();
		displayComboDevice();
	}
	
	/*--------------------main method--------------------*/
	public static void main(String[] args) {
		execute();
	}
}
