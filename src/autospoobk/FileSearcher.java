
package autospoobk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileSearcher {
    
    private File root;
    private String tb;

    public void setRoot(File root) {
        this.root = root;
    }
    


    public void setTb(String tb) {
        this.tb = tb;
    }

    public FileSearcher(File root, String tb) {
        this.root = root;
        this.tb = tb;
    }


    
    public boolean fileExist(){
        boolean ex=false;
        if(root.exists()){
            ex=true;            
        }
        return ex;
    }
    
    //Получение списка директорий в корне поиска в виде массива строк
    public List <String> getListOfRoot(){
        List <String> ports = new ArrayList<String>();
        for(String s:root.list()){            
            if(s.split("_")[0].compareTo("00"+tb)==0){                
                s=root.getAbsolutePath()+"\\"+s+"\\comfini";            
                ports.add(s);
            }
        }
        return ports; 
                
    }
   
            
    //Поиск файла в списке директорий и его возврат
    private File searchFile(String[] listPortsForSearch){
        int l = listPortsForSearch.length;
        for(int i=0;i<l;i++){
            
        }
        //listPortsForSearch.
        return null;
    }
    
    
    public static String xmlRead(){
        String server = null;        
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("Settings.xml");
            
            Node root = document.getDocumentElement();
            
            NodeList settings = root.getChildNodes();            
            Node setting = settings.item(1);
            server = setting.getTextContent(); 
        }
         catch (ParserConfigurationException ex) {
             ex.printStackTrace(System.out);
         }
         catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return server;
    }
    
}
