package island;

public class Island {
    public static Cell[][] cells;
    private static int islandWidth;
    private static int islandHeight;

    public static int getIslandWidth() {
        return islandWidth;
    }

    public static int getIslandHeight() {
        return islandHeight;
    }

    public Island(int width, int height) {
        islandWidth = width;
        islandHeight = height;

        cells = new Cell[islandWidth][islandHeight];
        for (int i = 0; i < islandWidth; i++) {
            for (int j = 0; j < islandHeight; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        System.out.println("\n******************************************************************* ISLAND INITIALIZED *****************************************************************");
        for (int i = 0; i < islandWidth; i++) {
            for (int j = 0; j < islandHeight; j++) {
                cells[i][j].reportStatus();
            }
        }
    }

    public boolean isEnaughAnimals() {
        int totalAnimalsCount = 0;
        for (int i = 0; i < islandWidth; i++) {
            for (int j = 0; j < islandHeight; j++) {
                totalAnimalsCount = totalAnimalsCount + cells[i][j].animalsInCell.size();
            }
        }
        System.out.println("\n------------------------------------------------------------------- TOTAL ISLAND ANIMALS COUNT: " + totalAnimalsCount + "---------------------------------------");
        return totalAnimalsCount > 0;
    }

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
            for (int i = 0; i < theIsland.islandWidth; i++) {
                for (int j = 0; j < theIsland.islandHeight; j++) {
                    cells[i][j].lifeRound();
                    cells[i][j].reportStatus();
                }
            }
            roundNumber++;
        }

    }
}
