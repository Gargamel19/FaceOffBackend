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
	                        	
	                        	Spieler fettarm = new Spieler(0, "FettarmQP", "fettarmQP");
	                        	Spieler mauchel1 = new Spieler(1, "Mauchel1", "mauchel1");
	                        	Spieler hiiimdash = new Spieler(2, "hiiimdash", "dash9");
	                        	Spieler soHShRoUd = new Spieler(3, "SoHShRoUd", "sohbaluu");
	                        	Spieler ikpuzdiewech = new Spieler(4, "ikpuzdiewech", "");
	                        	Spieler leo_van_Gareth = new Spieler(5, "Leo_van_Gareth", "");
	                        	Spieler deroberdulli = new Spieler(6, "DerOberDulli", "deroberdulli");
	                        	Spieler domiGwk = new Spieler(7, "DomiGwk", "");
	                        	Spieler tenecos = new Spieler(8, "Tenecos", "");
	                        	Spieler rumblemartin = new Spieler(9, "RumbleMartin", "");
	                        	Spieler uniCornDiVa = new Spieler(10, "UniCornDiVa", "msdiva2103");
	                        	Spieler fall1ng = new Spieler(11, "fall1ng  ", "Fall1ngtv");
	                        	Spieler sogger = new Spieler(12, "Sogger", "");
	                        	Spieler fred = new Spieler(13, "Ringone198", "");
	                        	Spieler eugenwip = new Spieler(14, "eugenwip", "");
	                        	Spieler x_X_Denis_X_x = new Spieler(15, "x_X_Denis_X_x", "");
	                        	Spieler mats4k = new Spieler(16, "Mats4k", "motiongamingbros");
	                        	Spieler weger1 = new Spieler(17, "WEGER1", "");
	                        	Spieler cedric22 = new Spieler(18, "Cedric22", "");
	                        	Spieler veryfluffy = new Spieler(19, "veryfluffy", "");
	                        	Spieler synx420 = new Spieler(20, "Synx420", "");
	                        	Spieler raechende_Titan = new Spieler(21, "Raechende_Titan", "");
	                        	spielerRepository.save(fettarm);
	                        	spielerRepository.save(mauchel1);
	                        	spielerRepository.save(hiiimdash);
	                        	spielerRepository.save(ikpuzdiewech);
	                        	spielerRepository.save(leo_van_Gareth);
	                        	spielerRepository.save(soHShRoUd);
	                        	spielerRepository.save(raechende_Titan);
	                        	spielerRepository.save(deroberdulli);
	                        	spielerRepository.save(domiGwk);
	                        	spielerRepository.save(tenecos);
	                        	spielerRepository.save(rumblemartin);
	                        	spielerRepository.save(uniCornDiVa);
	                        	spielerRepository.save(fall1ng);
	                        	spielerRepository.save(sogger);
	                        	spielerRepository.save(fred);
	                        	spielerRepository.save(eugenwip);
	                        	spielerRepository.save(x_X_Denis_X_x);
	                        	spielerRepository.save(mats4k);
	                        	spielerRepository.save(weger1);
	                        	spielerRepository.save(cedric22);
	                        	spielerRepository.save(veryfluffy);
	                        	spielerRepository.save(synx420);
	                        	Team teamStudentenPack = new Team(0, "StudentenPack", fettarm, mauchel1);
	                        	Team teamLutschendeLuder = new Team(1, "LutschendeLuder", ikpuzdiewech, leo_van_Gareth);
	                        	Team tEAMTaiwanNummer1 = new Team(2, "TEAM Taiwan Number1", soHShRoUd, raechende_Titan);
	                        	Team team31er = new Team(3, "Team 31er", soHShRoUd, tenecos);
	                        	Team theLionandtheUnicorn = new Team(4, "The Lion and the Unicorn", uniCornDiVa , rumblemartin);
	                        	Team n187Grabbelbande = new Team(5, "187 Grabbelbande", deroberdulli, domiGwk);
	                        	Team fortunaFlaschenbier = new Team(6, "Fortuna Flaschenbier", fall1ng, sogger);
	                        	Team vITAMINCHIK = new Team(7, "VITAMINCHIK", x_X_Denis_X_x, eugenwip);
	                        	Team teamMotion = new Team(8, "Team Motion", mats4k, weger1);
	                        	Team teamSynx = new Team(9, "Team Synx", synx420, veryfluffy);
	                        	Team teamFred = new Team(10, "Team Fred", fred, cedric22);
	                        	teamRepository.save(teamStudentenPack);
	                        	teamRepository.save(teamLutschendeLuder);
	                        	teamRepository.save(tEAMTaiwanNummer1);
	                        	teamRepository.save(n187Grabbelbande);
	                        	teamRepository.save(team31er);
	                        	teamRepository.save(theLionandtheUnicorn);
	                        	teamRepository.save(fortunaFlaschenbier);
	                        	teamRepository.save(vITAMINCHIK);
	                        	teamRepository.save(teamMotion);
	                        	teamRepository.save(teamSynx);
	                        	teamRepository.save(teamFred);
	                        	updateTeamBySpieler(fettarm.getName(), teamStudentenPack.getName(), spielerRepository);
	                        	updateTeamBySpieler(mauchel1.getName(), teamStudentenPack.getName(), spielerRepository);
	                        	updateTeamBySpieler(ikpuzdiewech.getName(), teamLutschendeLuder.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(leo_van_Gareth.getName(), teamLutschendeLuder.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(soHShRoUd.getName(), tEAMTaiwanNummer1.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(raechende_Titan.getName(), tEAMTaiwanNummer1.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(deroberdulli.getName(), n187Grabbelbande.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(domiGwk.getName(), n187Grabbelbande.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(soHShRoUd.getName(), team31er.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(tenecos.getName(), team31er.getName(), spielerRepository);
	                        	updateTeamBySpieler(uniCornDiVa.getName(), theLionandtheUnicorn.getName(), spielerRepository);
	                        	updateTeamBySpieler(rumblemartin.getName(), theLionandtheUnicorn.getName(), spielerRepository);
	                        	updateTeamBySpieler(fall1ng.getName(), fortunaFlaschenbier.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(sogger.getName(), fortunaFlaschenbier.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(x_X_Denis_X_x.getName(), vITAMINCHIK.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(eugenwip.getName(), vITAMINCHIK.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(mats4k.getName(), teamMotion.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(weger1.getName(), teamMotion.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(synx420.getName(), teamSynx.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(veryfluffy.getName(), teamSynx.getName(), spielerRepository);      	
	                        	updateTeamBySpieler(fred.getName(), teamFred.getName(), spielerRepository);         	
	                        	updateTeamBySpieler(cedric22.getName(), teamFred.getName(), spielerRepository);
	                        	
								

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