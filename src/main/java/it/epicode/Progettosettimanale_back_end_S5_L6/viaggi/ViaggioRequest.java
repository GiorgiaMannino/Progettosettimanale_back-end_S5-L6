package it.epicode.Progettosettimanale_back_end_S5_L6.viaggi;

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
public class ViaggioRequest {

    @NotBlank (message = "Destinazione obbligatoria")
    private String destinazione;

    @FutureOrPresent (message = "La data deve essere presente o futura")
    private LocalDate data;

    @NotNull(message = "Lo stato del viaggio è obbligatorio")
    private StatoViaggio stato;

}
