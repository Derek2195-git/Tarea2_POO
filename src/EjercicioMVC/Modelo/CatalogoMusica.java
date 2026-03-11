package EjercicioMVC.Modelo;

import EjercicioMVC.Controlador.Controlador;
import EjercicioMVC.Vista.Vista;

import javax.swing.*;
import java.util.*;

public class CatalogoMusica {
    private ArrayList<Musica> canciones;

    Scanner teclado = new Scanner(System.in);

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
        String cadena = null;

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

        System.out.println("Hello World!");
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

            if(!ListaDeCantantes.containsKey(cancion.getGenero())) {
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
        return canciones;
    }

}
