package runner;

import island.Island;

import static island.Island.cells;
import static org.apache.commons.lang3.math.NumberUtils.isDigits;

public class Main {

    private static final String ERROR_LOG = """
            Please, specify correct width and height of the Island.
            Expected values are integers above zero.""";

    public static void validateArgs(String[] args) {
        int argNumber = args.length;
        int heightParamIndex = 0;
        int widthParamIndex = 1;

        if ((argNumber < 2 || !isDigits(args[heightParamIndex]) || !isDigits(args[widthParamIndex]))) {

            showInfoAndQuit();
        }
    }

    private static void showInfoAndQuit() {
        System.out.println(ERROR_LOG);
        System.exit(1);
    }

    public static void main(String[] args) {
        int islandWidth;
        int islandHeight;

        validateArgs(args);
        islandWidth = Integer.parseInt(args[0]);
        islandHeight = Integer.parseInt(args[1]);

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
