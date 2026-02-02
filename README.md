# 🎧 Cenaflix Podcast – CRUD em Java com JPA

Projeto CRUD desenvolvido em **Java**, utilizando **JPA (Java Persistence API)** para persistência de dados em banco relacional.  
A aplicação permite o gerenciamento de podcasts, com **autenticação de usuários**, **controle de acesso por perfil e permissões** e **criptografia de senha**.

---

## 📌 Funcionalidades

- Autenticação de usuários
- Criptografia de senha (MD5)
- Controle de acesso por perfil e permissões
- Cadastro de podcasts
- Listagem de podcasts
- Consulta por produtor
- Exclusão de podcasts
- Interface gráfica com Swing

---

## 🧱 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas:

- **Entity** → Mapeamento das entidades com JPA  
- **DAO** → Acesso e manipulação dos dados  
- **Util** → Utilitários como JPAUtil e Criptografia  
- **View** → Interface gráfica desenvolvida com Swing  

---

## 🛠 Tecnologias Utilizadas

- Java  
- JPA (Hibernate)  
- MySQL  
- Swing  
- Maven  

---

## 🔐 Controle de Acesso

O sistema possui controle de permissões baseado em perfis de usuário, permitindo restringir ações como:

- Cadastro de podcasts
- Exclusão de podcasts

As permissões são validadas tanto na interface quanto na lógica de negócio.

---

## 📂 Estrutura do Banco de Dados

- **usuario**
- **perfil**
- **permissao**
- **perfil_permissao**
- **podcast**

Relacionamentos mapeados com JPA utilizando:
- `@Entity`
- `@ManyToOne`
- `@EmbeddedId`
- `@MapsId`

---

## ▶️ Como Executar o Projeto

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
