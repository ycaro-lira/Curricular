# Projeto Curricular

## Visão Geral

O Projeto Curricular é uma plataforma online dedicada a auxiliar os usuários na criação e aprimoramento de currículos, proporcionando uma interação direta com analistas experientes na área de contratação. A aplicação visa facilitar o processo de construção de currículos de qualidade, melhorando as chances dos usuários no mercado de trabalho.

## 1. Introdução

### 1.1 Objetivo do Projeto

O Projeto Curricular tem como objetivo principal fornecer uma plataforma intuitiva e eficiente para a criação e aprimoramento de currículos profissionais. Ao conectar usuários a analistas experientes, busca-se otimizar o processo de busca por emprego, fornecendo insights valiosos para a melhoria das candidaturas.

### 1.2 Principais Funcionalidades

- Cadastro de Usuários e Analistas
- Criação e Edição de Currículos
- Interação Direta entre Usuários e Analistas
- Avaliações e Feedbacks

### 1.3 Público-Alvo

- Profissionais em busca de emprego
- Analistas de Recursos Humanos e Contratação

## 2. Arquitetura do Sistema

### 2.1 Tecnologias Utilizadas

- Spring Framework (Spring Boot, Spring MVC)
- Java Persistence API (JPA) para integração com o banco de dados
- Spring Security
- Thymeleaf para templates HTML
- Bootstrap
- JavaScript
- Banco de dados relacional (MySQL)

### 2.2 Estrutura do Banco de Dados

- Tabelas para armazenar dados de usuários, analistas.

### 2.3 Camadas da Aplicação

O Projeto Curricular adota uma arquitetura baseada em camadas para promover uma estrutura organizada e modular. Cada camada desempenha um papel específico na aplicação.

### 2.3.1 Camada de Controle (Controladores)
A camada de controle é responsável por receber as requisições dos usuários e encaminhá-las para a lógica de negócios apropriada. Utilizando controladores Spring, ela mapeia URLs, processa dados de entrada e coordena a interação entre a interface do usuário e a lógica de negócios.
 
@Controller

@RequestMapping("/usuarios")
public class UsuarioControle {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ModelAndView listarUsuarios() {
        ModelAndView modelAndView = new ModelAndView("usuario/home");
        modelAndView.addObject("usuarios", usuarioService.listarTodosUsuarios());
        return modelAndView;
    }
    
    // ... outros métodos de controle ...
}
### 2.3.2 Camada de Serviço (Lógica de Negócios)
A camada de serviço contém a lógica de negócios da aplicação. Aqui, são implementadas as regras de negócios, validações e operações que não são diretamente relacionadas à manipulação de dados no banco. Os serviços são invocados pelos controladores e interagem com a camada de acesso a dados para buscar ou persistir informações.

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    // ... outros métodos de serviço ...
}

### 2.3.3 Camada de Acesso a Dados (Repositórios)
A camada de acesso a dados é responsável pela interação direta com o banco de dados. Ela utiliza interfaces JPA (Java Persistence API) para definir operações básicas de consulta, criação, atualização e exclusão. Os repositórios são utilizados pelos serviços para manipular dados persistentes.

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    // Métodos fornecidos pelo Spring Data JPA
    List<Usuario> findAll();
    
    // ... outros métodos de repositório ...
}

### 2.3.4 Camada de Apresentação (Views)
A camada de apresentação consiste nas views que são renderizadas e exibidas para os usuários. No Projeto Curricular, as views são criadas utilizando Thymeleaf, um motor de templates que integra de forma eficiente com o Spring. Elas recebem dados dos controladores e apresentam informações ao usuário de forma amigável.

```html
<!-- Arquivo Thymeleaf para exibir detalhes do usuário -->
<div th:each="usuario : ${usuarios}">
    <p th:text="${usuario.nome}"></p>
</div>

