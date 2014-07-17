package com.javier.producto.modelo;
// Generated 15-jul-2014 17:19:01 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Envios generated by hbm2java
 */
@Entity
@Table(name="envios"
    ,catalog="teide2014"
)
public class Envios  implements java.io.Serializable {


     private Integer idEnvios;
     private String nombre;
     private Set<EnvioProducto> envioProductos = new HashSet<EnvioProducto>(0);

    public Envios() {
    }

	
    public Envios(String nombre) {
        this.nombre = nombre;
    }
    public Envios(String nombre, Set<EnvioProducto> envioProductos) {
       this.nombre = nombre;
       this.envioProductos = envioProductos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idEnvios", unique=true, nullable=false)
    public Integer getIdEnvios() {
        return this.idEnvios;
    }
    
    public void setIdEnvios(Integer idEnvios) {
        this.idEnvios = idEnvios;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="envios")
    public Set<EnvioProducto> getEnvioProductos() {
        return this.envioProductos;
    }
    
    public void setEnvioProductos(Set<EnvioProducto> envioProductos) {
        this.envioProductos = envioProductos;
    }




}


