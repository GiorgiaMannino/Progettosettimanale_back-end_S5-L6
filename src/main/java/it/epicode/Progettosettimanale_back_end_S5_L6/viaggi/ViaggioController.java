package it.epicode.Progettosettimanale_back_end_S5_L6.viaggi;


import it.epicode.Progettosettimanale_back_end_S5_L6.common.CommonResponse;
import it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni.PrenotazioneRequest;
import it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni.PrenotazioneResponse;
import it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni.PrenotazioneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    // get tutti i viaggi
    @GetMapping
    public List<ViaggioResponse> findAll() {
        return viaggioService.findAll();
    }

    // get singolo viaggio con id
    @GetMapping("/{id}")
    public ViaggioResponse find(@PathVariable Long id) {
        return viaggioService.findById(id);
    }

    // post creazione nuovo viaggio
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ViaggioResponse save(@RequestBody @Valid ViaggioRequest request) {
        return viaggioService.save(request);
    }

    // put modifico viaggio con id
    @PutMapping("/{id}")
    public ViaggioResponse update(@PathVariable Long id, @RequestBody ViaggioRequest request) {
        return viaggioService.update(id, request);
    }

    // delete elimino viaggio con id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CommonResponse delete(@PathVariable Long id) {
        viaggioService.delete(id);
        return new CommonResponse(id);
    }

    // patch aggiorno lo stato del viaggio
    @PatchMapping("/{id}/stato")
    public ViaggioResponse updateStato(@PathVariable Long id, @RequestParam StatoViaggio stato) {
        viaggioService.aggiornaStato(id, stato);
        return viaggioService.findById(id);
    }

}