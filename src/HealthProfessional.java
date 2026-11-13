import java.util.ArrayList;

/**
 * Abstract base class for all health professional types.
 * Defines shared attributes and behaviour, and cannot be instantiated directly.
 * Enforces subclasses to implement their core duty method.
 */
public abstract class HealthProfessional {
    private int id;
    private String name;
    private ArrayList<String> workDays;

    /**
     * Constructs a health professional with base identity and availability.
     * @param id unique numeric identifier
     * @param name full name of the professional
     * @param workDays list of days the professional works each week
     */
    public HealthProfessional(int id, String name, ArrayList<String> workDays) {
        this.id = id;
        this.name = name;
        this.workDays = workDays;
    }

    /**
     * Abstract method describing the core duty of the professional.
     * Must be implemented by every concrete subclass.
     * @return description of the service provided
     */
    public abstract String performDuty();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getWorkDays() {
        return workDays;
    }

    /**
     * Checks whether the professional works on a given day.
     * @param day the day to check
     * @return true if the professional is available on that day
     */
    public boolean isWorkingDay(String day) {
        return workDays.contains(day);
    }

    /**
     * Returns base professional information as a formatted string.
     * @return summary of identity and working days
     */
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name
                + " | Working Days: " + String.join(", ", workDays);
    }
}
