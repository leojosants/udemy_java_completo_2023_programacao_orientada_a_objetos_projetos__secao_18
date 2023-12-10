/* -------------------- packages section -------------------- */
package model.entities;

/* -------------------- imports section -------------------- */
import java.time.LocalDateTime;

/* -------------------- CarRental class -------------------- */
public class CarRental {

	/* -------------------- attributes section -------------------- */
	private LocalDateTime start;
	private LocalDateTime finish;
	private Vehicle vehicle; // association
	private Invoice invoice; // association

	/* -------------------- constructors section -------------------- */
	// constructor - default
	public CarRental() {
		//
	}

	// constructor - overload
	public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {
		this.setStart(start);
		this.setFinish(finish);
		this.setVehicle(vehicle);
	}

	/* -------------------- getters and setters section -------------------- */
	public LocalDateTime getStart() {
		return this.start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getFinish() {
		return this.finish;
	}

	public void setFinish(LocalDateTime finish) {
		this.finish = finish;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
