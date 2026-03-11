import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Consumer;

public class EjemplosArrayList {
    public static void main(String[] args) {
        ArrayList<String> palabras = new ArrayList<String>();
        Scanner teclado = new Scanner(System.in);
        String op = "y";
        do {
            System.out.print("Ingrese una cadena: ");
            palabras.add(teclado.nextLine());
            System.out.print("Deseas introducr otro nombre? Y/N \n");
            op = teclado.nextLine();
        } while (op.equalsIgnoreCase("y"));

        System.out.println("Expresion lambda: ");
        Consumer metodoImprimir = (n) ->{System.out.println(n);};
        palabras.forEach((metodoImprimir));
    }
}
