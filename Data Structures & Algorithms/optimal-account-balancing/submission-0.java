/**
 * Optimal Account Balancing (LeetCode 465)
 * https://leetcode.com/problems/optimal-account-balancing/
 *
 * <h2>Problem</h2>
 * Given a list of transactions {@code [from, to, amount]}, return the minimum
 * number of transactions required to settle all debts between people.
 *
 * <h2>Key Insight: Reduce to Net Balances</h2>
 * Individual transactions don't matter — only each person's net balance does.
 * Sum each person's incoming minus outgoing amounts into a single {@code balance};
 * a positive balance means they're owed money, negative means they owe money.
 * People with a zero balance are already settled and can be dropped entirely.
 * The problem becomes: given a list of nonzero balances (which necessarily sum to
 * zero), find the minimum number of transfers to zero them all out.
 *
 * <h2>Backtracking</h2>
 * Take the first nonzero balance in the list. It must be settled by combining
 * with one or more other balances of the opposite sign. Try pairing it with every
 * other nonzero balance {@code j}: settle as much as possible between them
 * ({@code balances[j] += balances[i]}), recurse on the rest, then undo (backtrack)
 * and try the next {@code j}. Skip over balances already reduced to zero, and skip
 * duplicate values at the same recursion level to avoid redundant work (two people
 * with the same balance are interchangeable at this decision point).
 *
 * <p>Each pairing either fully settles one of the two balances (reducing the
 * nonzero count by at least one) or leaves a smaller nonzero remainder, so the
 * recursion always makes progress and terminates.
 *
 * <h2>Overflow Note</h2>
 * Amounts are bounded by {@code 100} and there are at most {@code 8} transactions,
 * so balances stay well within {@code int} range; no overflow possible.
 *
 * <h2>Complexity</h2>
 * <ul>
 *   <li>Time  – O(n!) worst case in the number of distinct nonzero balances
 *       {@code n} (at most 12, per {@code 0 <= from, to < 12}), since each call
 *       branches over the remaining nonzero balances. In practice heavily pruned
 *       by skipping zeros and duplicate values.</li>
 *   <li>Space – O(n) for the balances array and recursion depth.</li>
 * </ul>
 */
class Solution {
    public int minTransfers(int[][] transactions) {
        // Net balance per person id (ids are 0..11 per constraints).
        int[] net = new int[12];
        for (int[] t : transactions) {
            net[t[0]] -= t[2];
            net[t[1]] += t[2];
        }

        // Keep only nonzero balances; zero-balance people need no settling.
        int n = 0;
        int[] balances = new int[net.length];
        for (int b : net) {
            if (b != 0)
                balances[n++] = b;
        }
        int[] trimmed = new int[n];
        System.arraycopy(balances, 0, trimmed, 0, n);

        return settle(trimmed, 0);
    }

    /**
     * Settles the first nonzero balance starting at {@code start} by pairing it
     * with every other nonzero balance, recursing on the remainder.
     *
     * @param balances nonzero net balances (mutated and restored during backtracking)
     * @param start    index to begin scanning for the next unsettled balance
     * @return minimum number of transactions to zero out all balances from {@code start} on
     */
    private int settle(int[] balances, int start) {
        while (start < balances.length && balances[start] == 0) start++;
        if (start == balances.length)
            return 0;

        int min = Integer.MAX_VALUE;
        int prev = 0; // dedupe identical balances tried at this level
        for (int j = start + 1; j < balances.length; j++) {
            if (balances[j] == 0 || balances[j] == prev)
                continue;
            if ((balances[j] > 0) == (balances[start] > 0))
                continue; // must offset, opposite sign

            prev = balances[j];
            balances[j] += balances[start];
            int save = balances[start];
            balances[start] = 0;

            min = Math.min(min, 1 + settle(balances, start + 1));

            balances[start] = save;
            balances[j] -= balances[start];
        }
        return min;
    }
}
