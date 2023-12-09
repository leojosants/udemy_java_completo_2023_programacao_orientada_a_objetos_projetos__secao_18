/* -------------------- packages section -------------------- */
package application;

/* -------------------- imports section -------------------- */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;
import model.entities.CarRental;
import model.entities.Vehicle;

/* -------------------- Program class -------------------- */
public class Program {

	/* -------------------- functions section -------------------- */
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}

	private static String requestCarModel(Scanner scanner) {
		String car_model = null;
		System.out.print("Modelo do carro ..: ");
		car_model = scanner.nextLine().trim();

		while (car_model.isEmpty()) {
			System.out.print("-> Dados inválidos, tente novamente! Modelo do carro ..: ");
			car_model = scanner.nextLine().trim();
		}

		return car_model;
	}

	private static DateTimeFormatter generateDateTimeFormatter() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	}

	private static LocalDateTime requestDateStartDate(Scanner scanner, DateTimeFormatter date_time_formatter) {
		LocalDateTime start_date = null;
		String start_date_string = null;

		System.out.print("Data de retirada [dd/MM/yyyy HH:mm] ..: ");
		start_date_string = scanner.nextLine().trim();

		while (start_date_string.isEmpty()) {
			System.out.print("-> Dados inválidos, tente novamente! Data de retirada [dd/MM/yyyy HH:mm] ..: ");
			start_date_string = scanner.nextLine().trim();
		}

		start_date = LocalDateTime.parse(start_date_string, date_time_formatter);
		return start_date;
	}

	private static LocalDateTime requestDateFinishDate(Scanner scanner, DateTimeFormatter date_time_formatter) {
		LocalDateTime finish_date = null;
		String finish_date_string = null;

		System.out.print("Data de devolução [dd/MM/yyyy HH:mm]..: ");
		finish_date_string = scanner.nextLine().trim();

		while (finish_date_string.isEmpty()) {
			System.out.print("-> Dados inválidos, tente novamente! Data de devolução [dd/MM/yyyy HH:mm] ..: ");
			finish_date_string = scanner.nextLine().trim();
		}

		finish_date = LocalDateTime.parse(finish_date_string, date_time_formatter);
		return finish_date;
	}

	private static Vehicle generateInstanceVehicle(Scanner scanner, String car_model) {
		return new Vehicle(car_model);
	}

	private static CarRental generateInstanceCarRental(Scanner scanner, LocalDateTime start_date,
			LocalDateTime finish_date, Vehicle vehicle_car_model) {
		return new CarRental(start_date, finish_date, vehicle_car_model);
	}
	
	private static void dislayMessageDateTimeParseException() {
		System.out.println("-> erro: formato inválido para data e hora");
	}
	
	private static void dislayMessageEndProgram() {
		System.out.println("\n----- programa finalizado -----");
	}

	/* -------------------- main method -------------------- */
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = generateInstanceScanner();

		try {
			DateTimeFormatter date_time_formatter = generateDateTimeFormatter();

			System.out.println("\nEntre com os dados do aluguel");
			String car_model = requestCarModel(scanner);
			LocalDateTime start_date = requestDateStartDate(scanner, date_time_formatter);
			LocalDateTime finish_date = requestDateFinishDate(scanner, date_time_formatter);

			Vehicle vehicle_car_model = generateInstanceVehicle(scanner, car_model);
			CarRental car_rental = generateInstanceCarRental(scanner, start_date, finish_date, vehicle_car_model);
		} 
		catch (DateTimeParseException e) {
			dislayMessageDateTimeParseException();
		} 
		catch (Exception e) {
			System.out.println(e);
		} 
		finally {
			scanner.close();
			dislayMessageEndProgram();
		}
	}
}
