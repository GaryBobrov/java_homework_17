import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTest {

    @Test
    public void testSortTicketsMultipleFlights() {
        AviaSouls repo = new AviaSouls();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 5, 6);
        Ticket ticket2 = new Ticket("SPB", "MSK", 180, 7, 8);
        Ticket ticket3 = new Ticket("MSK", "AER", 400, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 150, 19, 20);
        Ticket ticket5 = new Ticket("AER", "SPB", 500, 23, 3);
        Ticket ticket6 = new Ticket("MSK", "AER", 350, 15, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 160, 19, 20);
        Ticket ticket8 = new Ticket("AER", "SPB", 420, 23, 3);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket4, ticket7, ticket1};
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsOneFlight() {
        AviaSouls repo = new AviaSouls();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 5, 6);
        Ticket ticket2 = new Ticket("SPB", "MSK", 180, 7, 8);
        Ticket ticket3 = new Ticket("MSK", "AER", 400, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 150, 19, 20);
        Ticket ticket5 = new Ticket("AER", "SPB", 500, 23, 3);
        Ticket ticket6 = new Ticket("MSK", "AER", 350, 15, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 160, 19, 20);
        Ticket ticket8 = new Ticket("PTZ", "SPB", 80, 23, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket8};
        Ticket[] actual = manager.search("PTZ", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsEmpty() {
        AviaSouls repo = new AviaSouls();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 5, 6);
        Ticket ticket2 = new Ticket("SPB", "MSK", 180, 7, 8);
        Ticket ticket3 = new Ticket("MSK", "AER", 400, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 150, 19, 20);
        Ticket ticket5 = new Ticket("AER", "SPB", 500, 23, 3);
        Ticket ticket6 = new Ticket("MSK", "AER", 350, 15, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 160, 19, 20);
        Ticket ticket8 = new Ticket("PTZ", "SPB", 80, 23, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("PTZ", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorMultipleFlights() {
        AviaSouls repo = new AviaSouls();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 5, 8);//3
        Ticket ticket2 = new Ticket("SPB", "MSK", 180, 7, 8);
        Ticket ticket3 = new Ticket("MSK", "AER", 400, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 160, 19, 20);//1
        Ticket ticket5 = new Ticket("AER", "SPB", 500, 23, 3);
        Ticket ticket6 = new Ticket("MSK", "AER", 350, 15, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 19, 21);//2
        Ticket ticket8 = new Ticket("PTZ", "SPB", 80, 23, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket7, ticket1};
        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorOneFlight() {
        AviaSouls repo = new AviaSouls();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 5, 8);//3
        Ticket ticket2 = new Ticket("SPB", "MSK", 180, 7, 8);
        Ticket ticket3 = new Ticket("MSK", "AER", 400, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 160, 19, 20);//1
        Ticket ticket5 = new Ticket("AER", "SPB", 500, 23, 3);
        Ticket ticket6 = new Ticket("MSK", "AER", 350, 15, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 19, 21);//2
        Ticket ticket8 = new Ticket("PTZ", "SPB", 80, 23, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.searchAndSortBy("AER", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorEmpty() {
        AviaSouls repo = new AviaSouls();
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 5, 8);//3
        Ticket ticket2 = new Ticket("SPB", "MSK", 180, 7, 8);
        Ticket ticket3 = new Ticket("MSK", "AER", 400, 15, 18);
        Ticket ticket4 = new Ticket("MSK", "SPB", 160, 19, 20);//1
        Ticket ticket5 = new Ticket("AER", "SPB", 500, 23, 3);
        Ticket ticket6 = new Ticket("MSK", "AER", 350, 15, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 19, 21);//2
        Ticket ticket8 = new Ticket("PTZ", "SPB", 80, 23, 24);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("AER", "PTZ", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}