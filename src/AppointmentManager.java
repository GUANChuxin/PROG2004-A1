import java.util.ArrayList;
import java.util.Collections;

/**
 * Central manager class for all appointment operations.
 * Encapsulates business rules including time slot validation,
 * double-booking prevention, filtering, sorting and cancellation.
 */
public class AppointmentManager {
    private ArrayList<Appointment> appointments;

    /** Fixed daily schedule: 08:00 to 16:00 in 30-minute intervals. */
    private static final String[] VALID_TIME_SLOTS = {
            "08:00", "08:30", "09:00", "09:30", "10:00", "10:30",
            "11:00", "11:30", "12:00", "12:30", "13:00", "13:30",
            "14:00", "14:30", "15:00", "15:30", "16:00"
    };

    /**
     * Creates an empty appointment manager.
     */
    public AppointmentManager() {
        this.appointments = new ArrayList<>();
    }

    /**
     * Attempts to add a new appointment after running all business validations.
     * Validations: valid time slot, working day check, no double-booking.
     * @param appointment the appointment to add
     * @return status message indicating success or reason for failure
     */
    public String addAppointment(Appointment appointment) {
        // Validation 1: check if time slot is within official schedule
        boolean isValidTime = false;
        for (String slot : VALID_TIME_SLOTS) {
            if (slot.equals(appointment.getTimeSlot())) {
                isValidTime = true;
                break;
            }
        }
        if (!isValidTime) {
            return "[FAILED] Invalid time slot " + appointment.getTimeSlot()
                    + ". Clinic operates 08:00-16:00 in 30-minute intervals.";
        }

        // Validation 2: check if the professional works on the booking day (Monday for demo)
        if (!appointment.getProfessional().isWorkingDay("Monday")) {
            return "[FAILED] " + appointment.getProfessional().getName()
                    + " is not available on the selected day.";
        }

        // Validation 3: prevent double-booking for the same professional at the same time
        for (Appointment existing : appointments) {
            if (existing.getProfessional().getId() == appointment.getProfessional().getId()
                    && existing.getTimeSlot().equals(appointment.getTimeSlot())) {
                return "[FAILED] " + appointment.getProfessional().getName()
                        + " is already booked at " + appointment.getTimeSlot() + ".";
            }
        }

        // All checks passed: add the appointment
        appointments.add(appointment);
        return "[SUCCESS] Appointment created: " + appointment.getPatient().getName()
                + " booked with " + appointment.getProfessional().getName()
                + " at " + appointment.getTimeSlot() + ".";
    }

    /**
     * Cancels an appointment matching the given professional ID and time slot.
     * @param professionalId ID of the health professional
     * @param timeSlot time of the appointment
     * @return status message for the cancellation attempt
     */
    public String cancelByProfessionalAndTime(int professionalId, String timeSlot) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment app = appointments.get(i);
            if (app.getProfessional().getId() == professionalId
                    && app.getTimeSlot().equals(timeSlot)) {
                appointments.remove(i);
                return "[SUCCESS] Cancelled appointment for professional ID "
                        + professionalId + " at " + timeSlot + ".";
            }
        }
        return "[FAILED] No matching appointment found to cancel.";
    }

    /**
     * Cancels the first appointment found for the given patient phone number.
     * @param phoneNumber patient contact number
     * @return status message for the cancellation attempt
     */
    public String cancelByPatientPhone(String phoneNumber) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment app = appointments.get(i);
            if (app.getPatient().getPhoneNumber().equals(phoneNumber)) {
                appointments.remove(i);
                return "[SUCCESS] Cancelled appointment for patient phone " + phoneNumber + ".";
            }
        }
        return "[FAILED] No appointment found for this phone number.";
    }

    /**
     * Returns all appointments for a specific health professional.
     * @param professionalId ID of the professional to filter by
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
     * Returns all appointments for a patient matching the given phone number.
     * @param phoneNumber patient contact number
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
     * Returns a copy of all appointments sorted chronologically by time slot.
     * @return sorted list of all appointments
     */
    public ArrayList<Appointment> sortByTime() {
        ArrayList<Appointment> sortedList = new ArrayList<>(appointments);
        Collections.sort(sortedList);
        return sortedList;
    }

    /**
     * Returns the full list of current appointments.
     * @return all stored appointments
     */
    public ArrayList<Appointment> getAllAppointments() {
        return appointments;
    }
}
