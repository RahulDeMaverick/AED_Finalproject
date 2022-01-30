/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BloodBankResearcher;

/**
 *
 * @author ABHI
 */
public class BloodBankResearcher {
    private String id;
    private String Name;
    private String Age;
    private String Address;
    private String phoneNumber;
    private String zipCode;
    private String City;
    private String bloodBankID;
    private String workAssigned;
    private String foreignKey;

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
 
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodBankID() {
        return bloodBankID;
    }

    public void setBloodBankID(String bloodBankID) {
        this.bloodBankID = bloodBankID;
    }

    public String getWorkAssigned() {
        return workAssigned;
    }

    public void setWorkAssigned(String workAssigned) {
        this.workAssigned = workAssigned;
    }
    


    
}
