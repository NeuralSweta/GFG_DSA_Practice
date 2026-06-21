class Solution:
    def floorSqrt(self, n): 
        # code here
        start,end=1,n
        idx=0
        while start<=end:
            mid=start+(end-start)//2
            if mid*mid==n:
                return mid
            elif mid*mid<n:
                idx=mid
                start=mid+1
            else:
                end=mid-1
        return idx        