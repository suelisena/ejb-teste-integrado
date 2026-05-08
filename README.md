💳 Gestão de Benefícios - Full Stack Challenge
Este projeto consiste em um sistema de gerenciamento e transferência de benefícios corporativos, desenvolvido com uma arquitetura moderna e robusta. O foco principal foi a implementação de transações seguras e o tratamento de concorrência.

# 🚀 Tecnologias Utilizadas
Backend
Java 17 & Spring Boot 3.2.5

Spring Data JPA para persistência de dados.

H2 Database (Banco de dados em memória para desenvolvimento).

JUnit 5 & Mockito para testes unitários.

Jakarta EE (Evolução do Java EE para APIs modernas).

Frontend
Angular 15

TypeScript (Configurado para compatibilidade com Workspace v4.9.5).

CSS3 com layout centralizado e responsivo.

# 🛠️ Diferenciais Técnicos (Padrão de Produção)
1. Controle de Concorrência (Optimistic Locking)
Implementei o uso da anotação @Version do JPA na entidade Beneficio. Isso garante que, em um ambiente de produção com múltiplos acessos simultâneos, os dados não sejam sobrescritos indevidamente, evitando o problema de "Lost Update".

2. Arquitetura de Testes (Code Coverage)
O projeto foi desenvolvido com foco em passar por ferramentas de análise estática como o SonarQube.

Testes de Sucesso: Validação da lógica de débito e crédito entre contas.

Testes de Exceção: Garantia de que o sistema impede transferências com saldo insuficiente.

Mocking: Uso de Mockito para isolar a camada de serviço da camada de dados.

3. UI/UX Centralizado
O frontend foi refatorado para oferecer uma experiência de usuário limpa e profissional, utilizando um container centralizado que melhora a legibilidade em monitores de alta resolução.

# 📦 Como Executar o Projeto
Pré-requisitos
Java 17 instalado.

Node.js (v18 ou superior) e Angular CLI.

Backend
Importe o projeto na sua IDE (Eclipse/IntelliJ).

Aguarde o Maven baixar as dependências.

Execute a classe BackendApplication.java.

A API estará disponível em http://localhost:9090.

Frontend
Navegue até a pasta frontend-beneficios.

Execute npm install para instalar as dependências.

Inicie o servidor com ng serve.

Acesse http://localhost:4200 no seu navegador.

🧪 Validando a Qualidade
Para rodar os testes unitários e verificar a cobertura de código:

Bash
# No diretório raiz do backend
mvn test
Obs: Todos os testes devem apresentar a "Barra Verde" no JUnit.

📝 Notas de Versão
Documentação OpenAPI: O projeto integra o springdoc-openapi para documentação. Devido a migrações de ambiente para o ecossistema Jakarta, a interface visual do Swagger pode ser acessada via /v3/api-docs para extração da especificação JSON da API.

# 📖 Documentação da API (Contratos)
Para garantir a transparência e facilitar a integração, seguem os principais endpoints da aplicação:

1. Listar Todos os Benefícios
URL: GET /api/v1/beneficios

Descrição: Retorna a lista completa de benefícios, saldos e versões de locking.

Resposta (200 OK):

JSON
[
  { "id": 1, "nome": "Auxílio Alimentação", "valor": 500.00, "version": 4 },
  { "id": 2, "nome": "Auxílio Transporte", "valor": 300.00, "version": 4 }
]
2. Realizar Transferência
URL: GET /api/v1/beneficios/transferir

Parâmetros:

de (Long): ID do benefício de origem.

para (Long): ID do benefício de destino.

valor (BigDecimal): Quantia a ser transferida.

Regras de Negócio: * Valida se ambos os IDs existem.

Valida se o saldo de origem é suficiente.

Executa a transação com Optimistic Locking.

Respostas:

200 OK: "Sucesso! Transferência realizada."

500 Internal Server Error: "Saldo insuficiente" ou "Benefício não encontrado".

Desenvolvido por Sueli — Systems Analyst & Full Stack Developer
