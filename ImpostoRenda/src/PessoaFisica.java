public class PessoaFisica extends Pessoa {
    private double salarioBruto;
    private int numeroDependentes;
    private double gastosSaude;
    private double gastosEducacao;

    private static final double DEDUCAO_POR_DEPENDENTE = 189.59;


    public PessoaFisica( long id, String nome, double salarioBruto, int numeroDependentes,
                         double gastosSaude, double gastosEducacao) {
        super(id, nome);
        this.salarioBruto = salarioBruto;
        this.numeroDependentes = numeroDependentes;
        this.gastosSaude = gastosSaude;
        this.gastosEducacao = gastosEducacao;
    }

    private double calcularINSS() {
        double aliquotaINSS = 0.11;
        return this.salarioBruto * aliquotaINSS;
    }

    @Override
    protected double calcularIR() {
        double aliquotaIRPF = 0.11;
        double inss = calcularINSS();

        double baseCalculo = this.salarioBruto -(this.numeroDependentes * DEDUCAO_POR_DEPENDENTE) - inss;

        if (baseCalculo < 0) {
            baseCalculo = 0;
        }
        double irParcial = baseCalculo * aliquotaIRPF;
        double irpfFinal = irParcial - (this.gastosSaude + this.gastosEducacao);

        return Math.max(0, irpfFinal);
    }

    @Override
    protected double calcularOutrosImpostos() {
        return calcularINSS();
    }

}