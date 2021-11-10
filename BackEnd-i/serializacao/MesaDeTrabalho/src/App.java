import model.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();

        Contato c1 = new Contato("Joao", "1244353463", "joao@mail.com");
        contatos.add(c1);

        Contato c2 = new Contato("Maria", "7389274938", "maria@mail.com");
        contatos.add(c2);

        Contato c3 = new Contato("Joana", "1244353463", "joana@mail.com");
        contatos.add(c3);

        Contato c4 = new Contato("Larissa", "1244353463", "larissa@mail.com");
        contatos.add(c4);

        Contato c5 = new Contato("Marcia", "1244353463", "marcia@mail.com");
        contatos.add(c5);

        // Escrita...
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("contatos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contatos);
        }
        catch(FileNotFoundException e){
            System.err.println("ERROR" + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            System.err.println("ERROR" + e.getMessage());
            e.printStackTrace();
        }

        // Leitura...
        List<Contato> contatos1 = null;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("contatos.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            contatos1 = (ArrayList) ois.readObject();
        }
        catch(FileNotFoundException e){
            System.err.printf("ERROR" + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            System.err.printf("ERROR" + e.getMessage());
            e.printStackTrace();
        }

        contatos1.forEach( contato -> {
            System.out.printf("%nNome: %s%nNumero: %s%nEmail: %s%n%n",
                    contato.getNome(),
                    contato.getNumero(),
                    contato.getEmail());
        });

    }
}
