package EjercicioMVC.Vista;

import EjercicioMVC.Modelo.Musica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Vista {
    public Musica capturarMusica() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el nombre de la cancion: ");
        String nombreCancion = teclado.nextLine();
        System.out.println("Ingresa el nombre del compositor de la cancion: ");
        String compositorCancion = teclado.nextLine();
        System.out.println("Ingresa el genero de la cancion");
        String generoCancion = teclado.nextLine();
        System.out.println("Ingresa el cantante de la cancion");
        String cantanteCancion = teclado.nextLine();
        System.out.println("Ingresa el formato de la cancion");
        String formatoCancion = teclado.nextLine();
        System.out.println("Ingresa el año en donde fue compuesta la cancion");
        int anioCancion = teclado.nextInt();
        System.out.println("Ingresa el costo de la cancion");
        double costoCancion = teclado.nextDouble();

        Musica melodia = new Musica(nombreCancion, compositorCancion, anioCancion, generoCancion, cantanteCancion, costoCancion, formatoCancion);
        return melodia;

    }

    public void exitoInsertar(boolean bandera) {
        String cadena = bandera ? "Se agrego una nueva melodia" : "La melodia ya esta dentro de la colección";
        System.out.println(cadena);
    }

    public void mostrarTodasLasMusicas(String cadenaMusicas) {
        System.out.println(cadenaMusicas);
    }

    public int mostrarMenu() {
        int opc = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("1. Ingresar una melodia");
        System.out.println("2. Mostrar todas las melodias");
        System.out.println("3. Mostrar la cantidad de canciones por genero");
        System.out.println("4. Mostrar las cancionees por generos");
        System.out.println("5. Obtener el valor monetario de la colección");
        System.out.println("6. Ver cuantos y cuales cantantes se registraron");
        System.out.println("9. Salir");

        opc = teclado.nextInt();
        return opc;
    }

    public void mostrarHashMap(HashMap diccionarioCanciones) {
        System.out.println(diccionarioCanciones);
    }

    public void mostrarHashSet(HashSet listaCanciones) {
        System.out.println(listaCanciones);
    }

    public void mostrarValorMonetario(double valorMonetario) {
        System.out.println("El valor monetario de la colección es de "+valorMonetario);
    }

    public void mostrarCantantes(HashMap cantantes) {
        System.out.println(cantantes);
    }

    public void mostrarCancionesUnGenero(ArrayList<Musica> canciones, String genero) {
        System.out.println("Todas las canciones del genero: " + genero);

        for (int i = 0; i < canciones.size(); i++ ) {
            System.out.println(canciones.get(i));
        }
    }


    public String leerCadena(String cadena) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el "+cadena);
        String generoMusical = teclado.nextLine();
        return generoMusical;
    }
}
