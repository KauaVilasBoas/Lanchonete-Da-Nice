
    document.getElementById('formulario').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio padrão do formulário

    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const telefone = document.getElementById('telefone').value;
    const cpf = document.getElementById('cpf').value;

    const cliente = {
    nome: nome,
    email: email,
    telefone: telefone,
    cpf: cpf
};

    fetch('http://localhost:8080/clientes', {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json'
},
    body: JSON.stringify(cliente)
})
    .then(response => response.json())
    .then(data => {
    document.getElementById('resultado').innerText = 'Cliente cadastrado com sucesso!';
    document.getElementById('formulario').reset(); // Limpa o formulário após o cadastro
})
    .catch(error => {
    document.getElementById('resultado').innerText = 'Erro ao cadastrar cliente.';
});
});

    function listarClientes() {
    fetch('http://localhost:8080/clientes')
        .then(response => response.json())
        .then(data => {
            let listaClientes = document.getElementById('listaClientes');
            listaClientes.innerHTML = ''; // Limpa a lista antes de adicionar os clientes

            let ul = document.createElement('ul');

            data.forEach(cliente => {
                let li = document.createElement('li');
                li.innerHTML = `
                        <strong>Nome:</strong> ${cliente.nome}<br>
                        <strong>Email:</strong> ${cliente.email}<br>
                        <strong>Telefone:</strong> ${cliente.telefone}<br>
                        <strong>CPF:</strong> ${cliente.cpf}<br>
                    `;
                ul.appendChild(li);
            });

            listaClientes.appendChild(ul);
        })
        .catch(error => {
            document.getElementById('listaClientes').innerText = 'Erro ao listar clientes.';
        });
}