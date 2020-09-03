package aufgabe.fuenf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskScheduler {
  public static class Task implements Comparable {
    final int startTime;
    final int endTime;

    public Task(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    @Override
    public int compareTo(Object other) {
      Task t = (Task) other;
      if (this.startTime < t.startTime) return -1;
      else if (this.startTime > t.startTime) return 1;
      else return 0;
    }

    public boolean overlaps(Task other) {
      if (other.startTime >= endTime) return false;
      if (other.endTime <= startTime) return false;
      return true;
    }

    @Override
    public String toString() {
      return " ( " + startTime + " , " + endTime + " ) ";
    }
  }

  public static class Machine {
    ArrayList<Task> tasks;

    public Machine() {
      tasks = new ArrayList<Task>();
    }

    public void add(Task t) {
      tasks.add(t);
    }

    public boolean conflicts(Task other) {
      for (Task t : tasks) {
        if (t.overlaps(other)) return true;
      }
      return false;
    }

    @Override
    public String toString() {
      String result = "";
      for (var t : tasks) result += t.toString() + " ";
      return result;
    }
  }

  public static void main(String args[]) {
    var tasks = new PriorityQueue<Task>();
    var machines = new ArrayList<Machine>();
    Pattern pattern = Pattern.compile("\\d+");
    String input = "(1,3) (1,4) (2,5) (3,7) (4,7) (6,9) (7,8)";
    String[] inputs = input.split(" ");
    Arrays.stream(inputs)
            .map(s -> parseTask(s, pattern))
            .forEach(tasks::add);
    for (Task task : tasks) {
      machines.stream()
          .filter(machine -> !machine.conflicts(task))
          .findFirst()
          .ifPresentOrElse(
              machine -> machine.add(task),
              () -> {
                var newMachine = new Machine();
                newMachine.add(task);
                machines.add(newMachine);
              });
    }
    machines.forEach(
            System.out::println);
  }

  private static Task parseTask(String input, Pattern pattern) {
    Matcher matcher = pattern.matcher(input);
    matcher.find();
    String first = matcher.group();
    matcher.find();
    String second = matcher.group();
    return new Task(Integer.parseInt(first), Integer.parseInt(second));
  }
}
