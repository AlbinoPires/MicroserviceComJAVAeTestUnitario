package com.cartorio.cartoriotest.infrastructure.apachecamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class ImovelRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:cadastro-imovel")
                .log("📦 Imóvel recebido para orquestração: ${body}")
                .setHeader("Content-Type", constant("application/json"))
                .to("http://localhost:8082/callback")
                .log("📬 Notificação enviada com sucesso: ${body}");

    }
}
