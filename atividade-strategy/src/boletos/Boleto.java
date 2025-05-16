package boletos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Boleto {
    private int id;
    private String codBanco;
    private LocalDate dataVencimento;
    private LocalDateTime dataPagamento;
    private String cpfCliente;
    private double valor;
    private double multa;
    private double juros;
    private String agencia;
    private String contaBancaria;

    public Boleto(int id, String codBanco, LocalDate dataVencimento, LocalDateTime dataPagamento,
                  String cpfCliente, double valor, double multa, double juros,
                  String agencia, String contaBancaria) {
        this.id = id;
        this.codBanco = codBanco;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.cpfCliente = cpfCliente;
        this.valor = valor;
        this.multa = multa;
        this.juros = juros;
        this.agencia = agencia;
        this.contaBancaria = contaBancaria;
    }

    @Override
    public String toString() {
        return "Boleto {" +
                "id: " + id +
                ", Código do Banco: '" + codBanco + '\'' +
        ", Data do Vencimento: " + dataVencimento +
                ", Data do Pagamento: " + dataPagamento +
                ", CPF do Cliente: '" + cpfCliente + '\'' +
        ", Valor: R$ " + valor +
                ", Multa: R$ " + multa +
                ", Juros: " + juros +
                ", Agência: '" + agencia + '\'' +
        ", Conta Bancária: '" + contaBancaria + '\'' +
        '}';
    }
}