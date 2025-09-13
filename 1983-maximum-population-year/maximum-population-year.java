class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];
        for (int i = 0; i < logs.length; i++) {
            int birth = logs[i][0];
            int death = logs[i][1];
            for (int year = birth; year < death; year++) {
                int index = year - 1950;
                population[index] += 1; 
            }
        }
        int maxPopulation = 0;
        int minYear = 1950;
        for (int i = 0; i < population.length; i++) {
            if (population[i] > maxPopulation) {
                maxPopulation = population[i];
                minYear = 1950 + i;
            }
        }
        return minYear;
    }
}