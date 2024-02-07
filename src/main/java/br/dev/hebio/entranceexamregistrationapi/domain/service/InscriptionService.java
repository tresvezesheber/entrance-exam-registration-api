package br.dev.hebio.entranceexamregistrationapi.domain.service;

import br.dev.hebio.entranceexamregistrationapi.domain.model.inscription.Inscription;
import br.dev.hebio.entranceexamregistrationapi.domain.model.inscription.InscriptionAccomplished;
import br.dev.hebio.entranceexamregistrationapi.domain.model.inscription.InscriptionDetails;
import br.dev.hebio.entranceexamregistrationapi.domain.model.inscription.InscriptionInput;
import br.dev.hebio.entranceexamregistrationapi.domain.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    public List<InscriptionAccomplished> listAllInscriptions() {
        return inscriptionRepository.findAll()
                .stream()
                .map(InscriptionAccomplished::new)
                .toList();
    }

    public List<InscriptionDetails> listAllInscriptionsPrivate() {
        return inscriptionRepository.findAll()
                .stream()
                .map(InscriptionDetails::new)
                .toList();
    }

    public InscriptionAccomplished findInscriptionById(Long id) {
        Inscription inscription = inscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Inscription with id: " + id + " not found"));
        return new InscriptionAccomplished(inscription);
    }

    public Long saveInscription(InscriptionInput inscriptionInput) {
        return inscriptionRepository.save(new Inscription(inscriptionInput)).getId();
    }
}
