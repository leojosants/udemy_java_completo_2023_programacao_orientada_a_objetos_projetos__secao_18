/*--------------------packages section--------------------*/
package devices;

/*--------------------class ConcretePrinter--------------------*/
public class ConcretePrinter extends Device implements IPrinter {

	/*--------------------constructors section--------------------*/
	public ConcretePrinter(String serial_number) {
		super(serial_number);
	}

	/*--------------------methods section--------------------*/
	@Override
	public void processDoc(String document) {
		System.out.printf("Processamento de impressão ......: %s%n", document);
	}
	
	@Override
	public void print(String document) {
		System.out.printf("Imprimindo ......................: %s%n", document);
	}
}
