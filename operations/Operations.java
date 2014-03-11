package operations;

import entity.Monom;
import java.util.List;

/**
 *
 * @author Bene Lorant
 */
public interface Operations {
    /**
     *
     * @return
     */
    public String add();
    public String substract();
    public String multiply();
    public String derivation(List<Monom> polinom);
}
