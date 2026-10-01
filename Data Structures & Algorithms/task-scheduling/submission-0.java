class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // Count each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // How many tasks have that maximum frequency?
        int maxCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        int schedule = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, schedule);
    }
}