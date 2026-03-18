/////////////////////////////////////////////////   BRUTE FORCE     ///////////////////////////////////////////////////
ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        int duplicateNo = 0;
        int missingNo = 0;
        for(int val : arr) {
            if(set.contains(val)) {
                duplicateNo = val;
            } else {
                set.add(val);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            //missing
            if(!set.contains(i+1)) {
                missingNo = i+1;
                break;
            }
        }
        
        
        list.add(duplicateNo);
        list.add(missingNo);
        return list;
    }




////////////////////////////////////////////////////////////////      OPTIMIZED     //////////////////////////////////////////////////////

public int[] findMissingAndRepeatedValues(int[][] grid) {
        int duplicateNo = 0;
        int missingNo = 0;
        HashSet<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = grid[i][j];
                if (set.contains(val)) {
                    duplicateNo = val;
                } else {
                    set.add(val);
                }
            }
        }

        for (int i = 0; i <= set.size(); i++) {
            if (!set.contains(i + 1)) {
                missingNo = i + 1;
            }
        }
        ans[0] = duplicateNo;
        ans[1] = missingNo;

        return ans;

    }

