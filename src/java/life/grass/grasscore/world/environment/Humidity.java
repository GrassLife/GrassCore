package life.grass.grasscore.world.environment;

import life.grass.grasscore.world.timeFlow.TimeFlow;

import static java.lang.Math.sin;

public class Humidity {
    private int[][] compHumi;

    public Humidity(TimeFlow timeFlow){
        compHumi = new int[4][4];
        int t = timeFlow.getGlobalTime();
        /*
        湿度の圧縮座標をセットする
         */
    }

    public int getHumidity(int x, int y){
        return 0;   //バイリニア補間
    }
}
