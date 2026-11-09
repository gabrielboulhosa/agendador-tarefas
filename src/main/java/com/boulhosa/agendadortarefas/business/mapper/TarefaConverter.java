package com.boulhosa.agendadortarefas.business.mapper;

import com.boulhosa.agendadortarefas.business.dtos.TarefaDTO;
import com.boulhosa.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefaEntity paraTarefaEntity(TarefaDTO tarefaDTO);

    TarefaDTO paraTarefaDTO(TarefaEntity tarefaEntity);

    List<TarefaEntity> paraListaTarefaEntity(List<TarefaDTO> tarefaDTOs);

    List<TarefaDTO> paraListaTarefaDTO(List<TarefaEntity> tarefaEntities);
}
