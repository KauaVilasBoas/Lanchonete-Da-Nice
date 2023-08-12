document.getElementById('formularioComida').addEventListener('submit', function (event) {
    event.preventDefault(); // Impede o envio padrão do formulário

    const titulo = document.getElementById('titulo').value;
    const preco = document.getElementById('preco').value;
    const imagem = document.getElementById('imagem').value;

    const comida = {
        titulo: titulo,
        preco: preco,
        imagem: imagem
    };

    fetch('http://localhost:8080/comidas', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(comida)
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('resultadoComida').innerText = 'Comida cadastrado com sucesso!';
            document.getElementById('formularioComida').reset();
        })
        .catch(error => {
            document.getElementById('resultado').innerText = 'Erro ao cadastrar comida.';
        });
});

function excluirComida(id) {
    event.preventDefault(); // Impede o redirecionamento da página
    fetch(`http://localhost:8080/comidas/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                listarComidas(); // Atualiza a lista após a exclusão
            } else {
                console.error('Erro ao excluir comida.');
            }
        })
        .catch(error => {
            console.error('Erro ao excluir comida.', error);
        });
}

function listarComidas() {
    fetch('http://localhost:8080/comidas')
        .then(response => response.json())
        .then(data => {
            let listaComidas = document.getElementById('listaComidas');
            listaComidas.innerHTML = '';

            let table = document.createElement('table');
            table.className = 'table';

            let thead = document.createElement('thead');
            thead.innerHTML = `
            <tr>
                <th scope="col">Título</th>
                <th scope="col">Preço</th>
                <th scope="col">Imagem</th>
            </tr>
        `;
            table.appendChild(thead);

            let tbody = document.createElement('tbody');

            data.content.forEach(comida => {
                let tr = document.createElement('tr');
                tr.innerHTML = `
                <td>${comida.titulo}</td>
                <td>R$ ${comida.preco}</td>
                <td><img src="${comida.imagem}" alt="${comida.titulo}" style="max-width: 100px;"></td>
                <td>
                <button class="btn btn-primary mr-2" onclick="abrirModalEditarComida(${comida.id})">Editar</button>
            <button class="btn btn-danger" onclick="excluirComida(${comida.id})">Excluir</button>
            <button class="btn btn-primary mr-2" onclick="detalharComida(${comida.id})">Detalhar</button>
        </td>
                
            `;
                tbody.appendChild(tr);
            });

            table.appendChild(tbody);

            listaComidas.appendChild(table);
            listaComidas.scrollIntoView({ behavior: "smooth" });
        })
        .catch(error => {
            document.getElementById('listaComidas').innerText = 'Erro ao listar comidas.';
        });


}

function detalharComida(id) {
    fetch(`http://localhost:8080/comidas/${id}`)
        .then(response => response.json())
        .then(comida => {
            const modal = new bootstrap.Modal(document.getElementById('modalDetalhesComida'));
            const detalhesComida = document.getElementById('detalhesComida');

            detalhesComida.innerHTML = `
                <h5>Título: ${comida.titulo}</h5>
                <p>Preço: R$ ${comida.preco.toFixed(2)}</p>
                <p>Imagem: <img src="${comida.imagem}" alt="Imagem da Comida" style="max-width: 100%;"></p>
            `;

            modal.show();
        })
        .catch(error => {
            console.error('Erro ao obter detalhes da comida.', error);
        });
}

function abrirModalEditarComida(id) {
    fetch(`http://localhost:8080/comidas/${id}`)
        .then(response => response.json())
        .then(comida => {
            const modal = new bootstrap.Modal(document.getElementById('modalEditarComida'));
            const form = document.getElementById('formEditarComida');

            form.innerHTML = `
                <input type="hidden" id="comidaIdEditar" value="${comida.id}">
                
                <div class="mb-3">
                    <label for="precoEditar" class="form-label">Preço:</label>
                    <input type="text" class="form-control" id="precoEditar" value="${comida.preco.toFixed(2)}">
                </div>
            `;

            document.getElementById('btnSalvarEdicaoComida').addEventListener('click', function() {
                const idEditar = document.getElementById('comidaIdEditar').value;
                const precoEditar = document.getElementById('precoEditar').value;

                const comidaEditar = {
                    id: idEditar,
                    preco: parseFloat(precoEditar)
                };

                fetch(`http://localhost:8080/comidas`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(comidaEditar)
                })
                    .then(response => {
                        if (response.ok) {
                            modal.hide();
                            listarComidas();
                        } else {
                            console.error('Erro ao editar comida.');
                        }
                    })
                    .catch(error => {
                        console.error('Erro ao editar comida.', error);
                    });
            });

            modal.show();
        })
        .catch(error => {
            console.error('Erro ao obter dados da comida para edição.', error);
        });
}
