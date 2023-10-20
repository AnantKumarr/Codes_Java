import java.util.ArrayList;
import java.util.Collections;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Car implements Comparable<Car> {
    private String carname;
    private String launchdate;
    private int price;

    public Car(String carname, String launchdate, int price) {
        this.carname = carname;
        this.launchdate = launchdate;
        this.price = price;
    }

    public String getCarname() {
        return carname;
    }

    public String getLaunchdate() {
        return launchdate;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Car other) {
        // Comparison based on brand name
        return this.carname.compareTo(other.carname);
    }

     static class LaunchDateComparator implements Comparable<Car> {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        
        public int compareTo(Car car1, Car car2) {
            try {
                Date date1 = dateFormat.parse(car1.launchdate);
                Date date2 = dateFormat.parse(car2.launchdate);
                return date1.compareTo(date2);
            } catch (ParseException e) {
                // Handle date parsing error
                return 0;
            }
        }
    }
}

class CarSortingExample {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Toyota Corolla", "15/01/20", 25000));
        cars.add(new Car("Honda Civic", "10/08/21", 28000));
        cars.add(new Car("Ford Mustang", "20/03/19", 55000));
        cars.add(new Car("Volkswagen Jetta", "05/06/18", 30000));
        cars.add(new Car("BMW X5", "03/11/22", 70000));

        // Sort by brand name
        Collections.sort(cars);
        System.out.println("Sorted by Brand Name:");
        for (Car car : cars) {
            System.out.println(car.getCarname());
        }

        // Sort by launch date
        Collections.sort(cars, new Car.LaunchDateComparator());
        System.out.println("\nSorted by Launch Date (Ascending):");
        for (Car car : cars) {
            System.out.println(car.getLaunchdate());
        }

        // Sort by model name (extracted from carname)
        Collections.sort(cars, (car1, car2) -> {
            String model1 = car1.getCarname().split(" ")[1];
            String model2 = car2.getCarname().split(" ")[1];
            return model1.compareTo(model2);
        });
        System.out.println("\nSorted by Model Name:");
        for (Car car : cars) {
            System.out.println(car.getCarname());
        }

        // Sort by price in reverse order
        Collections.sort(cars, (car1, car2) -> car2.getPrice() - car1.getPrice());
        System.out.println("\nSorted by Price (Descending):");
        for (Car car : cars) {
            System.out.println(car.getPrice());
        }
    }
}
