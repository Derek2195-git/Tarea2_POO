package EjercicioMVC.Controlador;

import EjercicioMVC.Modelo.CatalogoMusica;
import EjercicioMVC.Modelo.Musica;
import EjercicioMVC.Vista.Vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Controlador {
    private Vista vista;
    private CatalogoMusica modelo;

    public Controlador(CatalogoMusica modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();

            switch(opcion) {
                case 1:
                    insertarNuevaMusica();
                    break;
                case 2:
                    mostrarMusica();
                    break;
                case 3:
                    mostrarCantidadPorGenero();
                    break;
                case 4:
                    recuperarCancionesPorGenero();
                    break;
                case 5:
                    obtenerPrecioColeccion();
                    break;
                case 6:
                    obtenerListaCantantes();
                    break;
                case 7:
                    mostrarTodasDeUnGenero();
                    break;
                case 9:
                    System.out.println("Adios!");
                    break;
            }
        } while (opcion != 9);
    }

    public void insertarNuevaMusica() {
        Musica musica = vista.capturarMusica();
        boolean bandera = modelo.agregarMelodia(musica);
        vista.exitoInsertar(bandera);
    }

    public void mostrarMusica() {
        String cadena = modelo.mostrarColeccion();
        vista.mostrarTodasLasMusicas(cadena);
    }

    public void mostrarCantidadPorGenero() {
        // String generoCancion = vista.leerCadena("genero");
        HashMap hm = modelo.cantidadGeneroMusicas();
        vista.mostrarHashMap(hm);

    }

    public void recuperarCancionesPorGenero() {
        HashSet hs = modelo.recuperarTodosLosGeneros();
        vista.mostrarHashSet(hs);
    }

    public void obtenerPrecioColeccion() {
        double valorMonetario = modelo.obtenerValorMonetario();
        vista.mostrarValorMonetario(valorMonetario);
    }

    public void obtenerListaCantantes() {
        HashMap cantantes = modelo.listaCantantes();
        vista.mostrarCantantes(cantantes);
    }

    public void mostrarTodasDeUnGenero() {
        String genero = vista.leerCadena("genero");
        ArrayList<Musica> canciones = modelo.obtenerCancionesUnGenero(genero);
        vista.mostrarCancionesUnGenero(canciones, genero);
    }
}
