public class Levels {

    private ReadingLevelsFromFiles readingLevelsFromFiles;

    public Levels() {
        readingLevelsFromFiles = new ReadingLevelsFromFiles();
    }

    public int[][] nextLevel(int level) {
        int[][] desktop = null;

        try {
            switch (level) {
                case 1:
                    desktop = firstLevel();
                    break;
                case 2:
                    desktop = secondLevel();
                    break;
                case 3:
                    desktop = thirdLevel();
                    break;
                case 4:
                    desktop = readingLevelsFromFiles.nextLevelFromFile("src/levels/level4.sok");
                    break;
                case 5:
                    desktop = readingLevelsFromFiles.nextLevelFromFile("src/levels/level5.sok");
                    break;
                case 6:
                        desktop = readingLevelsFromFiles.nextLevelFromFile("src/levels/level6.sok");
                    break;
                default:
                    desktop = LevelsFromServer.getLevelFromServer(level);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }
        return desktop;
    }

    private int[][] firstLevel() {
        return new int[][]{
                {0, 0, 2, 2, 2, 0, 0, 0, 0, 0},
                {0, 0, 2, 4, 2, 0, 0, 0, 0, 0},
                {0, 0, 2, 3, 2, 2, 2, 2, 0, 0},
                {2, 2, 2, 5, 5, 3, 4, 2, 0, 0},
                {2, 4, 3, 5, 1, 2, 2, 2, 0, 0},
                {2, 2, 2, 2, 3, 2, 0, 0, 0, 0},
                {0, 0, 0, 2, 4, 2, 0, 0, 0, 0},
                {0, 0, 0, 2, 2, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }
    private int[][] secondLevel() {
        return new int[][] {
                {2, 2, 2, 2, 2, 0, 0, 0, 0, 0},
                {2, 1, 5, 5, 2, 0, 0, 0, 0, 0},
                {2, 5, 3, 3, 2, 0, 2, 2, 2, 0},
                {2, 5, 3, 5, 2, 0, 2, 4, 2, 0},
                {2, 2, 2, 5, 2, 2, 2, 4, 2, 0},
                {0, 2, 2, 5, 5, 5, 5, 4, 2, 0},
                {0, 2, 5, 5, 5, 2, 5, 5, 2, 0},
                {0, 2, 5, 5, 5, 2, 2, 2, 2, 0},
                {0, 2, 2, 2, 2, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }
    private int[][] thirdLevel() {
        return new int[][] {
                {0, 2, 2, 2, 2, 2, 2, 2, 0, 0},
                {0, 2, 5, 5, 5, 5, 5, 2, 2, 2},
                {2, 2, 3, 2, 2, 2, 5, 5, 5, 2},
                {2, 5, 1, 5, 3, 5, 5, 3, 5, 2},
                {2, 5, 4, 4, 2, 5, 3, 5, 2, 2},
                {2, 2, 4, 4, 2, 5, 5, 5, 2, 0},
                {0, 2, 2, 2, 2, 2, 2, 2, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }
}
