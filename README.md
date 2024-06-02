
VetControl
Visão Geral de Alto Nível
Entidades
Representam objetos principais do domínio com identidades únicas (ex.: Consulta, Cliente, Animal, Veterinario).

Objetos de Valor
Representam objetos sem identidade única (ex.: Pagamento, CRMV).

Repositórios
Cuidam da persistência das entidades (ex.: ConsultaRepository, ClientRepository).

Serviços
Encapsulam a lógica de negócios (ex.: ConsultaService, ClientService).

Fábricas
Criam instâncias de entidades (ex.: ConsultaFactory).

Classes e Suas Responsabilidades
1. Entidades
Consulta: Representa uma consulta veterinária com atributos como data, hora, veterinário, animal, status, pagamento e valor.
Cliente: Representa um cliente com atributos como nome, endereço e CPF.
Animal: Representa um animal com atributos como nome, raça e espécie.
Veterinário: Representa um veterinário com atributos como nome, endereço, especialização, telefone e CRMV.
2. Objetos de Valor
Pagamento: Representa um pagamento com atributos como ID, método de pagamento e status do pagamento.
CRMV: Representa o número de registro veterinário.
3. Repositórios
ConsultaRepository: Interface para operações CRUD em entidades Consulta.
ClientRepository: Interface para operações CRUD em entidades Cliente.
PetRepository: Interface para operações CRUD em entidades Animal.
4. Serviços
ConsultaService: Contém métodos para agendar, cancelar e marcar consultas como realizadas.
ClientService: Contém métodos para cadastrar e buscar clientes.
PetService: Contém métodos para cadastrar e buscar animais.
5. Fábricas
ConsultaFactory: Encapsula a lógica para criar instâncias de Consulta.
Fluxo de Comunicação
Agendamento de uma Consulta
Interação do Usuário: O usuário aciona o agendamento de uma consulta via UI, que chama o método agendarConsulta do ConsultaService.
Camada de Serviço:
ConsultaService.agendarConsulta é chamado com parâmetros incluindo data, hora, veterinário, animal, pagamento e valor.
O serviço usa ConsultaFactory para criar um novo objeto Consulta.
O serviço então chama consultaRepository.save para persistir a nova consulta.
Camada de Repositório:
O método consultaRepository.save persiste a entidade Consulta no banco de dados.
Cancelamento de uma Consulta
Interação do Usuário: O usuário aciona o cancelamento de uma consulta.
Camada de Serviço:
ConsultaService.cancelarConsulta é chamado com o ID da consulta.
O serviço recupera o objeto Consulta usando consultaRepository.findById.
O serviço atualiza o status da consulta para CANCELADA e chama consultaRepository.save para persistir a mudança.
Camada de Repositório:
O método consultaRepository.save atualiza a entidade Consulta no banco de dados.
Marcar uma Consulta como Realizada
Interação do Usuário: O usuário marca uma consulta como realizada.
Camada de Serviço:
ConsultaService.marcarConsultaComoRealizada é chamado com o ID da consulta.
O serviço recupera o objeto Consulta usando consultaRepository.findById.
O serviço atualiza o status da consulta para REALIZADA e chama consultaRepository.save para persistir a mudança.
Camada de Repositório:
O método consultaRepository.save atualiza a entidade Consulta no banco de dados.
Interação na Classe Main
A classe Main demonstra como as diferentes partes do sistema interagem:

Configuração:
Repositórios (ClientPersistence, PetPersistence, ConsultaPersistence) são instanciados.
Serviços (ClientService, PetService, ConsultaService) são instanciados com os respectivos repositórios.
Cadastro de Cliente:
O cliente é cadastrado usando ClientService.cadastrarCliente.
O cliente é recuperado usando ClientService.buscarClientePorCPF.
Cadastro de Animal:
O animal é cadastrado usando PetService.cadastrarAnimal.
O animal é recuperado usando PetService.buscarAnimalPorId.
Agendamento de Consulta:
A consulta é agendada usando ConsultaService.agendarConsulta.
A consulta é recuperada usando ConsultaService.buscarConsultaPorId.
Gerenciamento de Consulta:
A consulta é cancelada usando ConsultaService.cancelarConsulta.
A consulta é marcada como realizada usando ConsultaService.marcarConsultaComoRealizada.
