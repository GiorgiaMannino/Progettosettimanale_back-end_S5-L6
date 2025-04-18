package it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni;

import com.github.javafaker.Faker;
import it.epicode.Progettosettimanale_back_end_S5_L6.dipendenti.Dipendente;
import it.epicode.Progettosettimanale_back_end_S5_L6.dipendenti.DipendenteRepository;
import it.epicode.Progettosettimanale_back_end_S5_L6.viaggi.Viaggio;
import it.epicode.Progettosettimanale_back_end_S5_L6.viaggi.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(3)
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Override
    public void run(String... args) throws Exception {

        // recupero tutti i dipendenti e i viaggi esistenti
        List<Dipendente> dipendenti = dipendenteRepository.findAll();
        List<Viaggio> viaggi = viaggioRepository.findAll();

        if (dipendenti.isEmpty() || viaggi.isEmpty()) return;

        for (int i = 0; i < 10; i++) {
            Prenotazione prenotazione = new Prenotazione();

            Dipendente dipendente = dipendenti.get(i % dipendenti.size());
            Viaggio viaggio = viaggi.get(i % viaggi.size());

            LocalDate dataRichiesta = LocalDate.now().minusDays(faker.number().numberBetween(0, 5));

            boolean alreadyBooked = prenotazioneRepository
                    .existsByDipendenteIdAndDataRichiesta(dipendente.getId(), dataRichiesta);

            if (alreadyBooked) continue;

            prenotazione.setDipendente(dipendente);
            prenotazione.setViaggio(viaggio);
            prenotazione.setDataRichiesta(dataRichiesta);
            prenotazione.setPreferenze(faker.lorem().sentence());
            prenotazioneRepository.save(prenotazione);
        }
    }
}