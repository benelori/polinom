/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.MainFrameController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Bene Lorant
 */
public class MainFrame {
    private JFrame frame;
    /**
     * Declares input text fields for polynomials.
     */
    private JTextField polinom1, polinom2;
    /**
     * Declares buttons that perform the operations.
     */
    private JButton addButton;
    
    public MainFrame(MainFrameController mfc) {
        initFrame(mfc);
    }

    private void initFrame(MainFrameController mfc) {
        /*
         * Creates instances of all the elements required for the GUI.
         */
        
        // Creates frame instane.
        frame = new JFrame();
        // Creates instances of text fields for polynomials' input.
        polinom1 = new JTextField("Initial");
        polinom2 = new JTextField("Initial2");
        // Creates instance of Add button for performing addition.
        addButton = new JButton("Add");
        
        /*
         * Configures elements of the GUI.
         */
        
        // Configures frame properties.
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // Configures input text fields.
        polinom1.setBounds(50, 50, 150, 30);
        frame.add(polinom1);
        polinom2.setBounds(50, 100, 150, 30);
        frame.add(polinom2);
        //Configures Add button and adds action listener.
        addButton.setBounds(50, 150, 100, 50);
        frame.add(addButton);
        addButton.addActionListener(mfc.getActionListener());
    }

    public JTextField getPolinom1() {
        return polinom1;
    }
    
    public JTextField getPolinom2() {
        return polinom2;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
