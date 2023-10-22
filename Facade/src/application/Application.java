package application;

import facade.Facade;

public class Application {

	public static void main(String[] args) {
		
		System.out.println("Efetuando migração de cliente...");		
		Facade.getInstance().migrateCustomer("Lucas", "50010-000");;

	}

}
