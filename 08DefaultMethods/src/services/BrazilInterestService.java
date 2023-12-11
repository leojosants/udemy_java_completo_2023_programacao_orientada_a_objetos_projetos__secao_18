/*--------------------packages section--------------------*/
package services;

/*--------------------class BrazilInterestService--------------------*/
public class BrazilInterestService implements InterestServiceInterface {

	/*--------------------attributes section--------------------*/
	private Double interest_rate;

	/*--------------------constructors section--------------------*/
	public BrazilInterestService(Double interest_rate) {
		this.setInterestRate(interest_rate);
	}

	/*--------------------getters and setters section--------------------*/
	@Override
	public Double getInterestRate() {
		return this.interest_rate;
	}

	private void setInterestRate(Double interest_rate) {
		this.interest_rate = interest_rate;
	}
}
