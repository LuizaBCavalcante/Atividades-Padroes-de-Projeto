public class DescontoAniversario implements CalculadoraDesconto {
    @Override
    public double calcular(double valor) {
        System.out.println("Calculando com desconto de aniversário de 15%:");
        return valor * 0.15;
    }
}