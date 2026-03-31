class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m+n];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m) {
            arr[k] = nums1[i];
            k++;
            i++;
        }

        while(j < n) {
            arr[k] = nums2[j];
            k++;
            j++;
        }

        int index = (m+n)/2;
        if((m+n)%2 != 0) {
            return (double) arr[index];
        } 

        double val1 = arr[index-1];
        double val2 =  arr[index];

        double ans = val1 + (val2 - val1)/2;

        return ans;
    }
}
