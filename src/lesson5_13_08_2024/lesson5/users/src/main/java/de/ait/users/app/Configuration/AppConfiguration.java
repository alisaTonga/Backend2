package de.ait.users.app.Configuration;

import de.ait.users.app.repository.UserRepository;
import de.ait.users.app.repository.UserRepositoryInt;
import de.ait.users.app.repository.UserRepositoryJDBCImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${repository.type}")
    private String repositoryType;

    @Autowired
    private ConfigurableApplicationContext context;


    @Bean
    UserRepositoryInt getRepository(){
        if(repositoryType.equalsIgnoreCase("list")){
            return context.getBean(UserRepository.class);
        }  else {
            return context.getBean(UserRepositoryJDBCImpl.class);
        }
    }
    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}