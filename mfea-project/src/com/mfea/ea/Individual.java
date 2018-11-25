package com.mfea.ea;

import java.util.List;

/**
 * Created by Kumaran on 11/14/2018.
 */
public class Individual {

    List<Integer> gen;
    List<Integer> fitnessTask;
    List<Integer> factorial_rank;
    private int skillFactor;
    private double scalarFitness;

    Individual(List<Integer> gen, List<Integer> fitnessTask) {
        super();
        this.gen = gen;
        this.fitnessTask = fitnessTask;
    }

    Integer getMinFactorialRank() {
        Integer min = 10000000;
        for (Integer tmp : factorial_rank) {
            if (min > tmp) min = tmp;
        }
        return min;
    }

    List<Integer> getGen() {
        return gen;
    }

    List<Integer> getFitnessTask() {
        return fitnessTask;
    }

    void setFitnessTask(List<Integer> fitnessTask) {
        this.fitnessTask = fitnessTask;
    }

    int getSkillFactor() {
        return skillFactor;
    }

    void setSkillFactor(int skillFactor) {
        this.skillFactor = skillFactor;
    }

    double getScalarFitness() {
        return scalarFitness;
    }

    void setScalarFitness(double scalarFitness) {
        this.scalarFitness = scalarFitness;
    }

    List<Integer> getFactorialRank() {
        return factorial_rank;
    }

    void setFactorial_rank(List<Integer> factorial_rank) {
        this.factorial_rank = factorial_rank;
    }

    @Override
    public String toString() {
        return "Individual [gen=" + gen + ", fitnessTask=" + fitnessTask
                + ", factorialRank=" + factorial_rank + ", skillFactor="
                + skillFactor + ", scalarFitness=" + scalarFitness + "]";
    }
}
