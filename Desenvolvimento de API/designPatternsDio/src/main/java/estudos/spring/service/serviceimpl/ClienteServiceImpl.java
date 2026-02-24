package estudos.spring.service.serviceimpl;

import estudos.spring.model.Cliente;
import estudos.spring.model.Endereco;
import estudos.spring.repository.ClienteRepository;
import estudos.spring.repository.EnderecoRepository;
import estudos.spring.service.ClienteService;
import estudos.spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarCliente(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clientBd = clienteRepository.findById(id);
        if (clientBd.isPresent()) salvarCliente(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Iterable<Cliente> buscarUsuariosPorUf(String uf) {
        return clienteRepository.findAllByEndereco_UfIgnoreCase(uf);
    }

    @Override
    public void atualizarEndereco(Long id, String cep) {
       Cliente cliente = buscarPorId(id);
       Endereco novoEndereco = viaCepService.consultarCep(cep);
       enderecoRepository.save(novoEndereco);
       cliente.setEndereco(novoEndereco);
       clienteRepository.save(cliente);
    }

    private void salvarCliente(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}
