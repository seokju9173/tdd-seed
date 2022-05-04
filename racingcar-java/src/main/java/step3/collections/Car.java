package step3.collections;

public class Car {
    int number;
    String distance;

    public Car(int number, String distance){
        this.number = number;
        this.distance = distance;
    }

    public void setDistance(String distance){
        this.distance += distance;
    }
    public void printDistance(){
        System.out.println(distance);
    }
}
