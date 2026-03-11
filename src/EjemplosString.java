import java.sql.ResultSet;
import java.util.*;
import java.util.function.Consumer;

public class EjemplosString {
    public static void main(String args[]) {
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        array1.add(205);
        array1.add(102);
        array1.add(98);
        array1.add(274);
        array1.add(321);
        array1.add(224);
        System.out.println("Elementos antes de sortearlos: "+ array1);
        Collections.sort(array1);
        System.out.println("Elementos despues de sortearlos: "+array1);
    }
}
