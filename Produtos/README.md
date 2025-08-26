# Instanciando Produtos

Considere que temos uma classe Produto com os seguintes atributos:

* **long id**

* String codigoEan //código de barras

* **String descricao**

* **String marca**

* String modelo

* **double preco**

* **LocalDate dataCadastro**

* LocalDate dataUltimaAtualizacao

* int estoque

* **String categoria**

* String urlFoto

A classe possui os seguintes requisitos:

1. Os atributos em negrito são obrigatórios.
2. Não pode ser informado um modelo se não for informada a marca.
3. O preço deve ser maior que zero.
4. A data de cadastro não pode ser alterada e deve ser definida por padrão com a data atual.
5. A data da última atualização não pode ser anterior a data de cadastro.
6. O estoque padrão deve ser zero e não pode ser atribuído valor negativo.
7. Nenhum dos atributos String pode ser null.


## Responda

### 1. Que padrão de projeto pode ser utilizado para tornar mais fácil e claro o processo de instanciação de tal classe, uma vez que há dependências entre diferentes atributos, atributos obrigatórios e outros não? Implemente tal padrão para esta classe.
O padrão de projeto mais adequado ao caso seria o padrão **Builder**, tendo em vista a quantidade massiva de atributos e a necessidade de haver atributos obrigatórios e outros não. Além disso, o padrão builder garantirá a imutabilidade do objeto necessária no caso em tela.

