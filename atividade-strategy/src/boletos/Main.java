package boletos;

public class Main {
    public static void main(String[] args) {
        ProcessarBoletos processadorBB = new ProcessarBoletos(new LeituraRetornoBB());
        processadorBB.processar("C:\\Users\\user\\Documents\\IFTO\\2025-1\\Padrões de Projeto\\Strategy\\arquivos-retorno\\banco-brasil-1.csv");

        ProcessarBoletos processadorBradesco = new ProcessarBoletos(new LeituraRetornoBradesco());
        processadorBradesco.processar("C:\\Users\\user\\Documents\\IFTO\\2025-1\\Padrões de Projeto\\Strategy\\arquivos-retorno\\bradesco-1.csv");
    }
}