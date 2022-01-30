/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrganBankResearcher;
import Business.OrganBankResearcher.OrganBankResearcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import model.jdbcConnection;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ABHI
 */
public class OrganBankResearcherDirectory {
      public TableModel getOrganBankResearcherDirectory(String insuranceNumber)
    {       jdbcConnection jdbconnection = new jdbcConnection();
            Connection conn = jdbconnection.connect();
            ResultSet rs = null;
            TableModel resultSetToTableModel = null;
        try {
            
            
            String sql = "SELECT * FROM organResearcherTable where OrganBankID=?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1,insuranceNumber);
            
            //System.out.print(jTextField3.getText());

            rs = statement.executeQuery();
        resultSetToTableModel = DbUtils.resultSetToTableModel(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(OrganBankResearcherDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        { jdbconnection.disConnnect(conn);
        }
        return resultSetToTableModel;
    }
    public String addOrganResearcher(OrganBankResearcher researcher,String userName,String password)
    { jdbcConnection jdbconnection = new jdbcConnection();
    Connection conn = jdbconnection.connect();
    String insuranceNumber = jdbconnection.createrole(userName, password,"organbankresearcher");
    String message= null;
    String sql = "INSERT INTO organResearcherTable(name,age,Address,zipCode,City,phoneNumber,OrganBankID,personId) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,researcher.getName());
            pstmt.setString(2,researcher.getAge());
            pstmt.setString(3,researcher.getAddress());
            pstmt.setString(4,researcher.getZipCode());
            pstmt.setString(5,researcher.getCity());
            pstmt.setString(6,researcher.getPhoneNumber());
            pstmt.setString(7,researcher.getOrganBankId());
//            pstmt.setString(8,researcher.getWorkAssigned());
            pstmt.setString(8,insuranceNumber);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        finally
        {
        jdbconnection.disConnnect(conn);
        }
    return message;
    
    }
    public String[] getCredentials(String insuranceNumber)
{   String[] arr = new String[2];
    jdbcConnection jdbconnection = new jdbcConnection();
    Connection conn = jdbconnection.connect();
        try {
            ResultSet rs = null;
            
            String sql = "SELECT userName,password FROM personTable WHERE insuranceNumber=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, insuranceNumber);
            
            
            //System.out.print(jTextField3.getText());

            rs = statement.executeQuery();
            while(rs.next())
            {
            arr[0] = rs.getString("userName");
            arr[1] = rs.getString("password");
            }

}      
        catch (SQLException ex) {
            Logger.getLogger(OrganBankResearcherDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }        finally
        {
            jdbconnection.disConnnect(conn);
        }
        return arr;
}
    public String updateOrganResearcher(OrganBankResearcher researcher,String userName,String password)
    { jdbcConnection jdbconnection = new jdbcConnection();
    Connection conn = jdbconnection.connect();
//    String insuranceNumber = jdbconnection.createrole(userName, password,"bloodbankresearcher");
    String message= null;
    String sql = "UPDATE organResearcherTable SET name=?,age= ?,Address= ?,zipCode=?,City =?,phoneNumber=? WHERE personId =?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,researcher.getName());
            pstmt.setString(2,researcher.getAge());
            pstmt.setString(3,researcher.getAddress());
            pstmt.setString(4,researcher.getZipCode());
            pstmt.setString(5,researcher.getCity());
            pstmt.setString(6,researcher.getPhoneNumber());
            pstmt.setString(7,researcher.getForeignKey());
//            pstmt.setString(8,researcher.getWorkAssigned());
            //pstmt.setString(8,researcher.getForeignKey());
            pstmt.executeUpdate();
            updateCredentials(researcher.getForeignKey(),userName,password);
            
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        finally
        {
        jdbconnection.disConnnect(conn);
        }
    return message;
    
    }
    public String[] updateCredentials(String insuranceNumber,String username, String password)
{   String[] arr = new String[2];
    jdbcConnection jdbconnection = new jdbcConnection();
    Connection conn = jdbconnection.connect();
        try {
            ResultSet rs = null;
            
            String viewStatement = "UPDATE personTable SET userName=?,password=? WHERE insuranceNumber=?";
            PreparedStatement pstmt;
           pstmt = conn.prepareStatement(viewStatement);
           pstmt.setString(1,username);
           pstmt.setString(2, password);
           pstmt.setString(3,insuranceNumber);
           
       //    pstmt.setString(6,jLabel15.getText());
            pstmt.executeUpdate();

            
            
            //System.out.print(jTextField3.getText());

//            rs = statement.executeQuery();


}       catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            jdbconnection.disConnnect(conn);
        }
        return arr;
}
}
