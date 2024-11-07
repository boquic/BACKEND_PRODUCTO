package com.example.demo.SeriviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Producto;
import com.example.demo.Repository.ProductoRepository;
import com.example.demo.Service.ProductoService;

@Service

public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	
	private ProductoRepository productoRepository;
	

	@Override
	public Producto create(Producto c) {
		// TODO Auto-generated method stub
		return productoRepository.save(c);
	}

	@Override
	public Producto uptade(Producto c) {
		// TODO Auto-generated method stub
		return productoRepository.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

	@Override
	public Optional<Producto> read(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id); 
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}
	
	

}
