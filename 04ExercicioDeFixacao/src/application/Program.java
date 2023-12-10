/*-------------------- packages section --------------------*/
package application;

/*-------------------- imports section --------------------*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

/*-------------------- Program class --------------------*/
public class Program {

	/*-------------------- functions section --------------------*/
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}

	private static DateTimeFormatter generateDateTimeFormatter() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}

	private static LocalDate requestContractDate(Scanner scanner, DateTimeFormatter date_time_formatter) {
		LocalDate contract_date = null;
		String contract_date_string = null;
		contract_date_string = scanner.nextLine().trim();

		while (contract_date_string.isEmpty()) {
			System.out.print("-> Dados inválidos, tente novamente! Data [dd/MM/yyyy] ............: ");
			contract_date_string = scanner.nextLine().trim();
		}

		contract_date = LocalDate.parse(contract_date_string, date_time_formatter);
		return contract_date;
	}
	
	private static ContractService generateInstanceContractService(PaypalService paypal_service) {
		return new ContractService(paypal_service);
	}
		
	private static Contract generateInstanceContract(int number, LocalDate date, double total_value) {
		return new Contract(number, date, total_value);
	}
	
	private static PaypalService generateInstancePaypalService() {
		return new PaypalService();
	}
	
	private static int requestContractNumber(Scanner scanner) {
		int contract_number = 0;
		contract_number = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (contract_number <= 0) {
			System.out.print("-> Dados inválidos, tente novamente! Número ..: ");
			contract_number = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return contract_number;
	}
	
	private static int requestNumberOfInstallments(Scanner scanner) {
		int number_of_installments = 0;
		number_of_installments = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (number_of_installments <= 0) {
			System.out.print("-> Dados inválidos, tente novamente! Número de parcelas ...........: ");
			number_of_installments = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return number_of_installments;
	}
	
	private static double requestTotalValue(Scanner scanner) {
		double total_value = 0.0;
		
		total_value = scanner.nextDouble();
		scanner.nextLine(); // buffer
		
		while (total_value <= 0) {
			System.out.print("-> Dados inválidos, tente novamente! Valor do contrato ............: R$");
			total_value = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}
		
		return total_value;
	}
	
	private static void displayInstallments(Contract contract) {
		for(Installment installment : contract.getInstallments()) {
			installment.printInstallments();
		}
	}

	private static void dislayMessageDateTimeParseException() {
		System.out.println("-> erro: formato inválido para data");
	}
	
	private static void dislayMessageInputMismatchException() {
		System.out.println("-> erro: entrada inválida");;
	}
	
	private static void dislayMessageNullPointerException() {
		System.out.println("-> erro: valores nulos");
	}
	
	private static void dislayMessageException(Throwable e) {
		System.out.println(e);
	}

	private static void dislayMessageEndProgram() {
		System.out.println("\n----- programa finalizado -----");
	}
	
	private static void execute() {
		Locale.setDefault(Locale.US);
		Scanner scanner = generateInstanceScanner();
		DateTimeFormatter date_time_formatter = generateDateTimeFormatter();

		try {
			System.out.println("\nEntre com os dados do contrato");
			System.out.print("Número ..............: ");
			int contract_number = requestContractNumber(scanner);

			System.out.print("Data [dd/MM/yyyy] ...: ");
			LocalDate contract_date = requestContractDate(scanner, date_time_formatter);

			System.out.print("Valor do contrato ...: R$ ");
			double total_value = requestTotalValue(scanner);
			
			Contract contract = generateInstanceContract(contract_number, contract_date, total_value);
			
			System.out.print("Número de parcelas ..: ");
			int number_of_installments = requestNumberOfInstallments(scanner);
			
			PaypalService paypal_service = generateInstancePaypalService();
			ContractService contract_service = generateInstanceContractService(paypal_service);
			contract_service.processContract(contract, number_of_installments);
			
			System.out.println("\nParcelas");
			displayInstallments(contract);
		} 
		catch (DateTimeParseException e) {
			dislayMessageDateTimeParseException();
		} 
		catch (InputMismatchException e) {
			dislayMessageInputMismatchException();
		} 
		catch (NullPointerException e) {
			dislayMessageNullPointerException();
		} 
		catch (Exception e) {
			dislayMessageException(e);
		} 
		finally {
			scanner.close();
			dislayMessageEndProgram();
		}
	}

	/*-------------------- main method section --------------------*/
	public static void main(String[] args) {
		execute();
	}
}
