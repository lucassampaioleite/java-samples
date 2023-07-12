package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import services.CalculationService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		list.add(new Product("TV", 2500.00));
		list.add(new Product("Alexa", 550.00));
		list.add(new Product("Relógio", 800.00));
		list.add(new Product("Carro", 90000.00));
		
		System.out.println("Most Expensive: " + CalculationService.max(list));

	}

}
