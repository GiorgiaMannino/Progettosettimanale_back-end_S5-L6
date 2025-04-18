package it.epicode.Progettosettimanale_back_end_S5_L6.viaggi;

import it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni.PrenotazioneRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<ViaggioResponse> findAll() {
        return viaggioRepository.findAll().stream()
                .map(viaggio -> new ViaggioResponse(
                        viaggio.getId(),
                        viaggio.getDestinazione(),
                        viaggio.getData(),
                        viaggio.getStato()))
                .toList();
    }

    public ViaggioResponse findById(Long id) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));
        return new ViaggioResponse(
                viaggio.getId(),
                viaggio.getDestinazione(),
                viaggio.getData(),
                viaggio.getStato());
    }

    public ViaggioResponse save(@Valid ViaggioRequest request) {
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(request.getDestinazione());
        viaggio.setData(request.getData());
        viaggio.setStato(StatoViaggio.IN_PROGRAMMA);

        viaggioRepository.save(viaggio);

        return new ViaggioResponse(
                viaggio.getId(),
                viaggio.getDestinazione(),
                viaggio.getData(),
                viaggio.getStato());
    }

    public ViaggioResponse update(Long id, @Valid ViaggioRequest request) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));

        viaggio.setDestinazione(request.getDestinazione());
        viaggio.setData(request.getData());
        viaggio.setStato(request.getStato());

        viaggioRepository.save(viaggio);

        return new ViaggioResponse(
                viaggio.getId(),
                viaggio.getDestinazione(),
                viaggio.getData(),
                viaggio.getStato());
    }

    @Transactional
    public void delete(Long id) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));

        prenotazioneRepository.deleteAllByViaggioId(id);
        viaggioRepository.delete(viaggio);
    }

    public void aggiornaStato(Long id, StatoViaggio stato) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));

        viaggio.setStato(stato);
        viaggioRepository.save(viaggio);
    }

    public Viaggio getEntityById(Long id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaggio non trovato con id: " + id));
    }
}
