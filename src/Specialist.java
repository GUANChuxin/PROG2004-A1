import java.util.ArrayList;

/**
 * Represents a specialist medical practitioner.
 * Extends HealthProfessional with a specific field of medical specialisation.
 */
public class Specialist extends HealthProfessional {
    private String specialtyField;

    /**
     * Constructs a specialist with defined medical specialty.
     * @param id unique identifier
     * @param name doctor name
     * @param workDays available working days
     * @param specialtyField area of medical specialisation
     */
    public Specialist(int id, String name, ArrayList<String> workDays, String specialtyField) {
        super(id, name, workDays);
        this.specialtyField = specialtyField;
    }

    public String getSpecialtyField() {
        return specialtyField;
    }

    @Override
    public String performDuty() {
        return specialtyField + " specialist diagnosis and treatment planning";
    }

    @Override
    public String toString() {
        return "[Specialist] " + super.toString()
                + " | Specialty: " + specialtyField
                + " | Service: " + performDuty();
    }
}
