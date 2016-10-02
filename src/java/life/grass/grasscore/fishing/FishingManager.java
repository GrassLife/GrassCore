package life.grass.grasscore.fishing;

import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.block.Biome;
import org.bukkit.entity.Weather;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by takah on 2016/09/08.
 */
public class FishingManager {

    private static List<FishableItem> fishList = makeItemList();
    private static HashMap<FishableItem, ItemStack> fitemMap = makeFitemMap();
    private static List<Double> failList = makeFailList();

    /*
    実装時はコンフィグからアイテムのリストを作る予定。
     */
    public static List<FishableItem> makeItemList() {
        List<FishableItem> list = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            list.add(new FishableItem(1));
        }
        return list;
    }

    public static HashMap<FishableItem, ItemStack> makeFitemMap(){
        HashMap<FishableItem, ItemStack> map = new HashMap<>();
        map.put(fishList.get(0), new ItemStack(Material.RAW_BEEF));
        map.put(fishList.get(1), new ItemStack(Material.RAW_CHICKEN));
        map.put(fishList.get(2), new ItemStack(Material.RAW_FISH));
        return map;
    }

    public static List<Double> makeFailList(){
        List<Double> list = new ArrayList<>();
        list.add(5.0);
        list.add(5.0);
        return list;
    }

    /*
    釣りをしているときのバイオームと天候などを渡してgetRealratioにより比取得して対応するindexに入れていきます。
     */
    public static ArrayList<Double> makeRatioList(Biome b, WeatherType w) {
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < fishList.size(); i++) {
            list.add(fishList.get(i).getRealratio(b, w));
        }
        return list;
    }

    /*
    リストを渡すと各々のインデックスまでの総和を要素に持つ比のリストを生成します
     */
    public static List<Double> makeSumList(List<Double> list) {
        List<Double> sumList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Double left = i == 0 ? 0.0 : sumList.get(i - 1);
            sumList.add(left + list.get(i));
        }
        return sumList;
    }

    /*
    比のリストを渡すとそれに従ってランダムなindexを返してくれます。
     */
    public static int probMaker(List<Double> list) {
        double random = Math.random() * list.get(list.size() - 1);
        System.out.println(random);
        int indexNumber = 0;
        for (int i = 0; i < list.size(); i++) {
            double left = i == 0 ? 0 : list.get(i - 1);
            if (random >= left && random < list.get(i)) {
                indexNumber = i;
            }
        }

        return indexNumber;
    }



    public static List<FishableItem> getFishList() {
        return fishList;
    }

    public static HashMap<FishableItem, ItemStack> getFitemMap() {
        return fitemMap;
    }
}
