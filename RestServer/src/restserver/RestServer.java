package restserver;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Olli
 */
public class RestServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:20000/rest");
        server.start();
        JOptionPane.showMessageDialog(null, "Ende");
        server.stop(0);
    }
}