public class Venda {
    private final double valorTotal;
    private CalculadoraDesconto estrategiaDeDesconto;

    public Venda(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void setEstrategiaDeDesconto(CalculadoraDesconto estrategia) {
        this.estrategiaDeDesconto = estrategia;
    }

    public double calcularValorFinal() {
        if (estrategiaDeDesconto == null) {
            System.out.println("Nenhum desconto foi aplicado");
            return this.valorTotal;
        }

        double desconto = estrategiaDeDesconto.calcular(this.valorTotal);
        double valorFinal = this.valorTotal - desconto;

        System.out.printf("  Valor Original: R$ %.2f\n", this.valorTotal);
        System.out.printf("  Desconto: R$ %.2f\n", desconto);
        System.out.printf("  Valor Final: R$ %.2f\n", valorFinal);

        return valorFinal;
    }
}