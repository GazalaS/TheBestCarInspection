
package integration;


    

import java.time.YearMonth;

/**
 * Represents a specific credit card.
 */
public final class CreditCardDTO {
    private final int pin;
    private final String number;
    private final String holder;
    private final YearMonth expiryDate;
    private final int CVC;

    /**
     * Creates a new instance representing the specified card.
     *
     * @param pin        The pin code.
     * @param number     The card number.
     * @param holder     The name of the card holder.
     * @param expiryDate The expiry date.
     * @param CVC        The CVC code.
     */
    public CreditCardDTO(int pin, String number, String holder, YearMonth expiryDate, int CVC) {
        this.pin = pin;
        this.number = number;
        this.holder = holder;
        this.expiryDate = expiryDate;
        this.CVC = CVC;
    }

    /**
     * @return the CVC code
     */
    public int getCVC() {
        return CVC;
    }

    /**
     * @return the expiry date
     */
    public YearMonth getExpiryDate() {
        return expiryDate;
    }

    /**
     * @return the card holder's name.
     */
    public String getCardHolder() {
        return holder;
    }

    /**
     * @return the card number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return the pin code.
     */
    public int getPin() {
        return pin;
    }
}

    

