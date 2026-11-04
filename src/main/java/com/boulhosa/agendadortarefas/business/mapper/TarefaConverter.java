package com.boulhosa.agendadortarefas.business.mapper;

import com.boulhosa.agendadortarefas.business.dtos.TarefaDTO;
import com.boulhosa.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefaEntity paraTarefaEntity(TarefaDTO tarefaDTO);

    TarefaDTO paraTarefaDTO(TarefaEntity tarefaEntity);
}
