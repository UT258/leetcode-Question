class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic={}
        for i,num  in  enumerate(nums):
            newt=target-num
            if newt in dic:
                return [i,dic[newt]]
            dic[num]=i
        return []