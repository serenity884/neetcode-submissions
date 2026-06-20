class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // sort by position DESCENDING

        int fleets = 0;
        double maxTime = 0;
        for (double[] car : cars) {
            double time = car[1];
            if (time > maxTime) { // can't catch up to the fleet ahead → forms a NEW fleet
                fleets++;
                maxTime = time;
            }
            // else: time <= maxTime → merges into the fleet ahead, no new fleet
        }
        return fleets;
    }
}
