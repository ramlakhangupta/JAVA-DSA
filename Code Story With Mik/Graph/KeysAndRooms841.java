class Solution {

    public void DFS(List<List<Integer>> rooms, int i, HashSet<Integer> visited) {
        visited.add(i);

        for (int j : rooms.get(i)) {
            if (!visited.contains(j)) {
                DFS(rooms, j, visited);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();

        DFS(rooms, 0, visited);
        if (visited.size() == rooms.size()) {
            return true;
        }
        return false;
    }
}
