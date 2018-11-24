package com.mfea.sudoku;

import java.util.*;

/**
 * Created by Kumaran on 11/21/2018.
 */
public class SudokuGA {

    int lengthSudoku = 9;

    public static void main(String[] args) {
        //int[] givenProblem = {1, 2, 0, 4, 5, 0, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 0, 0, 0, 0, 1, 2, 0, 0, 0, 6, 7, 0, 0, 0, 0, 0, 0, 0, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] givenProblem = {0, 0, 4, 3, 0, 0, 2, 0, 9, 0, 0, 5, 0, 0, 9, 0, 0, 1, 0, 7, 0, 0, 6, 0, 0, 4, 3, 0, 0, 6, 0, 0, 2, 0, 8, 7, 1, 9, 0, 0, 0, 7, 4, 0, 0, 0, 5, 0, 0, 8, 3, 0, 0, 0, 6, 0, 0, 0, 0, 0, 1, 0, 5, 0, 0, 3, 5, 0, 8, 6, 9, 0, 0, 4, 2, 9, 1, 0, 3, 0, 0};
        int[] givenProblem1 = {0,0,4,3,0,0,2,0,9,0,0,5,0,0,9,0,0,1,0,7,0,0,6,0,0,4,3,0,0,6,0,0,2,0,8,7,1,9,0,0,0,7,4,0,0,0,5,0,0,8,3,0,0,0,6,0,0,0,0,0,1,0,5,0,0,3,5,0,8,6,9,0,0,4,2,9,1,0,3,0,0};
       int[] givenProblem2 ={1,6,8,2,5,7,4,3,9,7,9,2,4,3,6,1,5,8,5,4,3,9,8,1,6,7,2,6,3,9,8,7,4,5,2,1,4,1,5,6,2,9,7,8,3,2,8,7,3,1,5,9,6,4,9,2,4,7,6,3,8,1,5,3,7,1,5,4,8,2,9,6,8,5,6,1,9,2,3,4,7};


        SudokuGAOperations sudokuGAOperations = new SudokuGAOperations();
        List<int[]> samples = sudokuGAOperations.generatePopulation(10000);

        List<int[]> currentPop =new ArrayList<>(samples) ;
        int iteration =0;
        while(iteration<1000){
            List<int[]> offSprings = sudokuGAOperations.generateOffSprings(currentPop, givenProblem2, 10000, 0.5, 0.3, 0.3);

            currentPop = new ArrayList<>(offSprings);

            System.out.println();
            iteration++;
        }




//        for(GenomeSudoku e:offspringPopWithFitness){
//            System.out.println(e.fitnessScore+" "+Arrays.toString(e.solution));
//        }


    }

}
