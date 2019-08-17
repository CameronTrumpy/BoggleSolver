import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


import static java.lang.Thread.sleep;

public class BoggleSolver {
    //Global variable declaration
    static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    static char[][] boggleBoard;


    static ArrayList<String> usedWords = new ArrayList<String>();
    static ArrayList<String> invalidWords = new ArrayList<String>();

    static ArrayList<ArrayList<Point>> wordPoints = new ArrayList<ArrayList<Point>>();
    static ArrayList<Point> currentPoints = new ArrayList<Point>();

    static final int M = 4, N = 4;
    static String inputText;
    static int x = 0;

    public BoggleSolver() throws AWTException {
    }


    //End of variable declaration



    public static void main(String[] args) throws NullPointerException, Exception {
        System.out.println("Build Finished");
        SwingWindow swingWindow = new SwingWindow();
        pauseGame(true);
        swingWindow.create();
        while (!swingWindow.getFinished()){
            System.out.println("waiting for input");
            sleep(1000);
        }
        initBoard(swingWindow.inputText);
        findWords(boggleBoard);
        System.out.println(usedWords);
        System.out.println(wordPoints);
        pauseGame(false);
        readPoints();
}

    //Functions section

    public static void userInput(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter board info");
        inputText = myObj.nextLine();  // Read user input;
    }

    public static void initBoard(String inputText) throws NullPointerException, IOException {
        String i = inputText;
        boggleBoard = new char[][]{
                {i.charAt(0), i.charAt(1), i.charAt(2), i.charAt(3)},
                {i.charAt(4), i.charAt(5), i.charAt(6), i.charAt(7)},
                {i.charAt(8), i.charAt(9), i.charAt(10), i.charAt(11)},
                {i.charAt(12), i.charAt(13), i.charAt(14),i.charAt(15)}};
    }

