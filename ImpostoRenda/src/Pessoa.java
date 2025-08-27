public abstract class Pessoa {
    private long id;
    private String nome;

    public Pessoa(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public final double calcularImpostosTotais() {
        double ir = calcularIR();
        double outrosImpostos = calcularOutrosImpostos();
        return ir + outrosImpostos;
    }

    protected abstract double calcularIR();
    protected abstract double calcularOutrosImpostos();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}