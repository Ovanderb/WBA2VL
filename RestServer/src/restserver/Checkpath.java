/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Olli
 */
public class Checkpath {
    
    String Pfad;
    private void copyDat(String in, String out) throws FileNotFoundException, JAXBException, IOException {
        try (
                InputStream accfile = getClass().getResourceAsStream(in);
                FileOutputStream outputStream = new FileOutputStream(new File(Pfad +"/"+ out))) {

            int read;
            byte[] bytes = new byte[1024];

            while ((read = accfile.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
        
    }

    public Checkpath() throws FileNotFoundException, JAXBException, IOException {
        this.Pfad = System.getProperty("user.dir") + "/XML";
        System.out.println(Pfad);
        if (!new File(Pfad).isDirectory()) {
            new File(Pfad).mkdir();
            copyDat("XML/accounts.xml","accounts.xml");
            copyDat("XML/actors.xml","actors.xml");
            copyDat("XML/bills.xml","bills.xml");
            copyDat("XML/genres.xml","genres.xml");
            copyDat("XML/message.xml","message.xml");
            copyDat("XML/movies.xml","movies.xml");
        }
    }
}
