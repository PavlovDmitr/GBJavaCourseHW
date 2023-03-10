package units;

public class Archer extends Range {

    public Archer(int hp, int speed, int defense, int minDmg, int maxDmg, int shoots, Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg,shoots, team, point);
    }

    public Archer(int hp, int shoots, Team team, Point2D point) {
        this(hp, 200, 20, 30, 35, shoots, team, point);
    }

    public Archer(int shoots, Team team, Point2D point) {
        this(150, shoots, team, point);
    }

    public Archer(Team team, Point2D point){
        this(50,team, point);

    }

    @Override
    public String getInfo() {
        return "Лучник ".concat(heroID)
                .concat(", hp: ")
                .concat(String.valueOf(currentHp))
                .concat(", arrow: ")
                .concat(String.valueOf(shoots));
    }


}
