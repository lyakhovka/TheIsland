package runner;

import island.Island;

import static island.Island.cells;

public class Main {
    public static void main(String[] args) {
//        int islandWidth = Integer.parseInt(args[0]);
//        int islandHeight = Integer.parseInt(args[1]);

        int islandWidth = 3;
        int islandHeight = 3;

        Island theIsland = new Island(islandWidth, islandHeight);
        int roundNumber = 1;

        System.out.println("\n\n******************************************************************* LIFE BEGUN **********************************************************");
        while (theIsland.isEnaughAnimals()) {
            System.out.println("******************************************************************* ROUND " + roundNumber + " *************************************************************");
            for (int i = 0; i < Island.getIslandWidth(); i++) {
                for (int j = 0; j < Island.getIslandHeight(); j++) {
                    cells[i][j].lifeRound();
                    cells[i][j].reportStatus();
                }
            }
            roundNumber++;
        }

    }
}
