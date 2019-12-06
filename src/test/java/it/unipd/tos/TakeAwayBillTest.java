////////////////////////////////////////////////////////////////////
// Nicolò Giaccone 1171208
////////////////////////////////////////////////////////////////////
package it.unipd.tos;


import it.unipd.tos.buissness.TakeAwayBill;
import it.unipd.tos.buissness.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TakeAwayBillTest {
    CBill takeAwayBillTest;
    public TakeAwayBillTest(){
        takeAwayBillTest=new CBill();
    }
    @org.junit.Test
    public void TestRisultatoCorretto() throws TakeAwayBillException {

        List<MenuItem> ordini = new ArrayList<>();
        ordini.add(new MenuItem(MenuItem.itemType.Bevande, "Pepsi", 2.5));
        ordini.add(new MenuItem(MenuItem.itemType.Panini, "Primavera", 3.5));
        ordini.add(new MenuItem(MenuItem.itemType.Fritti, "Patatine", 3));
        ordini.add(new MenuItem(MenuItem.itemType.Panini, "Vegetariano", 3));
        ordini.add(new MenuItem(MenuItem.itemType.Bevande, "Sprite", 2));

        double conto = takeAwayBillTest.getOrderPrice(ordini);
        assertEquals(14, conto,0);
    }

    @org.junit.Test
    public void Test5Panini() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ordini.add(new MenuItem(MenuItem.itemType.Panini, "panino", 2.0));
        }

        assertEquals(11, takeAwayBillTest.getOrderPrice(ordini),0);
    }

    @org.junit.Test
    public void TestScontoTot() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ordini.add(new MenuItem(MenuItem.itemType.Bevande, "Pepsi", 3.0));
        }

        assertEquals(54.0, takeAwayBillTest.getOrderPrice(ordini),0);
    }

    @org.junit.Test(expected = TakeAwayBillException.class)
    public void TestGt30Elementi() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            ordini.add(new MenuItem(MenuItem.itemType.Fritti, "Patatine", 2.5));
        }

        takeAwayBillTest.getOrderPrice(ordini);
    }

    @org.junit.Test
    public void TestMinEuro10() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ordini.add(new MenuItem(MenuItem.itemType.Bevande, "Pepsi", 2.0));
        }
        assertEquals(8.5, takeAwayBillTest.getOrderPrice(ordini),0);
    }

    @org.junit.Test
    public void TestListaVuota() throws TakeAwayBillException {
        List<MenuItem> ordini = new ArrayList<>();
        assertEquals(0, takeAwayBillTest.getOrderPrice(ordini),0);
    }


}

