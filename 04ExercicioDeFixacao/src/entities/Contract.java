/*-------------------- packages section --------------------*/
package entities;

/*-------------------- imports section --------------------*/
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*-------------------- Contract class --------------------*/
public class Contract {

	/*-------------------- attributes section --------------------*/
	private Integer number;
	private LocalDate date;
	private Double total_value;
	private List<Installment> installments = new ArrayList<>(); // association
	
	/*-------------------- constructors section --------------------*/
	// default
	public Contract() {
		//
	}
	
	// overload
	public Contract(Integer number, LocalDate date, Double total_value) {
		this.setNumber(number);
		this.setDate(date);
		this.setTotalValue(total_value);
	}

	/*-------------------- getters and setters section --------------------*/
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return this.total_value;
	}

	public void setTotalValue(Double total_value) {
		this.total_value = total_value;
	}

	public List<Installment> getInstallments() {
		return this.installments;
	}
}
