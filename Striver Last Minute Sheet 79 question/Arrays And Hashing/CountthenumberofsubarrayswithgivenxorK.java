////////////////////////////////////////////////      BRUTE FORCE (TLE)      ///////////////////////////////////
public long subarrayXor(int arr[], int k) {
        int n = arr.length;
        long count = 0;
        
        for(int i = 0; i < n; i++) {
            long xor = 0;
            for(int j = i; j < n; j++) {
                xor = arr[j] ^ xor ;
                if(xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

////////////////////////////////////////////      OPTIMIZE      ///////////////////////////////////////////////////////
public long subarrayXor(int arr[], int k) {
        int n = arr.length;
        long count = 0;
        
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L,1L);  // (frontXor, count);
        
        long xor = 0;
        for(int i = 0; i < n; i++) {
            xor ^= arr[i];
            long x = xor^k;
            
            if(map.containsKey(x)) {
                count += map.get(x);
                
            } 
            
            if(map.containsKey(xor)) {
                long freq = map.get(xor);
                map.put(xor, freq+1);
            } else {
                map.put(xor, 1L);
            }
            
        }
        return count;
    }
