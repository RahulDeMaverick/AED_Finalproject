package Business.Role;

import Business.EcoSystem;
import javax.swing.JPanel;
import ui.BloodBank.BloodResearchJPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ABHI
 */
public class BloodResearcherRole {
    public JPanel createWorkArea(JPanel container, EcoSystem business, String ID) {
        return new BloodResearchJPanel(container,business,ID);
    }
}
