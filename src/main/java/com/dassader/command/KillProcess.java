package com.dassader.command;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 24.04.2015.
 */
public class KillProcess implements Command {
    @Override
    public void execute(String path, HttpServletResponse response) {
        try {
            Runtime.getRuntime().exec("taskkill /im " + path);
            response.getWriter().write("process killed + " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
