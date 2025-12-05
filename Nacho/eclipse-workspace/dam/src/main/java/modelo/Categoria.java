package modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id; 

    @Column(name = "nombre", nullable = false, unique = true) 
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Producto> productos = new ArrayList<>();
    
    public Categoria() {}
    
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
    	this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public void addProducto(Producto producto) {
        if (!productos.contains(producto)) {
             productos.add(producto);
        }
        producto.setCategoria(this); 
    }
    
    public Integer getId() { 
    	return id; 
    	}
    
    public void setId(Integer id) { 
    	this.id = id; 
    	}
    
    public String getNombre() { 
    	return nombre; 
    	}
    
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    	}
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<Producto> getProductos() { 
    	return productos; 
    }
    
    public void setProductos(List<Producto> productos) { 
    	this.productos = productos; 
    	}
    
    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nombre='" + nombre + "'}";
    }
}