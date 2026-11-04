package com.boulhosa.agendadortarefas.infrastructure.repository;

import com.boulhosa.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends MongoRepository<TarefaEntity, String> {


}
