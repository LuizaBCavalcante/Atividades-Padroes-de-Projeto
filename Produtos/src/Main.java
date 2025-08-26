public class Main {
    public static void main(String[] args) {
        try {
            Produto caneta = new Produto.Builder("Caneta", "BIC", 1.99, "Papelaria")
                    .build();

            System.out.println("Produto 1 criado com sucesso: " + caneta);

        } catch (IllegalStateException e) {
            System.err.println("Erro ao criar produto 1: " + e.getMessage());
        }

        System.out.println("*****************************************");

        try {
            Produto notebook = new Produto.Builder("Notebook", "Lenovo", 3499.00, "Informática")
                    .comId(12345L)
                    .comCodigoEan("7890123456789")
                    .comModelo("654321")
                    .emEstoque(50)
                    .comUrlFoto("https://images.notebook.com/lenovo.png")
                    .build();

            System.out.println("Produto 2 criado com sucesso: " + notebook);
            System.out.println("Modelo do notebook: " + notebook.getModelo());

        } catch (IllegalStateException e) {
            System.err.println("Erro ao criar produto 2: " + e.getMessage());
        }

        System.out.println("-------------------------------------");

        try {
            Produto produtoInvalido = new Produto.Builder("Produto com erro", "Marca X", -10.0, "Teste")
                    .build();
        } catch (IllegalStateException e) {
            System.err.println("Erro esperado ao criar produto 3: " + e.getMessage());
        }
    }
}