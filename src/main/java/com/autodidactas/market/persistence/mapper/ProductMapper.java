package com.autodidactas.market.persistence.mapper;

import com.autodidactas.market.domain.Product;
import com.autodidactas.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface ProductMapper {
    /**
     * Mapeamos un Producto -> Product (Objeto de dominio para el API)
     */
    @Mappings({
          @Mapping(source = "idProducto",target = "productId"),
          @Mapping(source = "nombre",target = "name"),
          @Mapping(source = "idCategoria",target = "categoryId"),
          @Mapping(source = "precioVenta",target = "price"),
          @Mapping(source = "cantidadStock",target = "stock"),
          @Mapping(source = "estado",target = "active"),
          @Mapping(source = "categoria",target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts (List<Producto> productos);    //Tomara la conversion de arriba

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);







}
