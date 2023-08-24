<h1>Food Delivery</h1>
  <p>Olá, seja muito bem vindo ao meu repositório</p>
  <p>Este é um projeto de uma APIRest de uma Lanchonete.</p>
  
  <h2> 🗂️ Sumário </h2>
    <li><a href="#funcionalidades">Funcionalidades</a></li>
    <li><a href="#tecnologiasUtilizadas">Tecnologias Utilizadas</a></li>
    <li><a href="#configurações">Configurações</a></li>
    <li><a href="#comoExecutar">Como Executar</a></li>
    <li><a href="#endpoints">Endpoints</a></li>
    <li><a href="#observações">Observações</a></li>
    <li><a href="#autor">Autor</a></li>
    <li><a href="#contatos">Contato</a></li>


  <h2  id="funcionalidades">📑Funcionalidades</h2>
  <ul>
     <h3>C.R.U.D (Create, Read, Update, Delete)</h3>
      <li>Listar todos os clientes, itens do cardápio e pedidos cadastrados</li>
      <li>Cadastrar um novo cliente, item do cardápio ou pedido </li>
      <li>Detalhar todas as informações de um cliente, item do cardápio ou pedido</li>
      <li>Excluir um cliente, item do cardápio ou pedido</li>
      <li>Atualiar informações sobre um cliente, item do cardápio ou pedido</li>
     <h3>FILTROS</h3>
        <li>Filtrar pedidos por status (ENTREGUE ou PREPARANDO)</li>
  </ul>

  <h2  id="tecnologiasUtilizadas">🖥️Tecnologias Utilizadas</h2>
  <ul>
    <li>Java</li>
    <li>Spring</li>
    <li>JPA / Hibernate</li>
    <li>PostgreSQL</li>
    <li>JDBC</li>
    <li>Lombok</li>
    <li>Spring Validation</li>
    <li>Flyway</li>
    <li>HTML</li>
    <li>CSS</li>
    <li>Javascript</li>
  </ul>
        

<h2 id="configurações">⚙️Configurações</h2>
  <p>Antes de executar o projeto, é necessário realizar as seguintes configurações:</p>
  <ol>
    <li>Configurar o banco de dados PostgreSQL e criar o banco de dados.</li>
    <li>Modificar as informações de conexão com o banco de dados (URL, usuário e senha) no pacote resources/application.properties</li>
  </ol>

  <h2 id="comoExecutar">❓Como Executar</h2>
  <ol>
    <li>Clone ou faça o download do projeto para o seu ambiente de desenvolvimento.</li>
    <li>Importe o projeto para a sua IDE Java (Eclipse, IntelliJ, etc.).</li>
    <li>Realize as configurações necessárias conforme descrito acima.</li>
    <li>Start o projeto.</li>
    <li>Acesse a aplicação pelo Insomnia, Postman, etc. Utilizando as requisições abaixo.</li>
  </ol>

  <h2 id="endpoints">🌐Endpoints</h2>

  <h3>Cliente</h3>

|   Endpoints   |  Parameters  |    Verb    |
| :---         |     :---:      |          ---: |
| /clientes       |   *  |   POST    |
| /clientes  |   *  | GET    |
| /clientes/{id}   |   *  | GET    |
| /clientes       |   *  | PUT   |
| /clientes/{id}        |   *  | DELETE   |

