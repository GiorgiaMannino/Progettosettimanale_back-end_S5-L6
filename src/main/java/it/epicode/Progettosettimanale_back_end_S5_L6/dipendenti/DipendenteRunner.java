package it.epicode.Progettosettimanale_back_end_S5_L6.dipendenti;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DipendenteRunner implements CommandLineRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Dipendente d = new Dipendente();
            String username = faker.name().username() + i;
            d.setUsername(username);
            d.setNome(faker.name().firstName());
            d.setCognome(faker.name().lastName());
            d.setEmail(faker.internet().emailAddress());

            d.setImmagineProfilo("https://robohash.org/" + username + "?size=200x200");

            dipendenteRepository.save(d);
        }
    }

}
