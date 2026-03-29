class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) {
            return 1;
        }

        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i] = new int[] {position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        int[] fleetHead = cars[0];
        int count = 1;

        for (int i = 0; i < n; i++) {
            int[] currentCar = cars[i];

            double currTimeToDest = timeToDestination(currentCar, target);
            double fleetHeadTimeToDest = timeToDestination(fleetHead, target);

            if (currTimeToDest > fleetHeadTimeToDest) {
                count++;
                fleetHead = currentCar;
            }
        }

        return count;
    }

    private double timeToDestination(int[] car, int target) {
        return ((double) target - car[0]) / car[1];
    }
}
