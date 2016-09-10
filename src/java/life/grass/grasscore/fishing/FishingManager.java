package life.grass.grasscore.fishing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takah on 2016/09/08.
 */
public class FishingManager {

    private List<Integer> ratiolist = makeratiolist();
    private List<Integer> rsumlist = makersumlist();
    //リストに関してはだいぶ未完成です。


    private ArrayList<Integer> makeratiolist(){
        ArrayList <Integer> list = new ArrayList<>();
        return list;
        //とりあえずはテストのためにこのように記述。
        //実際はすべてのアイテムに対してgetRealratioによりrealratioを取得、リストに入れていきます。
    }
    private ArrayList<Integer> makersumlist(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i= 0; i < ratiolist.size() ; i++){
            list.add(list.get(i) + ratiolist.get(i));
        }
        return list ;
    }
}
