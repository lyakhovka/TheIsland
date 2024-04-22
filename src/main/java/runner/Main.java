package runner;

import island.Island;

import static island.Island.cells;

public class Main {
    public static void main(String[] args) {
        int islandWidth;
        int islandHeight;
        try {
           islandWidth = Integer.parseInt(args[0]);
           islandHeight = Integer.parseInt(args[1]);
           if (islandWidth <= 0 || islandHeight <= 0){
               System.out.println("Please, specify correct width and height of the Island. Expected values are integers above zero.");
               return;
           }
       } catch (NumberFormatException e){
           System.out.println("Please, specify correct width and height of the Island. Expected values are integers above zero.");
           return;
       }



//        int islandWidth = 3;
//        int islandHeight = 3;

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
