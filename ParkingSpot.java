// Parking spot needs
// - id
// - Spot type
// - vehicle

public class ParkingSpot {
    private final String id;
    private final SpotType stype;
    private  Vehicle vehicle;

    public ParkingSpot(String id,SpotType stype){
        this.id = id;
        this.stype = stype;
    }
    //getters
    public String getId(){
        return id;
    }
    public SpotType getStype(){
        return stype;
    }
    //functions
    public boolean isFree(){
        return vehicle == null;
    }
    public Vehicle getParkedVehicle(){
        return vehicle;
    }
    
    //park and unpark
    public void park(Vehicle v){
        if(!isFree()){
            throw new IllegalStateException("Spot "+ id + " is already taken");
        }
        this.vehicle = v;
    }
    public Vehicle unpark(){
        if(isFree()){
            throw new IllegalStateException("Spot "+ id +" is already free");
        }
        Vehicle v = this.vehicle;
        this.vehicle = null;
        return v;
    }

}
