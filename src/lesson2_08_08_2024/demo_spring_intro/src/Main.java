import Staff.administration.Director;
import Staff.administration.ProductionChief;
import Staff.administration.SalesChief;
import Staff.production.MachineOperator;
import Staff.production.Merchandiser;
import Staff.production.SaleManager;
import Staff.production.StoreKeeper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        MachineOperator machineOperator = new MachineOperator();
//        StoreKeeper storeKeeper = new StoreKeeper();
//        SaleManager saleManager = new SaleManager();
//        Merchandiser merchandiser = new Merchandiser();
//        ProductionChief productionChief = new ProductionChief();
//        productionChief.setMachineOperator(machineOperator);
//        productionChief.setStoreKeeper(storeKeeper);
//        SalesChief salesChief = new SalesChief();
//        salesChief.setSaleManager(saleManager);
//        salesChief.setMerchandiser(merchandiser);
//        Director director = new Director();
//        director.setProductionChief(productionChief);
//        director.setSalesChief(salesChief);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(".configuration");
        Director director = context.getBean(Director.class);
        director.manageCompany();
    }
}