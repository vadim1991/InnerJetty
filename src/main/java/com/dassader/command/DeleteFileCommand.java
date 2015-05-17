package com.dassader.command;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 24.04.2015.
 */
public class DeleteFileCommand implements Command {
    @Override
    public void execute(String path, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }
        String message = "File with name " + file.getName() + " in not deleted";
        if (file.delete()) {
            message = "File with name " + file.getName() + " has been deleted";
        }
        try {
            response.getWriter().write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
