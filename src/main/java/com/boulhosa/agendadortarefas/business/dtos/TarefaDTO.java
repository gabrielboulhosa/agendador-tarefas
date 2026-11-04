package com.boulhosa.agendadortarefas.business.dtos;

import com.boulhosa.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefaDTO {

    private String id;

    private String nomeTarefa;

    private String descricao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataEvento;

    private String emailUsuario;

    private LocalDateTime dataAlteracao;

    private StatusNotificacaoEnum statusNotificacaoEnum;
}
