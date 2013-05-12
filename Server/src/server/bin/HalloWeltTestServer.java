/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bin;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import javax.swing.JOptionPane;
public class HalloWeltTestServer
{
   public static void main( String[] args ) throws Exception
   {
      HttpServer server = HttpServerFactory.create( "http://localhost:4434/rest" );
server.start();
JOptionPane.showMessageDialog( null, "Ende" );
server.stop( 0 );
   }
}