package units;

import java.util.ArrayList;

public interface Interf {

    void step(ArrayList<BaseHero> myTeam, ArrayList<BaseHero> enemyTeam);
    String getInfo();
}
