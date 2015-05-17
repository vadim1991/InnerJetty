package com.dassader.command;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by swift-seeker-89717 on 24.04.2015.
 */
public class DownloadCommand implements Command {

    @Override
    public void execute(String path, HttpServletResponse resp) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }
        resp.setContentType("application/force-download");
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Transfer-Encoding", "binary");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        Path pathFile = Paths.get(file.getPath());
        byte[] data;
        try {
            data = Files.readAllBytes(pathFile);
            resp.getOutputStream().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
