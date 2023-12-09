/* -------------------- packages section -------------------- */
package model.entities;

/* -------------------- Vehicle class -------------------- */
public class Vehicle {

	/* -------------------- attributes section -------------------- */
	private String model;

	/* -------------------- constructors section -------------------- */
	// constructor - default
	public Vehicle() {

	}

	// constructor - overload
	public Vehicle(String model) {
		this.setModel(model);
	}

	/* -------------------- getters and setters section -------------------- */
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}	
}
