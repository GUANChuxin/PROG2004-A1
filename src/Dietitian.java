import java.util.ArrayList;

/**
 * Represents an accredited dietitian and nutrition advisor.
 * Extends HealthProfessional with a specialised nutrition focus.
 */
public class Dietitian extends HealthProfessional {
    private String nutritionSpecialty;

    /**
     * Constructs a dietitian with specified area of nutrition expertise.
     * @param id unique identifier
     * @param name dietitian name
     * @param workDays available working days
     * @param nutritionSpecialty focus area of nutrition practice
     */
    public Dietitian(int id, String name, ArrayList<String> workDays, String nutritionSpecialty) {
        super(id, name, workDays);
        this.nutritionSpecialty = nutritionSpecialty;
    }

    public String getNutritionSpecialty() {
        return nutritionSpecialty;
    }

    @Override
    public String performDuty() {
        return nutritionSpecialty + " dietary planning and nutrition consultation";
    }

    @Override
    public String toString() {
        return "[Dietitian] " + super.toString()
                + " | Specialty: " + nutritionSpecialty
                + " | Service: " + performDuty();
    }
}
