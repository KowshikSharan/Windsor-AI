package com.mfea.ea;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kumaran on 11/24/2018.
 */
public class SudokuTask extends Task {

    int[] givenProblem;

    public SudokuTask(int[] givenProblem) {
        this.givenProblem = givenProblem;
    }

    @Override
    public int[] getGivenProblem() {
        return givenProblem;
    }

    @Override
    public void setGivenProblem(int[] givenProblem) {
        this.givenProblem = givenProblem;
    }

    @Override
    public int computeFitness(List<Integer> ind, int[] givenProblem) {

        int[] randomSolution = new int[81];

        randomSolution = ind.stream().mapToInt(k -> k).toArray();
        int fitness = 0;
        int[] boxIndex = {0, 3, 6, 27, 30, 33, 54, 57, 60};
        int[][] sudoku = transformSolution(randomSolution);
        for (int i = 0; i < 9; i++) {

            int[] box = getOneBox(randomSolution, boxIndex[i]);
            int[] oneSolutionRow = new int[9];
            for (int j = 0; j < 9; j++) {
                oneSolutionRow[j] = sudoku[i][j];
            }

            fitness += checkSuitableSolution(oneSolutionRow);

            int[] oneSolutionCol = new int[9];
            for (int j = 0; j < 9; j++) {
                oneSolutionCol[j] = sudoku[j][i];
            }
            fitness += checkSuitableSolution(oneSolutionCol);


        }

        fitness += compareSolWithGiven(randomSolution, givenProblem);
        return fitness;
    }


    public int[] getOneBox(int[] solution, int i) {


        int[] currentBox = new int[9];

        for (int row = 0; row < 3; row++) {
            currentBox[row] = solution[i + row];

        }

        for (int row = 0; row < 3; row++) {
            currentBox[row + 3] = solution[i + row + 9];

        }

        for (int row = 0; row < 3; row++) {
            currentBox[row + 6] = solution[i + row + 18];

        }

        return currentBox;

    }


    public int[][] transformSolution(int[] solution) {

        int[][] transformedSolution = new int[9][9];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                transformedSolution[i][j] = solution[index];
                index++;
            }
        }

        return transformedSolution;
    }


    public int checkSuitableSolution(int[] solution) {

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            uniqueNumbers.add(solution[i]);
        }

        if (solution.length == uniqueNumbers.size()) {
            return 1;
        } else {
            return 0;
        }

    }


    public int compareSolWithGiven(int[] rand, int[] given) {
        int flag = 0;
        for (int i = 0; i < rand.length; i++) {
            if (rand[i] == given[i]) {
                flag++;
            }
        }
        return flag;
    }

    public int getLenGen(){
        return 9;
    }
}
