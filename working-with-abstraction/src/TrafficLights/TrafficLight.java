package TrafficLights;

public enum TrafficLight {
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private String light;

    TrafficLight(String light) {
        this.light = light;
    }

    public String getLight() {
        return light;
    }
}