<details>
    <summary>CADASTRAR NOVO CLIENTE - /clientes </summary>
    
  ### Descrição
  
  - Cadastra um novo cliente e instancia-lo no banco de dados.
  
  ### Códigos de Resposta
  
  - `201`: CREATED.
  
  ### Exemplo de Requisição
  
  - POST - /clientes
  - HTTP/1.1
  - Host: localhost:8080
  - Content-Type: application/json
  
  ```json
{
	"nome": "Kaua",
	"email": "kaua@rest.com",
	"telefone": "71999525569",
	"cpf": "05096215956"
}
  ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 201 CREATED
  - Content-Type: application/json
  ```json
     {
	"id": 7,
	"nome": "Kaua",
	"email": "kaua@rest.com",
	"telefone": "71999525569",
	"cpf": "05096215956"
}
  ```
    
  </details>
  
  <details>
    <summary> DETALHAR CLIENTE - /clientes/{id} </summary>
    
  ### Descrição
  
  Detalha um cliente contidos no banco de dados de acordo com o seu ID.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - GET - /clientes/7
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
  ```json
{
	"id": 7,
	"nome": "Kauã Caldeira",
	"email": "kaua@restnice.com.br",
	"telefone": "71999664163",
	"cpf": "05096215963"
}
  ```
    
  </details>

  <details>
    <summary> LISTAR CLIENTES - /clientes </summary>
    
  ### Descrição
  
  Lista todos os cliente contidos no banco de dados.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - GET - /clientes
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json

```json
   {
	"content": [
		{
			"id": 1,
			"nome": "Kauã Caldeira",
			"email": "kaua@restnice.com.br",
			"telefone": "71999664163"
		},
		{
			"id": 7,
			"nome": "Klaiton",
			"email": "klaito@rest.com",
			"telefone": "71999525569"
		}
	],
	"pageable": {
		"sort": {
			"empty": false,
			"unsorted": false,
			"sorted": true
		},
		"offset": 0,
		"pageSize": 10,
		"pageNumber": 0,
		"unpaged": false,
		"paged": true
	},
	"last": true,
	"totalElements": 2,
	"totalPages": 1,
	"size": 10,
	"number": 0,
	"sort": {
		"empty": false,
		"unsorted": false,
		"sorted": true
	},
	"first": true,
	"numberOfElements": 2,
	"empty": false
}
```
  </details>

  <details>
    <summary> EDITAR CLIENTES - /clientes </summary>
    
  ### Descrição
  
  Edita os dados de um cliente contidos no banco de dados de acordo com seu ID.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - PUT - /clientes
  - HTTP/1.1
  - Host: localhost:8080

```json
{
	"id": 1,
	"nome": "Kauã Caldeira",
	"telefone": "71999664163"
}
  ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
    
  </details>
  
  <details>
    <summary>EXCLUIR CLIENTE /clientes/{id}</summary>
    
  ### Descrição
  
  Deleta o cliente de acordo com seu ID.
  
  ### Códigos de Resposta
  
  - `204`: No Content.
  
  ### Exemplo de Requisição
  
  - DELETE - /clientes/7
  - HTTP/1.1
  - Host: localhost:8080

  ### Exemplo de Resposta
  
  - HTTP/1.1 204 No Content
  - Content-Type: application/json
  
  </details>

  <h3>Comida</h3>

  |   Endpoints   |  Parameters  |    Verb    |
| :---         |     :---:      |          ---: |
| /comidas       |   *  |   POST    |
| /comidas  |   *  | GET    |
| /comidas/{id}   |   *  | GET    |
| /comidas       |   *  | PUT   |
| /comidas/{id}        |   *  | DELETE   |
  
  <details>
    <summary>CADASTRAR UMA NOVA COMIDA AO CARDÁPIO - /comidas</summary>
    
  ### Descrição
  
  Cadastra uma nova comida e instacia-a no banco de dados.
  
  ### Códigos de Resposta
  
  - `201`: CREATED.
  
  ### Exemplo de Requisição
  
  - POST /comidas
  - Host: localhost:8080
    
    ```json
    {
	"titulo": "X-Egg",
	"imagem": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcornershopapp.com%2Fpt-br%2Fproducts%2F1wr34-x-calabresa-unidade&psig=AOvVaw1aBznCOL71nYP_ZHsUmgt1&ust=1686922982173000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiUiv2zxf8CFQAAAAAdAAAAABAE",
	"preco": 10.0
    }  
    ```

  ### Exemplo de Resposta
  
  - HTTP/1.1 201 CREATED
  - Content-Type: application/json
      
  ```json
    {
	"id": 6,
	"titulo": "X-Egg",
	"imagem": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcornershopapp.com%2Fpt-br%2Fproducts%2F1wr34-x-calabresa-unidade&psig=AOvVaw1aBznCOL71nYP_ZHsUmgt1&ust=1686922982173000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiUiv2zxf8CFQAAAAAdAAAAABAE",
	"preco": 10.0
  }
  ```
    
  </details>

  <details>
    <summary> DETALHAR COMIDA - /comidas/{id} </summary>
    
  ### Descrição
  
  Detalha todos os dados de uma comida contida no banco de dados de acordo com o seu ID.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - GET - /comidas/6
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
  ```json
{
	"id": 6,
	"titulo": "X-Egg",
	"imagem": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcornershopapp.com%2Fpt-br%2Fproducts%2F1wr34-x-calabresa-unidade&psig=AOvVaw1aBznCOL71nYP_ZHsUmgt1&ust=1686922982173000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiUiv2zxf8CFQAAAAAdAAAAABAE",
	"preco": 10.0
}
  ```
    
  </details>

  <details>
    <summary> LISTAR COMIDAS - /comidas </summary>
    
  ### Descrição
  
  Lista todas as comidas contidas no banco de dados.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - GET - /comidas
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json

