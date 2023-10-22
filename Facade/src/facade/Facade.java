package facade;

import subsystem.crm.CrmService;
import subsystem.postal.code.ZipCodeApi;

public class Facade {
	
	private static Facade instance = new Facade();
	
	private Facade() {}
	
	public static Facade getInstance() {
		return instance;
	}
	
	public void migrateCustomer(String name, String zipCode) {
		String city = ZipCodeApi.getInstance().getCityByZipCode(zipCode);
		String state = ZipCodeApi.getInstance().getStateByZipCode(zipCode);
		String country = ZipCodeApi.getInstance().getCountryByZipCode(zipCode);
		
		CrmService.saveClient(name, zipCode, city, state, country);
	}

}
