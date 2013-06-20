package restserver;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

public class RestServer {
    static public final String HOST = "http://localhost:20000/";
    
    static public void main(String[] args) throws IOException, FileNotFoundException, JAXBException {
        if(new MyCheck().doCheck()) {
            HttpServer server = HttpServerFactory.create(RestServer.HOST);
            server.start();
            JOptionPane.showMessageDialog(null, "Ende");
            server.stop(0);
        }
    }
}
