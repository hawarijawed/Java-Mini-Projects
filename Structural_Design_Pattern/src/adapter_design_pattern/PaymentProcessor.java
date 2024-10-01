package adapter_design_pattern;

public interface PaymentProcessor {
	boolean processPayment(String accountNumber, double amount) throws Exception;

}

class ThirdPartyPaymentGateway {

	public boolean sendPayment(String email, double amount) {

		// Simulate third-party API processing

		System.out.println("Payment sent via Third-Party Gateway for " + email + " with amount: " + amount);

		return true;

	}

}



