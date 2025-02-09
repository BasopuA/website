/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class AssetwiseDatabase 
{
    
    private static final String URL ="jdbc:derby://localhost:1527/Assetwise";
    
     public static Connection getConnection() throws SQLException
     {
        return DriverManager.getConnection(URL);
    }
    public void addUser(User user) throws SQLException
    {
        String sql = "INSER INTO users(name, surname,email,password) "
                + "VALUES(?,?,?,?)";
        
        try
        {
            Connection conn = AssetwiseDatabase.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "The user is Loaded into Assetwise database");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean passwordVerify(String email, String password)
    {
        String sql = "SELECT password FROM users WHERE email =?";
        
        try {
            Connection conn = AssetwiseDatabase.getConnection();
            PreparedStatement pstmt =  conn.prepareStatement(sql);
            pstmt.setString(1, email);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next())
            {
                String storedPassword = rs.getString("password");
                
                return storedPassword.equals(password);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean emailExist(String email)
    {
        String sql = "SELECT email FROM users WHERE email =?";
        
        try {
            Connection conn = AssetwiseDatabase.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updatePassword(String email, String newPassword)
    {
        String sql = "UPDATE users SET password=? WHERE email = ?";
        try {
            Connection conn = AssetwiseDatabase.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);
            
            int rowsUdated = pstmt.executeUpdate();
            
            return rowsUdated > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
