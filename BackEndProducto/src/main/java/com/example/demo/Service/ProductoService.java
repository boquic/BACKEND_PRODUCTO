package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Producto;

public interface ProductoService {

	Producto create(Producto c);
	Producto uptade(Producto c);
	void delete(Long id);
	Optional<Producto> read(Long id);
	List<Producto> readAll();
}
