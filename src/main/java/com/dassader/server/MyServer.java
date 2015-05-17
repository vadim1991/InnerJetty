package com.dassader.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @author Andrii_Kulikov
 */
public class MyServer extends Thread {
    private Server server;
    private ServletContextHandler context;

    public MyServer(int port) {
        server = new Server(port);
        context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        server.setHandler(context);
    }

    public void addContext(java.lang.Class<? extends javax.servlet.Servlet> servlet, java.lang.String pathSpec) {
        context.addServlet(servlet, pathSpec);
    }

    @Override
    public void run() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
