package transport;

public class Mechanic<T extends Transport & Competing> {
    private final String name;
    private final String company;

    public Mechanic(String name, String company) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Неверные данные (имя)");
        } else {
            this.name = name;
        }
        if (company == null || company.isBlank()) {
            throw new IllegalArgumentException("Неверные данные (компания)");
        } else {
            this.company = name;
        }
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void fixVehicle(T vehicle) {
        if (vehicle.getMechanics().contains(this)) {
            System.out.println("Произведена починка");
            vehicle.setInspected(true);
        } else {
            throw new IllegalArgumentException("Механик не обслуживает данное транспортное средство");
        }
    }

    public void inspectVehicle(T vehicle) {
        vehicle.getMechanics().add(this);
    }
}
