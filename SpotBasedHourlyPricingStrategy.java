import java.time.Duration;
import java.time.Instant;

public class SpotBasedHourlyPricingStrategy implements PricingStrategy{

    @Override
    public int calculatedAmount(Ticket ticket, Instant exitTime) {
        long minutes = Duration.between(ticket.getEntryTime(), exitTime).toMinutes();
        long hours = (minutes +59)/2;
        int ratePerHour = switch(ticket.getSpotType()){
            case BIKE->10;
            case COMPACT -> 20;
            case LARGE -> 50;
        };
        return (int)(hours*ratePerHour);
    }
    
}
