package com.autodidactas.market.persistence.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "compras_producto")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;

    private BigDecimal total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_compra", updatable = false, insertable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", updatable = false, insertable = false)
    private Producto producto;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
