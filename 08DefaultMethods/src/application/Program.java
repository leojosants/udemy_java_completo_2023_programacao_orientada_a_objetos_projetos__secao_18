/*--------------------packages section--------------------*/
package application;

/*--------------------imports section--------------------*/
import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import services.BrazilInterestService;
import services.InterestServiceInterface;
import services.UsaInterestService;

/*--------------------class Program--------------------*/
public class Program {

	/*--------------------functions section--------------------*/
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}

	private static double requestAmount(Scanner scanner) {
		double amount = 0.0;
		
		System.out.println("\n-----Requesting data-----");
		System.out.print("Enter the amount ...........: R$ ");
		amount = scanner.nextDouble();
		scanner.nextLine(); // buffer
		
		while (amount <= 0.0) {
			System.out.print("Invalid entry, please try again! Enter the amount ....................: R$ ");
			amount = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}
		
		return amount;
	}
	
	private static int requestDurationOfMonths(Scanner scanner) {
		int duration_of_months = 0;
		
		System.out.print("Enter duration in months ...: ");
		duration_of_months = scanner.nextInt();
		scanner.nextLine(); // buffer		
		
		return duration_of_months;
	}
	
	private static InterestServiceInterface generateIntanceBrazilInterestService(double interest_rate) {
		return new BrazilInterestService(interest_rate);
	}
	
	private static InterestServiceInterface generateIntanceUsaInterestService(double interest_rate) {
		return new UsaInterestService(interest_rate);
	}
	
	private static void displayData(int duration_of_months, double brazil_payment, double usa_payment) {
		System.out.println("\n-----Displaying data-----");
		System.out.printf("BRAZIL\t-> payment after %d months ..: R$ %.2f%n", duration_of_months, brazil_payment);
		System.out.printf("USA\t-> payment after %d months ..: R$ %.2f%n", duration_of_months, usa_payment);
	}
	
	private static void displayMessageInputMismatchException() {
		System.out.println("-> error: data entry");		
	}
	
	private static void displayMessageInvalidParameterException(Throwable e) {
		System.out.println("-> error: " + e.getMessage());
	}
	
	private static void displayMessageException(Throwable e) {
		System.out.println(e);
	}
	
	private static void displayMessageEndOfProgram() {
		System.out.println("\n-----end of program-----");
	}
	
	private static void runProgram() {
		Locale.setDefault(Locale.US);
		Scanner scanner = generateInstanceScanner();
		
		try {
			double amount = requestAmount(scanner);
			int duration_of_months = requestDurationOfMonths(scanner);
			
			InterestServiceInterface brazil_interest_service = generateIntanceBrazilInterestService(2.0);
			InterestServiceInterface usa_interest_service = generateIntanceUsaInterestService(1.0);

			double brazil_payment = brazil_interest_service.payment(amount, duration_of_months);
			double usa_payment = usa_interest_service.payment(amount, duration_of_months);
			
			displayData(duration_of_months, brazil_payment, usa_payment);
		} 
		catch (InputMismatchException e) {
			displayMessageInputMismatchException();
		}
		catch (InvalidParameterException e) {
			displayMessageInvalidParameterException(e);
		}
		catch (Exception e) {
			displayMessageException(e);
		}
		finally {
			scanner.close();	
			displayMessageEndOfProgram();
		}
	}

	/*--------------------main method--------------------*/
	public static void main(String[] args) {
		runProgram();
	}
}
