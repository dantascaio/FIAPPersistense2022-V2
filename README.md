# Trabalho Final Persistense - Integrantes:
Caio Cesar - RM344946

Diogo Martins - RM344796

Marcos Alencar Arruda - RM344803

Rafael Braga - RM344805

Rafael Borger - RM344806

Vinicius Rodrigues Tonha - RM344810

# 1. FIAPPersistense2022-V2
Trabalho de conclusão da matéria "Persistense"


## 1.1. Para executar a aplicação, basta executar
` docker-compose up `

## 1.2. Foi criada uma coleção no Postman já com algumas requisições
`https://app.getpostman.com/run-collection/136c10df8eeddec03478`

# 2. Justificativas técnicas
O Banco de dados escolhido foi o MySQL. Por ser modelo de relacionamento
entre entidades definidas para um e-commerce o modelo relacional 
com um banco de dados relacional garante de forma mais consistentente 
a persistência dos dados. 

O Banco de dados para cacheamento foi o REDIS. A vantagem dele é consultar
blocos de informações pequenos. Nosso modelo relacional é pequeno e um sistema
de controle de estoques realiza muitas consultas. O REDIS por ser um banco 
chave e valor em memória o acesso aos dados é muito rápido.

A solução é altamente escalável utilizando serviços cloud. A Aplicação possui 
Docker Compose e Dockerfile podendo ser executada em servidores na cloud.

# 3. Informações Técnicas

É necesário uma instância de MySQL com um Schema chamado test. 
Na primeira execução serão criadas as tabelas.
