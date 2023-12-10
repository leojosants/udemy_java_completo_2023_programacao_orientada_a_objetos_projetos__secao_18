/*-------------------- packages section --------------------*/
package services;

/*-------------------- OnlinePaymentService interface --------------------*/
interface OnlinePaymentService {

	/*-------------------- methods section --------------------*/
	double paymentFee(double amount);
	double interest(double amount, int months);
}
