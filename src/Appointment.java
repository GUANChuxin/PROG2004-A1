/**
 * Appointment class links a patient, a health professional and a specific time slot
 * Implements Comparable to support sorting by appointment time
 */
public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private HealthProfessional professional;
    private String timeSlot;

    /**
     * Constructor with full validation
     * Ensures an appointment can never be created in an invalid state
     * @param patient the patient who books the appointment
     * @param professional the health professional to see
     * @param timeSlot appointment time in HH:mm format
     */
    public Appointment(Patient patient, HealthProfessional professional, String timeSlot) {
        if (patient == null) {
            throw new IllegalArgumentException("Appointment must have a patient");
        }
        if (professional == null) {
            throw new IllegalArgumentException("Appointment must have a health professional");
        }
        if (!isValidTimeSlot(timeSlot)) {
            throw new IllegalArgumentException("Invalid time slot. Must be 08:00-16:00 in 30-minute intervals.");
        }
        this.patient = patient;
        this.professional = professional;
        this.timeSlot = timeSlot;
    }

    /**
     * Validates time slot format and range
     * Clinic hours: 08:00 - 16:00, 30-minute intervals
     */
    private boolean isValidTimeSlot(String time) {
        if (time == null || time.length() != 5 || time.charAt(2) != ':') {
            return false;
        }
        try {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            return hour >= 8 && hour <= 16 && (minute == 0 || minute == 30) && !(hour == 16 && minute == 30);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Convert time slot to minutes for sorting comparison
     */
    private int timeToMinutes() {
        int hour = Integer.parseInt(timeSlot.substring(0, 2));
        int minute = Integer.parseInt(timeSlot.substring(3, 5));
        return hour * 60 + minute;
    }

    /**
     * Compare appointments by time for sorting
     */
    @Override
    public int compareTo(Appointment other) {
        return this.timeToMinutes() - other.timeToMinutes();
    }

    // Getter methods
    public Patient getPatient() {
        return patient;
    }

    public HealthProfessional getProfessional() {
        return professional;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Appointment Time: " + timeSlot +
               "\n" + patient +
               "\nHealth Professional: " + professional.getName() +
               " (" + professional.getClass().getSimpleName() + ")";
    }
}
