import java.time.Instant;

public interface PricingStrategy {
    int calculatedAmount(Ticket ticket, Instant exitTime);
}
