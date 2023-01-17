package com.autodidactas.market.persistence.mapper;

import com.autodidactas.market.domain.Category;
import com.autodidactas.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    //Diseño de los mappers (Categoria -> Category)

    @Mappings({         //Fuente(source) --> Lo lleve a (target)

        @Mapping(source = "idCategoria",target = "categoryId"),
        @Mapping(source = "descripcion",target = "category"),
        @Mapping(source = "estado",target = "active")
    })
    Category toCategory(Categoria categoria);

    //Conversion al reves
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);


}
