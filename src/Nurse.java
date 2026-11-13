import java.util.ArrayList;

/**
 * Represents a registered nurse working at the health service.
 * Extends HealthProfessional with a nursing qualification level.
 */
public class Nurse extends HealthProfessional {
    private String nursingLevel;

    /**
     * Constructs a nurse with given qualification level.
     * @param id unique identifier
     * @param name nurse name
     * @param workDays available working days
     * @param nursingLevel qualification or seniority level
     */
    public Nurse(int id, String name, ArrayList<String> workDays, String nursingLevel) {
        super(id, name, workDays);
        this.nursingLevel = nursingLevel;
    }

    public String getNursingLevel() {
        return nursingLevel;
    }

    @Override
    public String performDuty() {
        return "Basic nursing care, blood sample collection, vital signs monitoring and health education";
    }

    @Override
    public String toString() {
        return "[Nurse] " + super.toString()
                + " | Level: " + nursingLevel
                + " | Service: " + performDuty();
    }
}
