package it.epicode.Progettosettimanale_back_end_S5_L6.viaggi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioResponse {
    private Long id;
    private String destinazione;
    private LocalDate data;
    private StatoViaggio stato;
}
