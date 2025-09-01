import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double gain = gain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            pass++; total++;
            double gain = gain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        double sum = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            sum += top[1] / top[2];
        }
        return sum / classes.length;
    }

    private double gain(int pass, int total) {
        return ((double)(pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
