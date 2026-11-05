package com.boulhosa.agendadortarefas.infrastructure.repository;

import com.boulhosa.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefaEntity, String> {

    List<TarefaEntity> findByDataEventoBetween(
            LocalDateTime dataInicio,
            LocalDateTime dataFim
    );

    List<TarefaEntity> findByEmailUsuario(String email);
}
