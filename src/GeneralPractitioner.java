import java.util.ArrayList;

/**
 * Represents a General Practitioner (GP), a primary care physician.
 * Extends HealthProfessional and adds clinic location information.
 */
public class GeneralPractitioner extends HealthProfessional {
    private String clinicLocation;

    /**
     * Constructs a GP with base professional details and clinic location.
     * @param id unique identifier
     * @param name doctor name
     * @param workDays available working days
     * @param clinicLocation room or clinic address
     */
    public GeneralPractitioner(int id, String name, ArrayList<String> workDays, String clinicLocation) {
        super(id, name, workDays);
        this.clinicLocation = clinicLocation;
    }

    public String getClinicLocation() {
        return clinicLocation;
    }

    @Override
    public String performDuty() {
        return "General diagnosis, primary health consultation, and patient referral services";
    }

    @Override
    public String toString() {
        return "[General Practitioner] " + super.toString()
                + " | Clinic: " + clinicLocation
                + " | Service: " + performDuty();
    }
}
