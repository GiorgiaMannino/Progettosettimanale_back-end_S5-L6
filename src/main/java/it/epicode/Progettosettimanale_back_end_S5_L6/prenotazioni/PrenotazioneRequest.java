package it.epicode.Progettosettimanale_back_end_S5_L6.prenotazioni;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneRequest {

    @NotNull (message = "Viaggio obbligatorio")
    private Long viaggioId;

    @NotNull (message = "Dipendente obbligatorio")
    private Long dipendenteId;

    @NotNull(message = "La data richiesta è obbligatoria")
    @FutureOrPresent(message = "La data deve essere oggi o nel futuro")
    private LocalDate dataRichiesta;

    @NotBlank (message = "Preferenze obbligatorie")
    private String preferenze;
}
