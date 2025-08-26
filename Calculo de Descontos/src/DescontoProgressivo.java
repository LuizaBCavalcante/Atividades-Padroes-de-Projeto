
public class DescontoProgressivo implements CalculadoraDesconto {
    @Override
    public double calcular(Venda venda) {
        System.out.println("Calculando com desconto progressivo:");
        double valor = venda.getValorTotal();
        double percentualCalculado = (valor / 25.0) / 100.0;

        double percentualAplicado = Math.min(percentualCalculado, 0.20);

        System.out.printf("  (Percentual calculado: %.2f%%, aplicado: %.2f%%)\n", percentualCalculado * 100, percentualAplicado * 100);
        return valor * percentualAplicado;
    }
}