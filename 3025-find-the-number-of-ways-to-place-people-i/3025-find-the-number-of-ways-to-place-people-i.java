class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) ->
        a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int cnt = 0;
    for (int i = 0; i < points.length; i++) {
        int top = points[i][1];
        int bot = Integer.MIN_VALUE;
        for (int j = i + 1; j < points.length; j++) {
            int y2 = points[j][1];
            if (y2 <= top && y2 > bot) {
                cnt++;
                bot = y2;
            }
        }
    }
    return cnt;    
    }
}