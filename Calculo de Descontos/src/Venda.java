import java.time.LocalDate;


public class Venda {
    private long id;
    private Cliente cliente;
    private LocalDate data;
    private double valorTotal;

    private CalculadoraDesconto estrategiaDeDesconto;

    public Venda() {/**/}

    public Venda(Cliente cliente, LocalDate data, double valorTotal) {
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }


    public void setEstrategiaDeDesconto(CalculadoraDesconto estrategiaDeDesconto) {
        this.estrategiaDeDesconto = estrategiaDeDesconto;
    }

    public double calcularValorFinal() {
        if (this.estrategiaDeDesconto == null) {
            System.out.println("Nenhum desconto foi aplicado");
            return this.valorTotal;
        }

        double valorDoDesconto = this.estrategiaDeDesconto.calcular(this);
        double valorFinal = this.valorTotal - valorDoDesconto;

        System.out.printf("  Valor Original: R$ %.2f\n", this.valorTotal);
        System.out.printf("  Desconto: R$ %.2f\n", valorDoDesconto);
        System.out.printf("  Valor Final: R$ %.2f\n\n", valorFinal);

        return valorFinal;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
}