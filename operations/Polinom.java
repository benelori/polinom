package operations;

import entity.Monom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Bene Lorant
 */
public class Polinom implements Operations{
    List<Monom> polinom1;
    List<Monom> polinom2;
    List<Monom> result;

    public Polinom(List<Monom> list1, List<Monom> list2) {
        this.polinom1 = list1;
        this.polinom2 = list2;
    }

    /**
     *
     * @return
     */
    @Override
    public String add() {
        result = new ArrayList<Monom>();
        Iterator<Monom> it1 = polinom1.iterator();
        Iterator<Monom> it2 = polinom2.iterator();
        while (it1.hasNext()) {
            Monom monom1 = it1.next();
            while (it2.hasNext()) {
                Monom monom2 = it2.next();
                if (monom2.getExponent() == monom1.getExponent()) {
                    int newCoef = monom1.getCoeficcient() + monom2.getCoeficcient();
                    result.add(new Monom(newCoef,monom1.getExponent()));
                    it1.remove();
                    it2.remove();
                }
            }
            it2 = polinom2.iterator();
        }
        if (!polinom1.isEmpty()) {
            for (Monom monom : polinom1) {
                result.add(monom);
            }
        }
        if (!polinom2.isEmpty()) {
            for (Monom monom : polinom2) {
                result.add(monom);
            }
        }
        return resultString(result);
    }

    /**
     *
     * @return
     */
    @Override
    public String substract() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public String multiply() {
        return null;
    }

    /**
     *
     * @param polinom
     * @return
     */
    @Override
    public String derivation(List<Monom> polinom) {
        return null;
    }

    private String resultString(List<Monom> result) {
        String resultString = "";
        Collections.sort(result, ORDER);
        for (Monom monom : result) {
            resultString += monom.getCoeficcient() + "x^" + monom.getExponent() + "+";
        }
        resultString = resultString.replace("+-", "-");
        resultString = resultString.substring(0, resultString.length() - 1);
        return resultString;
    }

    static final Comparator<Monom> ORDER = new Comparator<Monom>() {
        @Override
        public int compare(Monom e1, Monom e2) {
            int comparison = 1;
            if (e2.getExponent() < e1.getExponent()) {
                comparison = -1;
            }
            return comparison;
        }
    };
}
