/**
 * Abstract base class representing a generic health professional.
 * Contains common attributes and behaviours shared by all health professional types.
 * This class cannot be instantiated directly.
 */
public abstract class HealthProfessional {
    // Private attributes - Encapsulation: controlled access only via getters
    private int id;
    private String name;
    private String[] workDays;

    /**
     * Full constructor with all parameters
     * @param id unique numeric ID of the professional
     * @param name full name of the professional
     * @param workDays array of working days in a week
     */
    public HealthProfessional(int id, String name, String[] workDays) {
        // Validation to ensure object is always in a valid state
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.id = id;
        this.name = name;
        this.workDays = workDays;
    }

    /**
     * Overloaded constructor with default work days (Monday to Friday)
     * @param id unique numeric ID of the professional
     * @param name full name of the professional
     */
    public HealthProfessional(int id, String name) {
        this(id, name, new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
    }

    /**
     * Abstract method that each specific professional type must implement
     * Describes the core duty of the professional
     */
    public abstract void performDuty();

    // Getter methods - read-only access to private attributes
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getWorkDays() {
        return workDays;
    }

    /**
     * Returns a readable string with all professional details
     */
    @Override
    public String toString() {
        String days = String.join(", ", workDays);
        return "Professional ID: " + id +
               "\nName: " + name +
               "\nWorking Days: " + days;
    }

    /**
     * Two professionals are considered equal if they have the same ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HealthProfessional other = (HealthProfessional) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
