package controller;

import entity.Monom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import operations.Operations;
import operations.Polinom;
import operations.Validation;
import view.MainFrame;

/**
 *
 * @author Bene Lorant
 */
public class MainFrameController {
    MainFrame mf;
    
    public MainFrameController() {
        mf = new MainFrame(this);
    }

    public ActionListener getActionListener() {
        return actionListener;
    }
    
    private ActionListener actionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polinom1 = mf.getPolinom1().getText();
            String polinom2 = mf.getPolinom2().getText();
            // Documentation for parsing and validation.
            Validation v = new Validation(polinom1, polinom2);
            List<Monom> list1 = v.parse(polinom1);
            List<Monom> list2 = v.parse(polinom2);
            // Creates new polinom instance.
            Operations pol1 = new Polinom(list1,list2);
            if (e.getSource() == mf.getAddButton()) {
                System.out.println("LOL");
            }
        }
    };
}
