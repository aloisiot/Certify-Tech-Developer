import models.Cliente;
import models.Filme;
import repository.GradeFilmes;
import services.GradeFilmesProxy;
import throwables.FilmeNaoHabilitadoException;

public class AppFilmes {
    public static void main(String[] args) {
        Filme result;
        GradeFilmesProxy proxy = new GradeFilmesProxy();
        GradeFilmes grade = GradeFilmes.getInstance();
        Cliente cliente = new Cliente("70.123.4.10", "Joao");

        Filme filme = new Filme("Avatar", "Brasil");
        Filme filme1 = new Filme("Matrix", "Colombia");
        Filme filme2 = new Filme("Hary Potter", "Argentina");

        grade.addFilme(filme);
        grade.addFilme(filme1);
        grade.addFilme(filme2);

        try{
            result = proxy.getFilme(cliente, "Avatar");
            System.out.printf("Link para acesso: %s%n", result.getLink());
        } catch(FilmeNaoHabilitadoException e){
            System.err.println(e.getMessage());
        }

        try{
            result = proxy.getFilme(cliente, "Matrix");
            System.out.printf("Link para acesso: %s%n", result.getLink());
        } catch(FilmeNaoHabilitadoException e){
            System.err.println(e.getMessage());
        }

        try{
            result = proxy.getFilme(cliente, "Hary Potter");
            System.out.printf("Link para acesso: %s%n", result.getLink());
        } catch(FilmeNaoHabilitadoException e){
            System.err.println(e.getMessage());
        }

    }
}
