/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import javax.swing.JPanel;
import ui.DonorAdmin.DonorAdminJPanel;
import ui.HostpitalAdmin.Hospitaladmin;

/**
 *
 * @author kashr
 */
public class HospitalAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, EcoSystem business, String ID) {
        return new Hospitaladmin(container, business, ID);
    }
}
