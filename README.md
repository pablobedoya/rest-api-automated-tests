# rest-api-automated-tests

Este projeto contém testes automatizados para uma [API REST](http://dummy.restapiexample.com), cujo objetivo é realizar operações de CRUD em cima da entidade Funcionário.
 
  ### Tecnologias utilizadas:
  * Java
  * Maven
  * Rest Assured
  * Junit
  * Cucumber
  * Cluecumber Report
  * Java Faker

  ### Destaques:
  * O framework responsável pelas requisições HTTP, nesse caso o Rest Assured, foi isolado dos steps BDD, a fim de prover uma fácil manutenção numa eventual necessidade de troca de framework.
  * Uso de Test Data Factory para criação de dados aleatórios utilizados para os testes.
  * Cenários concebidos seguindo os princípios [BRIEF](https://cucumber.io/blog/bdd/keep-your-scenarios-brief/) como um boa prática.
 
## Execução

### Pré-requisitos
* Clonar o repositório do projeto: `git clone https://github.com/pablobedoya/rest-api-automated-tests.git`
* Rodar o comando Maven para resolver as dependências: `mvn clean install -DskipTests`

### Rodar os testes
* Rodar o comando Maven: `mvn test`

### Gerar relatório de execução dos testes
* Após a execução dos testes, rodar o comando Maven: `mvn cluecumber-report:reporting`

**Nota:** Após a execução do comando de geração do relatório de execução dos testes, o relatório estará acessível dentro do projeto, no caminho `/target/generated-report/index.html`.
