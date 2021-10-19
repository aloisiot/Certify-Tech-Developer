import Services.ApiViagens;
import repository.*;

public class App {
    public static void main(String[] args) {
        Voos voos = Voos.getInstance();
        Hospedagens hospedagens = Hospedagens.getInstance();

        voos.addVoo("10/10/2021", "10/11/2021", "Recife");
        hospedagens.addHospedagem("10/10/2021", "10/11/2021", "Recife");
        voos.addVoo("10/10/2021", "10/11/2021", "Recife");
        hospedagens.addHospedagem("08/10/2021", "10/09/2021", "Gramado");
        voos.addVoo("10/10/2021", "10/11/2021", "Recife");
        hospedagens.addHospedagem("06/06/2021", "10/11/2022", "Hawai");
        voos.addVoo("10/10/2021", "10/11/2021", "Recife");
        hospedagens.addHospedagem("10/03/2021", "11/12/2021", "Piaui");

        ApiViagens apiViagens = new ApiViagens();
        String result = apiViagens.searchViagem("10/10/2021", "10/11/2021", "Recife");
        System.out.println(result);
    }
}
