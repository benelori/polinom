package operations;

import entity.Monom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bene Lorant
 */
public class Polinom implements Operations{
    List<Monom> polinom1;
    List<Monom> polinom2;

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
        return null;
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
}
