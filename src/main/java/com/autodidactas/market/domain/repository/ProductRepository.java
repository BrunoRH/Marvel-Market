package com.autodidactas.market.domain.repository;

import com.autodidactas.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    /**
     * Indica los metodos, que cualquier repositorio que quiera trabajar con Productos tenga que implementar
     * En terminos de "Product" y no de "Producto" (Tabla de BBDD)
     *
     * Reglas que tendrá nuestro dominio, para acceder a Productos dentro de una BBDD
     */

    List<Product> getAll();

    Optional<List<Product>> getByCategory(Long categoryId);

    Optional<List<Product>> getScarseProducts(int quantity);

    Optional<Product> getProduct(Long productId);

    Product save(Product product);

    void delete(Long productId);




}
