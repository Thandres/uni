package aufgabe.fuenf;

import java.util.ArrayList;
import java.util.PriorityQueue;

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
    /// * TODO: e r g a e n z e n * /
  }
}
