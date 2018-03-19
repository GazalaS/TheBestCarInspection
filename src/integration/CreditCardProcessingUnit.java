package integration;

/**
 * Handles all communication with the payment authorization system.
 */
public class CreditCardProcessingUnit {

    /**
     * Requests authorization for the specified payment.
     *
     * @param card The card used for the payment.
     * @param amount The amount to pay.
     * @return <code>true</code> if the payment is authorized,
     * <code>false</code> if it is not. This dummy implementation always returns
     * <code>true</code>.
     */
    public boolean authorizePayment(CreditCardDTO card, int amount) {
        return true;
    }
}
