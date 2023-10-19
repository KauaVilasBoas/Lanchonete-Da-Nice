// Função para carregar clientes no select
function carregarClientes() {
    fetch('http://localhost:8080/clientes')
        .then(response => response.json())
        .then(data => {
            const clienteSelect = document.getElementById('clienteSelect');
            clienteSelect.innerHTML = '<option selected disabled>Selecione um Cliente</option>';

            data.content.forEach(cliente => {
                const option = document.createElement('option');
                option.value = cliente.id;
                option.textContent = cliente.nome;
                clienteSelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Erro ao carregar clientes.', error);
        });
}

// Função para carregar comidas no select
function carregarComidas() {
    fetch('http://localhost:8080/comidas')
        .then(response => response.json())
        .then(data => {
            const comidaSelect = document.getElementById('comidaSelect');
            comidaSelect.innerHTML = '';

            data.content.forEach(comida => {
                const option = document.createElement('option');
                option.value = comida.id;
                option.textContent = comida.titulo;
                option.setAttribute('data-preco', comida.preco); // Definir o atributo data-preco
                comidaSelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Erro ao carregar comidas.', error);
        });
}

document.addEventListener('DOMContentLoaded', function () {
    const clienteSelect = document.getElementById('clienteSelect');
    const comidaSelect = document.getElementById('comidaSelect');
    const precoTotalElement = document.getElementById('precoTotal');

    // Carregar clientes e comidas ao carregar a página
    carregarClientes();
    carregarComidas();

    // Atualizar o preço total do pedido ao selecionar/desselecionar comidas
    comidaSelect.addEventListener('change', function () {
        let precoTotal = 0;
        const selectedOptions = Array.from(comidaSelect.selectedOptions);

        selectedOptions.forEach(option => {
            const precoComida = parseFloat(option.getAttribute('data-preco'));
            precoTotal += precoComida;
        });

        precoTotalElement.textContent = `Preço Total: R$ ${precoTotal.toFixed(2)}`;
    });

    document.getElementById('formularioPedido').addEventListener('submit', function (event) {
        event.preventDefault();

        const idCliente = clienteSelect.value;
        const selectedComidas = Array.from(comidaSelect.selectedOptions).map(option => parseInt(option.value));

        const pedido = {
            idCliente: idCliente,
            idComidaList: selectedComidas
        };

        fetch('http://localhost:8080/pedidos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(pedido)
        })
            .then(response => response.json())
            .then(data => {
                document.getElementById('resultadoPedido').innerText = 'Pedido feito com sucesso!';
                document.getElementById('formularioPedido').reset();
                precoTotalElement.textContent = 'Preço Total: R$ 0.00'; // Resetar o preço total
            })
            .catch(error => {
                document.getElementById('resultadoPedido').innerText = 'Erro ao fazer pedido.';
            });
    });

});

let currentPage = 1;
const itemsPerPage = 10;

function listarPedidos(page) {
    currentPage = page || 1;

    fetch(`http://localhost:8080/pedidos?page=${currentPage - 1}&size=${itemsPerPage}`)
        .then(response => response.json())
        .then(data => {
            let listaPedidos = document.getElementById('listaPedidos');
            listaPedidos.innerHTML = '';

            let table = document.createElement('table');
            table.className = 'table';

            let thead = document.createElement('thead');
            thead.innerHTML = `
            <tr>
                <th scope="col">Nome do Cliente</th>
                <th scope="col">Data e Hora</th>
                <th scope="col">Comidas</th>
                <th scope="col">Preço Total</th>
            </tr>
        `;
            table.appendChild(thead);

            let tbody = document.createElement('tbody');

            data.content.forEach(pedido => {
                let tr = document.createElement('tr');
                tr.innerHTML = `
        <td>${pedido.nomeCliente}</td>
        <td>${pedido.data_hora}</td> <!-- Exibir data e hora no formato original -->
        <td>${pedido.comidaList.map(comida => comida.titulo).join(', ')}</td>
        <td>R$ ${pedido.precoTotal.toFixed(2)}</td>
    `;
                tbody.appendChild(tr);
                listaPedidos.scrollIntoView({ behavior: "smooth" });
            });

            table.appendChild(tbody);

            listaPedidos.appendChild(table);

            // Paginação
            const pagination = document.getElementById('pagination');
            pagination.innerHTML = '';

            const totalPages = Math.ceil(data.totalElements / itemsPerPage);
            for (let i = 1; i <= totalPages; i++) {
                const li = document.createElement('li');
                li.className = 'page-item';
                li.innerHTML = `<a class="page-link" href="#" onclick="listarPedidos(${i})">${i}</a>`;
                if (i === currentPage) {
                    li.classList.add('active');
                }
                pagination.appendChild(li);
                listaPedidos.scrollIntoView({ behavior: "smooth" });
            }
        })
        .catch(error => {
            document.getElementById('listaPedidos').innerText = 'Erro ao listar pedidos.';
        });
}
