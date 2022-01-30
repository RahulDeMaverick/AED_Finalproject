/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import javax.swing.JPanel;
import ui.DonorAdmin.DonorAdminJPanel;
import ui.HostpitalAdmin.DoctorPanel;

/**
 *
 * @author kashr
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, EcoSystem business, String ID) {
        return new DoctorPanel(container, business, ID);
    }
}
