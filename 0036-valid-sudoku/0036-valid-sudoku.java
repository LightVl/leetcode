class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean result;
        char[] temp = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            temp = Arrays.copyOf(board[i], 9);
            System.out.println(temp);
            result = isValidList(temp);
            if (result == false) {
                System.out.println(false);
                return false;
            }
        }
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                temp[i] = board[i][j];
            }
            System.out.println(temp);
            result = isValidList(temp);
            if (result == false) {
                System.out.println(false);
                return false;
            }
        }
        Arrays.fill(temp,'.');
        int k=0;
        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                for (int j = n*3; j < n*3+3; j++) {
                    for (int i = m*3; i < m*3+3; i++) {
                        temp[k] = board[j][i];
                        k++;
                    }
                }
                k=0;
                System.out.println(temp);
                result = isValidList(temp);
                if (result == false) {
                    System.out.println(false);
                    return false;
                }
            }
        }
        System.out.println(true);
        return true;
    }

    public static boolean isValidList(char[] list) {
        List<Character> myTempList = new String(list).chars().mapToObj(i -> (char) i).filter(a -> !a.equals('.')).collect(Collectors.toList());
        return myTempList.stream().allMatch(new HashSet<>()::add);
    }
}