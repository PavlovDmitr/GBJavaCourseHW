package units;

import java.util.ArrayList;

public class Melee extends BaseHero {
    double attackRange = 1.5;

    protected Melee(int hp, int speed, int defense, int minDmg, int maxDmg, Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg, team, point);
    }

    @Override
    public void step(ArrayList<BaseHero> myTeam, ArrayList<BaseHero> enemyTeam) {
        BaseHero nearEnemy = enemyTeam.get(0);
        double rangeNearEnemy = this.point.getDistance(nearEnemy.getCoordinate());
        for (BaseHero enemy: enemyTeam) {
            if (enemy.status != HeroesStatus.DEAD &&
                    this.point.getDistance(enemy.getCoordinate()) < rangeNearEnemy){
                nearEnemy = enemy;
                rangeNearEnemy = this.point.getDistance(nearEnemy.getCoordinate());
            }
        }
        if (rangeNearEnemy <= attackRange) {
            if (nearEnemy.defense - attack > 0) nearEnemy.setCurrentHp(nearEnemy.getCurrentHp() - minDmg);
            else if (nearEnemy.defense - attack < 0) nearEnemy.setCurrentHp(nearEnemy.getCurrentHp() - maxDmg);
                else nearEnemy.setCurrentHp(nearEnemy.getCurrentHp() - (maxDmg + minDmg) / 2);
            if (nearEnemy.getCurrentHp() <= 0) {
                nearEnemy.setCurrentHp(0);
                nearEnemy.setStatus(HeroesStatus.DEAD);
                System.out.printf("%s DEAD \n", nearEnemy.heroID);
            }
        }
        else {

            if (Math.abs(nearEnemy.getCoordinate().getPosX() - this.getCoordinate().getPosX()) > Math.abs(nearEnemy.getCoordinate().getPosY() - this.getCoordinate().getPosY())) {
                if (nearEnemy.getCoordinate().getPosX() > this.getCoordinate().getPosX()) {
                    this.setCoordinate(this.getCoordinate().getPosX() + 1, this.getCoordinate().getPosY());
                } else {
                    this.setCoordinate(this.getCoordinate().getPosX() - 1, this.getCoordinate().getPosY());
                }
            } else {
                if (nearEnemy.getCoordinate().getPosY() > this.getCoordinate().getPosY()) {
                    this.setCoordinate(this.getCoordinate().getPosX(), this.getCoordinate().getPosY() + 1);
                } else {
                    this.setCoordinate(this.getCoordinate().getPosX() - 1, this.getCoordinate().getPosY() - 1);
                }
            }
        }
//        System.out.printf("%s target %s damage 0! \n", heroID, nearEnemy.heroID);
        if (this.point.getDistance(nearEnemy.getCoordinate()) < 2) {

        }
        if (nearEnemy.getCurrentHp() <=0) nearEnemy.setStatus(HeroesStatus.DEAD);

    }

    @Override
    public String getInfo() {
        return null;
    }

}
