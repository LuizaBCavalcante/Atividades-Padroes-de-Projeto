package boletos;

public class Main {
    public static void main(String[] args) {

        ProcessarBoletos processador = new ProcessarBoletos(LeituraRetorno::lerBradesco);
        processador.processar("arquivos-retorno/bradesco-1.csv");
    }
}