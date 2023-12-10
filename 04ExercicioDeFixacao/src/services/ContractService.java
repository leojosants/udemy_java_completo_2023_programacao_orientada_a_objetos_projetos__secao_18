/*-------------------- packages section --------------------*/
package services;

/*-------------------- imports section --------------------*/
import java.time.LocalDate;
import entities.Contract;
import entities.Installment;

/*-------------------- ContractService class --------------------*/
public class ContractService {

	/*-------------------- attributes section --------------------*/
	private OnlinePaymentService online_payment_service;

	/*-------------------- constructors section --------------------*/
	public ContractService(OnlinePaymentService online_payment_service) {
		this.setOnlinePaymentService(online_payment_service);
	}

	/*-------------------- getters and setters section --------------------*/
	public OnlinePaymentService getOnlinePaymentService() {
		return this.online_payment_service;
	}

	private void setOnlinePaymentService(OnlinePaymentService online_payment_service) {
		this.online_payment_service = online_payment_service;
	}

	/*-------------------- methods section --------------------*/
	public void processContract(Contract contract, int months) {
		double basic_quota = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			LocalDate due_date = contract.getDate().plusMonths(i);
			double interest = this.getOnlinePaymentService().interest(basic_quota, i);
			double fee = this.getOnlinePaymentService().paymentFee(basic_quota + interest);
			double quota = basic_quota + interest + fee;
			contract.getInstallments().add(new Installment(due_date, quota));
		}
	}
}
