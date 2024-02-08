package br.com.fiap.calorias.controller;

import br.com.fiap.calorias.dto.AlimentoCadastroDTO;
import br.com.fiap.calorias.dto.AlimentoExibicaoDTO;
import br.com.fiap.calorias.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @PostMapping("/alimentos")
    @ResponseStatus(HttpStatus.CREATED)
    public AlimentoExibicaoDTO salvar(
            @RequestBody AlimentoCadastroDTO alimento){
        return alimentoService.salvarAlimento(alimento);
    }

    @GetMapping("/alimentos")
    @ResponseStatus(HttpStatus.OK)
    public List<AlimentoExibicaoDTO> litarTodos(){
        return alimentoService.listarTodos();
    }

    @GetMapping("/alimentos/faixa")
    @ResponseStatus(HttpStatus.OK)
    public List<AlimentoExibicaoDTO> litarAlimentosPorFaixaDeCalorias(
            @RequestParam("minimo") Double minimo,
            @RequestParam("maximo") Double maximo
    ){
        return alimentoService.listarAlimentosPorFaixaDeCalorias(minimo, maximo);
    }

    @GetMapping("/alimentos/{alimentoId}")
    public ResponseEntity<AlimentoExibicaoDTO> buscarPorId(
            @PathVariable Long alimentoId){
        try {
            return ResponseEntity
                    .ok(alimentoService.buscarPorId(alimentoId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/alimentos/")
    public ResponseEntity<AlimentoExibicaoDTO> buscarPorNome(
            @RequestParam("nome") String nome){
        try {
            return ResponseEntity
                    .ok(alimentoService.buscarPorNome(nome));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/alimentos/{alimentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long alimentoId){
        alimentoService.excluir(alimentoId);
    }

    @PutMapping("/alimentos")
    public ResponseEntity<AlimentoExibicaoDTO> atualizar(
            @RequestBody AlimentoCadastroDTO alimentoDTO){
        try {
            AlimentoExibicaoDTO alimentoExibicaoDTO =
                    alimentoService.atualizar(alimentoDTO);
            return ResponseEntity.ok(alimentoExibicaoDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
