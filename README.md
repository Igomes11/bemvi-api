# 🌿 Bemvi API

> **No Bemvi, você não fala sozinha.**

A **Bemvi API** é o backend do ecossistema Bemvi, uma plataforma digital de acolhimento, orientação e conexão voltada para mães atípicas.

Desenvolvida com **Java e Spring Boot**, a API tem como objetivo fornecer serviços e endpoints para integrar as aplicações Web e Mobile, permitindo o gerenciamento de informações, usuários, profissionais e demais funcionalidades da plataforma.

O projeto faz parte do ecossistema Bemvi, idealizado a partir de pesquisas com mães atípicas e fundamentado nos princípios de Design Centrado no Usuário (DCU), Interação Humano-Computador (IHC), acessibilidade e inclusão digital.

## 🎯 Objetivo

Desenvolver uma API REST que centralize as regras de negócio e a comunicação entre as aplicações do Bemvi e a camada de persistência de dados.

A API busca oferecer uma estrutura organizada, segura e escalável para apoiar o desenvolvimento das funcionalidades da plataforma.

## ✨ Funcionalidades previstas

- **Gerenciamento de usuárias:** cadastro, consulta, atualização e gerenciamento de contas.
- **Autenticação e autorização:** controle de acesso aos recursos da plataforma.
- **Rede de apoio:** suporte aos dados e às interações relacionadas às comunidades temáticas.
- **Profissionais Bemvi:** cadastro, consulta e gerenciamento de indicações de profissionais.
- **Mapa de Inclusão:** gerenciamento de informações sobre estabelecimentos e espaços acessíveis.
- **Gerenciamento de perfis:** armazenamento e atualização das informações das usuárias.
- **Integração com Web e Mobile:** disponibilização de endpoints para consumo pelas aplicações React e React Native.

> As funcionalidades serão implementadas progressivamente, conforme a evolução do projeto. Os recursos que envolvem autenticação, conversas em tempo real e dados pessoais exigirão implementação e validação específicas.

## 🛠️ Tecnologias utilizadas

