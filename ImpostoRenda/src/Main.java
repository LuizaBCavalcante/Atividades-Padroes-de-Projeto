import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        List<Pessoa> contribuintes = new ArrayList<>();
        contribuintes.add(new PessoaFisica(1, "Luiza", 5000, 1, 500, 350));
        contribuintes.add(new PessoaFisica(2, "Gabriel", 15000, 3, 800, 100));
        contribuintes.add(new PessoaJuridica(3, "Mercado pegue e pague", 80000, 10000));

        for (Pessoa contribuinte : contribuintes) {
            System.out.println("----------------------------------------------");
            if (contribuinte instanceof PessoaFisica) {
                System.out.println("Contribuinte (PF): " + contribuinte.getNome());
            } else if (contribuinte instanceof PessoaJuridica) {
                System.out.println("Contribuinte (PJ): " + contribuinte.getNome());
            }


            double totalImpostos = contribuinte.calcularImpostosTotais();

            System.out.println("Total de impostos a pagar: " + nf.format(totalImpostos));
            System.out.println("   - IR........: " + nf.format(contribuinte.calcularIR()));
            System.out.println("   - Outros....: " + nf.format(contribuinte.calcularOutrosImpostos()));
        }
        System.out.println("----------------------------------------------");
    }
}
