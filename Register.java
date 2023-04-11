
package com.signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

    
    public class Register extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h2> Registered Successfully.....!</h2>");
        
            //name fetch
            String name=request.getParameter("user_name");
            String password=request.getParameter("user_password");
            String email=request.getParameter("user_email");
            
            out.print("user Name is : - " + name +"<br>");
            out.print("user Password is : - " + password +"<br>");
            out.print("user Email is : - " + email +"<br>");
            
            try {
            //load the driver......
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //creating a connection........
            String url="jdbc:mysql:/registration"; 
            String username="root";
            String pass="Prashant302";
            
            Connection con=DriverManager.getConnection(url,username,pass);
            
            String q="insert into students(tName,tPassword,tEmail) values (?,?,?) ";
            
            //Get prepare Statement Object.......
            PreparedStatement ptmt=con.prepareStatement(q);
            
            ptmt.setString(1, name);
            ptmt.setString(2, password);
            ptmt.setString(3, email);
            
            ptmt.executeUpdate();
            
            out.print("<h2>Successfully Data is Stored.........!!</h2>");
            
            con.close();
            
            } catch (Exception e) {
                
            out.println(e);
        }
        
    }    
}

