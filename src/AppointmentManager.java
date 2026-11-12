import java.util.ArrayList;
import java.util.Collections;

/**
 * Manages the collection of all appointments
 * Provides functionality to add, filter, sort and cancel appointments
 */
public class AppointmentManager {
    private ArrayList<Appointment> appointments;

    /**
     * Constructor initialises empty appointment list
     */
    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    /**
     * Add a new appointment
     * Prevents double-booking the same professional at the same time
     * @param appointment the appointment to add
     * @return result message indicating success or failure
     */
    public String addAppointment(Appointment appointment) {
        // Check for time conflict with the same professional
        for (Appointment app : appointments) {
            if (app.getProfessional().equals(appointment.getProfessional())
                && app.getTimeSlot().equals(appointment.getTimeSlot())) {
                return "[Add Failed] " + appointment.getProfessional().getName() +
                       " is already booked at " + appointment.getTimeSlot();
            }
        }
        appointments.add(appointment);
        return "[Add Success] Booked appointment for " + appointment.getPatient().getName() +
               " with " + appointment.getProfessional().getName() +
               " at " + appointment.getTimeSlot();
    }

    /**
     * Filter appointments by health professional ID
     * @param professionalId the ID to filter by
     * @return list of matching appointments
     */
    public ArrayList<Appointment> filterByProfessionalId(int professionalId) {
        ArrayList<Appointment> result = new ArrayList<>();
        for (Appointment app : appointments) {
            if (app.getProfessional().getId() == professionalId) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * Filter appointments by patient phone number
     * @param phoneNumber the phone number to filter by
     * @return list of matching appointments
     */
    public ArrayList<Appointment> filterByPatientPhone(String phoneNumber) {
        ArrayList<Appointment> result = new ArrayList<>();
        for (Appointment app : appointments) {
            if (app.getPatient().getPhoneNumber().equals(phoneNumber)) {
                result.add(app);
            }
        }
        return result;
    }

    /**
     * Sort all appointments by time (earliest to latest)
     * @return sorted list of all appointments
     */
    public ArrayList<Appointment> sortAllByTime() {
        ArrayList<Appointment> sorted = new ArrayList<>(appointments);
        Collections.sort(sorted);
        return sorted;
    }

    /**
     * Sort a given list of appointments by time
     * @param list the list to sort
     * @return sorted list
     */
    public ArrayList<Appointment> sortListByTime(ArrayList<Appointment> list) {
        ArrayList<Appointment> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted;
    }

    /**
     * Cancel an appointment by professional ID and time slot
     * @param professionalId ID of the health professional
     * @param timeSlot time of the appointment
     * @return result message indicating success or failure
     */
    public String cancelByProfessionalAndTime(int professionalId, String timeSlot) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment app = appointments.get(i);
            if (app.getProfessional().getId() == professionalId && app.getTimeSlot().equals(timeSlot)) {
                appointments.remove(i);
                return "[Cancel Success] Removed appointment for professional ID " +
                       professionalId + " at " + timeSlot;
            }
        }
        return "[Cancel Failed] No matching appointment found";
    }

    /**
     * Cancel all appointments for a given patient phone number
     * @param phoneNumber patient's phone number
     * @return result message indicating success or failure
     */
    public String cancelByPatientPhone(String phoneNumber) {
        int count = 0;
        // Iterate backwards to avoid index issues when removing
        for (int i = appointments.size() - 1; i >= 0; i--) {
            if (appointments.get(i).getPatient().getPhoneNumber().equals(phoneNumber)) {
                appointments.remove(i);
                count++;
            }
        }
        if (count > 0) {
            return "[Cancel Success] Removed " + count +
                   " appointment(s) for phone number " + phoneNumber;
        } else {
            return "[Cancel Failed] No appointments found for this phone number";
        }
    }

    /**
     * Get a copy of all appointments
     * @return list of all appointments
     */
    public ArrayList<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }
}
