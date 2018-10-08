package se1app.applicationcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import se1app.applicationcore.spielercomponent.Spieler;
import se1app.applicationcore.spielercomponent.SpielerRepository;
import se1app.applicationcore.teamcomponent.Team;
import se1app.applicationcore.teamcomponent.TeamRepository;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	@Bean
    CommandLineRunner init(TeamRepository teamRepository, SpielerRepository spielerRepository) {
        return (evt) -> Arrays.asList(
                "mueller".split(","))
                .forEach(
                        a -> {
							try {
	                        	Spieler we = new Spieler(3, "we", "twitch.tv/ew");
	                        	Spieler rewe = new Spieler(4, "rewe", "twitch.tv/rewe");
	                        	
	                        	spielerRepository.save(we);
	                        	spielerRepository.save(rewe);
	                        	
	                        	teamRepository.save(new Team(1, "StudentenPack", 1, "FettarmQP", "twitch.tv/FettarmQP", 2, "Mauchel1", "twitch.tv/Mauchel1", spielerRepository));
	                        	teamRepository.save(new Team(2, "GeiloTeam", we, rewe));
								

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
                        	
                        });
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowedHeaders("Content-Type", "Accept", "X-Requested-With", "remember-me")
                        .allowCredentials(true);
            }
        };
    }

}