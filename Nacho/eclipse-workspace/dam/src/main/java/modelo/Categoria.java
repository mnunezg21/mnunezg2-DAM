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
    private int id_categoria;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST)
    private List<Producto> productos = new ArrayList<>();
    
    public Categoria() {}
    
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    
    public int getId_categoria() { return id_categoria; }
    public void setId_categoria(int id_categoria) { this.id_categoria = id_categoria; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
    
    @Override
    public String toString() {
        return "Categoria{" + "id=" + id_categoria + ", nombre='" + nombre + "'}";
    }
}