//////////////////////////////////////////////////      BRUTE FORCE       /////////////////////
public int maxProduct(int[] nums) {
        int n = nums.length;

        int maximum_product = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maximum_product = Math.max(maximum_product, product);
            }
        }
        return maximum_product;
    }
/////////////////////////////////////////////////       OPTIMIZED      ////////////////////////////////////////////
public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            minProduct = Math.min(nums[i], nums[i] * minProduct);
            maxProduct = Math.max(nums[i], nums[i] * maxProduct);

            ans = Math.max(ans, maxProduct);
        }

        return ans;
    }
