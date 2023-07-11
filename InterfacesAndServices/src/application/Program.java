package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Numero: ");
		Integer contractNumber = sc.nextInt();
		System.out.print("Data (dd/mm/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Valor do contrato: ");
		Double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(contractNumber,date,contractValue);

		System.out.print("Entre com o número de parcelas: ");
		Integer installmentNumber = sc.nextInt();
		ContractService service = new ContractService(new PaypalService());
		service.processContract(contract, installmentNumber);
		
		System.out.println("Parcelas: ");
		for(Installment installment: contract.getInstallments())
			System.out.println(installment);
		
		sc.close();
	}

}
