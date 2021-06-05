package productmanagement;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductManagement {
    
    
    public static Scanner in = new Scanner(System.in);
    
    public static void createAccount(){
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        System.out.println("Create Account!");
        System.out.println("Enter your phone number : ");
        String phone = in.nextLine();
        System.out.println("Enter Your Name : ");
        String name = in.nextLine();
        System.out.println("Enter your password : ");
        String password = in.nextLine();
        
        Client client = new Client(phone, name, password, 0);
        client.createAccount(client);
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
                
    }
    
    public static void logIn(){
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        System.out.println("Log In!");
        System.out.println("Enter your phone number : ");
        String phone = in.nextLine();
        System.out.println("Enter Your Password : ");
        String password = in.nextLine();
        
        Client client = new Client();
        client = client.checkLogIn(phone, password);
        
        if(client.getPhoneNumber().equals("0") && client.getName().equals("0") 
                && client.getPassWord().equals("0") && client.getTotalPurchase() == 0){
            
            System.out.println("Worng number or password");
            
        }else{
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            
            System.out.println("1. Buy Product");
            System.out.println("2. View Profile");
            System.out.println("3. Exit");
            
            int a = in.nextInt();
            
            if(a == 1){
                
                List <Product> productList = new ArrayList();
                
                Product product = new Product();
                productList = product.viewProduct();
                
                System.out.println("Enter Product Code : ");
                int code = in.nextInt();
                System.out.println("Enter Amount : ");
                int amount = in.nextInt();
                
                for(Product temp : productList){
                    if(temp.getProductCode() == code){
                        if(amount > temp.getQuantity()){
                            System.out.println("Enter a valid amount");
                        }else{
                            
                            try {
                                product.setProductCode(code);
                                product.setProductName(temp.getProductName());
                                product.setProductPrice(temp.getProductPrice());
                                product.setQuantity(temp.getQuantity()-amount);
                                product.editProduct(temp, product);
                            
                                client.setTotalPurchase(client.getTotalPurchase()+temp.getProductPrice()*amount);
                                
                                client.editClient(client);
                            } catch (IOException ex) {
                                Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            System.out.println("Total perchase : "+temp.getProductPrice()*amount);
                            
                        }
                    }
                }
                
            }else if(a == 2){
                
                System.out.println("Number : "+client.getPhoneNumber()
                            +"; Name : "+client.getName()+"; Total Purchase : "+client.getTotalPurchase());
                
            }else if(a == 3){
                
            }
            
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
    }
    
    public static void admin(){
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        System.out.println("Admin Panel");
        System.out.println("1. Add product.");
        System.out.println("2. View Product");
        System.out.println("3. Edit Product.");
        System.out.println("4. Delete Product.");
        System.out.println("5. View Users");
        System.out.println("6. Delte User");
        System.out.println("7. Exit");
        
        int a = in.nextInt();
        
        if(a == 1){
            
            System.out.println("Product Code : ");
            int code = in.nextInt();
            System.out.println("Product Name : ");
            String name = in.next();
            in.nextLine();
            System.out.println("Product Price : ");
            double price = in.nextDouble();
            System.out.println("Product Quantity");
            int quantity = in.nextInt();
            
            Product product = new Product(code, name, price, quantity);
            product.addProduct(product);
            
        }else if(a == 2){
            
            Product product = new Product();
            product.viewProduct();         
            
        }else if(a == 3){
            
            Product product = new Product();
            List<Product> productList = new ArrayList();
            
            productList = product.viewProduct();
            
            System.out.println("Product Code : ");
            int code = in.nextInt();
            System.out.println("Product Name : ");
            String name = in.next();
            in.nextLine();
            System.out.println("Product Price : ");
            double price = in.nextDouble();
            System.out.println("Product Quantity");
            int quantity = in.nextInt();
            
            for(Product temp : productList){
                
                if(temp.getProductCode() == code){
                    
                    Product product2 = new Product(code, name, price, quantity);
                    temp.editProduct(temp, product2);
                    
                }
                
            }
            
        }else if(a == 4){
            
            Product product = new Product();
            product.viewProduct();
            
            System.out.println("Enter Code : ");
            int code = in.nextInt();
            product.deleteProduct(code);
            
        }else if(a == 5){
            
            Client client = new Client();
            client.viewAllClient();
            
        }else if(a == 6){
            
            Client client = new Client();
            client.viewAllClient();
            
            System.out.println("Enter Number");
            String number = in.next();
            in.nextLine();
            try {
                client.deletClient(number);
            } catch (IOException ex) {
                Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(a == 7){
            
            System.exit(0);
            
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
    }

    public static void main(String[] args) {
        
        while(true){
            
            System.out.println("Welcome!");
            System.out.println("1. Create Account.");
            System.out.println("2. Log In.");
            System.out.println("3. Exit");
            System.out.flush();
            String enter = in.next();
            in.nextLine();
            
            if(enter.equals("1")){
                
                createAccount();
                
            }else if(enter.equals("2")){
                
                logIn();
                
            }else if(enter.equals("3")){
                
                System.exit(0);
            
            }else if(enter.equals("2019-3-60-144")){
                
                System.out.println("Enter Password : ");
                String password = in.nextLine();
                
                if(password.equals("East West")){
                    admin();
                }else{
                    System.exit(0);
                }
                
            }
            
        }
        
    }
    
}
