package com.boulhosa.agendadortarefas.controller;

import com.boulhosa.agendadortarefas.business.dtos.TarefaDTO;
import com.boulhosa.agendadortarefas.business.services.TarefaService;
import com.boulhosa.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
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

    @DeleteMapping
    public ResponseEntity<Void> deletarTarefaPorId(@RequestParam("id") String id) {
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TarefaDTO> alterarStatus(@RequestParam("status") StatusNotificacaoEnum status,
                                                   @RequestParam("id") String id) {
        return ResponseEntity.ok(tarefaService.alteraStatus(status, id));
    }

    // teste

    @PutMapping
    public ResponseEntity<TarefaDTO> alterarTarefa(@RequestParam("id") String id,
                                                   @RequestBody TarefaDTO tarefaDTO){
        return ResponseEntity.ok(tarefaService.alterarTarefa(id, tarefaDTO));
    }
}
