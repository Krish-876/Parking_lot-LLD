import java.time.Instant;
import java.util.*;
// Parking lot contains list of parking spots

// 1. How do you assign a parking spot to a vehicle?
// There can be multiple approaches - Brute force ... etc.

// We will be using Strategy Pattern

public class ParkingLot {

    private final List<ParkingSpot> spots = new ArrayList<>();
    private final Map<String, Ticket> tickets = new HashMap<>();

    private final SpotAllocationStrategy allocationStrategy;
    private final PricingStrategy pricingStrategy;

    public ParkingLot(SpotAllocationStrategy allocationStrategy, PricingStrategy pricingStrategy){
        this.allocationStrategy = allocationStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    private Ticket getActiveTicket(String ticketId){
        Ticket t = tickets.get(ticketId);
        if(t==null) throw new IllegalArgumentException("Invalid ticket");
        if(t.getTicketStatus()!=TicketStatus.ACTIVE) throw new IllegalStateException("Ticket not active");
        return t;
    }

    public void addSpot(ParkingSpot spot){
        spots.add(spot);
    }
    public List<ParkingSpot> getAllSpots(){ return Collections.unmodifiableList(spots);}

    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot spot = allocationStrategy.findSpot(vehicle, this);
        if (spot == null) throw new IllegalStateException("No spot available");

        spot.park(vehicle);
        String ticketID = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketID, vehicle, spot);
        tickets.put(ticketID, ticket);
        return ticket;
    }

    public int calculateDue(String ticketId){
        Ticket ticket = getActiveTicket(ticketId);
        return pricingStrategy.calculatedAmount(ticket, Instant.now());
    }

    public PaymentReceipt payAndExit(String ticketId, PaymentMode mode){
        Ticket ticket = getActiveTicket(ticketId);
        int amount = pricingStrategy.calculatedAmount(ticket, Instant.now());
       // assume payment is success
        PaymentReceipt receipt = new PaymentReceipt(UUID.randomUUID().toString(), amount, PaymentStatus.SUCCESS);

        ParkingSpot spot = findSpotById(ticket.getSpotId());
        spot.unpark();

        ticket.setStatus(TicketStatus.PAID);
        return receipt;
    }

    private ParkingSpot findSpotById(String spotId){
        for (ParkingSpot spot : spots) {
            if (spot.getId().equals(spotId)) {
                return spot;
            }
        }
        throw new IllegalStateException("Spot not found: " + spotId);
    }
    
}
