package life.grass.grasscore.fishing;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takah on 2016/09/08.
 */
public class FishingManager {

    private List<String> fitemlist = makefitemlist();
    private List<Double> ratiolist = makeratiolist();
    private List<Double> rsumlist = makersumlist();


    private List<String> makefitemlist() {
        List<String> list = new ArrayList<>();
        list.add("鶏肉");
        list.add("牛肉");
        list.add("牛肉のような何か");
        return list;
    }


    private ArrayList<Double> makeratiolist(){
        ArrayList<Double> list = new ArrayList<>();
        for(int i = 0 ; i < fitemlist.size() ; i++){
            list.add((double) i + 1);
        }
        return list;
        //とりあえずはテストのためにこのように記述。
        //実際はすべてのアイテムに対してgetRealratioによりrealratioを取得、リストに入れていきます。
    }
    private ArrayList<Double> makersumlist(){
        ArrayList<Double> list = new ArrayList<>();
        list.add(ratiolist.get(0));
        for(int i= 1; i < ratiolist.size() ; i++){
            list.add(list.get(i - 1) + ratiolist.get(i));
        }
        return list ;
    }

    public List<Double> getRatiolist() {
        return ratiolist;
    }

    public List<Double> getRsumlist() {
        return rsumlist;
    }

    public List<String> getFitemlist() {
        return fitemlist;
    }
}
