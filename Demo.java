public class Demo {
    public static void main(String[] args) throws InterruptedException{
        ParkingLot lot = new ParkingLot(
            new SimpleSlotAllocationStrategy(),
            new SpotBasedHourlyPricingStrategy()
        );

        lot.addSpot(new ParkingSpot("B1", SpotType.BIKE));
        lot.addSpot(new ParkingSpot("C1", SpotType.COMPACT));
        lot.addSpot(new ParkingSpot("L1", SpotType.LARGE));
        
        Vehicle car = new Vehicle("DL-01-1234", VehicleType.CAR);
        
        Ticket t = lot.parkVehicle(car);
        System.out.println("Ticket "+ t.getTicketId()+ " Spot : "+ t.getSpotId());
        Thread.sleep(2000);
        int due = lot.calculateDue(t.getTicketId());
        System.out.println("Due :" +due);

        PaymentReceipt r = lot.payAndExit(t.getTicketId(), PaymentMode.UPI);
        System.out.println("Paid. Receipt generated :" + r);
    }    
}
