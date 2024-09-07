// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// class Room {
//     private int roomNumber;
//     private String category;
//     private boolean isAvailable;
//     private double pricePerNight;

//     public Room(int roomNumber, String category, boolean isAvailable, double pricePerNight) {
//         this.roomNumber = roomNumber;
//         this.category = category;
//         this.isAvailable = isAvailable;
//         this.pricePerNight = pricePerNight;
//     }

//     public int getRoomNumber() {
//         return roomNumber;
//     }

//     public String getCategory() {
//         return category;
//     }

//     public boolean isAvailable() {
//         return isAvailable;
//     }

//     public void setAvailable(boolean available) {
//         isAvailable = available;
//     }

//     public double getPricePerNight() {
//         return pricePerNight;
//     }

//     @Override
//     public String toString() {
//         return "Room{" +
//                 "roomNumber=" + roomNumber +
//                 ", category='" + category + '\'' +
//                 ", isAvailable=" + isAvailable +
//                 ", pricePerNight=" + pricePerNight +
//                 '}';
//     }
// }

// class Booking {
//     private Room room;
//     private String guestName;
//     private int nights;
//     private double totalAmount;
//     private boolean paymentStatus;

//     public Booking(Room room, String guestName, int nights) {
//         this.room = room;
//         this.guestName = guestName;
//         this.nights = nights;
//         this.totalAmount = room.getPricePerNight() * nights;
//         this.paymentStatus = false;
//     }

//     public Room getRoom() {
//         return room;
//     }

//     public String getGuestName() {
//         return guestName;
//     }

//     public int getNights() {
//         return nights;
//     }

//     public double getTotalAmount() {
//         return totalAmount;
//     }

//     public boolean isPaymentStatus() {
//         return paymentStatus;
//     }

//     public void setPaymentStatus(boolean paymentStatus) {
//         this.paymentStatus = paymentStatus;
//     }

//     @Override
//     public String toString() {
//         return "Booking{" +
//                 "room=" + room +
//                 ", guestName='" + guestName + '\'' +
//                 ", nights=" + nights +
//                 ", totalAmount=" + totalAmount +
//                 ", paymentStatus=" + paymentStatus +
//                 '}';
//     }
// }

// class Payment {
//     private String paymentMethod;
//     private double amount;
//     private boolean isSuccess;

//     public Payment(String paymentMethod, double amount) {
//         this.paymentMethod = paymentMethod;
//         this.amount = amount;
//         this.isSuccess = false;
//     }

//     public boolean processPayment() {
//         // Simulate payment processing
//         System.out.println("Processing payment of $" + amount + " using " + paymentMethod + "...");
//         // Here, we can simulate success/failure. We'll assume success for simplicity.
//         this.isSuccess = true;
//         return isSuccess;
//     }

//     public boolean isSuccess() {
//         return isSuccess;
//     }

//     @Override
//     public String toString() {
//         return "Payment{" +
//                 "paymentMethod='" + paymentMethod + '\'' +
//                 ", amount=" + amount +
//                 ", isSuccess=" + isSuccess +
//                 '}';
//     }
// }

// class Hotel {
//     private List<Room> rooms = new ArrayList<>();
//     private List<Booking> bookings = new ArrayList<>();

//     public Hotel() {
//         // Sample rooms
//         rooms.add(new Room(101, "Single", true, 100.0));
//         rooms.add(new Room(102, "Double", true, 150.0));
//         rooms.add(new Room(103, "Suite", true, 250.0));
//         rooms.add(new Room(104, "Single", true, 100.0));
//         rooms.add(new Room(105, "Double", true, 150.0));
//     }

//     public List<Room> searchAvailableRooms(String category) {
//         List<Room> availableRooms = new ArrayList<>();
//         for (Room room : rooms) {
//             if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
//                 availableRooms.add(room);
//             }
//         }
//         return availableRooms;
//     }

//     public Booking makeReservation(int roomNumber, String guestName, int nights, String paymentMethod) {
//         for (Room room : rooms) {
//             if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
//                 room.setAvailable(false);
//                 Booking booking = new Booking(room, guestName, nights);
//                 Payment payment = new Payment(paymentMethod, booking.getTotalAmount());
//                 if (payment.processPayment()) {
//                     booking.setPaymentStatus(true);
//                     bookings.add(booking);
//                     System.out.println("Booking successful: " + booking);
//                     return booking;
//                 } else {
//                     System.out.println("Payment failed. Booking not completed.");
//                     room.setAvailable(true); // Revert room availability
//                     return null;
//                 }
//             }
//         }
//         return null;
//     }

//     public List<Booking> viewBookings() {
//         return bookings;
//     }

//     public static void main(String[] args) {
//         Hotel hotel = new Hotel();
//         Scanner scanner = new Scanner(System.in);

//         while (true) {
//             System.out.println("1. Search available rooms");
//             System.out.println("2. Make a reservation");
//             System.out.println("3. View bookings");
//             System.out.println("4. Exit");
//             int choice = scanner.nextInt();

