package adapter_design_pattern;

import java.util.logging.Logger;

public class PaymentAdapter implements PaymentProcessor {

	Logger logger = MyLogger.getLogger();

	private ThirdPartyPaymentGateway thirdPartyPaymentGateway;
	
	//Constructor of PaymentAdapter
	public PaymentAdapter(ThirdPartyPaymentGateway thirdPartyPaymentGateway) {

		if (thirdPartyPaymentGateway == null) {

			throw new IllegalArgumentException("Third-party payment gateway cannot be null");

		}

		this.thirdPartyPaymentGateway = thirdPartyPaymentGateway;

	}

	@Override

	public boolean processPayment(String accountNumber, double amount) throws Exception {

		// Input validation

		if (accountNumber == null || accountNumber.isEmpty()) {

			logger.severe("Invalid account number");

			throw new IllegalArgumentException("Account number cannot be null or empty");

		}

		if (amount <= 0) {

			logger.severe("Invalid payment amount");

			throw new IllegalArgumentException("Payment amount must be greater than zero");

		}

		try {

			// Assuming the account number is an email in this case for the third-party API

			logger.info("Processing payment for account: " + accountNumber + " for amount: $" + amount);

			boolean result = thirdPartyPaymentGateway.sendPayment(accountNumber, amount);

			if (result) {

				logger.info("Payment processed successfully for account: " + accountNumber);

			} else {

				logger.warning("Payment failed for account: " + accountNumber);

			}

			return result;

		} catch (Exception e) {

			logger.severe("Error occurred during payment processing: " + e.getMessage());

			throw new Exception("Payment processing failed: " + e.getMessage());

		}

	}

}
