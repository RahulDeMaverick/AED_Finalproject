/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import javax.swing.JPanel;
import ui.DonorAdmin.DonorAdminJPanel;
import ui.HostpitalAdmin.PatientPanel;

/**
 *
 * @author kashr
 */
public class PatientRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, EcoSystem business, String ID) {
        return new PatientPanel(container, business, ID);
    }
}
