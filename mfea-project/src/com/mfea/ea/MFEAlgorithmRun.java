package com.mfea.ea;


import java.util.ArrayList;
import java.util.List;

public class MFEAlgorithmRun {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        int[] givenProblem1 = {0,0,4,3,0,0,2,0,9,0,0,5,0,0,9,0,0,1,0,7,0,0,6,0,0,4,3,0,0,6,0,0,2,0,8,7,1,9,0,0,0,7,4,0,0,0,5,0,0,8,3,0,0,0,6,0,0,0,0,0,1,0,5,0,0,3,5,0,8,6,9,0,0,4,2,9,1,0,3,0,0};
        int[] givenProblem2 ={1,6,8,2,5,7,4,3,9,7,9,2,4,3,6,1,5,8,5,4,3,9,8,1,6,7,2,6,3,9,8,7,4,5,2,1,4,1,5,6,2,9,7,8,3,2,8,7,3,1,5,9,6,4,9,2,4,7,6,3,8,1,5,3,7,1,5,4,8,2,9,6,8,5,6,1,9,2,3,4,7};
        tasks.add(new SudokuTask(givenProblem1));
        tasks.add(new SudokuTask(givenProblem2));

        MultiTaskingGA g = new MultiTaskingGA(tasks, 100, 0.0, 50);
        g.run(50);
    }
}
