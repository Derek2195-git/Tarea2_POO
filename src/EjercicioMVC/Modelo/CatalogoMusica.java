package EjercicioMVC.Modelo;

import EjercicioMVC.Controlador.Controlador;
import EjercicioMVC.Vista.Vista;

import javax.swing.*;
import java.util.*;

public class CatalogoMusica {
    private ArrayList<Musica> canciones;

    public CatalogoMusica() {
        canciones = new ArrayList<Musica>();
    }

    public boolean agregarMelodia(Musica melodia) {
        boolean bandera = true;
        for (Musica melodia1 : canciones) {
            if (melodia1.equals(melodia)) {
                bandera = false;
                break;
            }
            else bandera = true;
        }
        if (bandera) {
            canciones.add(melodia);
        }
        return bandera;
    }

    public String mostrarColeccion() {
        String cadena = "";

        for (Musica melodia : canciones) {
            cadena+= melodia+"\n";
        }

        return cadena;
    }

    /**
     * Metodo para saber la cantidad de melodias que tiene cada genero
     * * @return HashMap
     */
    public HashMap cantidadGeneroMusicas() {
        HashMap<String, Integer> mapa = new HashMap<>();
        for (Musica cancion : canciones) {

            if(!mapa.containsKey(cancion.getGenero())) {
                mapa.put(cancion.getGenero(), 1);
            } else {
                int valor = mapa.get(cancion.getGenero());
                valor++;
                mapa.put(cancion.getGenero(), valor);
            }
        }
        return mapa;
    }


    public static void main(String[] args) {
        CatalogoMusica modelo = new CatalogoMusica();
        Vista vista = new Vista();

        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciar();

    }

    public HashSet recuperarTodosLosGeneros() {
        HashSet<String> hs = new HashSet<>();

        for (Musica cancion : canciones) {
            hs.add(cancion.getGenero());
        }
        return hs;
    }
    // Obtener precio de una colección
    public double obtenerValorMonetario() {
        double suma = 0;
        for(Musica cancion : canciones) {
            suma += cancion.getCosto();

        }

        return suma;
    }

    public HashMap listaCantantes() {
        HashMap<String, Integer> ListaDeCantantes = new HashMap<>();
        for (Musica cancion : canciones) {

            if(!ListaDeCantantes.containsKey(cancion.getCantante())) {
                ListaDeCantantes.put(cancion.getCantante(), 1);
            } else {
                int valor = ListaDeCantantes.get(cancion.getCantante());
                valor++;
                ListaDeCantantes.put(cancion.getCantante(), valor);
            }
        }
        return ListaDeCantantes;
    }

    public ArrayList<Musica> obtenerCancionesUnGenero(String genero) {
        ArrayList<Musica> melodias = new ArrayList<>();
        for (Musica melodia : canciones) {
            if (genero.equalsIgnoreCase(melodia.getGenero())) {
                melodias.add(melodia);
            }
        }
        return melodias;
    }

    // Falto:

    // Obtener las melodias de un artista
    public ArrayList<Musica> obtenerMelodiasDeArtista(String artista) {
        ArrayList<Musica> melodias = new ArrayList<>();
        for (Musica melodia : canciones) {
            if (artista.equalsIgnoreCase(melodia.getCantante())) {
                melodias.add(melodia);
            }
        }
        return melodias;
    }


    // Eliminar melodias en base a su nombre
    public boolean eliminarMelodia(String nombreCancion) {

        /* Podemos borrar la canción usando un ciclo for y removiendola si se encuentra
           el nombre de dicha canción, pero no se borraran las que tengan nombres
           repetidos. Es por esto que usare un lambda
         */
        // Removemos las melodias que tengan un nombre igual al dado por el usuario
        return canciones.removeIf(melodia -> melodia.getNombre().equalsIgnoreCase(nombreCancion));
    }

    // Ultimo metodo: Modificar los datos de una melodia en caso de error
    public boolean modificarMelodia(String nombreBusqueda, Musica datosCambiados) {
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getNombre().equalsIgnoreCase(nombreBusqueda)) {
                canciones.set(i, datosCambiados);
                return true;
            }
        }
        return false;
    }

    public boolean comprobarSiExiste(String cancionABuscar) {
        for (Musica melodia : canciones) {
            if(melodia.getNombre().equalsIgnoreCase(cancionABuscar)) return true;
        }
        return false;
    }

    public Musica consultarUnaMelodia(String nombreMelodia) {

        for (Musica melodia : canciones) {
            if(melodia.getNombre().equalsIgnoreCase(nombreMelodia)) return melodia;
        }
        return null;
    }



}
