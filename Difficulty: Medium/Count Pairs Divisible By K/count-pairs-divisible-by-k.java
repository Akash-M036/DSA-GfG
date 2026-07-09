class Solution {
    public int countKdivPairs(int[] arr, int k) {
    for(int i = 0; i< arr.length; i++){
        arr[i] =  arr[i] % k;
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i =0; i< arr.length; i++){
        map.put(arr[i],map.getOrDefault(arr[i],0)+1);
    }
    int count=0;
    for(int a : arr){
            map.put(a, map.get(a) - 1);
        int target = Math.abs(k-a)%k;
        if(map.containsKey(target)){
            count+= map.get(target);
            // map.put(a,map.get(a)-1);
        }
    }
    return count;
    }
}
