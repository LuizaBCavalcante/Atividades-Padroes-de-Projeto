import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        Cliente clienteAniversariante = new Cliente(1L, "Luiza Cavalcante", hoje.withYear(1992));

        Venda venda = new Venda(clienteAniversariante, hoje, 600.00);

        System.out.println("Simulando descontos para uma venda de R$ " + venda.getValorTotal());
        System.out.println("******************************************************\n");

        venda.setEstrategiaDeDesconto(new DescontoFixo(0.10));
        venda.calcularValorFinal();

        venda.setEstrategiaDeDesconto(new DescontoProgressivo());
        venda.calcularValorFinal();

        venda.setEstrategiaDeDesconto(new DescontoAniversario());
        venda.calcularValorFinal();
    }
}