/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Person;

import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
            
    public abstract JPanel createWorkArea(JPanel container, EcoSystem business, String ID);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}