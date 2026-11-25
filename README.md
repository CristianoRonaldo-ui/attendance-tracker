# Attendance Tracker

A small Java console app that tracks student absences using a `Map<String, Integer>` backed by a `TreeMap`. You can add students, record absences, remove students, find at-risk students, and print an attendance report sorted by name.

## Features

- Add a student (starts with 0 absences); adding the same name twice is rejected
- Mark a student absent (count goes up by 1)
- Look up how many absences a student has
- Remove a student from the tracker
- Find students at risk: everyone with at least N absences
- Print a full attendance report, always sorted A to Z by name
- Built-in PASS/FAIL tests, including error cases

## Project Structure

```
attendance-tracker/
├── src/
│   ├── AttendanceTracker.java   # Core logic: TreeMap + methods
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
Alice: 2 absences
Bob: 1 absences
At risk (2+ absences): [Alice]
=== Attendance Report ===
Alice: 2 absences
=== Running Tests ===
Test 1 PASS: markAbsent counts correctly
Test 2 PASS: Student already exists: Bob
Test 3 PASS: Student not found: Charlie
Test 4 PASS: only Dana is at risk
```

## Complexity Analysis

| Method | Time | Why |
|---|---|---|
| `addStudent` | O(log n) | `containsKey` + `put` walk down the tree |
| `markAbsent` | O(log n) | `containsKey` + `get` + `put` |
| `getAbsences` | O(log n) | `containsKey` + `get` |
| `removeStudent` | O(log n) | `containsKey` + `remove` |
| `getStudentsAtRisk` | O(n) | checks every student once |
| `printReport` | O(n) | visits every student once, already in sorted order |

Space: O(n), where n is the number of students.

## Design Decision: HashMap vs TreeMap

The first version used a `HashMap`: lookups are O(1) on average, but the report printed students in an unpredictable order (Bob before Alice). I switched to a `TreeMap`, which keeps keys sorted, so the report is always alphabetical. The trade-off is that each lookup becomes O(log n) instead of O(1). For an attendance list, a readable sorted report is worth that small cost.

## What I Learned

- **`Map` basics in Java**: `put`, `get`, `containsKey`, `remove`, compared with Python's `dict`.
- **`get` returns `null` for a missing key** instead of raising an error like Python's `KeyError`. Unboxing that `null` into an `int` causes a `NullPointerException`, so I check `containsKey` first and throw a clear `IllegalArgumentException`.
- **Iterating with `entrySet()`** gives the key and value together through `Map.Entry`, which avoids an extra `get` lookup compared to looping over `keySet()`.
- **HashMap does not preserve order, TreeMap keeps keys sorted**, and choosing between them is a speed vs. ordering trade-off.
- **Program to an interface**: declaring the field as `Map` meant switching from `HashMap` to `TreeMap` only required changing one line (`new TreeMap<>()`).
- **Filtering into an `ArrayList`**: Java has no list comprehension, so I loop, check a condition, and `add` matching items.
- **Testing error cases with try/catch**: if the expected exception is thrown, the test passes; if the next line runs, the test fails.
- **Cleaning up warnings**: I removed unused `import` lines that the compiler flagged.
