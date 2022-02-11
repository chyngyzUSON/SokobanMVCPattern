public class Model {
    private Sound sound = new Sound();
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;
    private Levels levels;
    private int[][] arrayIndexesGoals;
    private int level;

    public Model(Viewer viewer) {
        level = 1;
        this.viewer = viewer;
        levels = new Levels();
        desktop = levels.nextLevel(level);
        initialization();
    }

    private void initialization() {
        initArrayIndexesGoals(desktop);
        initArrayIndexesGamer(desktop);
        sound.play(sound.load("/music/startup.wav"));
    }

    public void doAction(String command) {
        switch (command) {
            case "Restart":
                getNextLevel(level);
                break;
            case "Undo":
//                getNextLevel(level);
                break;
            case "Level 1":
                getNextLevel(1);
                level = 1;
                break;
            case "Level 2":
                getNextLevel(2);
                level = 2;
                break;
            case "Level 3":
                getNextLevel(3);
                level = 3;
                break;
            case "Level 4":
                getNextLevel(4);
                level = 4;
                break;
            case "Level 5":
                getNextLevel(5);
                level = 5;
                break;
            case "Level 6":
                getNextLevel(6);
                level = 6;
                break;
            case "Level 7":
                getNextLevel(7);
                level = 7;
                break;
            case "Level 8":
                getNextLevel(8);
                level = 8;
                break;
            case "Level 9":
                getNextLevel(9);
                level = 9;
                break;
            default:
        }
    }

    public void move(String direction) {
        if (direction.equals("Up")) {
            moveUp();
        } else if (direction.equals("Right")) {
            moveRight();
        } else if (direction.equals("Down")) {
            moveDown();
        } else if (direction.equals("Left")) {
            moveLeft();
        }
        checkGoal();
        viewer.update();
        won();
    }

    private void checkGoal() {
        int x;
        int y;
        for (int i = 0; i < arrayIndexesGoals.length; i++) {
            x = arrayIndexesGoals[i][0];
            y = arrayIndexesGoals[i][1];
            if (desktop[x][y] == 5) {
                desktop[x][y] = 4;
                break;
            }
        }
    }

    private void won() {
        boolean isWon = true;
        int x;
        int y;
        for (int i = 0; i < arrayIndexesGoals.length; i++) {
            x = arrayIndexesGoals[i][0];
            y = arrayIndexesGoals[i][1];
            if (desktop[x][y] != 3) {
                isWon = false;
                break;
            }
        }
        if (isWon) {
            viewer.showDialogWon();
            sound.play(sound.load("/music/fanfare.wav"));
            level = level + 1;
            getNextLevel(level);
            viewer.update();
        }
    }

    private void getNextLevel(int numberLevel) {
        try {
            desktop = levels.nextLevel(numberLevel);
        } catch (Exception e) {
            return;
        }
        viewer.update();
        initArrayIndexesGamer(desktop);
        initArrayIndexesGoals(desktop);
    }

    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 5 || desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 5;
                desktop[indexX - 2][indexY] = 3;
            }
        }

        if (desktop[indexX - 1][indexY] == 5 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 5;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
            sound.play(sound.load("/music/move.wav"));

        }
    }

    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 5 || desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 5;
                desktop[indexX][indexY + 2] = 3;
            }
        }

        if (desktop[indexX][indexY + 1] == 5 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 5;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
            sound.play(sound.load("/music/move.wav"));
        }
    }

    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 5 || desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 5;
                desktop[indexX + 2][indexY] = 3;
            }
        }

        if (desktop[indexX + 1][indexY] == 5 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 5;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
            sound.play(sound.load("/music/move.wav"));
        }
    }

    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 5 || desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 5;
                desktop[indexX][indexY - 2] = 3;
            }
        }
        if (desktop[indexX][indexY - 1] == 5 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 5;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
            sound.play(sound.load("/music/move.wav"));
        }
    }

    public int[][] getDesktop() {
        return desktop;
    }

    private void initArrayIndexesGoals(int[][] desktop) {
        int size = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 4) {
                    size = size + 1;
                }
            }
        }

        arrayIndexesGoals = new int[size][];
        int[] temp;
        int index = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 4) {
                    temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    arrayIndexesGoals[index] = temp;
                    index++;
                }
            }
        }
    }

    private void initArrayIndexesGamer(int[][] desktop) {
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    indexX = i;
                    indexY = j;
                    this.desktop[indexX][indexY] = 1;
                    return;
                }
            }
        }
    }
}
