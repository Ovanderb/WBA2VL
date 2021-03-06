package restserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Klasse um die XML Dateien erstmalig in das Arbeitsverzeichnis zu kopieren.
 * 
 * @author Olli
 */
public class MyCheck {
    public MyCheck() {
    }
    
    /**
     * Prüft ob das Arbeitsverzeichnis schon vorhanden ist. Ansonsten werden die
     * Vorlage XML Dateien kopiert.
     * @return Boolean
     */
    public boolean doCheck() {
        String[] files = {"accounts", "actors", "bills", "genres", "messages", "movies"};
        String path = System.getProperty("user.dir") + "/xml";
        File file = new File(path);
        boolean ok = true;
        
        if(!file.isDirectory()) { file.mkdir(); for(int i = 0; i < files.length && ok; i++) { ok = this.doCopy("xml/" + files[i] + ".xml", path + "/" + files[i] + ".xml"); } }
        return ok;
    }
    
    /**
     * Kopiert die Dateien aus dem JER ins Arbeitsverzeichnis
     * @return Boolean
     */
    private boolean doCopy(String from, String to) {
        try {
            InputStream i = this.getClass().getResourceAsStream(from);
            FileOutputStream o = new FileOutputStream(new File(to));
            byte[] buffer = new byte[1024];
            int size;
            
            try {
                while((size = i.read(buffer)) != -1) { o.write(buffer, 0, size); }
            } catch (IOException e) { return false; }
        } catch (FileNotFoundException e) { return false; }
        return true;
    }
}
