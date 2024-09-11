package application;

public class Program {

    public static void main(String[] args) {
        // you can test your classes here:
        Sensor kumpila = new TemperatureSensor();
        Sensor kaisaniemi = new TemperatureSensor();
        Sensor helsinkiVantaaAirport = new TemperatureSensor();

        AverageSensor helsinkiRegion = new AverageSensor();
        helsinkiRegion.addSensor(kumpila);
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(helsinkiVantaaAirport);
        
        helsinkiRegion.setOn();
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degree Celsius");
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degree Celsius");
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degree Celsius");
        
        System.out.println("readings: "  +  helsinkiRegion.readings());
    }

}
