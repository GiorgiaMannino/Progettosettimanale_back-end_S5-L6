package it.epicode.Progettosettimanale_back_end_S5_L6.dipendenti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dipendenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, unique = true)
    private String username;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String cognome;

    @Column(length = 50)
    private String email;

    private String immagineProfilo;
}
