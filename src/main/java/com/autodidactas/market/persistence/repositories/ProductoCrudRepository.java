package com.autodidactas.market.persistence.repositories;


import com.autodidactas.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProductoCrudRepository extends CrudRepository <Producto, Long> {


    //Recuperar toda la lista de productos que pertenezca a una categoria en especifico

    List<Producto> findByIdCategoriaOrderByNombre(Long idCategoria);

    //Optiene productos escasos en Stock pero con estado activo (en venta)
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    /* Con anotacion @Query
     *  @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
     *     List<Producto> getByCategoria(Long idCategoria);
     *
     */




}
