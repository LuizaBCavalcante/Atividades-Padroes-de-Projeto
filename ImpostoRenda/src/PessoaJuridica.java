public class PessoaJuridica extends Pessoa {
    private double lucro;
    private double faturamentoProdutos;

    public PessoaJuridica(long id, String nome, double lucro, double faturamentoProdutos) {
        super(id, nome);
        this.lucro = lucro;
        this.faturamentoProdutos = faturamentoProdutos;
    }
    @Override
    protected double calcularIR() {

        double aliquotaIRPJ = 0.15;
        double limiteCobrancaIR = 20000.0;
        double aliquotaAdicional = 0.10;

        double irParcial = this.lucro * aliquotaIRPJ;
        double irpjFinal = irParcial;

        if (irParcial > limiteCobrancaIR) {
            double irExcedente = irParcial - limiteCobrancaIR;
            irpjFinal += irExcedente * aliquotaAdicional;
        }

        return irpjFinal;
    }

    @Override
    protected double calcularOutrosImpostos() {
        return calcularCSLL() + calcularICMS();
    }
    private double calcularCSLL() {
        double aliquotaCSLL = 0.09;
        return this.lucro * aliquotaCSLL;
    }

    private double calcularICMS() {
        double aliquotaICMS = 0.05;
        return this.faturamentoProdutos * aliquotaICMS;
    }
}