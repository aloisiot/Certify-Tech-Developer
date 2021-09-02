package NotaFiscal;

public class Produto {
    private Double pesoLiquido;
    private int unidades;
    private int volumeUnitario;
    private int volumeTotal;
    private String dataValidade;
    private String dataFabricação;

    public Produto(Double pesoLiquido, int unidades, int volumeUnitario, String dataValidade, String dataFabricação) {
        this.pesoLiquido = pesoLiquido;
        this.unidades = unidades;
        this.volumeUnitario = volumeUnitario;
        this.dataValidade=dataValidade;
        this.dataFabricação=dataFabricação;
        this.volumeTotal = volumeUnitario * unidades;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getVolumeUnitario() {
        return volumeUnitario;
    }

    public void setVolumeUnitario(int volumeUnitario) {
        this.volumeUnitario = volumeUnitario;
    }

    public int getVolumeTotal() {
        return volumeTotal;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDataFabricação() {
        return dataFabricação;
    }

    public void setDataFabricação(String dataFabricação) {
        this.dataFabricação = dataFabricação;
    }
}
