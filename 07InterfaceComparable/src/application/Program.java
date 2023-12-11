/*--------------------packages section--------------------*/
package application;

/*--------------------imports section--------------------*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.entities.Employee;

/*--------------------class Program--------------------*/
public class Program {

	/*--------------------constants section--------------------*/
	public static final String path = "C:\\temp\\in.csv";
	
	/*--------------------functions section--------------------*/
	private static List<Employee> generateInstanceEmployeesList() {
		return new ArrayList<>();
	}
	
	private static FileReader generateInstanceFileReader(String path) throws FileNotFoundException {
		return new FileReader(path);
	}
	
	private static BufferedReader generateInstanceBufferedReader(FileReader file_reader) {
		return new BufferedReader(file_reader);
	}
	
	private static String readLinesFromFile(BufferedReader buffered_reader) throws IOException {
		String file = buffered_reader.readLine();
		return file;
	}
	
	private static String[] splitLine(String data) {
		String[] fields = data.split(",");
		return fields;
	}
	
	private static double convertStringToDouble(String field) {
		double employee_salary = Double.parseDouble(field);
		return employee_salary;
	}
	
	private static Employee generateInstanceEmployee(String emplyee_name, double employee_salary) {
		return new Employee(emplyee_name, employee_salary);
	}
	
	private static void orderEmployees(List<Employee> employees_list) {
		Collections.sort(employees_list);
	}
	
	private static void displayEmployeesList(List<Employee> employees_list) {
		System.out.println("\n-----Imprimindo dados-----");
		for (Employee employee : employees_list) {
			System.out.printf("Nome: %s, \t-\t Salário: R$ %.2f%n", employee.getName(), employee.getSalary());
		}
	}
	
	private static void displayMessageIOException(Throwable e) {
		System.out.println("Error: " + e.getMessage());
	}
	
	private static void displayEndMessage() {
		System.out.println("\n-----fim do programa-----");
	}
	
	private static void runProgram() throws FileNotFoundException {
		List<Employee> employees_list = generateInstanceEmployeesList();
		FileReader file_reader = generateInstanceFileReader(path);
		BufferedReader buffered_reader = generateInstanceBufferedReader(file_reader);
		
		try (buffered_reader) {
			String employee_csv = readLinesFromFile(buffered_reader);
			
			while (employee_csv != null) {
				String[] fields = splitLine(employee_csv);
				String emplyee_name = fields[0];
				double employee_salary = convertStringToDouble(fields[1]);
				employees_list.add(generateInstanceEmployee(emplyee_name, employee_salary));
				employee_csv = readLinesFromFile(buffered_reader);
			}

			orderEmployees(employees_list);
			displayEmployeesList(employees_list);	
		} 
		catch (IOException e) {
			displayMessageIOException(e);
		}
		finally {
			displayEndMessage();
		}
	}

	/*--------------------main method--------------------*/
	public static void main(String[] args) throws FileNotFoundException {
		runProgram();
	}
}