package com.dassader.command;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 24.04.2015.
 */
public class RunFileCommand implements Command {
    @Override
    public void execute(final String path, HttpServletResponse response) {
        new Thread() {
            @Override
            public void run() {
                CommandLine cmdLine = new CommandLine("cmd.exe");
                cmdLine.addArgument("/c");
                cmdLine.addArgument(path);
                DefaultExecutor executor = new DefaultExecutor();
                try {
                    executor.execute(cmdLine);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
