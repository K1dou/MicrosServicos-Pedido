package com.kido.pedido_api.controller;

import com.kido.pedido_api.config.PedidoConfig;
import com.kido.pedido_api.model.Pedido;
import com.kido.pedido_api.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Tag(name = "Pedidos", description = "Recurso para criar um novo pedido")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {


    @Autowired
    private PedidoConfig pedidoConfig;

    @Autowired
    private PedidoService pedidoService;

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);



    @GetMapping("/pedido")
    public ResponseEntity<String>pedido(@RequestParam(defaultValue = "") String name){

        if (name.isEmpty()) name = pedidoConfig.getDefaultValue();

        String respota = name+" "+pedidoConfig.getPedido();

        return new ResponseEntity<String>(respota,HttpStatus.OK);
    }



//    @Operation(summary = "Cria um novo pedido", description = "Contém as operaçoes para criar um novo pedido",
//            responses = @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
//                    content = @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = Pedido.class))))
//    @PostMapping
//    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
//        logger.info("Pedido recebido: {}", pedido.toString());
//        pedidoService.enfileirarPedido(pedido);
//
//
//
//        return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
//    }
//





}
