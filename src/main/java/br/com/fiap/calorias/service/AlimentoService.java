package br.com.fiap.calorias.service;

import br.com.fiap.calorias.dto.AlimentoCadastroDTO;
import br.com.fiap.calorias.dto.AlimentoExibicaoDTO;
import br.com.fiap.calorias.model.Alimento;
import br.com.fiap.calorias.repository.AlimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public AlimentoExibicaoDTO salvarAlimento(AlimentoCadastroDTO alimentoDTO){

        Alimento alimento = new Alimento();
        BeanUtils.copyProperties(alimentoDTO, alimento);

        Alimento alimentoSalvo = alimentoRepository.save(alimento);
        return new AlimentoExibicaoDTO(alimentoSalvo);

    }

    public AlimentoExibicaoDTO listarPorId(Long id){
        Optional<Alimento> alimentoOptional =
                alimentoRepository.findById(id);

        if (alimentoOptional.isPresent()){
            return new AlimentoExibicaoDTO(alimentoOptional.get());
        } else {
            throw new RuntimeException("Alimento não existe!");
        }
    }

    public List<AlimentoExibicaoDTO> listarTodos(){
        return alimentoRepository
                .findAll()
                .stream()
                .map(AlimentoExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long id){
        Optional<Alimento> alimentoOptional =
                alimentoRepository.findById(id);

        if (alimentoOptional.isPresent()){
            alimentoRepository.delete(alimentoOptional.get());
        } else {
            throw new RuntimeException("Alimento não encontrado!");
        }
    }

    public Alimento atualizar(Alimento alimento){
        Optional<Alimento> alimentoOptional =
                alimentoRepository.findById(alimento.getAlimentoId());

        if (alimentoOptional.isPresent()){
            return alimentoRepository.save(alimento);
        } else {
            throw new RuntimeException("Alimento não encontrado!");
        }
    }

}
