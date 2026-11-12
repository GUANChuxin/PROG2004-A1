/**
 * Patient class stores basic patient information
 */
public class Patient {
    private String name;
    private String phoneNumber;

    /**
     * Constructor with validation to ensure valid patient data
     * @param name patient's full name
     * @param phoneNumber patient's contact phone number
     */
    public Patient(String name, String phoneNumber) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Patient Name: " + name + "\nContact Phone: " + phoneNumber;
    }
}
