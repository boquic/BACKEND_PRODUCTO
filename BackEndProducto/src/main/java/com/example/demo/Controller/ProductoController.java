package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Producto;
import com.example.demo.Service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductoController {
	
	
	@Autowired
	private ProductoService  productoService;
	
	@GetMapping
	public ResponseEntity<List<Producto>> readAll(){
		try {
			List<Producto> productos= productoService.readAll(); 
			if (productos.isEmpty()) {
				return new  ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
			return new ResponseEntity<>(productos, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	
	
	@PostMapping
	public ResponseEntity<Producto> createProducto(@Valid @RequestBody Producto c){
		try {
			Producto  productos= productoService.create(c); 
			return new ResponseEntity<>(productos, HttpStatus.CREATED);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable("id") Long id){
		Optional<Producto> productos= productoService.read(id); 
		return productos.map(vale -> new ResponseEntity<>(vale, HttpStatus.OK) )
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable("id") Long id, @Valid @RequestBody Producto productos){
		 Optional<Producto> existing = productoService.read(id);
	        if (existing.isPresent()) {
	            productos.setId(id);
	            return new ResponseEntity<>(productoService.uptade(productos), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") Long id) {
        try {
        	productoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
	
	
	
	
	
}
