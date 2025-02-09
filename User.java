/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.model;

/**
 *
 * @author Alex
 */
public class User 
{
    private String name;
    private String surname;
    private String email;
    private String password;

    public User() {
        this.name = "Manez";
        this.surname = "Libele";
        this.email = "manezlibele@gmail.com";
        this.password = "123@Manez";
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String displayTheDetails(String name, String surname , String email)
    {
        return "Hello "+name+" "+surname+" You are succesful registered your email address  is"+email;
    }
    
}
