import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Operations {

    public void read(String file){
        String csvFile = file;

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            System.out.println(" ");
            while ((line = reader.readNext()) != null) {
                System.out.println("Product name:" + line[0] + ", Price: " + line[1] + " , Quantity: " + line[2]);
            }
            System.out.println(" ");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void create(String file, Product product){
        try {
            FileWriter mFileWriter = new FileWriter(file, true);
            CSVWriter mCsvWriter = new CSVWriter(mFileWriter);
            String prod = product.getProductName() + "," + product.getPrice() + "," + product.getQuantity();
            //System.out.println(prod);
            String[] productToInsert = prod.split(",");
            mCsvWriter.writeNext(productToInsert);
            mCsvWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public void update(String file, Product product){
        String csvFile = file;
        List<Product> products = new ArrayList<>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                Product product1 = new Product();
                product1.setProductName(line[0]);
                product1.setPrice(Double.parseDouble(line[1]));
                product1.setQuantity(Integer.parseInt(line[2]));
                products.add(product1);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Product p:products){
            if (p.getProductName().toLowerCase().equals(product.getProductName().toLowerCase())){
                p.setPrice(product.getPrice());
                p.setQuantity(product.getQuantity());
            }
        }

        try {
            FileWriter mFileWriter = new FileWriter(file);
            CSVWriter mCsvWriter = new CSVWriter(mFileWriter);
            for(Product p:products) {
                String prod = p.getProductName() + "," + p.getPrice() + "," + p.getQuantity();
                //System.out.println(prod);
                String[] productToInsert = prod.split(",");
                mCsvWriter.writeNext(productToInsert);
            }
            mCsvWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void delete(String file, String productName){
        String csvFile = file;
        List<Product> products = new ArrayList<>();
        List<Product> toRemove = new ArrayList<>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                Product product = new Product();
                product.setProductName(line[0]);
                product.setPrice(Double.parseDouble(line[1]));
                product.setQuantity(Integer.parseInt(line[2]));
                products.add(product);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Product p:products){
            if (p.getProductName().toLowerCase().equals(productName.toLowerCase())){
                toRemove.add(p);
            }
        }

        for(Product p:toRemove){
            products.remove(p);
        }

        try {
            FileWriter mFileWriter = new FileWriter(file);
            CSVWriter mCsvWriter = new CSVWriter(mFileWriter);
            for(Product p:products) {
                String prod = p.getProductName() + "," + p.getPrice() + "," + p.getQuantity();
                //System.out.println(prod);
                String[] productToInsert = prod.split(",");
                mCsvWriter.writeNext(productToInsert);
            }
            mCsvWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void findByName(String file, String productName){
        String csvFile = file;
        List<Product> products = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                Product product = new Product();
                product.setProductName(line[0]);
                product.setPrice(Double.parseDouble(line[1]));
                product.setQuantity(Integer.parseInt(line[2]));
                products.add(product);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Product p:products){
            if(p.getProductName().equals(productName)){
                System.out.println("Product name: " + p.getProductName() + ", Price: " + p.getPrice() + ", Quantity: " + p.getQuantity());
            }
        }

    }
}
