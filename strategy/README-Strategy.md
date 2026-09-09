# Strategy Design Pattern

O **Strategy** é um padrão de projeto comportamental que permite definir uma família de algoritmos, encapsular cada um deles em uma classe e torná-los intercambiáveis.

Em Java, o padrão é especialmente útil quando uma mesma operação pode ser realizada de diferentes maneiras e queremos evitar grandes blocos de `if/else` ou `switch` para escolher qual regra executar.

---

## 🎯 Qual problema o Strategy resolve?

Imagine uma aplicação de vendas que precisa calcular descontos diferentes:

- Cliente VIP → 20% de desconto
- Black Friday → 30% de desconto
- Sem desconto → 0%

Uma implementação inicial poderia concentrar todas as regras em uma única classe:

```java
public double calcularDesconto(String tipo, double valor) {
    if (tipo.equals("VIP")) {
        return valor * 0.80;
    } else if (tipo.equals("BLACK_FRIDAY")) {
        return valor * 0.70;
    } else {
        return valor;
    }
}
```

Funciona, mas conforme novas regras aparecem, essa classe começa a acumular responsabilidades e condicionais.

Com o **Strategy**, cada algoritmo fica separado em sua própria classe.

---

## 💡 Ideia principal

O Strategy funciona separando **o que precisa ser feito** de **como será feito**.

A classe principal trabalha com uma interface, enquanto cada implementação fornece uma estratégia diferente.

A estrutura básica é:

```text
                 ┌─────────────────────┐
                 │      Context        │
                 │                     │
                 │ usa uma Strategy    │
                 └──────────┬──────────┘
                            │
                            ▼
                 ┌─────────────────────┐
                 │      Strategy       │
                 │     <<interface>>   │
                 └──────────┬──────────┘
                            │
             ┌──────────────┼──────────────┐
             ▼              ▼              ▼
      ┌────────────┐ ┌────────────┐ ┌────────────┐
      │ Strategy A │ │ Strategy B │ │ Strategy C │
      └────────────┘ └────────────┘ └────────────┘
```

Cada estratégia implementa a mesma interface, mas possui sua própria regra de negócio.

---

# ☕ Strategy em Java

Uma forma comum de implementar o padrão em Java é utilizando uma **interface**.

### 1. Criando a interface Strategy

```java
public interface DescontoStrategy {

    double aplicarDesconto(double valor);
}
```

A interface define o contrato que todas as estratégias devem seguir.

---

### 2. Criando as estratégias concretas

Cada classe implementa uma forma diferente de calcular o desconto.

```java
public class DescontoClienteVIP implements DescontoStrategy {

    @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.80;
    }
}
```

Outra estratégia:

```java
public class DescontoBlackFriday implements DescontoStrategy {

    @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.70;
    }
}
```

E uma estratégia sem desconto:

```java
public class SemDesconto implements DescontoStrategy {

    @Override
    public double aplicarDesconto(double valor) {
        return valor;
    }
}
```

Assim, cada classe possui **uma responsabilidade específica**.

---

## 🧩 O Context

No Strategy, o **Context** é a classe que utiliza uma estratégia.

Neste exemplo, `Pedido` funciona como o Context:

```java
public class Pedido {

    private double valor;
    private DescontoStrategy tipoDesconto;

    public Pedido(double valor, DescontoStrategy tipoDesconto) {
        this.valor = valor;
        this.tipoDesconto = tipoDesconto;
    }

    public void setTipoDesconto(DescontoStrategy tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public double calcularValorFinal() {
        return tipoDesconto.aplicarDesconto(valor);
    }
}
```

Observe que `Pedido` **não sabe como cada desconto funciona**.

Ele conhece apenas a interface:

```java
DescontoStrategy
```

Isso permite trocar a estratégia sem modificar a classe `Pedido`.

---

# 🔄 Trocando estratégias em tempo de execução

Uma das características interessantes do Strategy é poder trocar o comportamento do objeto durante a execução.

