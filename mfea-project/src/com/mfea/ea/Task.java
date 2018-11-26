package com.mfea.ea;

import java.util.List;

abstract public class Task {
    protected int dimension, capacity;
    int[] givenProblem = {0, 0, 4, 3, 0, 0, 2, 0, 9, 0, 0, 5, 0, 0, 9, 0, 0, 1, 0, 7, 0, 0, 6, 0, 0, 4, 3, 0, 0, 6, 0, 0, 2, 0, 8, 7, 1, 9, 0, 0, 0, 7, 4, 0, 0, 0, 5, 0, 0, 8, 3, 0, 0, 0, 6, 0, 0, 0, 0, 0, 1, 0, 5, 0, 0, 3, 5, 0, 8, 6, 9, 0, 0, 4, 2, 9, 1, 0, 3, 0, 0};

    public int[] getGivenProblem() {
        return givenProblem;
    }

    public void setGivenProblem(int[] givenProblem) {
        this.givenProblem = givenProblem;
    }

    public abstract int computeFitness(List<Integer> ind, int[] givenProblem,int index);

    public abstract int getLenGen();
}
