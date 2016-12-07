package life.grass.grasscore.world.environment;

import life.grass.grasscore.world.timeFlow.TimeFlow;

import static java.lang.Math.sin;

public class Temperature {
    private int[][] compTemp;

    public Temperature(TimeFlow timeFlow){
        compTemp = new int[4][4];
        int t = timeFlow.getGlobalTime();
        /*
        温度の圧縮座標をセットする
         */
    }

    public int getTemperature(final int x, final int y){
        return 0;   //バイリニア補間
    }
}
