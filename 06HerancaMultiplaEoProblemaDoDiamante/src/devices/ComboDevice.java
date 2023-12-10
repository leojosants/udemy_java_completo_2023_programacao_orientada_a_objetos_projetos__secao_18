/*--------------------packages section--------------------*/
package devices;

/*--------------------class ComboDevice--------------------*/
public class ComboDevice extends Device implements IScanner, IPrinter {

	/*--------------------constructors section--------------------*/
	public ComboDevice(String serial_number) {
		super(serial_number);
	}

	/*--------------------methods section--------------------*/
	@Override
	public void print(String document) {
		System.out.printf("Impressão combinada .............: %s%n", document);
	}

	@Override
	public String scan() {
		return "Resultado da verificação combinada";
	}

	@Override
	public void processDoc(String document) {
		System.out.printf("Processamento combinado .........: %s%n", document);
	}
}
