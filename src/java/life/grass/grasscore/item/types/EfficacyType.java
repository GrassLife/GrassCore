package life.grass.grasscore.item.types;

/**
 * Created by Ecila on 2016/09/03.
 */
public enum EfficacyType {
    //料理
    DELICIOUS("おいしい", "まずい"),
    GREASY("こってり", "あっさり"),
    HEALTHY("健康的", "不健康"),
    SALTY("しょっぱい", null),
    SEA_FOOD("海の幸", "山の幸"),
    SOUR("酸っぱい", null),
    SPICY("辛い", null),
    SWEET("甘い", "苦い"),
    //製作
    BLOWING("打撃力", null),
    BREATHABIKITY("通気性", null),
    ELASTICITY("伸縮性", null),
    FIRE_BIAS("火属性" , "氷属性"),
    FIRE_RESISTANT("火耐性", null),
    HARDNESS("硬さ", "もろさ"),
    HEAVINESS("重さ","軽さ"),
    SHARPNESS("鋭さ", null),
    SLASHING("斬撃力", null),
    STRENGTH("強度", null),
    SUPPLENESS("しなやかさ", null),
    WATER_RESISTANT("水耐性", null);

    private final String positive;
    private final String negative;

    EfficacyType(String positive, String negative) {
        this.positive = positive;
        this.negative = negative;
    }

    public String getPositive() {
        return positive;
    }

    public String getNegative() {
        return negative;
    }
}
