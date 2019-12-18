/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autospoobk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Crow
 */
public class genProfiles {
    
    private Map<String, String> profilesMap = new HashMap<String, String>();

    
    private void containMap(){
       profilesMap.put("16", "9016/00002 16 Уральский");
       profilesMap.put("40", "9040/00003 40 Среднерусский");
       profilesMap.put("42", "9042/04200 42 Волго-Вятский");
       profilesMap.put("44", "9944/00003 44 Сибирский");
       profilesMap.put("52", "0001/00000 52 Юго-Западный");
       profilesMap.put("54", "0001/00001 54 Поволжский");
       profilesMap.put("55", "0003/00003 55 Северо-Западный");
       profilesMap.put("67", "9067/00002 67 Западно-Сибирский");
       profilesMap.put("70", "9070/00900 70 Дальневосточный");
       profilesMap.put("99", "0002/00003 99 Московский");      
   }
   
   public void generateProfiles(String[] val) throws FileNotFoundException, UnsupportedEncodingException, IOException{
       File profiles = new File("profiles.txt");
        if(profiles.exists()){  
            PrintWriter writer = new PrintWriter(profiles, "cp1251"); 
            containMap();
            for(int i=0;i<val.length;i++){
                writer.println(profilesMap.get(val[i]));
            }
            writer.close();
        }
        else{System.out.println("Файл "+profiles.getAbsoluteFile()+" не найден!");
        }
   }
}
