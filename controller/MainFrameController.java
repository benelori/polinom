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
 * This class is the controller class that manages the initialization of the GUI
 * and the actions that are performed on the GUI elements.
 *
 * @author Bene Lorant
 */
public class MainFrameController {
    /**
     * Declaration of the controller variable.
     */
    MainFrame mf;
    
    /**
     * Creates the MainFrame instance only once.
     */
    public MainFrameController() {
        mf = new MainFrame(this);
    }

    /**
     * Getter function for the Action Listeners of the GUI elements.
     *
     * @return
     *   Returns the action that is performed on GUI element.
     */
    public ActionListener getActionListener() {
        return actionListener;
    }
    
    /**
     * Overridden function of the default Action Listener. It performs actions
     * on the GUI elements that have action listeners added to them.
     */
    private ActionListener actionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Gets the Strings from the text fields.
            String polinom1 = mf.getPolinom1().getText();
            String polinom2 = mf.getPolinom2().getText();
            // Creates validation object for the Strings that have been
            // introduced into the text fields.
            Validation v = new Validation(polinom1, polinom2);
            // Validates the Strings, checks if they are polynomials introduced
            // in the specified format.
            if (v.isValid(polinom1) && v.isValid(polinom2)) {
                // Creates Monom list object after passing validations.
                List<Monom> list1 = v.createMonom(polinom1);
                List<Monom> list2 = v.createMonom(polinom2);
                Operations operation = new Polinom(list1,list2);
                // Creates new polinom instance.
                if (e.getSource() == mf.getAddButton()) {
                    String result = operation.add();
                    System.out.println(result);
                } else if (e.getSource() == mf.getSubButton()) {
                    String result = operation.substract();
                    System.out.println(result);
                }
            }
        }
    };
}
