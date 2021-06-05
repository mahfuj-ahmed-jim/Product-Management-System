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

public class Product {

    private int productCode;
    private String productName;
    private double productPrice;
    private int quantity;
    
    public Product(){
        
    }

    public Product(int productCode, String productName, double productPrice, int quantity) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void addProduct(Product product){
        List <Product> porductList = new ArrayList();
        try {
            File file = new File("Product.txt");
            
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            int count = 0;
            try {
                while((line = reader.readLine())!=null){
                    String [] productData = line.split("   ;   ");
                    
                    if(product.getProductCode() == parseInt(productData[0])){
                        
                        int quantity = product.getQuantity()+parseInt(productData[3]);
                        
                        Product tempProduct = new Product();
                        tempProduct.setProductCode(parseInt(productData[0]));
                        tempProduct.setProductName(productData[1]);
                        tempProduct.setProductPrice(Double.parseDouble(productData[2]));
                        tempProduct.setQuantity(quantity);
                        porductList.add(tempProduct);
                        
                        count++;
                        
                    }else{
                        Product tempProduct = new Product();
                        tempProduct.setProductCode(parseInt(productData[0]));
                        tempProduct.setProductName(productData[1]);
                        tempProduct.setProductPrice(Double.parseDouble(productData[2]));
                        tempProduct.setQuantity(parseInt((productData[3])));
                        porductList.add(tempProduct);
                    }
                    
                }
                
                if(count == 0){
                    Product tempProduct = new Product();
                    tempProduct.setProductCode(product.getProductCode());
                    tempProduct.setProductName(product.getProductName());
                    tempProduct.setProductPrice(product.getProductPrice());
                    tempProduct.setQuantity(product.getQuantity());
                    porductList.add(tempProduct);
                }
                
                try {
                    FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), false);
                    fileWriter = new FileWriter(file.getAbsolutePath(), true);
                
                    for(Product temp : porductList){
                        fileWriter.write(temp.productCode+"   ;   "+temp.getProductName()
                            +"   ;   "+temp.getProductPrice()+"   ;   "+temp.getQuantity());
            
                        fileWriter.write(System.lineSeparator());
                    }
                
                    fileWriter.close();
                
                } catch (IOException ex) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public List<Product> viewProduct(){
        FileReader fileReader = null;
        List <Product> productList = new ArrayList(); 
        try {
            File file = new File("Product.txt");
            fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            try {
                while((line = reader.readLine())!=null){
                    String [] productData = line.split("   ;   ");
                    System.out.println("Code : "+productData[0]+
                            "; Name : "+productData[1]+
                            "; Price : "+productData[2]+
                            "; Quantity : "+productData[3]);
                    
                    Product product = new Product();
                    product.setProductCode(parseInt(productData[0]));
                    product.setProductName(productData[1]);
                    product.setProductPrice(parseDouble(productData[2]));
                    product.setQuantity(parseInt(productData[3]));
                    
                    productList.add(product);
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return productList;
    }
    
    public void editProduct(Product oldProduct, Product newProduct){
        FileReader fileReader = null;
        List <Product> porductList = new ArrayList();
        try {
            File file = new File("Product.txt");
            fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            try {
                while((line = reader.readLine())!=null){
                    String [] productData = line.split("   ;   ");
                    
                    if(oldProduct.getProductCode() == parseInt(productData[0])){
                        
                        Product tempProduct = new Product();
                        tempProduct.setProductCode(newProduct.getProductCode());
                        tempProduct.setProductName(newProduct.getProductName());
                        tempProduct.setProductPrice(newProduct.getProductPrice());
                        tempProduct.setQuantity(newProduct.getQuantity());
                        porductList.add(tempProduct);
                        
                    }else{
                        
                        Product tempProduct = new Product();
                        tempProduct.setProductCode(parseInt(productData[0]));
                        tempProduct.setProductName(productData[1]);
                        tempProduct.setProductPrice(Double.parseDouble(productData[2]));
                        tempProduct.setQuantity(parseInt(productData[3]));
                        porductList.add(tempProduct);
                        
                    }
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), false);
                fileWriter = new FileWriter(file.getAbsolutePath(), true);
                
                for(Product temp : porductList){
                    fileWriter.write(temp.productCode+"   ;   "+temp.getProductName()
                    +"   ;   "+temp.getProductPrice()+"   ;   "+temp.getQuantity());
            
                    fileWriter.write(System.lineSeparator());
                }
                
                fileWriter.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void deleteProduct(int product){
        FileReader fileReader = null;
        List <Product> porductList = new ArrayList();
        try {
            File file = new File("Product.txt");
            fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            try {
                while((line = reader.readLine())!=null){
                    String [] productData = line.split("   ;   ");
                    
                    if(product == parseInt(productData[0])){
                        
                    }else{
                        Product tempProduct = new Product();
                        tempProduct.setProductCode(parseInt(productData[0]));
                        tempProduct.setProductName(productData[1]);
                        tempProduct.setProductPrice(Double.parseDouble(productData[2]));
                        tempProduct.setQuantity(parseInt(productData[3]));
                        porductList.add(tempProduct);
                    }
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), false);
                fileWriter = new FileWriter(file.getAbsolutePath(), true);
                
                for(Product temp : porductList){
                    fileWriter.write(temp.productCode+"   ;   "+temp.getProductName()
                    +"   ;   "+temp.getProductPrice()+"   ;   "+temp.getQuantity());
            
                    fileWriter.write(System.lineSeparator());
                }
                
                fileWriter.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
