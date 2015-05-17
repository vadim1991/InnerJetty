package com.dassader.servlet;

import com.dassader.command.Command;
import com.dassader.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 25.04.2015.
 */
public class ControlProcessServlet extends HttpServlet {

    private CommandContainer commandContainer;

    @Override
    public void init() throws ServletException {
        commandContainer = new CommandContainer();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        String processName = req.getParameter("process");

        if (commandName != null) {
            if (processName != null) {
                Command command = commandContainer.getCommand(commandName);
                command.execute(processName, resp);
                return;
            }
            Command command = commandContainer.getCommand(commandName);
            command.execute(processName, resp);
        }
    }
}
