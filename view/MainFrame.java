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
 * @author lolo
 */
public class MainFrame {
    private JFrame frame;
    private JTextField polinom1;
    private JButton addButton;
    
    public MainFrame(MainFrameController mfc) {
        initFrame(mfc);
    }

    private void initFrame(MainFrameController mfc) {
        frame = new JFrame();
        polinom1 = new JTextField("Initial");
        addButton = new JButton("Add");
        
        frame.setSize(600, 600);
        frame.setLayout(null);
        
        polinom1.setBounds(50, 50, 150, 30);
        frame.add(polinom1);
        
        addButton.setBounds(50, 100, 50, 50);
        frame.add(addButton);
        
        addButton.addActionListener(mfc.getActionListener());
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public JTextField getPolinom1() {
        return polinom1;
    }

    public JButton getAddButton() {
        return addButton;
    }    
}