- [**Java**](<https://www.java.com/>)**:** linguagem de programação.
- [**Spring Boot**](<https://spring.io/projects/spring-boot>)**:** framework para desenvolvimento da aplicação backend.
- [**Spring Web**](<https://docs.spring.io/spring-framework/reference/web/webmvc.html>)**:** criação de endpoints e APIs REST.
- [**Spring Data JPA**](<https://spring.io/projects/spring-data-jpa>)**:** integração com bancos de dados relacionais por meio da persistência de dados.
- [**Maven**](<https://maven.apache.org/>)**:** gerenciamento de dependências e construção do projeto, caso seja a ferramenta adotada.
- [**Git**](<https://git-scm.com/>)**:** controle de versão.
- [**GitHub**](<https://github.com/>)**:** hospedagem do repositório e colaboração.

Outras tecnologias poderão ser incorporadas conforme as necessidades de desenvolvimento.

## 🏗️ Arquitetura da aplicação

A API será estruturada para separar as responsabilidades da aplicação, facilitando a manutenção, a organização e a evolução do sistema.

A estrutura sugerida contempla:

- **Controller:** recebe as requisições HTTP e disponibiliza os endpoints.
- **Service:** concentra as regras de negócio.
- **Repository:** realiza as operações de persistência de dados.
- **Entity:** representa as entidades persistidas no banco de dados.
- **DTO (Data Transfer Object):** define os dados utilizados na comunicação entre as camadas e os clientes da API.
- **Config:** reúne configurações gerais da aplicação, quando necessário.


## 📋 Pré-requisitos

Antes de executar o projeto, instale:

- **JDK:** versão compatível com a versão do Spring Boot adotada.
- **Maven:** caso o projeto não utilize o Maven Wrapper (`mvnw`).
- **Git:** para clonar e versionar o repositório.
- **Banco de dados:** conforme a tecnologia escolhida para persistência.

Uma IDE, como IntelliJ IDEA, Eclipse ou Visual Studio Code com as extensões apropriadas, também pode facilitar o desenvolvimento.

## 🚀 Como executar o projeto

### 1\. Clone o repositório

```
git clone https://github.com/karolynne-freire/bemvi-api.git
```

### 2\. Acesse a pasta do projeto

```
cd bemvi-api
```

### 3\. Configure as variáveis de ambiente

Configure as propriedades necessárias para executar a aplicação, incluindo as credenciais do banco de dados, caso a persistência já esteja implementada.

Evite armazenar senhas, tokens ou outras credenciais diretamente no código ou em arquivos versionados.

### 4\. Instale as dependências e execute os testes

Se o projeto utilizar Maven e possuir o Maven Wrapper:

**Linux ou macOS:**

```
./mvnw clean verify
```

**Windows:**

```
mvnw.cmd clean verify
```

Caso utilize Maven instalado globalmente, execute:

```
mvn clean verify
```

### 5\. Inicie a aplicação

Com Maven Wrapper:

**Linux ou macOS:**

```
./mvnw spring-boot:run
```

**Windows:**

```
mvnw.cmd spring-boot:run
```

Ou, com Maven instalado:

```
mvn spring-boot:run
```

Se a aplicação estiver configurada com a porta padrão do Spring Boot, a API será iniciada em:

```
http://localhost:8080
```

> Os comandos pressupõem um projeto Spring Boot baseado em Maven. A execução depende da configuração real da aplicação e dos serviços externos necessários.

## 🔌 Endpoints da API

Os endpoints serão definidos conforme a implementação dos recursos do Bemvi.

Exemplos de recursos que poderão ser disponibilizados:

| Recurso | Finalidade |
| --- | --- |
| `/api/usuarios` | Gerenciamento de usuárias |
| `/api/profissionais` | Consulta e gerenciamento de profissionais |
| `/api/locais` | Consulta e gerenciamento de locais inclusivos |
| `/api/perfis` | Gerenciamento de perfis |
| `/api/comunidades` | Dados relacionados às comunidades de apoio |

> Os caminhos acima são exemplos de planejamento, não endpoints confirmados ou necessariamente implementados. Os métodos HTTP, parâmetros, regras de autenticação e respostas serão documentados conforme a API evoluir.


## 🔒 Segurança e privacidade

Como o Bemvi poderá lidar com dados pessoais e informações sensíveis, a segurança deverá ser considerada desde a arquitetura da API.

Entre as práticas previstas estão:

- Validação dos dados recebidos nas requisições.
- Autenticação e autorização adequadas aos recursos protegidos.
- Proteção de credenciais e segredos.
- Tratamento consistente de erros.
- Controle de acesso às informações pessoais.
- Cuidados específicos com dados relacionados à saúde e à família.
- Observância à Lei Geral de Proteção de Dados Pessoais (LGPD), quando aplicável.

A implementação de autenticação, criptografia, controles de acesso e demais mecanismos deverá ser validada durante o desenvolvimento.

## 🔗 Integração com as aplicações

A Bemvi API será responsável pela comunicação entre o backend e as interfaces do ecossistema:

- **Bemvi Web:** aplicação frontend desenvolvida com React.
- **Bemvi Mobile:** aplicativo desenvolvido com React Native.

A API REST permitirá que as aplicações consumam os recursos disponibilizados pelo backend por meio de requisições HTTP.

## 🚧 Status do projeto

**Em desenvolvimento.**

A API está sendo planejada para integrar as aplicações do ecossistema Bemvi. Os endpoints, as integrações, a persistência de dados e os mecanismos de segurança serão definidos e implementados conforme a evolução do projeto.


## 📄 Licença

Este projeto está sendo desenvolvido para fins acadêmicos e educacionais, como parte das atividades da disciplina de **Projeto de Pesquisa I (PP1)**.

