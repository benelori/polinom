package operations;

import entity.Monom;
import java.util.List;

/**
 *
 * @author Bene Lorant
 */
public class Validation {
    String polinom1, polinom2;

    public Validation(String polinom1, String polinom2) {
        this.polinom1 = polinom1;
        this.polinom2 = polinom2;
    }
    /**
     *
     * @param polinom
     * @return
     */
    public List<Monom> parse(String polinom) {
        System.out.println(polinom);
        return null;
    }

    public boolean valid(String polinom) {
        String[] monoms = polinom.split("x\\^|\\+|\\-");
        for (int i = 0; i < monoms.length; i++) {
            if (isInteger(monoms[i]) == false) {
                return false;
            }
        }
        return true;
    }

    private boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        // only got here if we didn't return false
        return true;
    }
}
