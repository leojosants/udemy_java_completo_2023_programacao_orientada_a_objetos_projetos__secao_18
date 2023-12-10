/*--------------------packages section--------------------*/
package devices;

/*--------------------class ConcreteScanner--------------------*/
public class ConcreteScanner extends Device implements IScanner {

	/*--------------------constructors section--------------------*/
	public ConcreteScanner(String serial_number) {
		super(serial_number);
	}

	/*--------------------methods section--------------------*/
	@Override
	public void processDoc(String document) {
		System.out.printf("Processamento de digitalização ..: %s%n", document);
	}
	
	@Override
	public String scan() {
		return "Digitalizado contéudo";
	}
}
