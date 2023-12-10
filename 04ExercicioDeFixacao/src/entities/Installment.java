/*-------------------- packages section --------------------*/
package entities;

/*-------------------- imports section --------------------*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*-------------------- Installment class --------------------*/
public class Installment {

	/*-------------------- attributes section --------------------*/
	private static DateTimeFormatter date_time_formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate date;
	private Double amount;

	/*-------------------- constructors section --------------------*/
	// default
	public Installment() {
		//
	}

	// overload
	public Installment(LocalDate date, Double amount) {
		this.setDate(date);
		this.setAmount(amount);
	}

	/*-------------------- getters and setters section --------------------*/
	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/*-------------------- methods section --------------------*/
	@Override
	public String toString() {
		return String.format("%s - R$ %.2f", this.getDate().format(date_time_formatter), this.getAmount());
	}	
	
	public void printInstallments() {
		System.out.println(toString());
	}
}
