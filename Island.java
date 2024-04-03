public class Island {
    public static Cell[][] cells;
    private int islandWidth;
    private int islandHeight;

    public Island (int width, int height) {
        islandWidth = width;
        islandHeight = height;

        cells = new Cell[islandWidth][islandHeight];
        for (int i = 0; i < islandWidth; i++) {
            for (int j = 0; j < islandHeight; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
        for (int i = 0; i < islandWidth; i++) {
            for (int j = 0; j < islandHeight; j++) {
                System.out.println();
                System.out.println();
                System.out.println("CELL["+i+"]["+j+"]");
                cells[i][j].reportStatus();
            }

        }
    }
    public static void main(String[] args){
    //the island size is temporary hardcoded

        Island theIsland = new Island(2, 2);

    }
}
