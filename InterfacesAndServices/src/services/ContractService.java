package services;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {

		Double quota = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {
			Double interest = onlinePaymentService.interest(quota, i);
			Double fee = onlinePaymentService.paymentFee(quota + interest);
			contract.addInstallment(new Installment(contract.getDate().plusMonths(i), quota + interest + fee));
		}
	}

}
