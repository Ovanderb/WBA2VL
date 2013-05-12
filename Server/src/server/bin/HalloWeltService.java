/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bin;

import javax.ws.rs.*;

@Path( "message" )
public class HalloWeltService
{
  @GET
  @Produces( "text/plain" )
  public String message()
  {
    return "Yea! ";
  }
}