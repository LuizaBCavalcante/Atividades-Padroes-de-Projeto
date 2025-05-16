package boletos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        List<Boleto> boletos = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                Boleto boleto = new Boleto(
                        Integer.parseInt(campos[0]),
                        campos[1],
                        LocalDate.parse(campos[4], dateFormatter),
                        LocalDateTime.parse(campos[5], dateTimeFormatter),
                        campos[6],
                        Double.parseDouble(campos[7]),
                        Double.parseDouble(campos[8]),
                        Double.parseDouble(campos[9]),
                        campos[2],
                        campos[3]
                );
                boletos.add(boleto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo do Bradesco: " + e.getMessage());
        }
        return boletos;
    }
}