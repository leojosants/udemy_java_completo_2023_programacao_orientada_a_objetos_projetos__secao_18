/*--------------------packages section--------------------*/
package services;

import java.security.InvalidParameterException;

/*--------------------interface InterestServiceInterface--------------------*/
public interface InterestServiceInterface {

	/*--------------------methods section--------------------*/
	Double getInterestRate();

	default Double payment(double amount, int duration_of_months) {
		if (duration_of_months < 1) {
			throw new InvalidParameterException("The duration of months must be greater than zero");
		}
		return amount * Math.pow(1.0 + this.getInterestRate() / 100.0, duration_of_months);
	}
}
