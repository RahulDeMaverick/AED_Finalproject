/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DonorSystem;

import Business.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.jdbcConnection;

/**
 *
 * @author kashr
 */
public class Donor extends Person{
    
    String bloodGroup, email, address, city, phoneNumber;
    int age;
    boolean isBloodDonor;
    boolean isOrganDonor;
    ArrayList<String> donatedOrgans;
    ArrayList<String> organsToDonate;

    public ArrayList<String> getOrgansToDonate() {
        return organsToDonate;
    }

    public void setOrgansToDonate(ArrayList<String> organsToDonate) {
        this.organsToDonate = organsToDonate;
      if(organsToDonate.size() > 0 )
            this.isOrganDonor = true;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public Donor(boolean isBloodDonor, boolean isOrganDonor, String bloodGroup, String name, String password, String _ID, String phoneNumber, String address, String city, int age, String email) {
        super(name, password, _ID);
        this.isBloodDonor = isBloodDonor;
        this.isOrganDonor = isOrganDonor;
        this.donatedOrgans = donatedOrgans;
        this.bloodGroup = bloodGroup;       
        this.phoneNumber= phoneNumber;
        this.address= address;
        this.city= city;
        this.age= age;
        this.email=email;
        this.donatedOrgans = new ArrayList();
        this.organsToDonate = new ArrayList();
    }

    public boolean isIsBloodDonor() {
        return isBloodDonor;
    }

 

    public void setIsBloodDonor(boolean isBloodDonor) {
        this.isBloodDonor = isBloodDonor;
    }

    public boolean isIsOrganDonor() {
        return isOrganDonor;
    }

    public void setIsOrganDonor(boolean isOrganDonor) {
        this.isOrganDonor = isOrganDonor;
    }

    public ArrayList<String> getDonatedOrgans() {
        return donatedOrgans;
    }

    public void setDonatedOrgans(ArrayList<String> donatedOrgans) {
        this.donatedOrgans = donatedOrgans;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public void organDonationStatus(String insuranceNumber)
    {
        jdbcConnection jdbc = new jdbcConnection();
        String sql = "update donorTable set organDonation=1 and bloodDonation=0 where insuranceNumber=?";
        Connection conn =jdbc.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);            
            pstmt.setString(1, insuranceNumber);
//            pstmt.setString(2, name);
//            pstmt.setInt(3, age);
//            pstmt.setString(4, contact);
//            pstmt.setString(5, address);
//            pstmt.setString(6, city);
//            pstmt.setString(7, email);
//            pstmt.setInt(8, organDonation);
//            pstmt.setString(9, OrgansToDonateStr);
//            pstmt.setString(10, donatedOrganStr);
//            pstmt.setString(11, donor.getUniqueID());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        jdbc.disConnnect(conn);
        
    }
}
