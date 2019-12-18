
package autospoobk;

import java.io.*;
import java.util.Scanner;

public class AutoSpoobk { 
    
   
     public static void main(String[] args) throws FileNotFoundException, IOException {
     genProfiles gn = new genProfiles();
     String s[] = {"99","70","55","40"};
     gn.generateProfiles(s);
     
   /* while(true){    
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ТБ");
        String tb = in.nextLine();
        System.out.println("Введите IP");        
        String ip = in.nextLine();
        System.out.println("");
        PortSearcher ps= new PortSearcher();
        if(ps.checkIP(ip)){
            File root = new File(FileSearcher.xmlRead());        
            FileSearcher fs = new FileSearcher(root,tb);         
            ps.freePortSearch(fs.getListOfRoot(),ip);
        }
        System.out.println("");
       }
    }
*/
     }  
}
