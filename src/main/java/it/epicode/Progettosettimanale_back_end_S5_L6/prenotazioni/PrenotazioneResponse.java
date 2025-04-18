package it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneResponse {
    private Long id;
    private String destinazione;
    private String username;
    private LocalDate dataRichiesta;
    private String preferenze;
}
