////////////////////////////////////////////////////////////////////
// Nicolò Giaccone 1171208
////////////////////////////////////////////////////////////////////
package it.unipd.tos.buissness;
import java.util.List;
import it.unipd.tos.buissness.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
public interface TakeAwayBill {
    double getOrderPrice(List<MenuItem> itemsOrdered)
            throws TakeAwayBillException;
}
