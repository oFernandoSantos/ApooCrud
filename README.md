# Sistema CRUD em Java com Swing

##  Descrição do Projeto

Este projeto consiste no desenvolvimento de um sistema de registo, leitura, atualização e exclusão de dados **(CRUD)**, utilizando a linguagem de programação Java com a biblioteca Swing para a interface gráfica em ambiente de trabalho. A aplicação conecta-se a uma base de dados relacional **SQLite** para garantir a persistência e a integridade das informações.

O principal objetivo é demonstrar práticas de desenvolvimento orientado a objetos, como a separação de responsabilidades (utilizando o padrão DAO), e oferecer uma aplicação funcional, segura e intuitiva para a gestão de dados de utilizadores.

---

##  Funcionalidades

O sistema permite realizar as quatro operações básicas de um CRUD:

* **Create:** Registar novos utilizadores com nome e e-mail.
* **Read:** Listar todos os utilizadores registados na base de dados.
* **Update:** Selecionar um utilizador da lista, editar os seus dados e guardar as alterações.
* **Delete:** Selecionar um utilizador da lista e removê-lo da base de dados após uma confirmação.

---

##  Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Interface Gráfica:** Java Swing
* **Base de Dados:** SQLite
* **Driver de Conexão:** SQLite JDBC
* **IDE:** IntelliJ IDEA

---

##  Estrutura do Projeto

O projeto foi organizado seguindo o padrão DAO (Data Access Object) para separar as responsabilidades da aplicação:

```
/
├── src/
│   ├── DAO/
│   │   └── UserDAO.java      # (Data Access Object) Lida com toda a comunicação com a base de dados.
│   ├── model/
│   │   └── User.java         # (Model) Classe que representa a entidade 'Utilizador'.
│   └── view/
│       ├── Main.java         # (View) Ponto de entrada que inicia a aplicação.
│       └── UserForm.java     # (View) Classe que constrói e gere a interface gráfica.
│
├── users.db                  # Ficheiro da base de dados SQLite.
└── README.md                 # Este ficheiro.
```

---

##  Como Executar o Projeto

Siga os passos abaixo para executar a aplicação:

1.  **Pré-requisitos:**
    * Ter o **Java Development Kit (JDK)**, versão 17 ou superior, instalado.
    * Ter um IDE Java, como o **IntelliJ IDEA**, instalado.

2.  **Clone o Repositório:**
    ```bash
    git clone [https://github.com/oFernandoSantos/ApooCrud.git]
    ```

3.  **Abra no IntelliJ IDEA:**
    * Abra o IntelliJ IDEA.
    * Selecione `File > Open...` e navegue até à pasta do projeto.

4.  **Dependências:**
    * O projeto utiliza o driver **SQLite JDBC**. Se o IntelliJ não o reconhecer automaticamente, adicione-o manualmente:
        * Vá a `File > Project Structure... > Libraries`.
        * Clique no `+` e selecione `From Maven...`.
        * Procure por `org.xerial:sqlite-jdbc` e adicione a versão mais recente.

5.  **Execute a Aplicação:**
    * Encontre o ficheiro `Main.java` dentro da pasta `src/view`.
    * Clique com o botão direito do rato sobre o ficheiro e selecione `Run 'Main.main()'`.
    * *Observação:* Se o ficheiro `users.db` não existir, o programa irá criá-lo automaticamente na primeira execução.

---

##  Como Usar a Aplicação

A interface principal permite realizar todas as operações de forma intuitiva.

*\[Imagem da tela principal do seu sistema]*

1.  **Adicionar um Utilizador:**
    * Preencha os campos "Nome" e "Email".
    * Clique no botão "Adicionar". O novo utilizador será guardado e a lista será atualizada.

2.  **Listar Utilizadores:**
    * Clique no botão "Listar" para recarregar e exibir todos os utilizadores da base de dados na área principal. A lista também é carregada automaticamente ao iniciar.

3.  **Atualizar um Utilizador:**
    * Clique num nome na lista para o selecionar. Os seus dados irão preencher os campos "Nome" e "Email".
    * Altere os dados nos campos de texto.
    * Clique no botão "Atualizar".

4.  **Excluir um Utilizador:**
    * Clique num nome na lista para o selecionar.
    * Clique no botão "Excluir".
    * Uma caixa de diálogo pedirá a confirmação. Clique em "Sim" para remover o registo permanentemente.

---

##  Autor

* **Fernando Santos**