Por exemplo:

```java
public class Main {

    public static void main(String[] args) {

        Pedido pedido = new Pedido(100.0, new SemDesconto());

        System.out.println(pedido.calcularValorFinal());

        pedido.setTipoDesconto(new DescontoClienteVIP());

        System.out.println(pedido.calcularValorFinal());

        pedido.setTipoDesconto(new DescontoBlackFriday());

        System.out.println(pedido.calcularValorFinal());
    }
}
```

O mesmo objeto `Pedido` pode utilizar diferentes algoritmos:

```text
Pedido
  │
  ├── SemDesconto
  │
  ├── DescontoClienteVIP
  │
  └── DescontoBlackFriday
```

A lógica de `Pedido` permanece a mesma.

---

# 🏗️ Estrutura do padrão

O Strategy normalmente possui três elementos principais:

### Strategy

Define o contrato comum para os algoritmos.

No projeto:

```java
DescontoStrategy
```

### Concrete Strategies

São as diferentes implementações do algoritmo.

No projeto:

```text
DescontoClienteVIP
DescontoBlackFriday
SemDesconto
```

### Context

É a classe que utiliza uma Strategy.

No projeto:

```text
Pedido
```

---

# 📦 Estrutura deste exemplo

O exemplo de cálculo de desconto deste projeto está organizado da seguinte maneira:

```text
strategy/
├── README.md
├── src/
│   ├── calculodesconto/
│   │   ├── Main.java
│   │   ├── Pedido.java
│   │   └── tiposdesconto/
│   │       ├── DescontoStrategy.java
│   │       ├── DescontoClienteVIP.java
│   │       ├── DescontoBlackFriday.java
│   │       └── SemDesconto.java
│   │
│   ├── calculofrete/
│   ├── formaspagamento/
│   └── ordenacaocustomizada/
```

Além do cálculo de descontos, o projeto contém outros exemplos para demonstrar como o Strategy pode ser aplicado em diferentes situações.

---

# 🚚 Exemplo conceitual: cálculo de frete

Imagine que uma loja ofereça diferentes formas de entrega:

```java
public interface FreteStrategy {

    double calcular(double distancia, double peso);
}
```

Podemos criar estratégias como:

```java
public class FreteNormal implements FreteStrategy {

    @Override
    public double calcular(double distancia, double peso) {
        return distancia * peso;
    }
}
```

E:

```java
public class FreteExpress implements FreteStrategy {

    @Override
    public double calcular(double distancia, double peso) {
        return (distancia * peso) * 1.5;
    }
}
```

O contexto não precisa conhecer os detalhes de cada cálculo.

---

# 💳 Exemplo conceitual: formas de pagamento

O mesmo princípio pode ser aplicado para pagamentos.

```java
public interface PagamentoStrategy {

    void pagar(double valor);
}
```

Implementações diferentes poderiam ser:

```text
PagamentoPix
PagamentoCartao
PagamentoBoleto
```

O sistema responsável pelo pedido poderia trabalhar apenas com:

```java
PagamentoStrategy
```

Dessa forma, adicionar uma nova forma de pagamento não exige alterar toda a lógica existente.

---

# 📊 Strategy e ordenação

Outro caso comum é quando uma aplicação precisa ordenar dados de maneiras diferentes.

Por exemplo:

```text
Ordenar por nome
Ordenar por preço
Ordenar por data
Ordenar por avaliação
```

Cada algoritmo de ordenação pode ser encapsulado em uma estratégia diferente.

Em Java, esse conceito aparece de maneira bastante natural com interfaces como `Comparator<T>`:

```java
Comparator<Produto> porNome =
        Comparator.comparing(Produto::getNome);
```

E outra estratégia:

```java
Comparator<Produto> porPreco =
        Comparator.comparing(Produto::getPreco);
```

O algoritmo que realiza a ordenação pode receber o `Comparator` e trabalhar com diferentes comportamentos sem precisar conhecer a implementação específica.

---

# ✅ Vantagens

