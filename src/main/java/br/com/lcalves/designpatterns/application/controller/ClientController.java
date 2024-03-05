package br.com.lcalves.designpatterns.application.controller;

import br.com.lcalves.designpatterns.application.dtos.request.ClienteRequest;
import br.com.lcalves.designpatterns.application.dtos.response.ClienteResponse;
import br.com.lcalves.designpatterns.application.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clienteService;

    @Autowired
    public ClientController(ClientService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ClienteResponse>> buscarTodos() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{registration}")
    public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable  String registration) {
        return ResponseEntity.ok(clienteService.findByRegistration(registration));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> inserir(@RequestBody ClienteRequest cliente) {
        return ResponseEntity.ok(clienteService.insert(cliente));
    }

    @PutMapping("/{registration}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable String registration, @RequestBody ClienteRequest cliente) {

        return ResponseEntity.ok(clienteService.update(registration, cliente));
    }

    @DeleteMapping("/{registration}")
    public ResponseEntity<Void> deletar(@PathVariable String registration) {
        clienteService.delete(registration);
        return ResponseEntity.ok().build();
    }
}
