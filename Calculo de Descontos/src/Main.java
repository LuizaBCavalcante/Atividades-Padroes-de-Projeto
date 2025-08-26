public class Main {
    public static void main(String[] args) {

        Venda venda = new Venda(600.00);

        System.out.println("*************************************************");


        CalculadoraDesconto descontoFixo = new DescontoFixo(0.10);
        venda.setEstrategiaDeDesconto(descontoFixo);
        venda.calcularValorFinal();

        System.out.println("*************************************************");

        CalculadoraDesconto descontoProgressivo = new DescontoProgressivo();
        venda.setEstrategiaDeDesconto(descontoProgressivo);
        venda.calcularValorFinal();

        System.out.println("*************************************************");

        CalculadoraDesconto descontoAniversario = new DescontoAniversario();
        venda.setEstrategiaDeDesconto(descontoAniversario);
        venda.calcularValorFinal();

    }
}