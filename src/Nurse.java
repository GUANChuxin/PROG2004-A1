/**
 * Nurse class, inherits from HealthProfessional
 * Represents a nurse who can take blood samples and provide nursing care
 */
public class Nurse extends HealthProfessional {
    private String nurseLevel;

    public Nurse(int id, String name, String[] workDays, String nurseLevel) {
        super(id, name, workDays);
        this.nurseLevel = nurseLevel;
    }

    public Nurse(int id, String name, String nurseLevel) {
        super(id, name);
        this.nurseLevel = nurseLevel;
    }

    /**
     * Unique behaviour: take blood sample from a patient
     */
    public void takeBloodSample(String patientName) {
        System.out.println("Nurse " + getName() + " takes a blood sample from patient " + patientName);
    }

    @Override
    public void performDuty() {
        System.out.println(getName() + " is providing nursing care.");
    }

    @Override
    public String toString() {
        return "[Nurse]\n" +
               super.toString() +
               "\nNurse Level: " + nurseLevel;
    }

    public String getNurseLevel() {
        return nurseLevel;
    }
}
