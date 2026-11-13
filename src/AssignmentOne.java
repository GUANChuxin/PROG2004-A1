import java.util.ArrayList;

/**
 * Main entry class for the health appointment system demonstration.
 * Executes a complete end-to-end script covering normal operations,
 * error cases, filtering, sorting and cancellation.
 */
public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("======= Health Appointment Management System Demo =======");
        System.out.println();

        // ========== 1. Initialise Health Professionals ==========
        System.out.println("--- 1. System Initialisation: Health Professionals ---");

        // General Practitioner 1
        ArrayList<String> gp1Days = new ArrayList<>();
        gp1Days.add("Monday");
        gp1Days.add("Wednesday");
        gp1Days.add("Friday");
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. James Wilson", gp1Days, "Room 102, Ground Floor");

        // General Practitioner 2
        ArrayList<String> gp2Days = new ArrayList<>();
        gp2Days.add("Monday");
        gp2Days.add("Tuesday");
        gp2Days.add("Thursday");
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Emma Carter", gp2Days, "Room 103, Ground Floor");

        // Specialist
        ArrayList<String> specDays = new ArrayList<>();
        specDays.add("Monday");
        specDays.add("Thursday");
        Specialist specialist = new Specialist(201, "Dr. Michael Brown", specDays, "Cardiology");

        // Nurse
        ArrayList<String> nurseDays = new ArrayList<>();
        nurseDays.add("Monday");
        nurseDays.add("Tuesday");
        nurseDays.add("Wednesday");
        nurseDays.add("Thursday");
        nurseDays.add("Friday");
        Nurse nurse = new Nurse(301, "Olivia Taylor", nurseDays, "Registered Nurse, Level 3");

        // Dietitian
        ArrayList<String> dietDays = new ArrayList<>();
        dietDays.add("Monday");
        dietDays.add("Wednesday");
        dietDays.add("Friday");
        Dietitian dietitian = new Dietitian(401, "Sophia Martinez", dietDays, "Chronic Disease Nutrition");

        // Polymorphic collection: all professionals stored under parent type
        ArrayList<HealthProfessional> staffList = new ArrayList<>();
        staffList.add(gp1);
        staffList.add(gp2);
        staffList.add(specialist);
        staffList.add(nurse);
        staffList.add(dietitian);

        System.out.println("Loaded " + staffList.size() + " health professionals:");
        for (HealthProfessional staff : staffList) {
            System.out.println("  " + staff);
        }
        System.out.println();

        // ========== 2. Initialise Patients ==========
        System.out.println("--- 2. System Initialisation: Patient Records ---");
        Patient p1 = new Patient(1, "Liam Anderson", "0400111001", 28, "Male");
        Patient p2 = new Patient(2, "Charlotte Evans", "0400111002", 35, "Female");
        Patient p3 = new Patient(3, "Noah Thompson", "0400111003", 42, "Male");
        Patient p4 = new Patient(4, "Ava Robinson", "0400111004", 25, "Female");

        System.out.println("Registered " + 4 + " patients:");
        System.out.println("  " + p1);
        System.out.println("  " + p2);
        System.out.println("  " + p3);
        System.out.println("  " + p4);
        System.out.println();

        // ========== 3. Core Appointment System Operations ==========
        System.out.println("--- 3. Appointment System Operations ---");
        AppointmentManager manager = new AppointmentManager();

        // 3.1 Add valid appointments
        System.out.println("[Adding Appointments]");
        System.out.println(manager.addAppointment(new Appointment(p1, gp1, "09:00")));
        System.out.println(manager.addAppointment(new Appointment(p2, specialist, "10:00")));
        System.out.println(manager.addAppointment(new Appointment(p3, nurse, "08:30")));
        System.out.println(manager.addAppointment(new Appointment(p4, dietitian, "11:00")));
        System.out.println();

        // 3.2 Error case: double-book the same professional at the same time
        System.out.println("[Error Demo: Double Booking Attempt]");
        System.out.println(manager.addAppointment(new Appointment(p3, gp1, "09:00")));
        System.out.println();

        // 3.3 Error case: booking outside clinic hours
        System.out.println("[Error Demo: Invalid Time Slot]");
        System.out.println(manager.addAppointment(new Appointment(p2, gp2, "17:30")));
        System.out.println();

        // 3.4 View all current appointments
        System.out.println("[All Current Appointments]");
        printAppointments(manager.getAllAppointments());
        System.out.println();

        // 3.5 View appointments sorted by time
        System.out.println("[Appointments Sorted by Time]");
        printAppointments(manager.sortByTime());
        System.out.println();

        // 3.6 Filter by professional ID
        System.out.println("[Filter: Appointments for Dr. James Wilson (ID 101)]");
        printAppointments(manager.filterByProfessionalId(101));
        System.out.println();

        // 3.7 Filter by patient phone number
        System.out.println("[Filter: Appointments for phone 0400111002]");
        printAppointments(manager.filterByPatientPhone("0400111002"));
        System.out.println();

        // 3.8 Cancel an existing appointment
        System.out.println("[Cancellation Operation]");
        System.out.println(manager.cancelByProfessionalAndTime(101, "09:00"));
        System.out.println();

        // 3.9 Error case: cancel a non-existent appointment
        System.out.println("[Error Demo: Cancel Non-Existent Appointment]");
        System.out.println(manager.cancelByPatientPhone("0499999999"));
        System.out.println();

        // 3.10 Show final state after cancellation
        System.out.println("[All Appointments After Cancellation]");
        printAppointments(manager.getAllAppointments());
        System.out.println();

        System.out.println("======= End of System Demo =======");
    }

    /**
     * Helper method to print a list of appointments in readable format.
     * @param list the list of appointments to display
     */
    private static void printAppointments(ArrayList<Appointment> list) {
        if (list.isEmpty()) {
            System.out.println("  No appointment records found.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  -- Appointment " + (i+1) + " --");
            System.out.println(list.get(i));
        }
    }
}
