package entity;

/**
 *
 * @author Bene Lorant
 */
public class Monom {
    private int coeficcient;
    private int exponent;

    public Monom(int coeficcient, int exponent) {
        this.coeficcient = coeficcient;
        this.exponent = exponent;
    }

    public int getCoeficcient() {
        return coeficcient;
    }

    public void setCoeficcient(int coeficcient) {
        this.coeficcient = coeficcient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        return "Monom{" + "coeficcient=" + coeficcient + ", exponent=" + exponent + '}';
    }
}
