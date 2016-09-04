package life.grass.grasscore.item.tags;

import life.grass.grasscore.item.type.WeaponType;

/**
 * Created by Ecila on 2016/09/04.
 */
public class Weapon implements ItemTag {
    private int basicDamage;
    private int magicDamage;
    private int condition;
    private double attackSpeed;
    private WeaponType type;

    public int getBasicDamage() {
        return basicDamage;
    }

    public void setBasicDamage(int basicDamage) {
        this.basicDamage = basicDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    @Override
    public String toJson() {
        return null;
    }
}