    public static void findWords(char[][] inputArray) throws IOException {
        {
            // Mark all characters as not visited
            boolean visited[][] = new boolean[M][N];

            // Initialize current string
            String str = "";


            // Consider every character and look for all words
            // starting with this character
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    findWordsUtil(boggleBoard, visited, i, j, str);
                }
            }
            }

    }

    public static void findWordsUtil(char boggle[][], boolean visited[][], int i, int j, String str) throws IOException {

        if(!dictIncludes(str)){
            invalidWords.add(str);

        }
        if(invalidWords.contains(str)){
            return;
        }
        // Mark current cell as visited and append current character
        // to str
        visited[i][j] = true;
        str = str + boggle[i][j];
        if(boggle[i][j] == 'q'){
            str = str + 'u';
        }
        currentPoints.add(new Point(i,j));
        System.out.println(".");
//        System.out.println(wordPoints);
        // System.out.println(str);
        // If str is present in dictionary, then print it
        //**********necessary if statement even if empty do not delete******
        if (dictCompare(str)) {
//            System.out.println(str);
//
//
//                x++;
//
//                System.out.println(x);

        }

        // Traverse 8 adjacent cells of boggle[i][j]
        for (int row = i - 1; row <= i + 1 && row < M; row++) {
            for (int col = j - 1; col <= j + 1 && col < N; col++){
                if (row >= 0 && col >= 0 && !visited[row][col]){
                    findWordsUtil(boggle, visited, row, col, str);
                }
            }
        }

        // Erase current character from string and mark visited
        // of current cell as false
        str = "" + str.charAt(str.length() - 1);
        currentPoints.remove(currentPoints.size() -1);
        visited[i][j] = false;
    }

    public static boolean dictCompare(String inputString) throws IOException {
            String filePath = "E:\\Java Projects\\BoggleSolver\\src\\Dictionary\\" +  inputString.substring(0, 1) + ".txt";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            if(st.equals(inputString)) {
                if(usedWords.contains(inputString)){
                    break;
                }

                usedWords.add(inputString);
                wordPoints.add(new ArrayList(currentPoints));

                return true;
            }

        }
        return false;
    }

    public static boolean dictIncludes(String inputString) throws IOException {
        String filePath;
        if(inputString == ""){
            filePath="E:\\Java Projects\\BoggleSolver\\src\\Dictionary\\a.txt";
        }
        else {
            filePath = "E:\\Java Projects\\BoggleSolver\\src\\Dictionary\\" + inputString.substring(0, 1) + ".txt";
        }
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            if(st.contains(inputString)) {
                return true;
            }

        }
        return false;
    }

    public static void readPoints() throws InterruptedException {
        for(int i = 0; i< wordPoints.size(); i++){
            for(int s = 0; s< wordPoints.get(i).size(); s++){
                keyboardController(wordPoints.get(i).get(s));
            }
            System.out.println(i);
//            sleep(15000);
            sleep(50);
            robot.keyPress('Y');
            sleep(200);
            robot.keyRelease('Y');
            sleep(50);
        }

    }

    public static void keyboardController(Point point) throws InterruptedException{
        int sleeptime = 1;
        switch((int) point.getX()){
            case(0): {
                switch ((int) point.getY()) {
                    case (0): {
                        robot.keyPress('A');
                        sleep(sleeptime);
                        robot.keyRelease('A');
                    }
                    break;
                    case (1): {
                        robot.keyPress('S');
                        sleep(sleeptime);
                        robot.keyRelease('S');
                    }
                    break;
                    case (2): {
                        robot.keyPress('D');
                        sleep(sleeptime);
                        robot.keyRelease('D');
                    }
                    break;
                    case (3): {
                        robot.keyPress('F');
                        sleep(sleeptime);
                        robot.keyRelease('F');
                    }
                    break;
                }
            }
            break;
            case(1):{
                switch ((int) point.getY()) {
                    case (0): {
                        robot.keyPress('G');
                        sleep(sleeptime);
                        robot.keyRelease('G');
                    }
                    break;
                    case (1): {
                        robot.keyPress('H');
                        sleep(sleeptime);
                        robot.keyRelease('H');
                    }
                    break;
                    case (2): {
                        robot.keyPress('J');
                        sleep(sleeptime);
                        robot.keyRelease('J');
                    }
                    break;
                    case (3): {
                        robot.keyPress('K');
                        sleep(sleeptime);
                        robot.keyRelease('K');
                    }
                    break;
                }
            }
            break;
            case(2):{
                switch ((int) point.getY()) {
                    case (0): {
                        robot.keyPress('Z');
                        sleep(sleeptime);
                        robot.keyRelease('Z');
                    }
                    break;
                    case (1): {
                        robot.keyPress('X');
                        sleep(sleeptime);
                        robot.keyRelease('X');
                    }
                    break;
                    case (2): {
                        robot.keyPress('C');
                        sleep(sleeptime);
                        robot.keyRelease('C');
                    }
                    break;
                    case (3): {
                        robot.keyPress('V');
                        sleep(sleeptime);
                        robot.keyRelease('V');
                    }
                    break;
                }
            }
            break;
            case(3):{
                switch ((int) point.getY()) {
                    case (0): {
                        robot.keyPress('B');
                        sleep(sleeptime);
                        robot.keyRelease('B');
                    }
                    break;
                    case (1): {
                        robot.keyPress('N');
                        sleep(sleeptime);
                        robot.keyRelease('N');
                    }
                    break;
                    case (2): {
                        robot.keyPress('M');
                        sleep(sleeptime);
                        robot.keyRelease('M');
                    }
                    break;
                    case (3): {
                        robot.keyPress('Q');
                        sleep(sleeptime);
                        robot.keyRelease('Q');
                    }
                    break;
                }
            }
            break;
        }
    }

    public static void pauseGame(Boolean paused) throws InterruptedException {
        if (paused){
            sleep(3000);
            robot.keyPress('P');
            sleep(100);
            robot.keyRelease('P');
            sleep(100);

        }
        else if(!paused){
            robot.keyPress('C');
            sleep(100);
            robot.keyRelease('C');
            sleep(500);
        }

    }

    //End of functions section
}

