package units;

import java.util.ArrayList;

public class Rouge extends Melee {


    public Rouge(int hp, int speed, int defense, int minDmg, int maxDmg,  Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg, team, point);
    }

    public Rouge(int hp, Team team, Point2D point) {
        this(hp, 250, 30, 30, 35, team, point);
    }

    public Rouge(Team team, Point2D point) {
        this(180, team, point);
    }


    @Override
    public String getInfo() {
        return "Разбойник ".concat(heroID)
                .concat(", hp: ")
                .concat(String.valueOf(currentHp));
    }


}
