/* -------------------- packages section -------------------- */
package model.services;

/* -------------------- imports section -------------------- */
import java.time.Duration;
import model.entities.CarRental;
import model.entities.Invoice;

/* -------------------- RentalService class -------------------- */
public class RentalService {
	
	/* -------------------- attributes section -------------------- */
	private Double price_per_hour;
	private Double price_per_day;
	private BrazilTaxService tax_service; // composition type association
	
	/* -------------------- constructors section -------------------- */
	public RentalService(Double price_per_hour, Double price_per_day, BrazilTaxService tax_service) {
		this.price_per_hour = price_per_hour;
		this.price_per_day = price_per_day;
		this.tax_service = tax_service;
	}
	
	/* -------------------- methods section -------------------- */
	public void processInvoice (CarRental car_rental) {
		double minutes = Duration.between(car_rental.getStart(), car_rental.getFinish()).toMinutes();
		double hours = minutes / 60.0;
		double basic_payment;
		
		if(hours <= 12.0) {
			basic_payment = price_per_hour * Math.ceil(hours);
		}
		else {
			basic_payment = price_per_day * Math.ceil(hours / 24.0);
		}
		
		double tax = this.tax_service.tax(basic_payment);
		car_rental.setInvoice(new Invoice(basic_payment, tax));
	}
}
