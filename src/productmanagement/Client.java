package productmanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    private String phoneNumber;
    private String name;
    private String passWord;
    private double totalPurchase;

    public Client() {
    }
    
    public Client(String phoneNumber, String name, String passWord, double totalPurchase) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.passWord = passWord;
        this.totalPurchase = totalPurchase;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }
    
    public void createAccount(Client client){
        File file = new File("Client.txt");
        
        try {
            
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            boolean userExist = false;
            try {
                while((line = reader.readLine())!=null){
                    String [] clientData = line.split("   ;   ");
                    
                    if(clientData[0].equals(client.getPhoneNumber())){
                        System.out.println("User already exists");
                        userExist = true;
                        break;
                    }
                    
                }
            }catch(Exception e){
                
            }
            
            if(userExist == false){
                try {
                    FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
                    writer.write(client.getPhoneNumber()+"   ;   "+client.getName()+"   ;   "
                        +client.getPassWord()+"   ;   "+client.getTotalPurchase());
                    writer.write(System.lineSeparator());
                    writer.close();
                    System.out.println("Successful");
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void viewAllClient(){
        File file = new File("Client.txt");
        
        try {
            
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            try {
                while((line = reader.readLine())!=null){
                    String [] clientData = line.split("   ;   ");
                    
                    System.out.println("Number : "+clientData[0]
                            +"; Name : "+clientData[1]+"; Total Purchase : "+clientData[3]);
                    
                }
            }catch(Exception e){
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editClient(Client client) throws IOException{
        File file = new File("Client.txt");
        List <Client> clientList = new ArrayList();
        try {
            
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            try {
                while((line = reader.readLine())!=null){
                    String [] clientData = line.split("   ;   ");
                    
                    if(clientData[0].equals(client.getPhoneNumber())){
                        
                        Client temp = new Client();
                        temp.setPhoneNumber(client.getPhoneNumber());
                        temp.setName(client.getName());
                        temp.setPassWord(client.getPassWord());
                        temp.setTotalPurchase(client.getTotalPurchase());
                        clientList.add(temp);
                        
                    }else{
                        
                        Client temp = new Client();
                        temp.setPhoneNumber(clientData[0]);
                        temp.setName(clientData[1]);
                        temp.setPassWord(clientData[2]);
                        temp.setTotalPurchase(parseDouble(clientData[3]));
                        clientList.add(temp);
                        
                    }
                    
                }
                
            }catch(Exception e){
                
            }
            
            FileWriter writers = new FileWriter(file.getAbsolutePath(), false);
                
                for(Client clienttemp : clientList){
                    try {
                        
                        FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
                    
                        writer.write(clienttemp.getPhoneNumber()+"   ;   "+clienttemp.getName()+"   ;   "
                            +clienttemp.getPassWord()+"   ;   "+clienttemp.getTotalPurchase());
                                
                        writer.write(System.lineSeparator());
                        writer.close();
                
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletClient(String client) throws IOException{
        
        File file = new File("Client.txt");
        List <Client> clientList = new ArrayList();
        try {
            
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            try {
                while((line = reader.readLine())!=null){
                    String [] clientData = line.split("   ;   ");
                    
                    if(clientData[0].equals(client)){
                        
                        
                        
                    }else{
                        
                        Client temp = new Client();
                        temp.setPhoneNumber(clientData[0]);
                        temp.setName(clientData[1]);
                        temp.setPassWord(clientData[2]);
                        temp.setTotalPurchase(parseDouble(clientData[3]));
                        clientList.add(temp);
                        
                    }
                    
                }
                
            }catch(Exception e){
                
            }
            
            FileWriter writers = new FileWriter(file.getAbsolutePath(), false);
                
                for(Client clienttemp : clientList){
                    try {
                        
                        FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
                    
                        writer.write(clienttemp.getPhoneNumber()+"   ;   "+clienttemp.getName()+"   ;   "
                            +clienttemp.getPassWord()+"   ;   "+clienttemp.getTotalPurchase());
                                
                        writer.write(System.lineSeparator());
                        writer.close();
                
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Client checkLogIn(String number, String password){
        Client client = new Client("0", "0", "0", 0);
        File file = new File("Client.txt");
        
        try {
            
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            try {
                while((line = reader.readLine())!=null){
                    String [] clientData = line.split("   ;   ");
                    
                    if(clientData[0].equals(number) && clientData[2].equals(password)){
                        
                        client.setPhoneNumber(clientData[0]);
                        client.setName(clientData[1]);
                        client.setPassWord(clientData[2]);
                        client.setTotalPurchase(parseDouble(clientData[3]));
                        
                    }
                    
                }
            }catch(Exception e){
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return client;
        
    }
    
}
