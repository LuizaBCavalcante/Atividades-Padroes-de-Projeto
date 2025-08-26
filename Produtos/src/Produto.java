import java.time.LocalDate;
import java.util.Objects;

public final class Produto {

    private final long id;
    private final String codigoEan;
    private final String descricao;
    private final String marca;
    private final String modelo;
    private final double preco;
    private final LocalDate dataCadastro;
    private final LocalDate dataUltimaAtualizacao;
    private final int estoque;
    private final String categoria;
    private final String urlFoto;


    private Produto(Builder builder) {
        this.id = builder.id;
        this.codigoEan = builder.codigoEan;
        this.descricao = builder.descricao;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.preco = builder.preco;
        this.dataCadastro = builder.dataCadastro;
        this.dataUltimaAtualizacao = builder.dataUltimaAtualizacao;
        this.estoque = builder.estoque;
        this.categoria = builder.categoria;
        this.urlFoto = builder.urlFoto;
    }

    public long getId() { return id; }
    public String getCodigoEan() { return codigoEan; }
    public String getDescricao() { return descricao; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPreco() { return preco; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public LocalDate getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public int getEstoque() { return estoque; }
    public String getCategoria() { return categoria; }
    public String getUrlFoto() { return urlFoto; }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                ", categoria='" + categoria + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }


    public static class Builder {
        private long id;
        private String codigoEan = "";
        private final String descricao;
        private final String marca;
        private String modelo = "";
        private final double preco;
        private final LocalDate dataCadastro;
        private LocalDate dataUltimaAtualizacao;
        private int estoque = 0;
        private final String categoria;
        private String urlFoto = "";

        public Builder(String descricao, String marca, double preco, String categoria) {
            this.descricao = Objects.requireNonNull(descricao, "Descrição não pode ser nula.").trim();
            this.marca = Objects.requireNonNull(marca, "Marca não pode ser nula.").trim();
            this.preco = preco;
            this.categoria = Objects.requireNonNull(categoria, "Categoria não pode ser nula.").trim();

            this.dataCadastro = LocalDate.now();
            this.dataUltimaAtualizacao = this.dataCadastro;
        }

        public Builder comId(long id) {
            this.id = id;
            return this;
        }

        public Builder comCodigoEan(String codigoEan) {
            this.codigoEan = Objects.requireNonNullElse(codigoEan, "");
            return this;
        }

        public Builder comModelo(String modelo) {
            this.modelo = Objects.requireNonNullElse(modelo, "");
            return this;
        }

        public Builder comDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
            this.dataUltimaAtualizacao = dataUltimaAtualizacao;
            return this;
        }

        public Builder emEstoque(int estoque) {
            this.estoque = estoque;
            return this;
        }

        public Builder comUrlFoto(String urlFoto) {
            this.urlFoto = Objects.requireNonNullElse(urlFoto, "");
            return this;
        }

        public Produto build() {
            if (descricao.isEmpty() || marca.isEmpty() || categoria.isEmpty()) {
                throw new IllegalStateException("Descrição, marca e categoria não podem ser vazias.");
            }
            if (preco <= 0) {
                throw new IllegalStateException("O preço deve ser maior que zero.");
            }
            if (!modelo.isEmpty() && marca.isEmpty()) {
                throw new IllegalStateException("Modelo não pode ser informado se a marca não existir.");
            }
            if (dataUltimaAtualizacao != null && dataUltimaAtualizacao.isBefore(dataCadastro)) {
                throw new IllegalStateException("A data da última atualização não pode ser anterior à data de cadastro.");
            }
            if (estoque < 0) {
                throw new IllegalStateException("O estoque não pode ser negativo.");
            }

            return new Produto(this);
        }
    }
}