package model;

public class Quadrado implements Forma{
    int comprimentoVertices;

    public Quadrado(int compromentoVertices) {
        this.comprimentoVertices = compromentoVertices;
    }

    @Override
    public int calcPerimetro() {
        return 4 * this.comprimentoVertices;
    }
}
