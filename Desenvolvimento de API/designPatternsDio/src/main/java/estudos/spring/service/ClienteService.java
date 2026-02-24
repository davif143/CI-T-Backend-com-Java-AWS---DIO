package estudos.spring.service;

import estudos.spring.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
    Iterable<Cliente> buscarUsuariosPorUf(String Uf);
    void atualizarEndereco(Long id, String cep);
}
