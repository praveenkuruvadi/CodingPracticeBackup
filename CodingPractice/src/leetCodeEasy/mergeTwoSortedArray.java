package leetCodeEasy;

public class mergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] list = new int[m+n];
        int count1 =0;
        int count2 =0;
        if(m == 0){
            for(int i=0;i<n;i++)
                nums1[i]=nums2[i];
        }
        else if( n !=0){
            for(int i=0;i<= m+n-1;i++){
            if(count1==m && count2 < n){
                list[i]=nums2[count2];
                count2++;
            }else if(count2 == n && count1 < m){
                list[i]=nums1[count1];
                count1++;
            }else{
                if(nums1[count1]<nums2[count2]){
                    list[i]=nums1[count1];
                    count1++;
                    
                }else
                    list[i]=nums2[count2++];
            }
        }
        for(int i=0;i<list.length;i++)
            nums1[i] = list[i];
        }
        
    }

}
