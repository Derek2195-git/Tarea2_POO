package EjercicioMVC.Modelo;

import java.util.Objects;

/**
 * @author Derek Ramón Garzón Vizcarra
 */
public class Musica {
    private String nombre;
    private String compositor;
    private int anio;
    private String genero;
    private String cantante;
    private double costo;
    private String formato;

    public Musica() {
        setNombre("Constructor");
        setCompositor("Derek");
        setAnio(2005);
        setGenero("Rock");
        setCantante("Derek");
        setCosto(100);
        setFormato("ogg");
    }

    public Musica(String nombre, String compositor, int anio, String genero, String cantante, double costo, String formato) {
        setNombre(nombre);
        setCompositor(compositor);
        setAnio(anio);
        setGenero(genero);
        setCantante(cantante);
        setCosto(costo);
        setFormato(formato);
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public int getAnio() {
        return anio;
    }

    public String getCompositor() {
        return compositor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+
                "\nCompositor: "+compositor+
                "\nAño: "+anio+
                "\nGenero: "+genero+
                "\nCantante: "+cantante+
                "\nCantidad total que se pago: "+costo+
                "\nFormato: "+formato+
                "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
           return false;
        }
        final Musica other = (Musica) obj;
        if (this.anio != other.anio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.compositor, other.compositor);
    }
}
