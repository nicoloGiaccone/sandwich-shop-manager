////////////////////////////////////////////////////////////////////
// Nicolò Giaccone 1171208
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import it.unipd.tos.buissness.TakeAwayBill;
import it.unipd.tos.buissness.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

import java.util.LinkedList;
import java.util.List;

public class CBill implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered)
            throws TakeAwayBillException {
        double conto = 0.0;
        if (itemsOrdered.isEmpty()) {
            return conto;
        }

        if (itemsOrdered.size()>30) {
            throw new TakeAwayBillException();
        }

        for (MenuItem item : itemsOrdered) {
            conto += item.getPrice();
        }

        List<MenuItem> panini = new LinkedList<>();
        for (MenuItem item:itemsOrdered){
            if (item.getType() == MenuItem.itemType.Panini){
                panini.add(item);
            }
        }
        double min = 99999999999.0;
        if (panini.size()>=5){
            for (MenuItem panino: panini) {
                if (panino.getPrice() < min) {
                    min = panino.getPrice();
                }
            }
            conto -= min/2;
        }

        if (conto > 50.0) {
            return conto *= 0.9;
        }

        if (conto <10) {
            return conto += 0.5;
        }

        return conto;
    }
}
