import com.dassader.server.MyServer;
import com.dassader.servlet.*;

import java.awt.*;
import java.net.URI;

/**
 * @author Andrii_Kulikov
 */
public class RunMe {
    public static void main(String[] args) throws Exception {
        MyServer myServer = new MyServer(8080);

        myServer.addContext(HelloServlet.class, "/");
        myServer.addContext(GetSystemTimeServlet.class, "/getTime");
        myServer.addContext(FileServlet.class, "/file");
        myServer.addContext(ControlProcessServlet.class, "/process");
        myServer.addContext(CmdServlet.class, "/cmd");
        myServer.addContext(UiServlet.class, "/ui");

        myServer.start();

        Desktop.getDesktop().browse(new URI("http://localhost:8080"));
    }
}