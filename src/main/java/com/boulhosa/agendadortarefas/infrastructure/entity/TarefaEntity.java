package com.boulhosa.agendadortarefas.infrastructure.entity;

import com.boulhosa.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("tarefa")
public class TarefaEntity {

    @Id
    private String id;

    private String nomeTarefa;

    private String descricao;

    private LocalDateTime dataCriacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataEvento;

    private String emailUsuario;

    private LocalDateTime dataAlteracao;

    private StatusNotificacaoEnum statusNotificacaoEnum;
}
