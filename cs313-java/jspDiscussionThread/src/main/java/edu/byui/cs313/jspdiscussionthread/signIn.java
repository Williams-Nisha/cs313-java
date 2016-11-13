/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.jspdiscussionthread;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 *
 * @author Nisha
 */

@WebServlet(name = "signIn", urlPatterns = {"/signIn"})
public class signIn extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
         public signIn(){
         super();
         // TODO Auto-generated constructor stub
     }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user = request.getParameter("username"); 
        String pass = request.getParameter("password"); 
        
        String filename = "/passwords.txt";
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream(filename);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            PrintWriter writer = response.getWriter();
            String text;
            Boolean found = false;

            while ((text = reader.readLine()) != null) {
                    String[] credentials = text.split(":");
                    String username = credentials[0];
                    String password = credentials[1];

                   if(username.equals(user) && password.equals(pass)){ 
                       found = true;
      
                       break;
                   }
            }
            if(found){
                request.getSession().setAttribute("username", user);
                request.getRequestDispatcher("/newPosts.jsp").forward(request, response);
                
            }
            else{
                String error = "Wrong username or password";
                request.setAttribute("error",  error); 
                request.getRequestDispatcher("/invalidLogin.jsp").forward(request, response);
            }
        }

    } 
    
    
    }

