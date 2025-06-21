package boletos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBB implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        List<Boleto> boletos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String caminhoArquivo = "arquivos-retorno/" + nomeArquivo;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                Boleto boleto = new Boleto(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        LocalDate.parse(campos[2], formatter),
                        LocalDate.parse(campos[3], formatter).atStartOfDay(),
                        campos[4],
                        Double.parseDouble(campos[5]),
                        Double.parseDouble(campos[6]),
                        Double.parseDouble(campos[7]),
                        null,
                        null
                );
                boletos.add(boleto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo do Banco do Brasil: " + e.getMessage());
        }
        return boletos;
    }
}