```json
    {
	"content": [
		{
			"titulo": "X-Calabresa",
			"imagem": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcornershopapp.com%2Fpt-br%2Fproducts%2F1wr34-x-calabresa-unidade&psig=AOvVaw1aBznCOL71nYP_ZHsUmgt1&ust=1686922982173000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiUiv2zxf8CFQAAAAAdAAAAABAE",
			"preco": 15.0
		},
		{
			"titulo": "X-Egg",
			"imagem": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcornershopapp.com%2Fpt-br%2Fproducts%2F1wr34-x-calabresa-unidade&psig=AOvVaw1aBznCOL71nYP_ZHsUmgt1&ust=1686922982173000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiUiv2zxf8CFQAAAAAdAAAAABAE",
			"preco": 10.0
		},
		{
			"titulo": "X-Tudo",
			"imagem": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcornershopapp.com%2Fpt-br%2Fproducts%2F1wr34-x-calabresa-unidade&psig=AOvVaw1aBznCOL71nYP_ZHsUmgt1&ust=1686922982173000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPiUiv2zxf8CFQAAAAAdAAAAABAE",
			"preco": 19.0
		}
	],
	"pageable": {
		"sort": {
			"empty": false,
			"sorted": true,
			"unsorted": false
		},
		"offset": 0,
		"pageNumber": 0,
		"pageSize": 10,
		"paged": true,
		"unpaged": false
	},
	"last": true,
	"totalPages": 1,
	"totalElements": 3,
	"size": 10,
	"number": 0,
	"sort": {
		"empty": false,
		"sorted": true,
		"unsorted": false
	},
	"first": true,
	"numberOfElements": 3,
	"empty": false
}
```
  </details>
  
  <details>
    <summary>EDITAR COMIDA /comidas</summary>
    
  ### Descrição
  
  Edita os dados de uma comida contida no banco de dados.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - PUT - /comida
  - HTTP/1.1
  - Host: localhost:8080

```json
{
	"id": 9,
	"imagem": "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.lelelanches.batataisfood.com.br%2Fx-tudo-duplo&psig=AOvVaw31m-fwFDsWC0mz7ii6-hET&ust=1686923241779000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPi22_e0xf8CFQAAAAAdAAAAABAE",
	"preco": 16.0
}
```

  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
  
  </details>

  <details>
    <summary>DELETAR COMIDA /comidas/{id}</summary>
    
  ### Descrição
  
  Deleta uma comida contida no banco de dados de acordo com o seu ID.
  
  ### Códigos de Resposta
  
  - `204`: NO CONTENT.
  
  ### Exemplo de Requisição
  
  - DELETE - /comidas/9
  - HTTP/1.1
  - Host: localhost:8080

  ### Exemplo de Resposta
  
  - HTTP/1.1 204 NO CONTENT
  - Content-Type: application/json
  
  </details>

 <h3>Pedido</h3>

  |   Endpoints   |  Parameters  |    Verb    |
