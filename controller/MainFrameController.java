/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainFrame;

/**
 *
 * @author lolo
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
            if (e.getSource() == mf.getAddButton()) {
                System.out.println("LOL");
            }
        }
    };

}
