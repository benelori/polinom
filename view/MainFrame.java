/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.MainFrameController;
import javax.swing.*;

/**
 *
 * @author Bene Lorant
 */
public class MainFrame {
    /**
     * Declares frame.
     */
    private JFrame frame;

    /**
     * Declares input text fields for polynomials.
     */
    private JTextField polinom1, polinom2;

    /**
     * Declares buttons that perform the operations.
     */
    private JButton addButton, subButton, multiplyButton, derivateButton;

    /**
     * Declares example Labels that will appear on the frame with instructions
     * for polynomial input format.
     */
    private JLabel example1, example2, example3;

    /**
     * Initializes the Main Frame.
     *
     * @param mfc
     *   Main Frame Controller object, that handles everything that happens
     *   with the GUI elements defined on the Main Frame.
     */
    public MainFrame(MainFrameController mfc) {
        initFrame(mfc);
    }

    /**
     * Initializes the frame with GUI elements.
     *
     * @param mfc
     *   Controller object that manages GUI elements.
     */
    private void initFrame(MainFrameController mfc) {
        /*
         * Creates instances of all the elements required for the GUI.
         */

        // Creates frame instance.
        frame = new JFrame();
        // Creates instances of text fields for polynomials' input.
        polinom1 = new JTextField("1x^1+1x^2");
        polinom2 = new JTextField("1x^1+1x^2");
        // Creates instance of Add button for performing addition.
        addButton = new JButton("Add");
        subButton = new JButton("Substract");
        multiplyButton = new JButton("Multiply");
        derivateButton = new JButton("Derivate");
        // Creates instance of example Label.
        example1 = new JLabel("Please use the following format for polynomial input:");
        example2 = new JLabel("<coefficent>x^<exponent> <operation> <coefficent>x^<exponent>");
        example3 = new JLabel("E.g. 2x^3-4x^2+5x^1+6x^0");

        /*
         * Configures elements of the GUI.
         */

        // Configures frame properties.
        frame.setSize(900, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // Configures input text fields.
        polinom1.setBounds(50, 50, 800, 30);
        frame.add(polinom1);
        polinom2.setBounds(50, 100, 800, 30);
        frame.add(polinom2);
        // Configures Add button and adds action listener.
        addButton.setBounds(50, 150, 100, 50);
        frame.add(addButton);
        addButton.addActionListener(mfc.getActionListener());
        // Configures Substract button and adds action listener.
        subButton.setBounds(50, 250, 100, 50);
        frame.add(subButton);
        subButton.addActionListener(mfc.getActionListener());
        // Configures Mulitply button and adds action listener.
        multiplyButton.setBounds(50, 350, 100, 50);
        frame.add(multiplyButton);
        multiplyButton.addActionListener(mfc.getActionListener());
        // Configures Mulitply button and adds action listener.
        derivateButton.setBounds(50, 450, 100, 50);
        frame.add(derivateButton);
        derivateButton.addActionListener(mfc.getActionListener());
        // Configures example Labels.
        example1.setBounds(50, 150, 800, 30);
        frame.add(example1);
        example2.setBounds(50, 180, 800, 30);
        frame.add(example2);
        example3.setBounds(50, 210, 800, 30);
        frame.add(example3);
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

    public JButton getSubButton() {
        return subButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDerivateButton() {
        return derivateButton;
    }
}
