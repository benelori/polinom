package operations;

import entity.Monom;
import java.util.ArrayList;
import java.util.List;

/**
 * This class performs the validation and parsing of the input Strings.
 * It checks if the input Strings are in the format required for polynomials
 * and if they are then it creates the monom list from the exponents and
 * coefficients.
 *
 * @author Bene Lorant
 */
public class Validation {
    /**
     * Declares the input polynomials.
     */
    String polinom1, polinom2;

    /**
     * Class constructor.
     *
     * @param polinom1
     *   Polynomial from the first text field.
     * @param polinom2
     *   Polynomial from the second text field.
     */
    public Validation(String polinom1, String polinom2) {
        this.polinom1 = polinom1;
        this.polinom2 = polinom2;
    }

    /**
     * Creates the monom objects for each polynomial that is introduced in the
     * text fields.
     *
     * @param polinom
     *   The polynomial from the text field.
     *
     * @return
     *   Returns the list of monoms from the input polynomial.
     */
    public List<Monom> createMonom(String polinom) {
        // Creates ArrayList instance of the list of monoms.
        List<Monom> monomList = new ArrayList<Monom>();
        // Splits the polinom with the x^ regex separator.
        String[] monoms = polinom.split("x\\^");
        int[] numberList = new int[(monoms.length-1)*2];
        int listLength = 0;
        numberList[listLength] = Integer.parseInt(monoms[0]);
        listLength++;
        for (int i = 1; i < monoms.length - 1; i++) {
            String[] numbers = parse(monoms[i]);
            for(int j = 0;j<numbers.length;j++) {
                numberList[listLength] = Integer.parseInt(numbers[j]);
                listLength++;
            }
        }
        numberList[listLength] = Integer.parseInt(monoms[monoms.length-1]);
        for (int i = 0; i<numberList.length; i+=2) {
            monomList.add(new Monom(numberList[i],numberList[i+1]));
        }
        return monomList;
    }

    /**
     * Validation function for the input polynomials.
     *   Splits up the polynomial by x^, + and - separators (if existent),
     *   performs integer check on the split results and checks if split results
     *   are positive and if they correspond to a coefficient-exponent pair.
     *   We also check the uniqueness of the exponents.
     *
     * @param polinom
     *   The polynomial from the text field.
     *
     * @return
     *   Returns true or false.
     */
    public boolean isValid(String polinom) {
        // Checks for the existence of the 'x^' substring, because it is
        // necessary for the input, per format specifications.
        if (!polinom.contains("x^")) {
            return false;
        }
        else {
            // Splits string by 'x^' or '+' or '-' characters.
            String[] monoms;
            String[] monom = polinom.split("x\\^|\\+|\\-");
            if (monom[0].equals("")) {
                monoms = new String[monom.length - 1];
                for (int i = 1; i < monom.length; i++) {
                    monoms[i-1] = monom[i];
                }
            }
            else {
                monoms = polinom.split("x\\^|\\+|\\-");
            }
            // Checks if polynomial is in correct format, with a
            // '1 coefficent 1 exponent' pair.
            if (monoms.length%2 == 0) {
                // Array that is used to check uniqueness of exponents.
                int unique[] = new int[monoms.length/2];
                for (int i = 0; i < unique.length; i++) {
                    unique[i] = -(i+1);
                }
                int uniqueIterator = 0;
                for (int i = 0; i < monoms.length; i++) {
                    // If the elements of the monoms array are integer, then the
                    // input polynomial has the correct format.
                    if (isInteger(monoms[i]) == false) {
                        return false;
                    }
                    else if (i%2 != 0) {
                        // Checks the sign of the exponent.
                        if (Integer.parseInt(monoms[i]) > 0) {
                            unique[uniqueIterator] = Integer.parseInt(monoms[i]);
                            uniqueIterator++;
                        }
                        else {
                            return false;
                        }
                        // Checks the uniqueness of the exponents.
                        if (checkUnique(unique) == false) {
                            return false;
                        }
                    }
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper function for checking if a String is an Integer.
     *
     * @param s
     *   Input String parameter.
     *
     * @return
     *   Returns true or false based on the integer check.
     */
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * Helper function for parsing the input polynomials.
     *
     * @param monom
     *   The result from the initial split in creatMonom function.
     *
     * @return
     *   Returns the numbers after the split by '+' or '-'.
     */
    private String[] parse(String monom) {
        String exp = "";
        String coef = "";
        if (monom.indexOf('+') >= 0) {
            exp = monom.substring(0, monom.indexOf('+'));
            coef = monom.substring(monom.indexOf('+'));
        } else if (monom.indexOf('-') >= 0) {
            exp = monom.substring(0, monom.indexOf('-'));
            coef = monom.substring(monom.indexOf('-'));
        }
        String[] numbers = {exp, coef};
        return numbers ;
    }

    /**
     * Helper function to check for the uniqueness of an introduced exponent.
     *
     * @param unique
     *   Array of coefficients from the input polynomial.
     *
     * @return
     *   Returns boolean value on uniqueness of the exponent parameter.
     */
    private boolean checkUnique(int[] unique) {
        for (int i = 0; i < unique.length - 1; i++) {
            if (unique[i] == unique[unique.length - 1]){
                return false;
            }
        }
        return true;
    }
}
