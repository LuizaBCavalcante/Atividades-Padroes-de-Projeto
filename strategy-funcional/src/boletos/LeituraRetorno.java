package boletos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetorno {
    public static List<Boleto> lerBradesco(String nomeArquivo) {
        List<Boleto> boletos = new ArrayList<>();

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        try {
            List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
            for (String linha : linhas) {
                String[] campos = linha.split(";");

                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(campos[0]));
                boleto.setCodBanco(campos[1]);
                boleto.setAgencia(campos[2]);
                boleto.setContaBancaria(campos[3]);
                boleto.setDataVencimento(LocalDate.parse(campos[4], formatoData));
                boleto.setDataPagamento(LocalDateTime.parse(campos[5], formatoDataHora));
                boleto.setCpfCliente(campos[6]);
                boleto.setValor(Double.parseDouble(campos[7]));
                boleto.setMulta(Double.parseDouble(campos[8]));
                boleto.setJuros(Double.parseDouble(campos[9]));

                boletos.add(boleto);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return boletos;
    }
}
