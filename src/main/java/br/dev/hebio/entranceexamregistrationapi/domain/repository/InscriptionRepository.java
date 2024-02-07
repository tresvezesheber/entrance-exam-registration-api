package br.dev.hebio.entranceexamregistrationapi.domain.repository;

import br.dev.hebio.entranceexamregistrationapi.domain.model.inscription.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
