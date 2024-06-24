package br.edu.ifsp.domain.usecases.client;

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.client.Client;
import br.edu.ifsp.domain.model.client.ClientRepository;

public class UpdateClientUseCase {
    private ClientRepository clientRepository;

    public UpdateClientUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void updateClient(CPF cpf, String novoNome, String novoEndereco) {
       FindClientUseCase findClient = new FindClientUseCase(clientRepository);

        Client client = findClient.FindClientByCPF(cpf);

        if (client != null) {
            if (novoNome != null && !novoNome.isEmpty()) {
                client.setName(novoNome);
            }
            if (novoEndereco != null && !novoEndereco.isEmpty()) {
                client.setAddress(novoEndereco);
            }
            else {
                throw new IllegalArgumentException("Novos dados inválidos. As informações antigas foram mantidas.");
            }
            clientRepository.update(client);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado com o CPF fornecido.");
        }
    }
}
