/*--------------------packages section--------------------*/
package model.entities;

/*--------------------class Employee--------------------*/
public class Employee implements Comparable<Employee> {

	/*--------------------attributes section--------------------*/
	private String name;
	private Double salary;

	/*--------------------constructors section--------------------*/
	public Employee(String name, Double salary) {
		this.setName(name);
		this.setSalary(salary);
	}

	/*--------------------getters and setters section--------------------*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/*--------------------methods section--------------------*/
	@Override
	public int compareTo(Employee other) {
//		return this.getName().compareTo(other.getName()); 		// ordenando por nome
//		return this.getSalary().compareTo(other.getSalary());	// ordenando por salario em ordem crescente
		return - this.getSalary().compareTo(other.getSalary());	// ordenando por salario em ordem decrescente
	}
}
