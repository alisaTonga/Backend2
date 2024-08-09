package Staff.administration;

import Staff.production.Merchandiser;
import Staff.production.SaleManager;
import org.springframework.beans.factory.annotation.Autowired;

public class SalesChief {
    @Autowired
    private SaleManager saleManager;
    @Autowired
    private Merchandiser merchandiser;

    public void setSaleManager(SaleManager saleManager) {
        this.saleManager = saleManager;
    }

    public void setMerchandiser(Merchandiser merchandiser) {
        this.merchandiser = merchandiser;
    }
    public void giveOrders(){
        saleManager.work();
        merchandiser.work();
    }
}
