package com.cartorio.notificacaoac.controller;

import com.cartorio.notificacaoac.model.NotificacaoEntity;
import com.cartorio.notificacaoac.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.camel.model.rest.RestParamType.body;

@RestController
@RequestMapping("/callback")
public class CallbackController {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @PostMapping
    public ResponseEntity<String> receberNotificacao(@RequestBody String payload) {
        NotificacaoEntity notificacao = NotificacaoEntity.builder()
                .payload(payload)
                .build();
                notificacaoRepository.save(notificacao);
        System.out.println("🔔 [Recebido via HTTP] " + payload);
        return ResponseEntity.ok("Recebido com sucesso");
    }


}
