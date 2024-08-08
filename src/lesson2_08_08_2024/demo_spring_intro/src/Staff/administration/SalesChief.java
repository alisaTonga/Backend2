package Staff.administration;

import Staff.production.Merchandiser;
import Staff.production.SaleManager;

public class SalesChief {
    private SaleManager saleManager;
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
