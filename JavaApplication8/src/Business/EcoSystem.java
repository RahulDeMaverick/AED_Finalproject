/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.DonorSystem.Donor;
import Business.DonorSystem.DonorDirectory;
import Business.Role.DonorAdminRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.jdbcConnection;

/**
 *
 * @author MyPC1
 */
public class EcoSystem {
    
    private static EcoSystem business;    
    private static jdbcConnection connection;
    
    // Ctor
    private EcoSystem(){
        EcoSystem.connection = new jdbcConnection();
    }
    
    public jdbcConnection getConnection(){
        return EcoSystem.connection;
    }
        
    public static EcoSystem getInstance(){
        
        if(business==null){
            business=new EcoSystem();            
        }
        return business;
    }
            
    // validate mobile number
    public Boolean validateMobileNo(String phoneNo)
    {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phoneNo);
        return (matcher.matches());
       
    }
    public Boolean validateEmail(String email)
    {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return (matcher.matches());
    }
    
    public DonorDirectory getDonorList(){
        return connection.getDonorList();
    }
    
    public Donor getDonor(String ID){
        return connection.getDonor(ID);
    }
    
    public void updateDonor(Donor donor){
        connection.updateDonor(donor);
    }
}
