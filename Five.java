package five;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Five {
    private final Queue<String> queue1 = new LinkedBlockingDeque<>(5);
    private final Queue<String> queue2 = new LinkedBlockingDeque<>(5);
    private Queue<String> queue3;

    private void fillQueue() {
        for (int i = 0; i < (int) (Math.random() * 10); i++) {
            addCustomer("Покупатель " + Integer.toString(i));
            System.out.println("Добавлен покупатель " + Integer.toString(i));
        }
    }

    private boolean addCustomer(String s) {
        try {
            if (queue1.size() < queue2.size()) {
                queue1.add(s);
            } else {
                queue2.add(s);
            }
            return true;
        } catch (IllegalStateException e) {
            if (queue3 == null) {
                System.out.println("Создаем новую очередь");
                queue3 = new LinkedBlockingDeque<>(5);
                queue3.add(s);
                return true;
            } else {
                try {
                    queue3.add(s);
                    return true;
                } catch (IllegalStateException ex) {
                    System.out.println("Больше нет места");
                    return false;
                }
            }
        }
    }

    private void delCustomer(Queue<String> queue, int n) {
        try {
            queue.poll();
            System.out.println("Удалено из очереди " + n);
        } catch (NullPointerException e) {
            System.out.println("Случайная очередь пуста");
        }

    }

    private void deleteRandomCustomer() {
        int numberQueue = (int) (Math.random() * 3);
        switch (numberQueue) {
            case 0:
                delCustomer(queue1, 1);
                break;
            case 1:
                delCustomer(queue2, 2);
                break;
            case 2:
                delCustomer(queue3, 3);
                break;
            default:
                throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        var five = new Five();
        Scanner in = new Scanner(System.in);
        five.fillQueue();
        while (true) {
            System.out.print("Введите 1, чтобы добавить покупателя: ");
            int num = in.nextInt();
            if (num == 1 && five.addCustomer("Новый покупатель")) {
                System.out.println("+1");
            } else break;
        }
        five.deleteRandomCustomer();
    }
}
