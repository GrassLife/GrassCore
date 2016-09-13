package life.grass.grasscore.fishing;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takah on 2016/09/08.
 */
public class FishingManager {

    private List<String> fitemList = Makefitemlist();
    private List<Double> ratioList = Makeratiolist();
    private List<Double> rsumList = Makersumlist();


    private List<String> Makefitemlist() {
        List<String> list = new ArrayList<>();
        list.add("鶏肉");
        list.add("牛肉");
        list.add("牛肉のような何か");
        return list;
    }


    private ArrayList<Double> Makeratiolist(){
        ArrayList<Double> list = new ArrayList<>();
        for(int i = 0 ; i < fitemList.size() ; i++){
            list.add((double) i + 1);
        }
        return list;
        //とりあえずはテストのためにこのように記述。
        //実際はすべてのアイテムに対してgetRealratioによりrealratioを取得、リストに入れていきます。
    }
    private ArrayList<Double> Makersumlist(){
        ArrayList<Double> list = new ArrayList<>();
        list.add(ratioList.get(0));
        for(int i= 1; i < ratioList.size() ; i++){
            list.add(list.get(i - 1) + ratioList.get(i));
        }
        return list ;
    }

    public List<Double> getRatiolist() {
        return ratioList;
    }

    public List<Double> getRsumlist() {
        return rsumList;
    }

    public List<String> getFitemlist() {
        return fitemList;
    }
}
