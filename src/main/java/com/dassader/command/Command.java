package com.dassader.command;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by swift-seeker-89717 on 24.04.2015.
 */
public interface Command {

    void execute(String path,HttpServletResponse response);

}
