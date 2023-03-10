package units;

public class Crossbowman extends Range {


    public Crossbowman(int hp, int speed, int defens, int minDmg, int maxDmg, int shoots, Team team, Point2D point) {
        super(hp, speed, defens, minDmg, maxDmg,shoots, team, point);

    }

    public Crossbowman(int hp, int shoots, Team team, Point2D point) {
        this(hp, 150, 30, 40, 50, shoots, team, point);
        
    }

    public Crossbowman(int shoots, Team team, Point2D point) {
        this(200, shoots, team, point);
    }

    public Crossbowman(Team team, Point2D point){
        this(40, team, point);
    }


    @Override
    public String getInfo() {
        return "Арбалетчик ".concat(heroID)
                .concat(", hp: ")
                .concat(String.valueOf(currentHp))
                .concat(", arrow: ")
                .concat(String.valueOf(shoots));
    }


}
