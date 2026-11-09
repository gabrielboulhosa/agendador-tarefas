package com.boulhosa.agendadortarefas.business.services;

import com.boulhosa.agendadortarefas.business.dtos.TarefaDTO;
import com.boulhosa.agendadortarefas.business.mapper.TarefaConverter;
import com.boulhosa.agendadortarefas.business.mapper.TarefaUpdateConverter;
import com.boulhosa.agendadortarefas.infrastructure.entity.TarefaEntity;
import com.boulhosa.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.boulhosa.agendadortarefas.infrastructure.exeptions.ResourceNotFoundExeption;
import com.boulhosa.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.boulhosa.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;
    private final TarefaUpdateConverter tarefaUpdateConverter;

    public TarefaDTO gravarTarefa(String token, TarefaDTO tarefaDTO) {
        String emailUsuario = jwtUtil.extractUsername(token.substring(7)); // Remove "Bearer " from the token
        tarefaDTO.setDataCriacao(LocalDateTime.now());
        tarefaDTO.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        tarefaDTO.setEmailUsuario(emailUsuario);


        TarefaEntity tarefaEntity = tarefaConverter.paraTarefaEntity(tarefaDTO);

        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(tarefaEntity));
    }

    public List<TarefaDTO> buscaTarefaAgendadaPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {

        return tarefaConverter.paraListaTarefaDTO(tarefasRepository.findByDataEventoBetween(dataInicio, dataFim));
    }

    public List<TarefaDTO> buscaTarefaPorEmail(String token) {
        String emailUsuario = jwtUtil.extractUsername(token.substring(7));
        return tarefaConverter.paraListaTarefaDTO(tarefasRepository.findByEmailUsuario(emailUsuario));
    }

    public void deletarTarefaPorId(String id) {
        try {

            tarefasRepository.deleteById(id);

        } catch (
                ResourceNotFoundExeption e) {
            throw new ResourceNotFoundExeption("Erro ao deletar a tarefa com o id: " + id, e.getCause());
        }
    }

    public TarefaDTO alteraStatus(StatusNotificacaoEnum status, String id) {
        try {
            TarefaEntity tarefa = tarefasRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundExeption("Tarefa não encontrada com o id: " + id));

            tarefa.setStatusNotificacaoEnum(status);

            return tarefaConverter.paraTarefaDTO(tarefasRepository.save(tarefa));
        } catch (
                ResourceNotFoundExeption e) {
            throw new ResourceNotFoundExeption("Erro ao alterar o status da tarefa com o id: " + id, e.getCause());
        }
    }

    public TarefaDTO alterarTarefa(String id, TarefaDTO tarefaDTO) {
        try {
            TarefaEntity tarefa = tarefasRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundExeption("Tarefa não encontrada com o id: " + id));

            tarefaUpdateConverter.updateTarefas(tarefaDTO, tarefa);

           return tarefaConverter.paraTarefaDTO(tarefasRepository.save(tarefa));
        } catch (
                ResourceNotFoundExeption e) {
            throw new ResourceNotFoundExeption("Erro ao alterar a tarefa com o id: " + id, e.getCause());
        }
    }
}
