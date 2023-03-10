package units;

import java.util.ArrayList;

public class Magican extends Mage {


    public Magican(int hp, int speed, int defense, int minDmg, int maxDmg, int mana, Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg, mana, team, point);

    }

    public Magican(int hp, int mana, Team team, Point2D point) {
        this(hp, 110, 30, -50, -50, mana, team, point);
    }

    public Magican(int mana, Team team, Point2D point) {
        this(100, mana, team, point);
    }

    public Magican(Team team, Point2D point){
        this(50 ,team, point);
    }


    @Override
    public String getInfo() {
        return "Маг ".concat(heroID)
                .concat(", hp: ")
                .concat(String.valueOf(currentHp))
                .concat(", mp: ")
                .concat(String.valueOf(mana));
    }


}
