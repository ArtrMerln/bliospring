package springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controllers.Homecontroller;



@EnableWebMvc //habilita a classe o modo web mvc do spring para ele tomar conta das reqisocoes 
@ComponentScan(basePackageClasses = {Homecontroller.class}) //os controllers ficam na casa homecontroller.class no pacote base dessa classe

public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
 
resolver.setPrefix("/WEB-INF/views/");
	//metodo que mostra onde esta os arquivos jps 
resolver.setSuffix(".jsp");	
return resolver;
	}
	
}
