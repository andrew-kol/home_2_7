package transport;

public class Sponsor {
    private final String name;
    private final int sum;

    public Sponsor(String name, int sum) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Неверные данные (имя)");
        } else {
            this.name = name;
        }
        if (sum <= 0) {
            throw new IllegalArgumentException("Неверные данные (сумма)");
        } else {
            this.sum = sum;
        }
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void sponsorRace(Transport vehicle) {
        vehicle.getSponsors().add(this);
    }
}
