public class Vehicle{
    //Private variables
    private final String plate;
    private final VehicleType type;
    
    //Constructor
    public Vehicle(String plate, VehicleType type){
        this.plate = plate;
        this.type = type;
    }

    //getters
    public String getPlate(){
        return plate;
    }
    public VehicleType getVehicleType(){
        return type;
    }
}