package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {

}
