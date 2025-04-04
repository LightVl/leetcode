class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> listResult = new ArrayList<int[]>();
        int firstNum=intervals[0][0];
        int secondNum=intervals[0][1];
        int i;
        finish:
        for(i=0;i<intervals.length-1;i++) {
            while (secondNum >= intervals[i + 1][0]) {
                secondNum = (secondNum > intervals[i + 1][1]) ? secondNum : intervals[i + 1][1];
                i++;
                if (i== intervals.length-1)
                    break finish;
            }
            listResult.add(new int[]{firstNum,secondNum});
            firstNum=intervals[i+1][0];
            secondNum=intervals[i+1][1];
        }
        secondNum = (secondNum > intervals[i][1]) ? secondNum : intervals[i][1];
        listResult.add(new int[]{firstNum,secondNum});
        int[][] result = new int[listResult.size()][2];
        for (i = 0; i < listResult.size(); i++) {
            result[i] = listResult.get(i);
        }
        System.out.println(Arrays.deepToString(result));
        return result;      
    }
}