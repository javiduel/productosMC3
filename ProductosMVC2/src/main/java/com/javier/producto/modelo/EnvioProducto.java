package com.javier.producto.modelo;
// Generated 15-jul-2014 17:19:01 by Hibernate Tools 3.6.0


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EnvioProducto generated by hbm2java
 */
@Entity
@Table(name="envio_producto"
    ,catalog="teide2014"
)
public class EnvioProducto  implements java.io.Serializable {


     private EnvioProductoId id;
     private TiendaProducto tiendaProducto;
     private Envios envios;
     private double coste;

    public EnvioProducto() {
    }

    public EnvioProducto(EnvioProductoId id, TiendaProducto tiendaProducto, Envios envios, double coste) {
       this.id = id;
       this.tiendaProducto = tiendaProducto;
       this.envios = envios;
       this.coste = coste;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idEnvio", column=@Column(name="idEnvio", nullable=false) ), 
        @AttributeOverride(name="idProducto", column=@Column(name="idProducto", nullable=false) ) } )
    public EnvioProductoId getId() {
        return this.id;
    }
    
    public void setId(EnvioProductoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idProducto", nullable=false, insertable=false, updatable=false)
    public TiendaProducto getTiendaProducto() {
        return this.tiendaProducto;
    }
    
    public void setTiendaProducto(TiendaProducto tiendaProducto) {
        this.tiendaProducto = tiendaProducto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idEnvio", nullable=false, insertable=false, updatable=false)
    public Envios getEnvios() {
        return this.envios;
    }
    
    public void setEnvios(Envios envios) {
        this.envios = envios;
    }

    
    @Column(name="coste", nullable=false, precision=22, scale=0)
    public double getCoste() {
        return this.coste;
    }
    
    public void setCoste(double coste) {
        this.coste = coste;
    }




}

