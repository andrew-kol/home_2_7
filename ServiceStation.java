package transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation<T extends Transport & Competing> {
    private Queue<T> queue = new LinkedList<>();

    public void addVehicle(T vehicle) {
        if (vehicle instanceof Bus) {
            System.out.println("Автобус не нуждается в диагностике!");
        } else {
            queue.offer(vehicle);
        }
    }

    public void fixVehicle() {
        var vehicle = queue.peek();
        if (vehicle == null) return;
        if (!vehicle.passTechnicalInspection()) {
            System.out.println("Починили " + vehicle.getBrand() + ' ' + vehicle.getModel());
            vehicle.setInspected(true);
        }
        queue.poll();
    }
}
