# Java Task Tracker CLI

A simple command-line to-do list written in plain Java. Tasks are saved to a text file so they stay between runs.

## Features
- Add, list, complete and delete tasks
- Saves to `tasks.txt` automatically
- Input validation (empty text, bad ids)

## Concepts used
Classes and objects, `ArrayList`, file I/O (`BufferedReader` / `PrintWriter`), exception handling.

## Run
Requires JDK 11+.

```bash
mkdir out
javac -d out src/*.java
java -cp out Main
```

## Example
```
=== Task Tracker ===
1. Add task
2. List tasks
3. Mark task done
4. Delete task
5. Quit
Choose: 2
1. [x] Finish CA1 report
2. [ ] Apply for internship
```

## Project structure
```
src/
  Main.java         menu loop
  Task.java         one task
  TaskManager.java  list + file saving
```

## Possible improvements
- Due dates and priorities
- Edit a task
- Unit tests with JUnit
