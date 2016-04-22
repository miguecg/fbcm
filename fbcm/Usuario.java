/*
 * Autor: Miguel Angel Cedeño Garcidueñas
 * 
 * FIE-UMSNH
 */
package fbcm;

/**
 *
 * @author miguel
 */
import java.io.Serializable;

public class Usuario implements Serializable {
    
    private String nombre;
    private String id;

    public Usuario() {
    }

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
