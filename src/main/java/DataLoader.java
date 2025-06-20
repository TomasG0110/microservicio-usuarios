import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Usuarios.model.Usuarios;
import com.example.Usuarios.repository.UsuarioRepository;

import java.util.List;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
       Faker faker = new Faker();
       Random random = new Random();

       //Generar Usuarios
       for (int i = 0; i < 20; i++) {
        Usuarios usuarios = new Usuarios();
        usuarios.setId(i+1);
        usuarios.setRun(faker.idNumber().valid());
        usuarios.setNombre(faker.book().genre());
        usuarios.setApellido(faker.name().lastName());
        usuarios.setEmail(faker.internet().emailAddress());
        usuarios.setTelefono(faker.number().numberBetween(100000000, 999999999));
        usuarioRepository.save(usuarios);
        
       }
    }

   
    

}