//             switch (choice) {
//                 case 1:
//                     System.out.println("Enter room category (Single/Double/Suite): ");
//                     String category = scanner.next();
//                     List<Room> availableRooms = hotel.searchAvailableRooms(category);
//                     System.out.println("Available rooms: " + availableRooms);
//                     break;

//                 case 2:
//                     System.out.println("Enter room number: ");
//                     int roomNumber = scanner.nextInt();
//                     System.out.println("Enter guest name: ");
//                     String guestName = scanner.next();
//                     System.out.println("Enter number of nights: ");
//                     int nights = scanner.nextInt();
//                     System.out.println("Enter payment method (CreditCard/DebitCard/PayPal): ");
//                     String paymentMethod = scanner.next();
//                     Booking booking = hotel.makeReservation(roomNumber, guestName, nights, paymentMethod);
//                     if (booking == null) {
//                         System.out.println("Booking failed.");
//                     }
//                     break;

//                 case 3:
//                     List<Booking> bookings = hotel.viewBookings();
//                     System.out.println("Bookings: " + bookings);
//                     break;

//                 case 4:
//                     System.exit(0);

//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//             }
//         }
//     }
// }










import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room{
    private final int roomNumber;
    private final String category;
    private boolean isAvailable;
    private final double pricePerNight;

    public Room(int roomNumber, String category, boolean isAvailable, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = isAvailable;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", category='" + category + '\'' +
                ", isAvailable=" + isAvailable +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}

class Booking {
    private final Room room;
    private final String guestName;
    private final int nights;
    private final double totalAmount;
    private boolean paymentStatus;

    public Booking(Room room, String guestName, int nights) {
        this.room = room;
        this.guestName = guestName;
        this.nights = nights;
        this.totalAmount = room.getPricePerNight() * nights;
        this.paymentStatus = false;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", guestName='" + guestName + '\'' +
                ", nights=" + nights +
                ", totalAmount=" + totalAmount +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}

class Payment {
    private final String paymentMethod;
    private final double amount;
    private boolean isSuccess;
    private String failureReason;

    public Payment(String paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.isSuccess = false;
        this.failureReason = "";
    }

    public boolean processPayment() {
        // Simulate payment processing
        System.out.println("Processing payment of $" + amount + " using " + paymentMethod + "...");
        // Here, we can simulate success/failure. We'll assume success for simplicity.
        if (paymentMethod.equalsIgnoreCase("CreditCard") ||
            paymentMethod.equalsIgnoreCase("DebitCard") ||
            paymentMethod.equalsIgnoreCase("PayPal")) {
            this.isSuccess = true;
        } else {
            this.failureReason = "Invalid payment method.";
        }
        return isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getFailureReason() {
        return failureReason;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", amount=" + amount +
                ", isSuccess=" + isSuccess +
                ", failureReason='" + failureReason + '\'' +
                '}';
    }
}

class Hotel {
    private final List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Hotel() {
        // Sample rooms
        rooms.add(new Room(101, "Single", true, 100.0));
        rooms.add(new Room(102, "Double", true, 150.0));
        rooms.add(new Room(103, "Suite", true, 250.0));
        rooms.add(new Room(104, "Single", true, 100.0));
        rooms.add(new Room(105, "Double", true, 150.0));
    }

    public List<Room> searchAvailableRooms(String category) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Booking makeReservation(int roomNumber, String guestName, int nights, String paymentMethod) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
                Booking booking = new Booking(room, guestName, nights);
                Payment payment = new Payment(paymentMethod, booking.getTotalAmount());
                if (payment.processPayment()) {
                    booking.setPaymentStatus(true);
                    bookings.add(booking);
                    System.out.println("Booking successful: " + booking);
                    return booking;
                } else {
                    System.out.println("Payment failed: " + payment.getFailureReason());
                    room.setAvailable(true); // Revert room availability
                    return null;
                }
            }
        }
        System.out.println("Room not available or invalid room number.");
        return null;
    }

    public List<Booking> viewBookings() {
        return bookings;
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Search available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View bookings");
            System.out.println("4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter room category (Single/Double/Suite): ");
                    String category = sc.next();
                    List<Room> availableRooms = hotel.searchAvailableRooms(category);
                    System.out.println("Available rooms: " + availableRooms);
                    break;

                case 2:
                    System.out.println("Enter room number: ");
                    int roomNumber = sc.nextInt();
                    System.out.println("Enter guest name: ");
                    String guestName = sc.next();
                    System.out.println("Enter number of nights: ");
                    int nights = sc.nextInt();
                    System.out.println("Enter payment method (CreditCard/DebitCard/PayPal): ");
                    String paymentMethod = sc.next();
                    Booking booking = hotel.makeReservation(roomNumber, guestName, nights, paymentMethod);
                    if (booking == null) {
                        System.out.println("Booking failed.");
                    }
                    break;

                case 3:
                    List<Booking> bookings = hotel.viewBookings();
                    System.out.println("Bookings: " + bookings);
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}


















