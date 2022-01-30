/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import Business.EcoSystem;
import javax.swing.JPanel;
import ui.OrganResearch.OrganResearchJPanel;
/**
 *
 * @author ABHI
 */
public class OrganResearcherRole {
    public JPanel createWorkArea(JPanel container, EcoSystem business, String ID) {
        return new OrganResearchJPanel(container, business, ID);
    }
}
