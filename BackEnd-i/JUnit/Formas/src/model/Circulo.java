package model;

public class Circulo implements Forma{
    int raio;

    public Circulo(int raio){
        this.raio = raio;
    }

    @Override
    public int calcPerimetro() {
        double perimetro = 2 * Math.PI * this.raio;
        return (int)perimetro;
    }
}
