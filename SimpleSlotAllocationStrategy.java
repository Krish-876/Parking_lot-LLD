public class SimpleSlotAllocationStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot findSpot(Vehicle vehicle, ParkingLot lot) {
        SpotType required = requiredSpot(vehicle.getVehicleType());
        for(ParkingSpot spot : lot.getAllSpots()){
            if(spot.isFree()&& spot.getStype()== required) return spot;
        }
        return null;
    }
    
    private SpotType requiredSpot(VehicleType type){
        return switch (type) {
            case BIKE -> SpotType.BIKE;
            case CAR -> SpotType.COMPACT;
            case TRUCK -> SpotType.LARGE;
        };
    }

}
