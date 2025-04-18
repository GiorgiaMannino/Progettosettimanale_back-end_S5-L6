package it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByDipendenteIdAndDataRichiesta(Long dipendenteId, LocalDate dataRichiesta);

    void deleteAllByViaggioId(Long viaggioId);

    void deleteAllByDipendenteId(Long dipendenteId);



}