import java.util.*;

import units.*;


public class Main {

    public static ArrayList<BaseHero> team1 = new ArrayList<>();
    public static ArrayList<BaseHero> team2 = new ArrayList<>();
    public static ArrayList<BaseHero> fight = new ArrayList<>();
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.print("Press Enter to begin.");
        user_input.nextLine();
        team1.addAll(createTeam(Team.RED));
        team2.addAll(createTeam(Team.BLUE));

        fight.addAll(team1);
        fight.addAll(team2);
        int team1DeadCount = 0;
        int team2DeadCount = 0;

        fight.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2){
                return o2.getSpeed() - o1.getSpeed();
            }
        });


        boolean trigger = true;
        while (trigger) {
            View.view();
            team1DeadCount = 0;
            user_input.nextLine();
            for (BaseHero fighter: team1)
            {
                if (fighter.getStatus() == HeroesStatus.DEAD) {
                    team1DeadCount++;
                }
            }
            team2DeadCount = 0;
            for (BaseHero fighter2: team2)
            {
                if (fighter2.getStatus() == HeroesStatus.DEAD) {
                    team2DeadCount++;
                }
            }
            System.out.printf("RED Team DEAD - %d : BLUE Team DEAD - %d \n", team1DeadCount, team2DeadCount);
            if (team1DeadCount < team1.toArray().length){
                if (team2DeadCount < team2.toArray().length) {
                    for (BaseHero fighter : fight) {
                        if (fighter.getStatus() != HeroesStatus.DEAD) {
                            if (fighter.getTeam() == Team.RED) fighter.step(team1, team2);
                            else fighter.step(team2, team1);
                        }
                    }
                } else {trigger = false; View.finish("Team RED");}
            } else {trigger = false; View.finish("Team BLUE");}


        }


    }
    public static ArrayList<BaseHero> createTeam(Team teamSide) {
        ArrayList<BaseHero> team = new ArrayList<>();
        int y = 9;
        if (teamSide == Team.RED) y = 1;
        int teamsUnitsCount = 11;
        for (int i = 1; i < teamsUnitsCount; i++) {
            switch (new Random().nextInt(1,8)) {
                case 1:
                    team.add(new Magican(teamSide, new Point2D(i, y)));
                    break;
                case 2:
                    team.add(new Crossbowman(teamSide, new Point2D(i, y)));
                    break;
                case 3:
                    team.add(new Archer(teamSide, new Point2D(i, y)));
                    break;
                case 4:
                    team.add(new Monk(teamSide, new Point2D(i, y)));
                    break;
                case 5:
                    team.add(new Rouge(teamSide, new Point2D(i, y)));
                    break;
                case 6:
                    team.add(new Spearman(teamSide, new Point2D(i, y)));
                    break;
                case 7:
                    team.add(new Villager(teamSide, new Point2D(i, y)));
                    break;
            }
            
        }
        return team;
    }
}


