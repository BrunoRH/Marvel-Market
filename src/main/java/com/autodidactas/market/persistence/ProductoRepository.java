package com.autodidactas.market.persistence;

import com.autodidactas.market.domain.Product;
import com.autodidactas.market.domain.repository.ProductRepository;
import com.autodidactas.market.persistence.entity.Producto;
import com.autodidactas.market.persistence.mapper.ProductMapper;
import com.autodidactas.market.persistence.repositories.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductoRepository(ProductoCrudRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Long categoryId) {
        List<Producto> productos = productoRepository.findByIdCategoriaOrderByNombre(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        return productoRepository.findById(productId).map(product -> productMapper.toProduct(product));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoRepository.save(producto));
    }
    @Override
    public void delete(Long idProducto){
        productoRepository.deleteById(idProducto);
    }

}
