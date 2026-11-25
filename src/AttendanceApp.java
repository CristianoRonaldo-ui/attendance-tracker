public class AttendanceApp {
    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();

        tracker.addStudent("Alice");
        tracker.addStudent("Bob");

        tracker.markAbsent("Alice");
        tracker.markAbsent("Alice");
        tracker.markAbsent("Bob");

        tracker.printReport();
    }
}
