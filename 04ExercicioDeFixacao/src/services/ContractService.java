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
		contract.getInstallments().add(new Installment(LocalDate.of(2018, 7, 25), 206.04));
		contract.getInstallments().add(new Installment(LocalDate.of(2018, 8, 25), 208.08));
	}
}
