package boletos;

import java.util.List;

public interface LeituraRetorno {
    List<Boleto> lerArquivo(String nomeArquivo);
}