package units;

import java.util.ArrayList;

public class Range extends BaseHero{

    int shoots;
    int maxShoots;
    protected Range(int hp, int speed, int defense, int minDmg, int maxDmg, int shoots, Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg, team, point);
        this.shoots = shoots;
        this.maxShoots = shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> myTeam, ArrayList<BaseHero> enemyTeam) {

        BaseHero nearEnemy = enemyTeam.get(0);
        if (shoots >=1) {

            for (BaseHero enemy : enemyTeam) {
                if (enemy.getStatus() != HeroesStatus.DEAD &&
                        this.point.getDistance(enemy.getCoordinate()) < this.point.getDistance(nearEnemy.getCoordinate())) {
                    nearEnemy = enemy;
                }
            }
            if (nearEnemy.getStatus() != HeroesStatus.DEAD) {
                this.shoots -= 1;
                if (nearEnemy.defense - attack > 0) nearEnemy.setCurrentHp(nearEnemy.getCurrentHp() - minDmg);
                else if (nearEnemy.defense - attack < 0) nearEnemy.setCurrentHp(nearEnemy.getCurrentHp() - maxDmg);
                else nearEnemy.setCurrentHp(nearEnemy.getCurrentHp() - (maxDmg + minDmg) / 2);
                if (nearEnemy.getCurrentHp() <= 0) {
                    nearEnemy.setCurrentHp(0);
                    nearEnemy.setStatus(HeroesStatus.DEAD);
                    System.out.printf("%s DEAD \n", nearEnemy.heroID);
                }
//                System.out.printf("%s target %s, dmg %d \n", heroID, nearEnemy.heroID, maxDmg);
            }
        }

    }

    public int getShoots() {
        return shoots;
    }

    public void setShoots(int shoots) {
        this.shoots = shoots;
    }

    public int getMaxShoots(){
        return maxShoots;
    }


    @Override
    public String getInfo() {
        return null;
    }
}
