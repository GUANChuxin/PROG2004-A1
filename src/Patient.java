/**
 * Entity class representing a patient in the health service system.
 * Encapsulates patient personal details with controlled read-only access.
 */
public class Patient {
    private int patientId;
    private String name;
    private String phoneNumber;
    private int age;
    private String gender;

    /**
     * Constructs a Patient with all required personal information.
     * @param patientId unique numeric identifier for the patient
     * @param name full name of the patient
     * @param phoneNumber contact phone number
     * @param age age of the patient
     * @param gender gender of the patient
     */
    public Patient(int patientId, String name, String phoneNumber, int age, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    /**
     * Returns a formatted string with full patient details.
     * @return patient information as a readable string
     */
    @Override
    public String toString() {
        return "Patient | ID: " + patientId + " | Name: " + name
                + " | Age: " + age + " | Gender: " + gender
                + " | Phone: " + phoneNumber;
    }
}
