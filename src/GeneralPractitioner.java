/**
 * General Practitioner (GP) class, inherits from HealthProfessional
 * Represents a family doctor who can prescribe medication
 */
public class GeneralPractitioner extends HealthProfessional {
    private String clinicLocation;

    /**
     * Full constructor
     */
    public GeneralPractitioner(int id, String name, String[] workDays, String clinicLocation) {
        super(id, name, workDays);
        this.clinicLocation = clinicLocation;
    }

    /**
     * Overloaded constructor with default work days
     */
    public GeneralPractitioner(int id, String name, String clinicLocation) {
        super(id, name);
        this.clinicLocation = clinicLocation;
    }

    /**
     * Unique behaviour: prescribe medication for a patient
     */
    public void prescribeMedication(String patientName, String medication) {
        System.out.println("Dr. " + getName() + " prescribes " + medication + " to patient " + patientName);
    }

    @Override
    public void performDuty() {
        System.out.println(getName() + " is conducting a general consultation.");
    }

    @Override
    public String toString() {
        return "[General Practitioner]\n" +
               super.toString() +
               "\nClinic Location: " + clinicLocation;
    }

    public String getClinicLocation() {
        return clinicLocation;
    }
}
