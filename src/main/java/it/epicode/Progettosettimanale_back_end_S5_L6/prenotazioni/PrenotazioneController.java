package it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni;

import it.epicode.Progettosettimanale_back_end_S5_L6.common.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    // get tutte le prenotazioni
    @GetMapping
    public List<PrenotazioneResponse> findAll() {
        return prenotazioneService.findAll();
    }

    // get singola prenotazione con id
    @GetMapping("/{id}")
    public PrenotazioneResponse find(@PathVariable Long id) {
        return prenotazioneService.findById(id);
    }

    // post creazione nuova prenotazione
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrenotazioneResponse save(@RequestBody @Valid PrenotazioneRequest request) {
        return prenotazioneService.save(request);
    }

    // put modifica prenotazione
    @PutMapping("/{id}")
    public PrenotazioneResponse update(@PathVariable Long id, @RequestBody @Valid PrenotazioneRequest request) {
        return prenotazioneService.update(id, request);
    }


    // delete elimino prenotazione con id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CommonResponse delete(@PathVariable Long id) {
        prenotazioneService.delete(id);
        return new CommonResponse(id);
    }
}