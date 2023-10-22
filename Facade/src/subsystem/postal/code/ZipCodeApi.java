package subsystem.postal.code;

public class ZipCodeApi {
	
	private static ZipCodeApi instance = new ZipCodeApi();
	
	private ZipCodeApi() {}
	
	public static ZipCodeApi getInstance() {
		return instance;
	}
	
	public String getCityByZipCode(String zipCode) {
		return "Recife";
	}
	
	public String getStateByZipCode(String zipCode) {
		return "Pernambuco";
	}
	
	public String getCountryByZipCode(String zipCode) {
		return "Brasil";
	}

}
