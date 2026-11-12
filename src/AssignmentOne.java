import java.util.ArrayList;

/**
 * Main class for Assignment 1 demonstration
 * Entry point of the appointment system program
 */
public class AssignmentOne {
    public static void main(String[] args) {
        // ========== Part 3: Demonstrate Health Professional Classes ==========
        System.out.println("===== Health Professional Details =====");
        System.out.println();

        // Use a list of the base type to store all subclasses - Polymorphism
        ArrayList<HealthProfessional> staffList = new ArrayList<>();

        // Add 3 General Practitioners
        staffList.add(new GeneralPractitioner(101, "James Wilson", "City Central Clinic, Room 101"));
        staffList.add(new GeneralPractitioner(102, "Mary Johnson", 
            new String[]{"Monday", "Wednesday", "Friday"}, 
            "East Side Clinic, Room 203"));
        staffList.add(new GeneralPractitioner(103, "Robert Brown", "South District Clinic, Room 105"));

        // Add 2 Specialists
        staffList.add(new Specialist(201, "Emily Davis", "Cardiology", 150.0));
        staffList.add(new Specialist(202, "Michael Chen", 
            new String[]{"Tuesday", "Thursday"}, 
            "Pediatrics", 120.0));

        // Add 2 Nurses
        staffList.add(new Nurse(301, "Sarah Lewis", "Senior Nurse"));
        staffList.add(new Nurse(302, "David Kim", 
            new String[]{"Monday", "Tuesday", "Wednesday"}, 
            "Junior Nurse"));

        // Add 1 Dietitian
        staffList.add(new Dietitian(401, "Lisa Taylor", "Diabetes Management"));

        // Print all professionals - each object calls its own toString()
        for (HealthProfessional professional : staffList) {
            System.out.println(professional);
            System.out.println("------------------------");
        }

        // ========== Part 6: Demonstrate Appointment System End-to-End ==========
        System.out.println();
        System.out.println("===== Appointment System Demonstration =====");
        System.out.println();

        AppointmentManager manager = new AppointmentManager();

        // Create patient objects
        Patient patient1 = new Patient("Alice Smith", "0412345678");
        Patient patient2 = new Patient("Bob Johnson", "0423456789");
        Patient patient3 = new Patient("Charlie Brown", "0434567890");

        // 1. Add appointments (normal cases)
        System.out.println("--- Adding Appointments ---");
        System.out.println(manager.addAppointment(new Appointment(patient1, staffList.get(0), "09:00")));
        System.out.println(manager.addAppointment(new Appointment(patient2, staffList.get(0), "10:30")));
        System.out.println(manager.addAppointment(new Appointment(patient3, staffList.get(3), "09:00")));
        System.out.println(manager.addAppointment(new Appointment(patient1, staffList.get(5), "14:00")));
        System.out.println(manager.addAppointment(new Appointment(patient2, staffList.get(7), "11:00")));

        // 2. Error case: double-book the same professional at same time
        System.out.println();
        System.out.println("--- Error Test: Double Booking ---");
        System.out.println(manager.addAppointment(new Appointment(patient3, staffList.get(0), "09:00")));

        // 3. Display all appointments sorted by time
        System.out.println();
        System.out.println("--- All Appointments (Sorted by Time) ---");
        ArrayList<Appointment> sortedAll = manager.sortAllByTime();
        for (Appointment app : sortedAll) {
            System.out.println(app);
            System.out.println("------------------------");
        }

        // 4. Filter by professional ID
        System.out.println();
        System.out.println("--- Filter: Appointments for Professional ID 101 ---");
        ArrayList<Appointment> filterByPro = manager.filterByProfessionalId(101);
        for (Appointment app : filterByPro) {
            System.out.println(app);
            System.out.println("------------------------");
        }

        // 5. Filter by patient phone number
        System.out.println();
        System.out.println("--- Filter: Appointments for phone 0412345678 ---");
        ArrayList<Appointment> filterByPhone = manager.filterByPatientPhone("0412345678");
        for (Appointment app : filterByPhone) {
            System.out.println(app);
            System.out.println("------------------------");
        }

        // 6. Cancel appointments
        System.out.println();
        System.out.println("--- Cancelling Appointments ---");
        System.out.println(manager.cancelByProfessionalAndTime(101, "09:00"));
        // Error case: cancel non-existent appointment
        System.out.println(manager.cancelByPatientPhone("0499999999"));

        // 7. Display all appointments after cancellation
        System.out.println();
        System.out.println("--- All Appointments After Cancellation ---");
        sortedAll = manager.sortAllByTime();
        for (Appointment app : sortedAll) {
            System.out.println(app);
            System.out.println("------------------------");
        }
    }
}
