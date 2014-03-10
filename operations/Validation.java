package operations;

import entity.Monom;
import java.util.List;

/**
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
     */
    public List<Monom> createMonom(String polinom) {
        // Splits the polinom with the x^ regex separator.
        String[] monoms = polinom.split("x\\^");
        int[] numberList = new int[10];
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
        for (int i = 0; i<numberList.length; i++) {
            System.out.println(numberList[i]);
        }


        return null;
    }

    /**
     * Validation function for the input polynomials.
     *   Splits up the polynomial by x^, + and - separators (if existent), and
     *   performs integer check on the split results.
     *
     * @param polinom
     *   The polynomial from the text field.
     *
     * @return
     *   Returns true or false.
     */
    public boolean isValid(String polinom) {
        // Splits string by 'x^' or '+' or '-' characters.
        String[] monoms = polinom.split("x\\^|\\+|\\-");
        for (int i = 0; i < monoms.length; i++) {
            if (isInteger(monoms[i]) == false) {
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
}
