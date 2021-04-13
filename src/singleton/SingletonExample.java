package singleton;

import java.util.concurrent.Executor;

public class SingletonExample {

    // If Single Thread
    public static class Printer {

        private static Printer printer = null;

        public static Printer getInstance() {
            if (printer == null) {
                printer = new Printer();
            }
            return printer;
        }

        private Printer() {}
    }

    // If Multi Thread - Use initialize static Printer
    public static class Printer_2 {
        private static Printer_2 printer = new Printer_2();
        private int counter = 0;

        public static Printer_2 getInstance() {
            return printer;
        }

        public void print(String str) {
            synchronized (this) {
                counter++;
                System.out.println(str + " counter : " + counter + " Instance :" + this.toString());
            }
        }

        private Printer_2() {}
    }

    public static class Printer_3 {
        private static Printer_3 printer = null;
        private int counter = 0;

        public static synchronized Printer_3 getInstance() {
            if (printer == null) {
                printer = new Printer_3();
            }
            return printer;
        }

        public void print(String str) {
            synchronized (this) {
                counter++;
                System.out.println(str + " counter : " + counter + " Instance :" + this.toString());
            }
        }

        private Printer_3() {}
    }


    public static void main(String[] args) {
        Runnable task = () -> {
            Printer_2 printer_2 = Printer_2.getInstance();
            printer_2.print("Print Thread - 1");
        };
        Runnable task2 = () -> {
            Printer_2 printer_2 = Printer_2.getInstance();
            printer_2.print("Print Thread - 2");
        };
        Runnable task3 = () -> {
            Printer_2 printer_2 = Printer_2.getInstance();
            printer_2.print("Print Thread - 3");
        };
        Runnable task4 = () -> {
            Printer_2 printer_2 = Printer_2.getInstance();
            printer_2.print("Print Thread - 4");
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        Thread thread4 = new Thread(task4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
