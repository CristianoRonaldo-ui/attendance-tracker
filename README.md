# Attendance Tracker

A small Java console app that tracks student absences using a `HashMap<String, Integer>`. You can add students, record absences, remove students, and print an attendance report.

## Features

- Add a student (starts with 0 absences); adding the same name twice is rejected
- Mark a student absent (count goes up by 1)
- Look up how many absences a student has
- Remove a student from the tracker
- Print a full attendance report by iterating over the HashMap with `entrySet()`
- Built-in PASS/FAIL tests, including error cases

## Project Structure

```
attendance-tracker/
├── src/
│   ├── AttendanceTracker.java   # Core logic: HashMap + methods
│   └── AttendanceApp.java       # main(): demo + tests
├── .gitignore
└── README.md
```

## How to Run

Requires Java (JDK) installed.

```bash
javac src/*.java
java -cp src AttendanceApp
```

## Example Output

```
=== Attendance Report ===
Bob: 1 absences
Alice: 2 absences
=== Attendance Report ===
Alice: 2 absences
=== Running Tests ===
Test 1 PASS: markAbsent counts correctly
Test 2 PASS: Student already exists: Bob
Test 3 PASS: Student not found: Charlie
```

> Note: `HashMap` does not keep insertion order, so student order in the report may vary.

## Complexity Analysis

| Method | Time | Why |
|---|---|---|
| `addStudent` | O(1) average | `containsKey` + `put` are hash lookups |
| `markAbsent` | O(1) average | `containsKey` + `get` + `put` |
| `getAbsences` | O(1) average | `containsKey` + `get` |
| `removeStudent` | O(1) average | `containsKey` + `remove` |
| `printReport` | O(n) | visits every student once |

Space: O(n), where n is the number of students.

## What I Learned

- **`HashMap` basics in Java**: `put`, `get`, `containsKey`, `remove`, compared with Python's `dict`.
- **`get` returns `null` for a missing key** instead of raising an error like Python's `KeyError`. Unboxing that `null` into an `int` causes a `NullPointerException`, so I check `containsKey` first and throw a clear `IllegalArgumentException`.
- **Iterating with `entrySet()`** gives the key and value together through `Map.Entry`, which avoids an extra `get` lookup compared to looping over `keySet()`.
- **HashMap does not preserve insertion order**: Alice was added first but printed second.
- **Testing error cases with try/catch**: if the expected exception is thrown, the test passes; if the next line runs, the test fails.
- **Cleaning up warnings**: I removed a duplicate `import` that the compiler flagged as unused.
