# Cálculo de Descontos

## Descrição do Problema

Considere que temos um sistema de vendas onde diferentes formas de desconto podem ser implementadas de acordo com as promoções vigentes, como em datas comemorativas. O sistema deve permitir o cálculo do desconto sobre a venda das seguintes maneiras:

* Percentual de desconto definido (que pode vir de um banco de dados).
* Percentual de desconto progressivo: `valor da compra / 25`, não podendo ultrapassar 20% (estes são apenas valores arbitrários de exemplo).
* Desconto de 15% na data de aniversário do cliente.

> O usuário é quem escolhe o tipo de desconto a ser aplicado, não o programa. O programa deve apenas permitir que seja mudado o algoritmo de cálculo do desconto.

---


### 1. Qual padrão de projeto pode ser utilizado no desenvolvimento de uma solução?

O padrão **Strategy**.

### 2. Como poderíamos implementar estes tipos de desconto sem utilizar Padrões de Projetos?

Para implementar esses tipos de desconto sem utilizar Padrões de Projetos, poderíamos utilizar alguma estrutura condicional como `if-else` ou `switch-case` na classe "Venda", onde a escolha do usuário seria passada para o método de cálculo como um parâmetro (uma string, por exemplo).

### 3. Quais os problemas que tal implementação traria?

Tal implementação violaria o **Open/Closed Principle**, pois toda vez que um novo tipo de desconto for implementado, será necessário alterar o bloco condicional, o que também implica em dificuldades para a manutenção do código. Ademais, essa implementação limitaria a reutilização de código, uma vez que na hipótese de criação de um novo módulo no sistema que utilize a lógica do cálculo, seria necessário replicar o código.
