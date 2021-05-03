import java.util.Arrays;

public class RobotMoves {
    private String path;
    private int[][] matrix;
    private int row, column;
    private int rowNextStep, columnNextStep;
    private String output;

    public String comeBack(String path) {
        try {
            setPath(path);
            createMatrix(this.path);
            setRobotsLocation();
            move();
            checkRobotLocation();
            return output;
        } catch (NullPointerException e) {
            e.toString();
            return "Use just 'U', 'D', 'L', 'R' letters, please!";
        }
    }

    public String outputMatrix() {
        return Arrays.deepToString(matrix);
    }

    private void setPath(String path) {
        if (checkSymbols(path)) {
            this.path = path;
        }
    }

    private boolean checkSymbols(String path) {
        for (int i = 0; i < path.length(); i++) {
            int x = (int) path.charAt(i);
            if (x != 68 && x != 85 && x != 76 && x != 82) {
                return false;
            }
        }
        return true;
    }

    private void createMatrix(String input) {
        int row, column;
        row = path.length() * 2 + 1;
        column = path.length() * 2 + 1;
        this.matrix = new int[row][column];
    }

    private void setRobotsLocation() {
        this.row = matrix.length / 2;
        this.column = matrix.length / 2;
        matrix[row][column] = -1;
    }

    private void move() {
        for (int i = 0; i < path.length(); i++) {
            if (i == 0) {
                if (path.charAt(i) == 'L') {
                    rowNextStep = row;
                    columnNextStep = column - 1;
                    matrix[rowNextStep][columnNextStep] = i + 1;
                } else if (path.charAt(i) == 'R') {
                    rowNextStep = row;
                    columnNextStep = column + 1;
                    matrix[rowNextStep][columnNextStep] = i + 1;
                } else if (path.charAt(i) == 'U') {
                    rowNextStep = row - 1;
                    columnNextStep = column;
                    matrix[rowNextStep][columnNextStep] = i + 1;
                } else {
                    rowNextStep = row + 1;
                    columnNextStep = column;
                    matrix[rowNextStep][columnNextStep] = i + 1;
                }
            } else {
                if (path.charAt(i) == 'L') {
                    columnNextStep = columnNextStep - 1;
                    matrix[rowNextStep][columnNextStep] = i + 1;
                } else if (path.charAt(i) == 'R') {
                    columnNextStep = columnNextStep + 1;
                    matrix[rowNextStep][columnNextStep] = i + 1;
                } else if (path.charAt(i) == 'U') {
                    rowNextStep = rowNextStep - 1;
                    matrix[rowNextStep][columnNextStep] = i + 1;
                } else {
                    rowNextStep = rowNextStep + 1;
                    matrix[rowNextStep][columnNextStep] = i + 1;
                }
            }
        }
    }

    private void checkRobotLocation() {
        if (row == rowNextStep && column == columnNextStep) {
            output = "true";
        } else {
            output = "false";
        }
    }
}
