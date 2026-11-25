public class AttendanceApp {
    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();

        tracker.addStudent("Alice");
        tracker.addStudent("Bob");

        tracker.markAbsent("Alice");
        tracker.markAbsent("Alice");
        tracker.markAbsent("Bob");

        System.out.println("Alice: " + tracker.getAbsences("Alice") + " absences");
        System.out.println("Bob: " + tracker.getAbsences("Bob") + " absences");
    }
}
