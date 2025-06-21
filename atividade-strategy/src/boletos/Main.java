package boletos;

public class Main {
    public static void main(String[] args) {
        ProcessarBoletos processadorBB = new ProcessarBoletos(new LeituraRetornoBB());
        processadorBB.processar("banco-brasil-1.csv");

        ProcessarBoletos processadorBradesco = new ProcessarBoletos(new LeituraRetornoBradesco());
        processadorBradesco.processar("bradesco-1.csv");
    }
}