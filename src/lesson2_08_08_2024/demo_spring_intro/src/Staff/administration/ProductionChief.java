package Staff.administration;

import Staff.production.MachineOperator;
import Staff.production.StoreKeeper;

public class ProductionChief {
    private MachineOperator machineOperator;
    private StoreKeeper storeKeeper;

    public void setMachineOperator(MachineOperator machineOperator) {
        this.machineOperator = machineOperator;
    }

    public void setStoreKeeper(StoreKeeper storeKeeper) {
        this.storeKeeper = storeKeeper;
    }
    public void giveOrders(){
        machineOperator.work();
        storeKeeper.work();
    }
}
