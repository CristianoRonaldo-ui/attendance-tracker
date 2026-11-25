import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    // Prints every student and their absence count
    public void printReport() {
        System.out.println("=== Attendance Report ===");
        for (Map.Entry<String, Integer> entry : absences.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            System.out.println(name + ": " + count + " absences");
        }
    }

    // Removes a student from the tracker
    public void removeStudent(String name) {
        if (!absences.containsKey(name)) {
            throw new IllegalArgumentException("Student not found: " + name);
        }
        absences.remove(name);
    }

    // Returns names of students with at least `threshold` absences
    public ArrayList<String> getStudentsAtRisk(int threshold) {
        ArrayList<String> atRisk = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : absences.entrySet()) {
            if (entry.getValue() >= threshold) {
                atRisk.add(entry.getKey());
            }
        }
        return atRisk;
    }
}
