package com.dassader.servlet;

import com.dassader.ErrorMessage;
import com.dassader.command.Command;
import com.dassader.command.CommandContainer;
import com.dassader.command.RunFileCommand;
import com.dassader.util.FileExplorer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Andrii_Kulikov
 */
public class FileServlet extends HttpServlet {

    private CommandContainer commandContainer;

    @Override
    public void init() throws ServletException {
        commandContainer = new CommandContainer();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        String commandName = req.getParameter("command");

        if (path == null) {
            resp.getWriter().write("Please enter parameter 'path'");
            return;
        }

        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(ErrorMessage.FILE_NOT_FOUND + path);
        }
        if (file.isFile()) {
            if (commandName != null) {
                Command command = commandContainer.getCommand(commandName);
                command.execute(path, resp);
            } else {
                new RunFileCommand().execute(path, resp);
            }
            return;
        }
        FileExplorer fileExplorer = new FileExplorer(path);
        resp.getWriter().write(fileExplorer.getJSONFileList().toString());
    }
}

