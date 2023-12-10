/* -------------------- packages section -------------------- */
package model.services;

/* -------------------- BrazilTaxService class -------------------- */
public class BrazilTaxService implements TaxService{
	
	/* -------------------- methods section -------------------- */
	public double tax(double amount) {
		if(amount <= 100.0) {
			return amount * 0.2;
		}
		else {
			return amount * 0.15;
		}
	}
}
