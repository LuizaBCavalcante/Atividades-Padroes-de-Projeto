
import java.time.LocalDate;
import java.time.MonthDay;

public class DescontoAniversario implements CalculadoraDesconto {
    @Override
    public double calcular(Venda venda) {
        System.out.println("Calculando com desconto de aniversário:");

        Cliente cliente = venda.getCliente();
        if (cliente == null || cliente.getDataNascimento() == null) {
            return 0;
        }

        MonthDay aniversarioCliente = MonthDay.from(cliente.getDataNascimento());
        MonthDay dataVenda = MonthDay.from(venda.getData());

        if (aniversarioCliente.equals(dataVenda)) {
            System.out.println("  Parabéns! Desconto de 15% aplicado.");
            return venda.getValorTotal() * 0.15;
        }

        System.out.println("  Não é aniversário do cliente. Nenhum desconto aplicado.");
        return 0;
    }
}