package life.grass.grasscore.world.timeFlow;

import life.grass.grasscore.GrassCore;

public class TimeFlow {

    private int globalTime;

    public TimeFlow(){
        //DB(APIサーバー)からglobalTimeを取得
        globalTime = 0; //仮
    }

    public void proceedTime(){
        globalTime++;
        if(globalTime >= 10000){ //仮
            globalTime = 0;
        }
    }
}
