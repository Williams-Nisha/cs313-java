/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.jspdiscussionthread;


import edu.byui.cs313.jspdiscussionthread.model.FilePostHandler;
import edu.byui.cs313.jspdiscussionthread.model.Posts;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nisha
 */
@WebServlet(name = "CreatePosts", urlPatterns = {"/CreatePosts"})
public class CreatePosts extends HttpServlet {

    private static final long serialVersionUID = 1L;
 
     /**
     * @see HttpServlet#HttpServlet()
     */
     public CreatePosts() {
         super();
         // TODO Auto-generated constructor stub
     }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = request.getParameter("message");
        
        if (!message.isEmpty()){
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            HttpSession session = request.getSession(true);
            String user = session.getAttribute("username").toString();

            Posts newPost = new Posts(user, date, message);


            FilePostHandler handler = new FilePostHandler("list.txt");
            handler.addPost(newPost);
        
            response.sendRedirect("LoadPosts");
        }
        else {
            String error = "All fields are required!";
            request.setAttribute("error",  error); 
            request.getRequestDispatcher("/newPosts.jsp").forward(request, response);
        }
    }
}