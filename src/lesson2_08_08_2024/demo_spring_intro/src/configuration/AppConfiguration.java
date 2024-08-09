package configuration;

import Staff.administration.Director;
import Staff.administration.ProductionChief;
import Staff.administration.SalesChief;
import Staff.production.MachineOperator;
import Staff.production.Merchandiser;
import Staff.production.SaleManager;
import Staff.production.StoreKeeper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public StoreKeeper storeKeeper(){
        return new StoreKeeper();
    }

    @Bean
    public SaleManager saleManager(){
        return new SaleManager();
    }

    @Bean
    public Merchandiser merchandiser(){
        return new Merchandiser();
    }

    @Bean
    public MachineOperator machineOperator(){
        return new MachineOperator();
    }

    @Bean
    public SalesChief salesChief(){
        return new SalesChief();
    }

    @Bean
    public ProductionChief productionChief(){
        return new ProductionChief();
    }

    @Bean
    public Director director(){
        return new Director();
    }
}
