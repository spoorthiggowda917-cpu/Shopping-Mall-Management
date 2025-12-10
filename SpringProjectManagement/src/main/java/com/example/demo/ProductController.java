package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
@Autowired
ProductService service;

@GetMapping("/products")
public List<ProductEntity> list()
{
	return service.listAll();
	
}

@GetMapping("/products/{id}")
public ResponseEntity<ProductEntity> get(@PathVariable Integer id)
{
	try
	{
		ProductEntity product=service.get(id);
		return new ResponseEntity<ProductEntity>(product,HttpStatus.OK);
	}
	catch(NoSuchElementException e){
		return new ResponseEntity<ProductEntity>(HttpStatus.NOT_FOUND);
		
	}
}



//Restful API method for Create operation
@PostMapping("/products")
public void add(@RequestBody ProductEntity product)
{
	service.save(product);
}

@PutMapping("/products/{id}")
public ResponseEntity<ProductEntity> update(@RequestBody ProductEntity product, @PathVariable Integer id) {
    try {
        ProductEntity existingProduct = service.get(id);  // check if product exists
        service.save(existingProduct);  // save updated product

        return new ResponseEntity<>(existingProduct, HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


@DeleteMapping("/products/{id}")
public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    try {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

}

