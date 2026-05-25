class Solution {
    public double average(int[] salary) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0.0;

        for(int i = 0; i < salary.length; i++) {

            if(salary[i] > max)
                max = salary[i];

            if(salary[i] < min)
                min = salary[i];

            sum += salary[i];
        }

        sum = sum - min - max;

        return sum / (salary.length - 2);
    }
}