/**
 * Represents a single appointment linking a patient to a health professional at a specific time.
 * Implements Comparable to enable natural sorting by appointment time.
 */
public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private HealthProfessional professional;
    private String timeSlot;

    /**
     * Constructs a valid appointment with patient, professional and time slot.
     * @param patient the patient attending the appointment
     * @param professional the health professional providing the service
     * @param timeSlot appointment time in HH:mm format
     */
    public Appointment(Patient patient, HealthProfessional professional, String timeSlot) {
        this.patient = patient;
        this.professional = professional;
        this.timeSlot = timeSlot;
    }

    public Patient getPatient() {
        return patient;
    }

    public HealthProfessional getProfessional() {
        return professional;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Compares appointments by time slot for chronological ordering.
     * @param other the other appointment to compare against
     * @return comparison result for sorting
     */
    @Override
    public int compareTo(Appointment other) {
        return this.timeSlot.compareTo(other.timeSlot);
    }

    /**
     * Returns a formatted multi-line description of the full appointment.
     * @return readable appointment details
     */
    @Override
    public String toString() {
        return "Time: " + timeSlot + "\n"
                + "  " + patient.toString() + "\n"
                + "  Provider: " + professional.toString();
    }
}
