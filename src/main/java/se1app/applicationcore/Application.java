package se1app.applicationcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.export.SpecificTriggerProperties;
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
	                        	Spieler fettarm = new Spieler(0, "FettarmQP", "twitch.tv/FettarmQP");
	                        	Spieler mauchel1 = new Spieler(1, "Mauchel1", "twitch.tv/Mauchel1");
	                        	Spieler ickputzdiewech = new Spieler(2, "ickputzdiewech", "");
	                        	Spieler leovanGareth = new Spieler(3, "LeovanGareth", "");
	                        	spielerRepository.save(fettarm);
	                        	spielerRepository.save(mauchel1);
	                        	spielerRepository.save(ickputzdiewech);
	                        	spielerRepository.save(leovanGareth);
	                        	Team teamStudentenPack = new Team(0, "StudentenPack", fettarm, mauchel1);
	                        	Team teamLutschendeLuder = new Team(1, "LutschendeLuder", ickputzdiewech, leovanGareth);
	                        	teamRepository.save(teamStudentenPack);
	                        	teamRepository.save(teamLutschendeLuder);
	                        	updateTeamBySpieler(fettarm.getName(), teamStudentenPack.getName(), spielerRepository);
	                        	updateTeamBySpieler(mauchel1.getName(), teamStudentenPack.getName(), spielerRepository);
	                        	updateTeamBySpieler(ickputzdiewech.getName(), teamLutschendeLuder.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(leovanGareth.getName(), teamLutschendeLuder.getName(), spielerRepository);         	
	                        	
	                        	
								

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
    
    private void updateTeamBySpieler(String spieler, String team, SpielerRepository sr) {
    	Spieler newSpieler = sr.findByName(spieler);
		sr.delete(newSpieler);
		newSpieler.addTeam(team);
		sr.save(newSpieler);
    }

}