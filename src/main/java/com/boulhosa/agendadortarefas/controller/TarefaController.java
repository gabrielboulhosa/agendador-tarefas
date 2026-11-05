package com.boulhosa.agendadortarefas.controller;

import com.boulhosa.agendadortarefas.business.dtos.TarefaDTO;
import com.boulhosa.agendadortarefas.business.services.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaDTO> gravarTarefa(@RequestBody TarefaDTO tarefaDTO, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, tarefaDTO));
    }

    @GetMapping("/evento")
    public ResponseEntity<List<TarefaDTO>> buscaTarefaAgendadaPorPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
                                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
        return ResponseEntity.ok(tarefaService.buscaTarefaAgendadaPorPeriodo(dataInicio, dataFim));

    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscarTarefaPorEmail(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.buscaTarefaPorEmail(token));
    }
}
