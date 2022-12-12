package br.com.senac.codingliferay;

import br.com.senac.codingliferay.dtos.CollaboratorDTO;
import br.com.senac.codingliferay.services.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingLiferayApplication implements CommandLineRunner {
    @Autowired
    CollaboratorService collaboratorService;

    public static void main(String[] args) {
        SpringApplication.run(CodingLiferayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (collaboratorService.getAll().isEmpty()) {
            CollaboratorDTO amanda = new CollaboratorDTO(
                    "AMANDA GOUVEIA",
                    "SENIOR QA"
            );
            collaboratorService.save(amanda);
        }
    }

}
