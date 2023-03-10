package units;

import java.util.ArrayList;

public class Villager extends BaseHero {
    double attackRange = 2;
    private int delivery;
    int maxDelivery = 5;

    public Villager(int hp, int speed, int defense, int minDmg, int maxDmg, int delivery, Team team, Point2D point) {
        super(hp, speed, defense, minDmg, maxDmg, team, point);
        this.delivery = delivery;
    }

    public Villager(int hp, int delivery, Team team, Point2D point) {
        this(hp, 100, 10, 1, 2, delivery, team, point);

    }

    public Villager(int delivery, Team team, Point2D point) {
        this(80, delivery, team, point);
    }

    public Villager(Team team, Point2D point) {
        this(1, team, point);

    }

    @Override
    public String getInfo() {
        return "Крестьянин ".concat(heroID)
                .concat(", hp: ")
                .concat(String.valueOf(currentHp)
                        .concat(" backpack: ")
                        .concat(String.valueOf(delivery)));
    }

    @Override
    public void step(ArrayList<BaseHero> myTeam, ArrayList<BaseHero> enemyTeam) {
        BaseHero nearFriend = myTeam.get(0);
        for (BaseHero friend : myTeam){

            if (friend.getClass() == Archer.class || friend.getClass() == Crossbowman.class) nearFriend = friend;
        }
        if (this.delivery > 0 && (nearFriend instanceof Range)) {

            double rangeNearFriend = this.point.getDistance(nearFriend.getCoordinate());
            for (BaseHero friend : myTeam) {
                if (friend.status != HeroesStatus.DEAD &&
                        friend instanceof Range &&
                        this.point.getDistance(friend.getCoordinate()) < rangeNearFriend) {
                    nearFriend = friend;
                    rangeNearFriend = this.point.getDistance(nearFriend.getCoordinate());
                }
            }
            Range nearRangeFriend = (Range) nearFriend;
            if (rangeNearFriend <= attackRange) {
                if (nearRangeFriend.getShoots() < nearRangeFriend.getMaxShoots()) {
                    nearRangeFriend.setShoots(nearRangeFriend.getShoots()+1);
                    this.delivery--;
                }

            } else {

                if (Math.abs(nearFriend.getCoordinate().getPosX() - this.getCoordinate().getPosX()) > Math.abs(nearFriend.getCoordinate().getPosY() - this.getCoordinate().getPosY())) {
                    if (nearFriend.getCoordinate().getPosX() > this.getCoordinate().getPosX()) {
                        this.setCoordinate(this.getCoordinate().getPosX() + 1, this.getCoordinate().getPosY());
                    } else {
                        this.setCoordinate(this.getCoordinate().getPosX() - 1, this.getCoordinate().getPosY());
                    }
                } else {
                    if (nearFriend.getCoordinate().getPosY() > this.getCoordinate().getPosY()) {
                        this.setCoordinate(this.getCoordinate().getPosX(), this.getCoordinate().getPosY() + 1);
                    } else {
                        this.setCoordinate(this.getCoordinate().getPosX() - 1, this.getCoordinate().getPosY() - 1);
                    }
                }
            }
        }
        if (delivery < maxDelivery) delivery++;
    }
}
