package NotaFiscal;

import java.util.Date;

public class NotaFiscal {

    private Destinatario destinatario;
    private Emitente emitente;
    private Transportador transportador;
    private int serie;
    private Date dataEmicao;
    private Produto produto;

    public NotaFiscal(Destinatario destinatario, Emitente emitente, Transportador transportador,  int serie, Date dataEmicao, Produto produto) {
        this.destinatario = destinatario;
        this.transportador = transportador;
        this.serie = serie;
        this.dataEmicao=dataEmicao;
        this.emitente=emitente;
        this.produto=produto;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Transportador getTransportador() {
        return transportador;
    }

    public void setTransportador(Transportador transportador) {
        this.transportador = transportador;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    // Impressão da nota fiscal
    public void printNotaFiscal(){
        var day = Integer.toString(dataEmicao.getDay());
        var month = Integer.toString(1+dataEmicao.getMonth());
        var year = Integer.toString(1900+dataEmicao.getYear());

        // Info NF
        System.out.println("\n");
        System.out.printf("Data Emição: %s/%s/%s\n", day, month, year);
        System.out.printf("Numero de série: %d\n", serie);
        System.out.println("\n");

        // Print Info Destinatário
        System.out.println("Imformações do destinatário:");
        System.out.printf("Nome: %s\n", destinatario.getNome());
        System.out.printf("Cpf/Cnpj: %s\n", Integer.toString(destinatario.getCpfCnpj()));
        System.out.printf("Inscrição estadual: %s\n", Integer.toString(destinatario.getInscricaoEstadual()));
        System.out.printf("Telefone: %s\n", destinatario.getTelefone());

        System.out.println("\nEndereco do Destinatário:");
        System.out.printf("Logradouro: %s\n", destinatario.getEndereco().getLogradouro());
        System.out.printf("Numero: %s\n", Integer.toString(destinatario.getEndereco().getNumero()));
        System.out.printf("Bairro: %s\n", destinatario.getEndereco().getBairro());
        System.out.printf("Cidade: %s\n", destinatario.getEndereco().getCidade());

        // Print Info Emitente
        System.out.println("\nInformações do Emitente");
        System.out.printf("Nome: %s\n", emitente.getNome());
        System.out.printf("Cpf/Cnpj: %s\n", Integer.toString(emitente.getCpfCnpj()));
        System.out.printf("Inscrição Estadual: %s\n", Integer.toString(emitente.getInscricaoEstadual()));
        System.out.printf("Telefone: %s\n", emitente.getTelefone());

        System.out.println("\nEndereco do Emitente:");
        System.out.printf("Logradouro: %s\n", emitente.getEndereco().getLogradouro());
        System.out.printf("Numero: %s\n", Integer.toString(emitente.getEndereco().getNumero()));
        System.out.printf("Bairro: %s\n", emitente.getEndereco().getBairro());
        System.out.printf("Cidade: %s\n", emitente.getEndereco().getCidade());

        // Print Info Transportador
        System.out.println("\nInformações do Transpordador");
        System.out.printf("Nome: %s\n", transportador.getNome());
        System.out.printf("Antt: %s\n", Integer.toString(transportador.getAntt()));
        System.out.printf("Placa Veiculo: %s\n", transportador.getPlacaVeiculo());

        // Print produt Info
        System.out.println("\nInformações do produto");
        System.out.printf("Peso liquido: %s\n", Double.toString(produto.getPesoLiquido()));
        System.out.printf("Unidades: %s\n", Integer.toString(produto.getUnidades()));
        System.out.printf("Volume Unitário: %s\n", Double.toString(produto.getVolumeUnitario()));
        System.out.printf("Volume total: %s\n", Double.toString(produto.getVolumeTotal()));
        System.out.printf("Data de validade: %s\n", produto.getDataValidade());
        System.out.printf("Data de Fabricação: %s\n", produto.getDataFabricação());

    }
}
