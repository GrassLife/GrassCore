package life.grass.grasscore.world;

import life.grass.grasscore.world.environment.Humidity;
import life.grass.grasscore.world.environment.Temperature;
import life.grass.grasscore.world.timeFlow.TimeFlow;

public class WorldEnvironment {
    public TimeFlow timeFlow;
    public Temperature temperature;
    public Humidity humidity;

    public WorldEnvironment(){
        timeFlow = new TimeFlow();
        temperature = new Temperature(timeFlow);
        humidity = new Humidity(timeFlow);
    }
}
