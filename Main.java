import java.io.*;
import java.util.*;

interface IntervalCallback {
  void callback();
}

class Main {
  public static void main(String[] args) {
    Stack<Number> pacientes = new Stack<Number>();
    int fichaN = 0;
    interval(() -> {
      if (pacientes.size() > 0) {
        Number ficha = pacientes.remove(0);
        System.out.println("Vez da ficha " + String.valueOf(ficha));
      }
    }, 10000);
    while (true) {
      System.out.println("Pressione enter para pegar uma ficha");
      try {
        System.in.read(new byte[2]);
      } catch (IOException e) {
      }
      fichaN++;
      System.out.println("Você pegou a ficha " + String.valueOf(fichaN));
      pacientes.add(fichaN);
    }
  }

  public static void interval(IntervalCallback cb, int time) {
    new Timer().scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        cb.callback();
      }
    }, 0, time);
  }
}