/**
 * Dietitian class, inherits from HealthProfessional
 * Represents a dietitian who creates personalised diet plans
 */
public class Dietitian extends HealthProfessional {
    private String expertiseArea;

    public Dietitian(int id, String name, String[] workDays, String expertiseArea) {
        super(id, name, workDays);
        this.expertiseArea = expertiseArea;
    }

    public Dietitian(int id, String name, String expertiseArea) {
        super(id, name);
        this.expertiseArea = expertiseArea;
    }

    /**
     * Unique behaviour: create a diet plan for a patient
     */
    public void createDietPlan(String patientName) {
        System.out.println("Dietitian " + getName() + " creates a " + expertiseArea + " diet plan for patient " + patientName);
    }

    @Override
    public void performDuty() {
        System.out.println(getName() + " is providing nutritional consultation.");
    }

    @Override
    public String toString() {
        return "[Dietitian]\n" +
               super.toString() +
               "\nExpertise Area: " + expertiseArea;
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }
}