### 1. Reduz condicionais

Evita grandes blocos de:

```java
if / else if / else
```

ou:

```java
switch
```

quando esses condicionais existem apenas para escolher algoritmos diferentes.

### 2. Princípio Aberto/Fechado

Novas estratégias podem ser adicionadas sem modificar o contexto existente.

Por exemplo, podemos criar:

```java
public class DescontoAniversariante implements DescontoStrategy {

    @Override
    public double aplicarDesconto(double valor) {
        return valor * 0.90;
    }
}
```

Sem precisar alterar `Pedido`.

### 3. Responsabilidade única

Cada estratégia fica responsável por uma regra específica.

### 4. Código mais testável

Cada estratégia pode ser testada isoladamente.

### 5. Permite trocar comportamentos

O comportamento pode ser escolhido e alterado em tempo de execução.

---

# ⚠️ Desvantagens

O Strategy também possui alguns custos.

### Mais classes

Cada estratégia normalmente é representada por uma classe. Em sistemas grandes, isso pode aumentar bastante a quantidade de arquivos.

### Complexidade desnecessária em casos simples

Se existem apenas duas regras muito simples e que provavelmente nunca irão crescer, criar várias classes pode ser exagero.

### Escolha da estratégia

Em algum ponto do sistema ainda será necessário decidir qual estratégia utilizar:

```java
if (tipo.equals("VIP")) {
    strategy = new DescontoClienteVIP();
}
```

O objetivo do Strategy não é eliminar todos os `if`s da aplicação, mas **tirar a lógica dos algoritmos de dentro do contexto**.

---

# 🆚 Antes e depois

### Sem Strategy

```java
public double calcular(String tipo, double valor) {

    if (tipo.equals("VIP")) {
        return valor * 0.80;
    }

    if (tipo.equals("BLACK_FRIDAY")) {
        return valor * 0.70;
    }

    return valor;
}
```

Com o crescimento da aplicação, novos tipos fazem essa classe crescer.

### Com Strategy

```java
public double calcularValorFinal() {
    return tipoDesconto.aplicarDesconto(valor);
}
```

A regra está delegada para a estratégia.

---

# 🔑 Quando utilizar Strategy?

O padrão é uma boa opção quando:

- existem vários algoritmos para realizar a mesma tarefa;
- o comportamento precisa ser escolhido em tempo de execução;
- existem muitos `if/else` ou `switch` relacionados à escolha de um algoritmo;
- as regras de negócio tendem a crescer ou mudar;
- você deseja isolar diferentes comportamentos em classes independentes;
- diferentes partes do sistema podem utilizar diferentes estratégias.

---

# 🧠 Resumo

O **Strategy Pattern** permite encapsular algoritmos diferentes atrás de uma mesma interface.

Em Java, uma implementação típica utiliza:

```text
Interface
    ↓
Estratégias concretas
    ↓
Contexto utiliza a interface
```

No exemplo deste projeto:

```text
DescontoStrategy
       │
       ├── DescontoClienteVIP
       ├── DescontoBlackFriday
       └── SemDesconto

              ↑
              │
            Pedido
```

A principal ideia para lembrar é:

> **Em vez de colocar vários comportamentos diferentes dentro de uma única classe, encapsule cada comportamento em uma estratégia e faça o contexto depender de uma abstração.**

---

## 📚 Referências

- **Design Patterns: Elements of Reusable Object-Oriented Software** — Erich Gamma, Richard Helm, Ralph Johnson e John Vlissides (Gang of Four).
- **Effective Java** — Joshua Bloch.
- Documentação oficial da linguagem Java sobre interfaces e `Comparator`.

---

## 📁 Sobre este diretório

Este diretório faz parte do repositório de estudos de **Design Patterns em Java** e contém exemplos práticos do padrão Strategy.

O objetivo é estudar não apenas a definição teórica do padrão, mas também observar como ele pode ser aplicado em diferentes problemas utilizando recursos da orientação a objetos em Java.
