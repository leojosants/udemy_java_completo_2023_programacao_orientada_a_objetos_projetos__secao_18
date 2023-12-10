/*--------------------packages section--------------------*/
package devices;

/*--------------------abstract class Device--------------------*/
public abstract class Device {
	
	/*--------------------attributes section--------------------*/
	private String serial_number;

	/*--------------------constructors section--------------------*/
	public Device(String serial_number) {
		this.setSerialNumber(serial_number);
	}

	/*--------------------getters and setters section--------------------*/
	public String getSerialNumber() {
		return this.serial_number;
	}

	public void setSerialNumber(String serial_number) {
		this.serial_number = serial_number;
	}

	/*--------------------methods section--------------------*/
	public abstract void processDoc(String doc);
}
