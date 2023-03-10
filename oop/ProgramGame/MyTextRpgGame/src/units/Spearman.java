package units;

public class Spearman extends Melee {


    public Spearman(int hp, int speed, int defense, int minDmg, int maxDmg, Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg, team, point);

    }

    public Spearman(int hp, Team team, Point2D point) {
        this(hp, 150, 50, 45, 50, team, point);
    }

    public Spearman(Team team, Point2D point) {
        this(250, team, point);
    }


    @Override
    public String getInfo() {
        return "Копейщик "
                .concat(heroID)
                .concat(", hp: ")
                .concat(String.valueOf(currentHp));
    }


}
