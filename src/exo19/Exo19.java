package exo19;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Exo19 {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		AnalyzeBean ab = new AnalyzeBean();

		//Q1 : obtenir la classe d'un objet
		String s1 = "Bonjour";
		System.out.println("Classe : " + AnalyzeBean.getClassName(s1));
		
		//Q2 : créer une instance d'un objet		
		Personne p = (Personne)ab.getInstance("exo19.Personne");
		p.firstName = "Océane";
		p.lastName = "Brisac";
		p.Age = 24;
		System.out.println("p = " + p);

		Employee e = (Employee)ab.getInstance("exo19.Employee");
		e.salary= 2000;
		System.out.println("e = " + e);
		
		//Q3 : obtenir les propriétés d'un objet
		List<String> properties1 = ab.getProperties(p);
		System.out.println("\n Personne properties = " + properties1);
		
		List<String> properties2 = ab.getProperties(e);
		System.out.println("\n Employee properties = " + properties2);
		
		//Q4 : obtenir la valeur d'une propriété
		System.out.println("\n First name de p = " + ab.get(p, "getfirstName"));
		
		//Q5 : set la valeur d'une propriété
		String s2 = new String ("Paul");
		ab.set(e, "firstName", s2);
		System.out.println("\n First name de e = " + e.getfirstName());

		
	}

}
