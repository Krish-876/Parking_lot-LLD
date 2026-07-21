// Strategy pattern:
// Parking lot can choose from different allocation strategies:
// - first available
// - nearest spot
// - floor-wise
// - etc.

public interface SpotAllocationStrategy {
    ParkingSpot findSpot(Vehicle vehicle, ParkingLot lot);
}
