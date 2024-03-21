package edu.webclass.restapi.Product.Management.System.repository;

import edu.webclass.restapi.Product.Management.System.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {
    public static ArrayList<Product> products= new ArrayList<>();
    public static int lastIndex=0;

    public ProductRepository(){
        products.add(new Product("Mobile","Samsung", 50000000));
        products.add(new Product("Cacke","TITOP!",10000));
        products.add(new Product("Shoes","adidas",1000000));
        products.add(new Product("shirt","Poma",400000));
        products.add(new Product("Machine","Peride",300000000));
        products.add(new Product("laptop","Asus",40000000));
        products.add(new Product("TV","LG",20000000));
        products.add(new Product("backpack","Cat",300000));
        products.add(new Product("Toothpaste","Merident",40000));
        products.add(new Product("chewing gum","Biodent",20000));
    }

    public boolean createNewProduct(Product product){
        products.add(product);
        if(ProductRepository.lastIndex == ProductRepository.products.size()){
            return true;
        }else{
            return false;
        }
    }

    public List<Product> findAllProducts(){
        return products;
    }

    public Product returnSpecialProduct(String id) {
        for(int i = 0; i < ProductRepository.products.size(); i++){
            if(ProductRepository.products.get(i).id.equals(id)){
                System.out.println(id);
                return ProductRepository.products.get(i);
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
}
