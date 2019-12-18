
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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class PortSearcher {
            
    public void freePortSearch(List <String> directory, String ip) throws FileNotFoundException, IOException{
        if(!directory.isEmpty()){
        for(String s:directory){ 
        File freePort = new File(s);
        if(!freePort.exists()){
           System.out.println("Файл "+freePort.getAbsoluteFile()+" не найден!");
        }
        File comf = new File("comfini");
            if(freePort.exists()){
            BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(freePort), "UTF8"));
                System.out.println("Обработка файла "+freePort.getAbsoluteFile());
                if(portScanning(br,ip)){
                    br.close();
                    Files.copy(comf.toPath(), freePort.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                }
                }else{
                    System.out.println("Файл "+freePort.getAbsoluteFile()+" не найден!");                    
                }
            }
        }
    }
    
    
    public boolean portScanning(BufferedReader bf, String ipAddress) throws IOException{
        boolean isDone=false;
        int starIndex = 0;
        int endIndex = 0;        
        String beginOfPorts = "*****************************USERS***********************************";
        String endOfPorts = "*********************************************************************";
        
        List<String> allPortsNumber = new ArrayList<String>(); 
        List<String> portsNumberAfterFirstStar = new ArrayList<String>();
        List<String> portsNumberBeetwenStars =new ArrayList<String>();
        List<String> portsNumberAfterLastStars =new ArrayList<String>();
        
        while(true){                 
                String line = bf.readLine();
                if (line == null) break;
                allPortsNumber.add(line);                
            }        
        for(String s : allPortsNumber){  
            if(s.contains(beginOfPorts)){
                starIndex = allPortsNumber.indexOf(s);  
            }
            if(s.contains(endOfPorts)){
                endIndex = allPortsNumber.indexOf(s);  
            }
        }
        allPortsNumber.remove(starIndex);
        
        portsNumberAfterFirstStar = allPortsNumber.subList(starIndex, allPortsNumber.size());
        List<String> portsNumberUntilFirstStar = allPortsNumber.subList(0,starIndex);
        
        for(String e:portsNumberAfterFirstStar){
            if(!e.contains(endOfPorts)){
                if(!e.isEmpty()){
                    portsNumberBeetwenStars.add(e);
                }
            }else{
                break;
            }
        }
        if(portsNumberBeetwenStars.size()<59){            
            portsNumberAfterLastStars = allPortsNumber.subList(endIndex,allPortsNumber.size());
            PrintWriter writer = new PrintWriter("comfini", "UTF-8");            
            for(String f:portsNumberUntilFirstStar){
                writer.println(f);            
            }
            writer.println(beginOfPorts);        

            for(String t:portsNumberBeetwenStars){            
                writer.println(t);
            }              
            writer.println(addPort(portsNumberBeetwenStars.size()+1,ipAddress));
            writer.println(endOfPorts); 

            for(String h:portsNumberAfterLastStars){            
                writer.println(h);
            }
            System.out.println("Запись успешно добавлена!");
            isDone=true;            
            writer.close();
        }else{
            System.out.println("Недостаточно места!");
        }
        return isDone;
    }
    
    public String addPort(int portNum, String ip){
        String adddingPort;
        if(portNum<10){
          adddingPort  = ">crt:      ThatHost   HSTU00"+portNum+"   "+ip+"      5      1000 4    5";
            
        }else{
            adddingPort = ">crt:      ThatHost   HSTU0"+portNum+"   "+ip+"      5      1000 4    5";
        }
        return adddingPort;
    }
    
    public boolean checkIP(String ip){
        boolean isValid=true;
        final int maxSize=255;
        final int beginNum=10;
        int actett=0;
        try{
            if(ip.contains(".")){
                if(ip.split("\\.")[0].equals("10")){            
                    for(int i=1;i<3;i++){
                        if(isDigit(ip.split("\\.")[i])){
                            actett = Integer.parseInt(ip.split("\\.")[i]);
                            if(actett>255){
                                System.out.println("В введенном ip "+ip+" значение "+actett+" превышающее 255 !");
                                isValid=false;
                                break;
                            }
                        }else{
                            System.out.println("Введено неверное значение "+actett+" для ip адреса "+ip+" !");
                            isValid=false;
                            break;
                        }
                    }            
                }else{
                    isValid=false;
                    System.out.println("Неверный формат ip адреса "+ip+" !");
                }
            }else{
                isValid=false;
                System.out.println("Неверный формат ip адреса "+ip+" !");
            }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            isValid=false;
            System.out.println("Неверный формат ip адреса "+ip+" !");
        }        
        return isValid;
    }
    
    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}    
      
    


