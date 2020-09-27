### Run application

1. Run `gradlew shadowJar` command to create `nordea-interview-task-1.0-SNAPSHOT-all` jar under `build\libs` directory.
2. To start parsing file run:

```
java -jar nordea-interview-task-1.0-SNAPSHOT-all.jar "inputFilePath" "outputFilePath"
example: java -jar nordea-interview-task-1.0-SNAPSHOT-all.jar "C:\Users\user\Desktop\small.in" "C:\Users\user\Desktop\small.xml"
```

### Remarks

For the sake of this task (and due to short time) I decided to make some simplifications
which need to be explained:

1. `CornerCases` class contains all edge cases which are not covered by `BreakIterator`.
In the next step I would like to move this class to some properties file to make it easier 
to configure.

2. `CsvWriter` is not 100% completed due to the fact that I found it difficult to create header row 
(could not find a way to edit first line of the file).
