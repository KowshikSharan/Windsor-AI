package com.mfea.sudoku;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Kumaran on 11/21/2018.
 */
public class SudokuGAOperations {

    public List<int[]> generatePopulation(int numPop) {

        List<int[]> population = new ArrayList<>();

        ArrayList<Integer> gene = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            gene.add(new Integer(i));
        }



        for (int i = 0; i < numPop; i++) {
            List<Integer> chromosome = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                Collections.shuffle(gene);
                chromosome.addAll(gene);
            }
            int[] newSolution = new int[81];

            newSolution = chromosome.stream().mapToInt(k -> k).toArray();

            population.add(newSolution);
        }
        return population;
    }


    public List<int[]> mutate(List<int[]> population, int popSize, double mutationRate) {
        List<int[]> mutatedPop = new ArrayList<>();
        Random random = new Random();

        double mutatePointCount = 81 * mutationRate;
        int mutatePoints = (int) mutatePointCount;
        for (int i = 0; i < popSize; i++) {
            int[] parent = population.get(random.nextInt(population.size()));
            int[] mutationPoints = random.ints(mutatePoints, 0, 80).toArray();
            for (int j = 0; j < 5; j++) {
                int temp;

                temp = parent[8-j];
                parent[8-j] = parent[j];
                parent[j] = temp;
//                parent[mutationPoints[j]] = ThreadLocalRandom.current().nextInt(1, 10);
            }
            mutatedPop.add(parent);
        }
        return mutatedPop;
    }


    public List<int[]> crossover(List<int[]> population, int popSize) {

        List<int[]> offspringList = new ArrayList<>();
        Random random = new Random();
        int[] boxIndex = {0, 3, 6, 27, 30, 33, 54, 57, 60};
        for (int i = 0; i < popSize; i++) {

            int crossOverPoint = boxIndex[random.nextInt(8)];
//          int crossOverPoint = boxIndex[1];
            int[] parent1 = population.get(random.nextInt(population.size()));
            int[] parent2 = population.get(random.nextInt(population.size()));
            int[] offSpring = new int[81];

//            int[] gene11 = getOneBox(parent1, 0);
//            int[] gene21 = getOneBox(parent2, 3);
////            System.out.println("Parent 11 "+Arrays.toString(gene11));
////            System.out.println("Parent 21 "+Arrays.toString(gene21));
//            int[] gene12 = getOneBox(parent1, 6);
//            int[] gene22 = getOneBox(parent2, 27);
////            System.out.println("Parent 11 "+Arrays.toString(gene11));
////            System.out.println("Parent 21 "+Arrays.toString(gene21));
//            int[] gene13 = getOneBox(parent1, 30);
//            int[] gene23 = getOneBox(parent2, 33);
////            System.out.println("Parent 11 "+Arrays.toString(gene11));
////            System.out.println("Parent 21 "+Arrays.toString(gene21));
//            int[] gene14 = getOneBox(parent1, 54);
//            int[] gene24 = getOneBox(parent2, 57);
////            System.out.println("Parent 11 "+Arrays.toString(gene11));
////            System.out.println("Parent 21 "+Arrays.toString(gene21));
//            int[] gene15 = getOneBox(parent1, 60);
//
//
//
////subgrid 1
//            for (int m = 0; m < 3; m++) {
//                offSpring[m] = gene11[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9] = gene11[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18] = gene11[m + 6];
//            }
//
////subgrid 2
//
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 3] = gene21[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9 + 3] = gene21[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18 + 3] = gene21[m + 6];
//            }
//
////subgrid 3
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 3 + 3] = gene12[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9 + 3 + 3] = gene12[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18 + 3 + 3] = gene12[m + 6];
//            }
////subgrid 4
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 3 + 3 + 3+18] = gene22[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9 + 3 + 3 + 3+18] = gene22[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18 + 3 + 3 + 3+18] = gene22[m + 6];
//            }
////subgrid 5
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 3 + 3 + 3 + 3+18] = gene13[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9 + 3 + 3 + 3 + 3+18] = gene13[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18 + 3 + 3 + 3 + 3+18] = gene13[m + 6];
//            }
////subgrid 6
//
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 3 + 3 + 3 + 3 + 3+18] = gene23[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9 + 3 + 3 + 3 + 3 + 3+18] = gene23[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18 + 3 + 3 + 3 + 3 + 3+18] = gene23[m + 6];
//            }
////subgrid 7
//
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene14[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9 + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene14[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18 + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene14[m + 6];
//            }
//
////subgrid 8
//
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 3 + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene24[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9 + 3 + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene24[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18 + 3 + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene24[m + 6];
//            }
//
//            //subgrid 9
//
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 3 + 3 + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene15[m];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 9 + 3 + 3 + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene15[m + 3];
//            }
//            for (int m = 0; m < 3; m++) {
//                offSpring[m + 18 + 3 + 3 + 3 + 3 + 3 + 3 + 3 + 3+18+18] = gene15[m + 6];
//            }


            for (int k = 0; k < crossOverPoint; k++) {
                offSpring[k] = parent1[k];
            }
            for (int j = crossOverPoint; j < population.get(0).length; j++) {
                offSpring[j] = parent2[j];
            }
//            System.out.println(offSpring);
            offspringList.add(offSpring);

        }
        return offspringList;
    }

    public List<int[]> generateOffSprings(List<int[]> population, int[] givenProblem, int popSize, double selectionRate, double mutatePopRate, double mutateRate) {


        List<int[]> newOffSpringList = new ArrayList<>();
        List<GenomeSudoku> popWithFitness = new ArrayList<>();
        int id = 0;
        for (int[] curentsample : population) {
            GenomeSudoku currentGenome = new GenomeSudoku();
            currentGenome.id = id;
            currentGenome.solution = curentsample;
            currentGenome.fitnessScore = calculateFitness(curentsample, givenProblem);
            System.out.print(", " + currentGenome.fitnessScore);
            popWithFitness.add(currentGenome);
            id++;
        }

        List<int[]> selectedPop = selection(popWithFitness, selectionRate);
        double crossoverOffsprinfSize = popSize * (1 - mutatePopRate);
        int crossoverPopSize = (int) crossoverOffsprinfSize;

        double mutateOffsprinfSize = popSize * (mutatePopRate);
        int mutatePopSize = (int) mutateOffsprinfSize;
        List<int[]> crossoverOffSpringPop = crossover(selectedPop, crossoverPopSize);
        List<int[]> mutateOffSpringPop = mutate(selectedPop, mutatePopSize, mutateRate);

        newOffSpringList.addAll(crossoverOffSpringPop);
        newOffSpringList.addAll(mutateOffSpringPop);
        System.out.println();
        System.out.println("solution " + Arrays.toString(newOffSpringList.get(0)));
        return newOffSpringList;
    }


    public List<int[]> selection(List<GenomeSudoku> population, double selectionIndex) {
        List<int[]> newPop = new ArrayList<>();

        double limit = population.size() * selectionIndex;
        int lint = (int) limit;
        Collections.sort(population, (a, b) -> a.fitnessScore < b.fitnessScore ? 1 : a.fitnessScore == b.fitnessScore ? 0 : -1);
        for (int i = 0; i < lint; i++) {
            newPop.add(population.get(i).solution);
        }

        return newPop;

    }


    public int calculateFitness(int[] randomSolution, int[] givenProblem) {
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

        fitness += 10*compareSolWithGiven(randomSolution, givenProblem);
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


}
