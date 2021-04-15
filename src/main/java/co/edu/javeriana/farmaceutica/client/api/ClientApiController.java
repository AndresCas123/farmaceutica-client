package co.edu.javeriana.farmaceutica.client.api;

import co.edu.javeriana.farmaceutica.client.entity.Client;
import co.edu.javeriana.farmaceutica.client.service.ClientService;
import co.edu.javeriana.farmaceutica.client.util.LogTrace;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "clients", description = "API para gestión de clientes.", tags = { "clients" })
@RequestMapping("${app.context-api}/clients")
@RestController
@Slf4j
@AllArgsConstructor
public class ClientApiController {

    private final ClientService clientService;

    @ApiOperation(value = "Listar clientes.",
            nickname = "list",
            notes = "Permite listar todos los clientes.",
                    tags = { "clients" })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200, message = "Listado con clientes.",
                    response = Client.class, responseContainer = "List")
        }
    )
    @GetMapping
    public ResponseEntity<?> list() {
        LogTrace.trace(log);
        return new ResponseEntity<>(clientService.list(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna un cliente.",
            nickname = "get",
            notes = "Permite retornar un cliente de acuerdo a su identificador.",
            tags = { "clients" })
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200, message = "Retorna el cliente solicitado.", response = Client.class),
            @ApiResponse(
                    code = 404, message = "Si el cliente no existe.")
        }
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@ApiParam(value = "Identificador del cliente", required = true) @PathVariable String id) {
        LogTrace.trace(log);
        return clientService.get(id)
                .map(supplier -> new ResponseEntity<>(supplier, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}