package exo19;

public class Employee extends Personne {

	int salary;
	
	public Employee() {
	}
	
	@Override
	public String toString() {
		return "Personne : Nom =" + lastName + ", Pr�nom=" + firstName + ", age=" + Age + ", salary=" + salary;
	}
	
}
