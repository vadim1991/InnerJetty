package com.dassader.command;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by swift-seeker-89717 on 24.04.2015.
 */
public class ShowProcessCommand implements Command {

    private static final String TASKLIST_COMMAND = "tasklist";

    @Override
    public void execute(String path, HttpServletResponse response) {
        try {
            String line;
            Process p = Runtime.getRuntime().exec(TASKLIST_COMMAND);
            StringBuilder builder = new StringBuilder();
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            input.close();
            response.getWriter().write(builder.toString());
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
