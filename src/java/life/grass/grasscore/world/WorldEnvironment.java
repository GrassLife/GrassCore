package life.grass.grasscore.world;

import life.grass.grasscore.world.timeFlow.TimeFlow;

public class WorldEnvironment {
    public TimeFlow timeFlow;

    public WorldEnvironment(){
        timeFlow = new TimeFlow();
    }
}
