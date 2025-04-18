package it.epicode.Progettosettimanale_back_end_S5_L6.viaggi;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Order(2)
public class ViaggioRunner implements CommandLineRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Viaggio v = new Viaggio();
            v.setDestinazione(faker.country().capital());
            v.setData(LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
            v.setStato(StatoViaggio.IN_PROGRAMMA);

            viaggioRepository.save(v);
        }
    }
}