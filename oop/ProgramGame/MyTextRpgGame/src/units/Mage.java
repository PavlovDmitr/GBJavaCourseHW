package units;

import java.util.ArrayList;

public class Mage extends BaseHero{
    int manaMax;
    int mana;
    int healCost = 5;

    protected Mage(int hp, int speed, int defense, int minDmg, int maxDmg, int mana, Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg, team, point);
        this.manaMax = mana;
        this.mana = mana;
    }

    @Override
    public void step(ArrayList<BaseHero> myTeam, ArrayList<BaseHero> enemyTeam) {
        BaseHero nearEnemy = myTeam.get(0);
        if (mana > healCost) {
            mana -= healCost;
            for (BaseHero enemy : myTeam) {
                if (enemy.status != HeroesStatus.DEAD && enemy.getCurrentHp() < enemy.maxHp &&
                        this.point.getDistance(enemy.getCoordinate()) < this.point.getDistance(nearEnemy.getCoordinate())) {
                    nearEnemy = enemy;
                }
            }
            if (nearEnemy.getCurrentHp() - minDmg >= nearEnemy.maxHp) nearEnemy.setCurrentHp(nearEnemy.maxHp);
            else nearEnemy.setCurrentHp(nearEnemy.getCurrentHp() - minDmg);


            if (nearEnemy.getCurrentHp() <= 0) {nearEnemy.setStatus(HeroesStatus.DEAD); System.out.println("SET DEAD \n");}
//            System.out.printf("%s target %s, heal %d \n", heroID, nearEnemy.heroID, maxDmg);
        }
    }

    @Override
    public String getInfo() {
        return null;
    }
}
