package adapter_design_pattern;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class PaymentIntegrationTester {

	public static boolean isValidEmail(String email) {
		String email_re = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(email_re);
		Matcher match = pattern.matcher(email);
		return match.matches();
	}

	public static void main(String[] args) throws Exception {
		Logger logger = MyLogger.getLogger();
		Scanner sc = new Scanner(System.in);
		try {
			//Create third party payment gateway instance

			ThirdPartyPaymentGateway thirdPartyGateway = new ThirdPartyPaymentGateway();

			//Construct payment processor adapter

			PaymentProcessor paymentProcessor = new PaymentAdapter(thirdPartyGateway);
		
			System.out.print("Enter user email id: ");
			String email = sc.nextLine();
			int faultAttempt = 0;
			while(!isValidEmail(email)) {
			System.out.println("Invalid email");
				logger.log(Level.INFO,"Invalid email");
				faultAttempt++;
				if(faultAttempt == 3) {
					System.out.println("Payment gateway is locked for now due to multiple failed attempts. Try after 12 hours");
					logger.log(Level.SEVERE,"Payment failed due to multiple failed attempts");
					return;
				}
			System.out.println("Enter valid user email id: ");
			email = sc.nextLine();
			}
			System.out.print("Enter amount to pay: ");
			double amount = sc.nextDouble();
			//Process payment

			boolean success = paymentProcessor.processPayment(email, amount);

			logger.info("Payment succeeded: " + success);

			//Attempt payment with empty account number

			try {

				paymentProcessor.processPayment("", 50.00);

			} catch (IllegalArgumentException e) {

				logger.warning("Exception caught: " + e.getMessage());

			}

			//Try negative payment amount

			try {

				paymentProcessor.processPayment("user@email.com", -10.00);

			} catch (IllegalArgumentException e) {

				logger.warning("Exception caught: " + e.getMessage());

			}

		} catch (Exception e) {

			logger.severe("Payment processing error: " + e.getMessage());
			throw new Exception("Payment processing failed: " + e.getMessage());


		}
		sc.close();
	}
}