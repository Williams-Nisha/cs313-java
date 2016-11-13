/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.jspdiscussionthread;

import edu.byui.cs313.jspdiscussionthread.model.FilePostHandler;
import edu.byui.cs313.jspdiscussionthread.model.PostDataHandler;
import edu.byui.cs313.jspdiscussionthread.model.Posts;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nisha
 */
@WebServlet(name = "LoadPosts", urlPatterns = {"/LoadPosts"})
public class LoadPosts extends HttpServlet {

        public LoadPosts() {
          super();
          // TODO Auto-generated constructor stub
     }
       
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PostDataHandler handler = new FilePostHandler("list.txt");
            request.setAttribute("posts", handler.getPosts());
            request.getRequestDispatcher("viewPosts.jsp").forward(request,response);

       } 

}