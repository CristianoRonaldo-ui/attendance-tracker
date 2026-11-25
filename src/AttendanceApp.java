public class AttendanceApp {
    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();

        tracker.addStudent("Alice");
        tracker.addStudent("Bob");

        tracker.markAbsent("Alice");
        tracker.markAbsent("Alice");
        tracker.markAbsent("Bob");

        tracker.printReport();
        tracker.removeStudent("Bob");
        tracker.printReport();
        runTests();
    }

    // Runs simple PASS/FAIL checks on AttendanceTracker
    public static void runTests() {
        System.out.println("=== Running Tests ===");

        // Test 1: markAbsent increases the count
        AttendanceTracker t1 = new AttendanceTracker();
        t1.addStudent("Alice");
        t1.markAbsent("Alice");
        t1.markAbsent("Alice");
        if (t1.getAbsences("Alice") == 2) {
            System.out.println("Test 1 PASS: markAbsent counts correctly");
        } else {
            System.out.println("Test 1 FAIL: expected 2, got " + t1.getAbsences("Alice"));
        }

        // Test 2: adding a duplicate student throws an exception
        AttendanceTracker t2 = new AttendanceTracker();
        t2.addStudent("Bob");
        try {
            t2.addStudent("Bob");
            System.out.println("Test 2 FAIL: duplicate student was accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2 PASS: " + e.getMessage());
        }

        // Test 3: a removed student can no longer be found
        AttendanceTracker t3 = new AttendanceTracker();
        t3.addStudent("Charlie");
        t3.removeStudent("Charlie");
        try {
            t3.getAbsences("Charlie");
            System.out.println("Test 3 FAIL: removed student still found");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3 PASS: " + e.getMessage());
        }
    }
}
