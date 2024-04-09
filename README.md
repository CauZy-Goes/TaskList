# Documentação do Projeto TaskList

## Descrição

O TaskList é um sistema gerenciador de lista de tarefas desenvolvido em Java, utilizando JDBC para interação com um sistema de persistência local. Este sistema permite que os usuários gerenciem membros da família e suas respectivas tarefas, possibilitando adicionar, modificar, remover, listar, e visualizar tarefas específicas.

## Equipe de Desenvolvimento

- Cauã Goes Farias
- Kailan Souza Diaz
- Yan Fernandes
- Guilherme Lacerda
- Adriano Abreu

## Tecnologias Utilizadas

- Java
- JDBC
- Maven

## Funcionalidades

O sistema oferece as seguintes funcionalidades para os usuários:

- **Adicionar membro na família**: Permite ao usuário adicionar um novo membro à família.
- **Deletar membro da família**: Permite ao usuário remover um membro da família.
- **Mostrar membros da família**: Exibe todos os membros cadastrados pelo usuário.
- **Adicionar tarefa**: Permite ao usuário adicionar uma nova tarefa à lista de tarefas.
- **Modificar tarefa**: Permite ao usuário modificar uma tarefa existente na lista de tarefas.
- **Deletar tarefa**: Permite ao usuário remover uma tarefa da lista de tarefas.
- **Filtrar pelo ID do membro da família**: Exibe todos os membros da família filtrados pelo ID fornecido.
- **Mostrar todas as tarefas atrasadas/fora do prazo**: Exibe todas as tarefas que estão atrasadas ou fora do prazo.

## Diagramas

![image](https://github.com/yan-pi/TaskList/assets/102800044/7d24c587-a2b9-4d97-bbd5-92c5345b3dd9)

![image](https://github.com/yan-pi/TaskList/assets/102800044/918a9ae1-d5d6-443e-bdf1-583a8aea17e4)

## Configuração e Uso

### Pré-requisitos

- JDK instalado
- Maven instalado

### Configuração do Sistema de Persistência Local

O sistema utiliza um sistema de persistência local para armazenar os dados. Não é necessário configurar um banco de dados.

### Executando o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/CauZy-Dev/TaskList.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd TaskList
   ```

3. Compile e execute o projeto utilizando o Maven:

   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass="NomeDaClassePrincipal"
   ```

### Utilizando o Sistema

Após executar o projeto, você terá acesso a um menu com as opções disponíveis. Escolha a opção desejada e siga as instruções na tela para gerenciar membros da família e suas respectivas tarefas.

## Contribuição

Sinta-se à vontade para contribuir com melhorias para este projeto. Basta fazer um fork do repositório, implementar suas alterações e enviar um pull request.

---

Espero que esta documentação atenda às suas expectativas! Se você tiver alguma dúvida ou precisar de mais informações, não hesite em perguntar.
