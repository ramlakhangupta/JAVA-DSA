class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] meet : meetings) {
            map.computeIfAbsent(meet[0], kwy -> new ArrayList<>()).add(new int[] { meet[1], meet[2] });
            map.computeIfAbsent(meet[1], kwy -> new ArrayList<>()).add(new int[] { meet[0], meet[2] });
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { 0, 0 });
        que.add(new int[] { firstPerson, 0 });

        HashMap<Integer, Integer> knowsSecret = new HashMap<>();
        knowsSecret.put(0, 0);
        knowsSecret.put(firstPerson, 0);

        while (!que.isEmpty()) {
            int[] top = que.poll();
            int topPerson = top[0];
            int topTiming = top[1];

            for (int[] neighbor : map.getOrDefault(topPerson, new ArrayList<>())) {
                int person = neighbor[0];
                int timing = neighbor[1];

                //case 1
                if ( timing >= topTiming) {
                    if (knowsSecret.containsKey(person) && knowsSecret.get(person) > timing) {
                        knowsSecret.put(person, timing);
                        que.add(new int[] { person, timing });
                    } 
                }

                //case2 
                if (!knowsSecret.containsKey(person)) {
                    if (topTiming <= timing) {
                        knowsSecret.put(person, timing);
                        que.add(new int[] { person, timing });
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>(knowsSecret.keySet());
        return ans;

    }
}
