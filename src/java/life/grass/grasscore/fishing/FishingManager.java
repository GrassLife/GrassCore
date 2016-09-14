package life.grass.grasscore.fishing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takah on 2016/09/08.
 */
public class FishingManager {

    private static List<String> fitemList = makeItemList();
    private static List<Double> ratioList = makeRatioList();
    private static List<Double> rsumList = makeSumList(ratioList);

    //実装時はコンフィグからアイテムのリストを作る予定。
    public  static List<String> makeItemList() {
        List<String> list = new ArrayList<>();
        list.add("鶏肉");
        list.add("牛肉");
        list.add("牛肉のような何か");
        return list;
    }

    //実装時には釣りをしているときのバイオームと天候などを渡してgetRealratioにより比取得して対応するindexに入れていきます。
    public static ArrayList<Double> makeRatioList(){
        ArrayList<Double> list = new ArrayList<>();
        list.add(7.0);
        list.add(2.0);
        list.add(1.0);
        return list;
    }
    //リストを渡すと各々のインデックスまでの総和を要素に持つ比のリストを生成します
    public static List<Double> makeSumList(List<Double> list){
        List<Double> sumList = new ArrayList<>();
        for(int i= 0; i < list.size() ; i++){
            Double left = i == 0? 0.0: sumList.get(i - 1);
            sumList.add(left + list.get(i));
        }
        return sumList ;
    }
    //比のリストを渡すとそれに従ってランダムなindexを返してくれます。
    public static int probMaker( List<Double> list){
        double random = Math.random() * list.get(list.size() - 1);
        System.out.println(random);
        int indexNumber = 0;
        for(int i = 0 ; i < list.size() ; i++){
            double left = i == 0? 0: list.get(i - 1);
            if(random >= left && random < list.get(i) ){
                indexNumber = i;
            }
        }

        return indexNumber;
    }

    public static List<Double> getRatioList() {
        return ratioList;
    }

    public static List<Double> getRsumList() {
        return rsumList;
    }

    public static List<String> getFitemList() {
        return fitemList;
    }
}
