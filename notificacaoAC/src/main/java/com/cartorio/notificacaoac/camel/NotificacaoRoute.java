package com.cartorio.notificacaoac.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:notificacao")
                .log("🔔 [Notificação recebida] ${body}")
                .to("http://localhost:8082/callback")
                .end();
    }

}
