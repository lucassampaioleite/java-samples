package subsystem.crm;

public class CrmService {
	
	private CrmService() {}
	
	public static void saveClient(String name, String zipCode, String city, String state, String country) {
		System.out.println("Cliente salvo no sistema de CRM: ");
		System.out.println("Nome: " + name);
		System.out.println("CEP: " + zipCode);
		System.out.println("Cidade: " + city);
		System.out.println("Estado: " + state);
		System.out.println("País: " + country);
	}

}
 