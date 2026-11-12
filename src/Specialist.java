/**
 * Specialist class, inherits from HealthProfessional
 * Represents a doctor specialised in a specific medical field
 */
public class Specialist extends HealthProfessional {
    private String specialtyField;
    private double consultationFee;

    public Specialist(int id, String name, String[] workDays, String specialtyField, double consultationFee) {
        super(id, name, workDays);
        this.specialtyField = specialtyField;
        this.consultationFee = consultationFee;
    }

    public Specialist(int id, String name, String specialtyField, double consultationFee) {
        super(id, name);
        this.specialtyField = specialtyField;
        this.consultationFee = consultationFee;
    }

    /**
     * Unique behaviour: perform specialist diagnosis
     */
    public void performSpecialistDiagnosis(String patientName) {
        System.out.println(specialtyField + " specialist Dr. " + getName() + " diagnoses patient " + patientName);
    }

    @Override
    public void performDuty() {
        System.out.println(getName() + " is providing " + specialtyField + " specialist treatment.");
    }

    @Override
    public String toString() {
        return "[Specialist]\n" +
               super.toString() +
               "\nSpecialty Field: " + specialtyField +
               "\nConsultation Fee: $" + consultationFee;
    }

    public String getSpecialtyField() {
        return specialtyField;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
}
