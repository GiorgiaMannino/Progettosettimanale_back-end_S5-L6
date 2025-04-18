package it.epicode.Progettosettimanale_back_end_S5_L6.dipendenti;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteRequest {

    @NotBlank (message = "Username obbligatorio")
    private String username;

    @NotBlank (message = "Nome obbligatorio")
    private String nome;

    @NotBlank (message = "Cognome obbligatorio")
    private String cognome;

    @Email (message = "Email non valida")
    @NotBlank (message = "Email obbligatoria")
    private String email;

    @NotBlank(message = "Immagine profilo obbligatoria")
    private String immagineProfilo;
}
