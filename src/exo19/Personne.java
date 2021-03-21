package exo19;

public class Personne {

	String firstName;
	String lastName;
	int Age;
	

	public Personne(String firstName, String lastName, int Age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.Age = Age;
	}
	
	public Personne() {
	}

	public String getlastName() {
		return this.lastName;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public void setfirstName(String firstN) {
		this.firstName= firstN;
	}
	
	public void setlastName(String lastN) {
		this.lastName= lastN;
	}
	
	@Override
	public String toString() {
		return "Personne : Nom =" + lastName + ", Prénom=" + firstName + ", age=" + Age;
	}
}
