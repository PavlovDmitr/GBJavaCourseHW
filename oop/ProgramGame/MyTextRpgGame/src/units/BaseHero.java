package units;

import java.util.ArrayList;
import java.util.Random;


public abstract class BaseHero implements Interf {

    protected int attack;
    protected int defense;
    protected int minDmg;
    protected int maxDmg;
    protected int currentHp;
    protected int maxHp;
    protected int speed;
    protected String heroID;
    protected Team team;
    protected Point2D point;
    protected HeroesStatus status;


    /**
     * @param hp unit HP
     * @param speed unit Speed
     * @param defense
     * @param minDmg
     * @param maxDmg
     * @param team
     * @param point
     */
    public BaseHero(int hp, int speed, int defense, int minDmg, int maxDmg, Team team, Point2D point) {
        this.attack = 1;
        this.defense = defense;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.currentHp = hp;
        this.maxHp = hp;
        this.speed = speed;
        this.team = team;

        this.heroID = String.valueOf(HeroesNames.values()[new Random().nextInt(HeroesNames.values().length)]);
        this.point = point;
        status = HeroesStatus.STAND;
    }

    public BaseHero(Team team, Point2D point) {
        this(1, 1, 1, 1, 1, team, point);
    }

    public void healed(int heal) {
        this.currentHp = heal + this.currentHp > this.maxHp ? this.maxHp : heal + this.currentHp;
    }

    public void GetDamage(BaseHero Enemy) {
        int damage = Enemy.minDmg;
        if (this.defense - Enemy.attack > 0) {damage = Enemy.minDmg;}
        else if (this.defense - Enemy.attack == 0) { damage = (Enemy.minDmg + Enemy.maxDmg) /2; }
        else if (this.defense - Enemy.attack < 0) { damage = Enemy.maxDmg;  }


        if (this.currentHp - damage > 0) {
           if (this.currentHp - damage >= this.maxHp) this.currentHp = this.maxHp;
           else this.currentHp -= damage;
        }
        else if(this.currentHp - damage <= 0) {this.currentHp =0; status = HeroesStatus.DEAD; }
    }

    public int getSpeed() {
        return speed;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public String getName(){
        return this.heroID;
    }

    public Team getTeam() {
        return team;
    }

    public Point2D getCoordinate(){
        return point;
    }

    public void setCoordinate(int x, int y) {point = new Point2D(x,y);}

    public HeroesStatus getStatus(){
        return status;
    }
    public void setStatus(HeroesStatus status) {this.status = status;}

    public abstract void step(ArrayList<BaseHero> myTeam, ArrayList<BaseHero> enemyTeam);
}