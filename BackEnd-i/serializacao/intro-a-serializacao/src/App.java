import model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro c1 = new Cachorro(10, "Coragem");
        cachorros.add(c1);

        Cachorro c2 = new Cachorro(5, "Pitoco");
        cachorros.add(c2);

        Cachorro c3 = new Cachorro(3, "Scoobedo");
        cachorros.add(c3);

        // Escrita...
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("output-file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cachorros);
        }
        catch(FileNotFoundException e){
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // Leitura...
        List<Cachorro> cachorros1 = null;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("output-file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            cachorros1 = (ArrayList) ois.readObject();
        }
        catch(FileNotFoundException e){
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        cachorros1.forEach(cachorro -> {
            System.out.printf("%nnome: %s%nidade: %d%n", cachorro.getNome(), cachorro.getIdade());
        });
    }
}
