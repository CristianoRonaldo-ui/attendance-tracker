import java.util.HashMap;

public class AttendanceTracker {
    // Maps each student's name to their number of absences
    private HashMap<String, Integer> absences;

    public AttendanceTracker() {
        absences = new HashMap<>();
    }

    // Adds a new student with 0 absences
    public void addStudent(String name) {
        if (absences.containsKey(name)) {
            throw new IllegalArgumentException("Student already exists: " + name);
        }
        absences.put(name, 0);
    }
}
