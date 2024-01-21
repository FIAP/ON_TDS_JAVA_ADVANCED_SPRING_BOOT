package br.com.fiap.calorias.repository;

import br.com.fiap.calorias.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}
