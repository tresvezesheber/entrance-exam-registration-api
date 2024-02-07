package br.dev.hebio.entranceexamregistrationapi.api.open;

import br.dev.hebio.entranceexamregistrationapi.domain.model.inscription.InscriptionAccomplished;
import br.dev.hebio.entranceexamregistrationapi.domain.model.inscription.InscriptionInput;
import br.dev.hebio.entranceexamregistrationapi.domain.service.InscriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/inscription")
public class InscriptionPublicController {

    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionAccomplished> findInscriptionById(@PathVariable Long id) {
        return ResponseEntity.ok(inscriptionService.findInscriptionById(id));
    }

    @GetMapping
    public ResponseEntity listAllInscriptions() {
        return ResponseEntity.ok(inscriptionService.listAllInscriptions());
    }

    @PostMapping
    public ResponseEntity saveInscription(@RequestBody @Valid InscriptionInput inscriptionInput) {
        return ResponseEntity.ok(inscriptionService.saveInscription(inscriptionInput));
    }
}
