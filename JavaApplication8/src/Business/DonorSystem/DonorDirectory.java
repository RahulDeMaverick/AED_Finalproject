/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DonorSystem;

import Business.BloodBankResearcher.BloodBankResearcherDirectory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.jdbcConnection;

/**
 *
 * @author kashr
 */
public class DonorDirectory {
    ArrayList<Donor> directory;

    public ArrayList<Donor> getDirectory() {
        return directory;
    }

    public void setDirectory(ArrayList<Donor> directory) {
        this.directory = directory;
    }
    
    public String getName(String insuranceNumber)
{   
    jdbcConnection jdbconnection = new jdbcConnection();
    Connection conn = jdbconnection.connect();
    String name=null;
        try {
            ResultSet rs = null;
            
            String sql = "SELECT name FROM bloodResearcherTable WHERE personId=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, insuranceNumber);
            
            
            //System.out.print(jTextField3.getText());

            rs = statement.executeQuery();
            while(rs.next())
            {
            name = rs.getString("name");
            
            }

}      
        catch (SQLException ex) {
            Logger.getLogger(DonorDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }        finally
        {
            jdbconnection.disConnnect(conn);
        }
        return name;
} 
    public String getOrganResearcherName(String insuranceNumber)
{
jdbcConnection jdbconnection = new jdbcConnection();
Connection conn = jdbconnection.connect();
String name=null;
try {
ResultSet rs = null;

String sql = "SELECT name FROM organResearcherTable WHERE personId=?";
PreparedStatement statement = conn.prepareStatement(sql);
statement.setString(1, insuranceNumber);


//System.out.print(jTextField3.getText());



rs = statement.executeQuery();
while(rs.next())
{
name = rs.getString("name");

}



}
catch (SQLException ex) {
Logger.getLogger(DonorDirectory.class.getName()).log(Level.SEVERE, null, ex);
} finally
{
jdbconnection.disConnnect(conn);
}
return name;
}
}
