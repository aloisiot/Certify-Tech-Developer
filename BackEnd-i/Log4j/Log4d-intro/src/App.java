import org.apache.log4j.Logger;

public class App {

    private static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("Iniciando com log4j");

        try{
            System.out.println(10/0);
        } catch (ArithmeticException e){
            logger.error("Impossivel dividir por zero.", e);
        }
        logger.warn("Aviso");
    }
}
