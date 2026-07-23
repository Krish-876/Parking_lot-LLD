# Parking Lot System (Low-Level Design)

A modular, extensible Java implementation of a **Parking Lot Management System** designed using Object-Oriented Design (OOD) principles and Design Patterns.

## Project Overview

This project simulates core parking lot operations, including vehicle entry, parking spot allocation, ticket generation, dynamic fee calculation, and payment receipts upon exit.

### Key Features

* **Flexible Spot Allocation Strategy:** Easily plug in custom algorithms (e.g., nearest slot, first available slot).
* **Dynamic Pricing Strategies:** Calculate parking fees based on hourly rates, spot types, or duration.
* **Support for Multiple Vehicle & Spot Types:** Manage diverse vehicle classes and designated parking spots (e.g., Two-Wheeler, Compact, Large).
* **Payment Processing:** Issue digital receipts and track ticket/payment states (`ACTIVE`, `PAID`, `SUCCESS`, `FAILED`, etc.).

## Architecture & Design Patterns

* **Strategy Pattern:**
* `SpotAllocationStrategy` (implemented by `SimpleSlotAllocationStrategy`): Encapsulates slot assignment logic.
* `PricingStrategy` (implemented by `SpotBasedHourlyPricingStrategy`): Decouples dynamic pricing rules.
* **Domain Model Separation:** Enums (`VehicleType`, `SpotType`, `TicketStatus`, `PaymentStatus`, `PaymentMode`) cleanly manage system states and configurations.

## Repository Structure

```text
.
├── Demo.java                        # Entry point / Demo application
├── ParkingLot.java                  # Main domain controller for parking lot logic
├── ParkingSpot.java                  # Model for parking spots
├── Vehicle.java                     # Model for incoming vehicles
├── Ticket.java                      # Model for issued parking tickets
├── PaymentReceipt.java              # Receipt generation post-payment
│
├── SpotAllocationStrategy.java      # Strategy interface for allocating slots
├── SimpleSlotAllocationStrategy.java# Default slot allocation strategy
├── PricingStrategy.java             # Strategy interface for fee calculation
├── SpotBasedHourlyPricingStrategy.java # Spot & hourly-rate based pricing logic
│
└── Enums
    ├── VehicleType.java             # Types of vehicles (CAR, BIKE, TRUCK, etc.)
    ├── SpotType.java                # Types of spots (COMPACT, LARGE, TWO_WHEELER)
    ├── TicketStatus.java            # States: ACTIVE, PAID, LOST
    ├── PaymentStatus.java           # States: SUCCESS, FAILED
    └── PaymentMode.java             # Modes: CASH, CARD, UPI, etc.

```

## Getting Started

### Prerequisites

* **Java Development Kit (JDK):** Version 8 or higher.
* **IDE:** IntelliJ IDEA, Eclipse, or VS Code (optional).

### Running the Demo

1. **Clone the Repository:**
```bash
git clone https://github.com/your-username/Parking_lot-LLD.git
cd Parking_lot-LLD

```


2. **Compile the Java Files:**
```bash
javac *.java

```


3. **Run the Application:**
```bash
java Demo

```

## Usage Example

```java
// Initialize strategies
SpotAllocationStrategy allocationStrategy = new SimpleSlotAllocationStrategy();
PricingStrategy pricingStrategy = new SpotBasedHourlyPricingStrategy();

// Initialize Parking Lot
ParkingLot parkingLot = new ParkingLot(allocationStrategy, pricingStrategy);

// Vehicle Entry
Vehicle car = new Vehicle("ABC-1234", VehicleType.CAR);
Ticket ticket = parkingLot.parkVehicle(car);

// Vehicle Exit & Payment
PaymentReceipt receipt = parkingLot.unparkVehicle(ticket, PaymentMode.UPI);

```
