package com.boulhosa.agendadortarefas.business.mapper;

import com.boulhosa.agendadortarefas.business.dtos.TarefaDTO;
import com.boulhosa.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefaDTO tarefaDTO, @MappingTarget TarefaEntity tarefaEntity);
}
