# Sistema de Controle de Estoque e Vendas

Sistema desenvolvido para gerenciamento de estoque, movimentações, clientes e vendas, permitindo o controle completo de produtos e operações comerciais de pequenas empresas.

## Tecnologias Utilizadas

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Validation
* Lombok
* PostgreSQL

### Documentação

* Swagger / OpenAPI

### Banco de Dados

* PostgreSQL

---

## Funcionalidades

### Produtos

* Cadastro de produtos
* Atualização de produtos
* Exclusão de produtos
* Consulta por ID
* Listagem completa

### Categorias

* Cadastro de categorias
* Listagem de categorias
* Associação de produtos a categorias

### Controle de Estoque

* Entrada de mercadorias
* Saída de mercadorias
* Controle automático de quantidade
* Validação de estoque insuficiente
* Histórico completo de movimentações

### Clientes

* Cadastro de clientes
* Consulta de clientes

### Vendas

* Registro de vendas
* Associação de cliente à venda
* Associação de múltiplos produtos à venda
* Cálculo automático do valor total
* Baixa automática do estoque
* Registro automático de movimentações de saída

### Dashboard

* Total de produtos
* Produtos com estoque baixo
* Total de clientes
* Total de vendas
* Faturamento total

### Tratamento de Erros

* Produto não encontrado
* Cliente não encontrado
* Estoque insuficiente
* Quantidade inválida

---

## Estrutura do Projeto

```text
src/main/java/com/maarimo/estoque

├── controller
├── service
├── repository
├── entity
├── dto
├── exception
├── config
└── EstoqueApplication
```

---

## Modelo de Dados

### Categoria

```text
Categoria
├── id
└── nome
```

### Produto

```text
Produto
├── id
├── codigo
├── nome
├── descricao
├── precoCusto
├── precoVenda
├── quantidade
├── estoqueMinimo
└── categoria
```

### Cliente

```text
Cliente
├── id
├── nome
├── telefone
└── email
```

### Venda

```text
Venda
├── id
├── cliente
├── data
└── valorTotal
```

### ItemVenda

```text
ItemVenda
├── id
├── venda
├── produto
├── quantidade
├── precoUnitario
└── subtotal
```

### MovimentacaoEstoque

```text
MovimentacaoEstoque
├── id
├── produto
├── quantidade
├── tipo
└── data
```

---

## Relacionamentos

```text
Categoria 1 ---- N Produtos

Cliente 1 ---- N Vendas

Venda 1 ---- N ItemVenda

Produto 1 ---- N ItemVenda

Produto 1 ---- N MovimentacoesEstoque
```

---

## Configuração do Banco de Dados

Crie um banco PostgreSQL:

```sql
CREATE DATABASE estoque_db;
```

## Como Executar o Projeto

### Clonar o repositório

```bash
git clone https://github.com/seu-usuario/estoque.git
```

### Entrar na pasta

```bash
cd estoque
```

### Instalar dependências

```bash
mvn clean install
```

### Executar aplicação

```bash
mvn spring-boot:run
```

---

## Documentação da API

Após iniciar a aplicação:

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

---

## Exemplos de Requisição

### Criar Categoria

```http
POST /categorias
```

```json
{
  "nome": "Eletrônicos"
}
```

---

### Criar Produto

```http
POST /produtos
```

```json
{
  "codigo": "P001",
  "nome": "Mouse Gamer",
  "descricao": "Mouse RGB",
  "precoCusto": 80,
  "precoVenda": 120,
  "quantidade": 10,
  "estoqueMinimo": 2,
  "categoriaId": 1
}
```

---

### Entrada de Estoque

```http
POST /estoque/entrada
```

```json
{
  "produtoId": 1,
  "quantidade": 20
}
```

---

### Criar Cliente

```http
POST /clientes
```

```json
{
  "nome": "João Silva",
  "telefone": "71999999999",
  "email": "joao@email.com"
}
```

---

### Registrar Venda

```http
POST /vendas
```

```json
{
  "clienteId": 1,
  "itens": [
    {
      "produtoId": 1,
      "quantidade": 2
    }
  ]
}
```

---


## Autor

Matheus Amorim

Desenvolvedor Java | Spring Boot | PostgreSQL

Projeto desenvolvido para estudo, portfólio e futura comercialização para pequenos negócios.
