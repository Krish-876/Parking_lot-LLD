import java.time.Instant;

// Ticket has 
// - ticket id
// - entry time
// - status
// - plate number
// - spot id
// - vehicle type
// - spot type

// Why are we taking spot id, vehicle type etc instead of complete class?
// In real life we use database and we dont store Objects in it, bcs we have to serialize and deserialize

public class Ticket {
    private final String ticketId;
    // Vehicle snapshot
    private final String vehiclePlate;
    private final VehicleType vehicleType;

    // Spot snapshot
    private final String spotId;
    private final SpotType spotType;


    private final Instant entryTime;
    private TicketStatus status;

    public Ticket(String ticketId,Vehicle vehicle, ParkingSpot spot){
        this.ticketId = ticketId;
        this.vehiclePlate = vehicle.getPlate();
        this.vehicleType = vehicle.getVehicleType();

        this.spotId = spot.getId();
        this.spotType = spot.getStype();

        this.entryTime = Instant.now();
        this.status = TicketStatus.ACTIVE;
    }

    public String getTicketId(){
        return ticketId;
    }
    public String getVehiclePlate(){
        return vehiclePlate;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public String getSpotId(){
        return spotId;
    }
    public SpotType getSpotType(){
        return spotType;
    }
    public Instant getEntryTime(){
        return entryTime;
    }
    public TicketStatus getTicketStatus(){
        return status;
    }
    public void setStatus(TicketStatus status){
        this.status = status;
    }
}
