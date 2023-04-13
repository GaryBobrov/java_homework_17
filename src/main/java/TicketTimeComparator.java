import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flyTime1 = t1.getTimeTo() - t1.getTimeFrom();
        int flyTime2 = t2.getTimeTo() - t2.getTimeFrom();
        return flyTime1 - flyTime2;
    }
}