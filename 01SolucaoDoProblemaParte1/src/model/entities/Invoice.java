/* -------------------- packages section -------------------- */
package model.entities;

/* -------------------- Invoice class -------------------- */
public class Invoice {

	/* -------------------- attributes section -------------------- */
	private Double basic_payment;
	private Double tax;
	
	/* -------------------- constructors section -------------------- */
	// constructor - default
	public Invoice() {
		//
	}

	// constructor - overload
	public Invoice(Double basic_payment, Double tax) {
		this.setBasicPayment(basic_payment);
		this.setTax(tax);
	}

	/* -------------------- getters and setters section -------------------- */
	public Double getBasicPayment() {
		return this.basic_payment;
	}

	public void setBasicPayment(Double basic_payment) {
		this.basic_payment = basic_payment;
	}

	public Double getTax() {
		return this.tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	/* -------------------- methods section -------------------- */
	public Double getTotalPayment() {
		return this.getBasicPayment() - this.getTax();
	}
}
