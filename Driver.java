package driver;
import transport.Competing;
import transport.Transport;


    public abstract class Driver<T extends Transport & Competing> {
        private final String name;
        private final Character license;
        private Integer experience;

        private T drivenVehicle;

        protected Driver(String name, Character license, Integer experience) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Некорректные данные");
            } else {
                this.name = name;
            }
            if (license == null) {
                throw new IllegalArgumentException("Необходимо указать тип прав!");
            } else if (license != 'C' && license != 'B' && license != 'D') {
                throw new IllegalArgumentException("Необходимо указать тип прав!");
            } else {
                this.license = license;
            }
            setExperience(experience);
        }
        public String getName() {
            return name;
        }
        public Character getLicense() {
            return license;
        }
        public Integer getExperience() {
            return experience;
        }

        public T getDrivenVehicle() {
            return drivenVehicle;
        }

        public void setDrivenVehicle(T drivenVehicle) {
            this.drivenVehicle = drivenVehicle;
            drivenVehicle.setDriver(this);
        }

        public void setExperience(Integer experience) {
            if (experience == null || experience < 0) {
                throw new IllegalArgumentException("Некорректные данные");
            } else {
                this.experience = experience;
            }
        }
        public void start(T transport) {
            System.out.println(name + " запускает " + transport.getBrand());
        }
        public void stop(T transport) {
            System.out.println(name + " останавливает " + transport.getBrand());
        }
        public void refillCar(T transport) {
            System.out.println(name + " заправляет " + transport.getBrand());
        }
        public void printInfo() {
            if (drivenVehicle == null) {
                System.out.println("Водителю пока не назначен автомобиль");
            } else {

                        System.out.println("Водитель " + name + " управляет " + getDrivenVehicle().getBrand() +
                                ' ' + getDrivenVehicle().getModel() + " и будет участвовать в заезде");
            }
        }
    }
