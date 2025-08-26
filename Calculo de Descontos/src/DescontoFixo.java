
public class DescontoFixo implements CalculadoraDesconto {
    private final double percentual;

    public DescontoFixo(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Venda venda) {
        System.out.println("Calculando com desconto fixo de " + (percentual * 100) + "%:");
        return venda.getValorTotal() * this.percentual;
    }
}
