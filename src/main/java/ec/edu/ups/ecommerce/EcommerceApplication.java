package ec.edu.ups.ecommerce;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import ec.edu.ups.ecommerce.entities.ERol;
import ec.edu.ups.ecommerce.entities.Rol;
import ec.edu.ups.ecommerce.repositories.RepositorioRol;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
	
	

}

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private RepositorioRol repositorioRol;

	@Override
	public void run(String... args) throws Exception {

		if(repositorioRol.count() ==0) {
			
			Rol r1 = new Rol();
			r1.setName(ERol.ROLE_ADMIN);
			repositorioRol.save(r1);
			
			Rol r2 = new Rol();
			r2.setName(ERol.ROLE_PROVIDER);
			repositorioRol.save(r2);
			
			Rol r3 = new Rol();
			r3.setName(ERol.ROLE_USER);
			repositorioRol.save(r3);
			
			
		}
	}
}
