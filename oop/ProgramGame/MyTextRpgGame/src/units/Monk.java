package units;

import java.util.ArrayList;

public class Monk extends Mage {

    public Monk(int hp, int speed, int defense, int minDmg, int maxDmg, int mana, Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg, mana, team, point);

    }
    public Monk(int hp, int mana, Team team, Point2D point) {
        this(hp, 120, 30, -45, -45, mana, team, point);
    }
    public Monk(int mana, Team team, Point2D point) {
        this(180, mana, team, point);
    }
    public Monk(Team team, Point2D point){
        this(60, team, point);
    }

    @Override
    public String getInfo() {
        return "Монах ".concat(heroID)
                .concat(", hp: ")
                .concat(String.valueOf(currentHp))
                .concat(", mp: ")
                .concat(String.valueOf(mana));
    }


}
