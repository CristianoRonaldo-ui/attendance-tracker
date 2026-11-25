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

    // Records one absence for an existing student
    public void markAbsent(String name) {
        if (!absences.containsKey(name)) {
            throw new IllegalArgumentException("Student not found: " + name);
        }
        int current = absences.get(name);
        absences.put(name, current + 1);
    }

    // Returns how many absences a student has
    public int getAbsences(String name) {
        if (!absences.containsKey(name)) {
            throw new IllegalArgumentException("Student not found: " + name);
        }
        return absences.get(name);
    }
}
