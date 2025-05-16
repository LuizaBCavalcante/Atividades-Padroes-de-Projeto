package boletos;

import java.util.List;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo) {
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
        for (Boleto b : boletos) {
            System.out.println(b);
        }
    }
}