| :---         |     :---:      |          ---: |
| /pedidos       |   *  |   POST    |
| /pedidos  |   *  | GET    |
| /pedidos/detalhar/{id}   |   *  | GET    |
| /pedidos/comidas/{id}   |   *  | GET    |
| /pedidos/{id}        |   *  | PTCH   |
| /pedidos       |   *  | PUT   |
| /pedidos/{id}        |   *  | DELETE   |
  
  <details>
    <summary>CADASTRAR UM NOVO PEDIDO - /pedidos</summary>
    
  ### Descrição
  
  Cadastra um novo pedido e instacia-o no banco de dados.
  
  ### Códigos de Resposta
  
  - `201`: CREATED.
  
  ### Exemplo de Requisição
  
  - POST /comida
  - Host: localhost:8080
    
    ```json
    {
	"idCliente":4,
	"idComidaList":[2,3]
	}
    ```

  ### Exemplo de Resposta
  
  - HTTP/1.1 201 CREATED
  - Content-Type: application/json
      
  ```json
    {
	"id": 5,
	"cliente": {
		"id": 4,
		"nome": "Axel",
		"email": "axel@rest.com",
		"telefone": "71999882319",
		"cpf": "615.897.321-19",
		"ativo": true
	},
	"comidas": [
		{
			"id": 2,
			"titulo": "X-Tudo",
			"imagem": "https://www.receiteria.com.br/receitas-de-x-tudo/",
			"preco": 20.0,
			"ativo": true
		},
		{
			"id": 3,
			"titulo": "X-Bacon",
			"imagem": "https://www.recepedia.com/pt-br/receita/carne/230410-x-salada-bacon/",
			"preco": 16.0,
			"ativo": true
		}
	],
	"data_hora": "2023-07-14T11:22:27.6859439",
	"status": "PREPARANDO",
	"ativo": true,
	"precoTotal": 36.0
	}
  ```
    
  </details>

  <details>
    <summary> DETALHAR PEDIDO - /pedidos/detalhar/{id} </summary>
    
  ### Descrição
  
  Detalha um pedido contidos no banco de dados de acordo com o seu ID.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - GET - /pedidos/5
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
  ```json
{
	"id": 5,
	"cliente": {
		"id": 4,
		"nome": "Axel",
		"email": "axel@rest.com",
		"telefone": "71999882319",
		"cpf": "615.897.321-19",
		"ativo": true
	},
	"comidas": [
		{
			"id": 2,
			"titulo": "X-Tudo",
			"imagem": "https://www.receiteria.com.br/receitas-de-x-tudo/",
			"preco": 20.0,
			"ativo": true
		},
		{
			"id": 3,
			"titulo": "X-Bacon",
			"imagem": "https://www.recepedia.com/pt-br/receita/carne/230410-x-salada-bacon/",
			"preco": 16.0,
			"ativo": true
		}
	],
	"data_hora": "2023-07-14T11:22:27.685944",
	"status": "CANCELADO",
	"ativo": false,
	"precoTotal": 36.0
}
  ```
  </details>

  <details>
    <summary> LISTAR ITENS DO CARDÁPIO DE UM PEDIDO - /pedidos/comidas/{id} </summary>
    
  ### Descrição
  
  Lista todos as comidas de um pedido contido no banco de dados.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - GET - /pedidos/comidas/{id}
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json

```json
  [
	{
		"id": 2,
		"titulo": "X-Tudo",
		"imagem": "https://www.receiteria.com.br/receitas-de-x-tudo/",
		"preco": 20.0,
		"ativo": true
	},
	{
		"id": 3,
		"titulo": "X-Bacon",
		"imagem": "https://www.recepedia.com/pt-br/receita/carne/230410-x-salada-bacon/",
		"preco": 16.0,
		"ativo": true
	}
]
```
  </details>

<details>
    <summary> CONCLUIR PEDIDO - /pedidos/{id} </summary>
    
  ### Descrição
  
  Altera o status do pedido para: "Concluído" de acordo com o seu ID.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - PTCH - /pedidos/3
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json

  </details>

  <details>
    <summary>EDITAR PEDIDO - /pedidos</summary>
    
  ### Descrição
  
  Edita um pedido contido no banco de dados.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - PUT /pedidos
  - Host: localhost:8080
    
    ```json
    {
	"id":5,
	"idComidaList":[2,4]
	}
    ```

  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
      
  ```json
   Pedido atualizado
  ```
    
  </details>

  <details>
    <summary>DELETAR PEDIDO /pedidos/{id}</summary>
    
  ### Descrição
  
  Deleta um pedido contido no banco de dados de acordo com o seu ID.
  
  ### Códigos de Resposta
  
  - `204`: NO CONTENT.
  
  ### Exemplo de Requisição
  
  - DELETE - /pedidos/3
  - HTTP/1.1
  - Host: localhost:8080

  ### Exemplo de Resposta
  
  - HTTP/1.1 204 NO CONTENT
  - Content-Type: application/json
  
  </details>


  

  <h2 id="observações">❗Observações</h2>
  <p>Este projeto é apenas uma demonstração básica de uma API de Lanchonete utilizando Spring e Banco de Dados. Para fins de aprendizado e desenvolvimento.</p>

  <h2 id="autor">🖐️Autor</h2>
  <p>Kauã Caldeira Vilas Boas</p>
  
  <h2 id="contatos">📞Contato</h2>
  <ul>
    <li>Email: kauacaldeira@hotmail.com</li>
    <li>LinkedIn: <a href="https://www.linkedin.com/in/kauavilasboas/">Kauã Vilas Boas</a></li>
  </ul>

