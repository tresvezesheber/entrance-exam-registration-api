package br.dev.hebio.entranceexamregistrationapi.api.closed;

import br.dev.hebio.entranceexamregistrationapi.domain.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/inscription")
public class InscriptionPrivateController {

    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping
    public ResponseEntity listAllInscriptions() {
        return ResponseEntity.ok(inscriptionService.listAllInscriptionsPrivate());
    }
}
