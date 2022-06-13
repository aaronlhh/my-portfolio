package com.google.sps.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /movie URL. Try running a server and navigating to /movie! */
@WebServlet("/movie")
public class HelloWorldServlet extends HttpServlet {
    ArrayList<String> list = new ArrayList<String>(Arrays.asList("Big Bang Theories", "Avengers", "Star Wars", "Harry Potter"));

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // convert the arraylist to json array
        Gson gson = new Gson();
        String json = gson.toJson(list);

        // send json string as response
        // response.setContentType("text/html;");
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }
}
