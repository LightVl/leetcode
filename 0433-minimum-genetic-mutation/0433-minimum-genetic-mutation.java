class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        List<String> mut = new java.util.ArrayList<>(Arrays.stream(bank).toList());
        Map<Character, String> mutationMap = new HashMap<>(4);
        mutationMap.put('A', "TCG");
        mutationMap.put('T', "ACG");
        mutationMap.put('C', "ATG");
        mutationMap.put('G', "ATC");
        Deque<res> queue = new ArrayDeque<>();
        queue.offer(new res(startGene,0));
        while (true)
            next:{
            if (queue.isEmpty())
                return -1;
            if(queue.peek().gene.equals(endGene)) {
                return queue.peek().i;
            }
            for(int i=0;i<queue.peek().gene.length();i++) {
                for(char b: mutationMap.get(queue.peek().gene.charAt(i)).toCharArray()) {
                    String newGene = queue.peek().gene.substring(0,i)+b+queue.peek().gene.substring(i+1);
                    if (mut.contains(newGene)) {
                        queue.offerFirst(new res(newGene,queue.peek().i+1));
                        mut.remove(newGene);
                        break next;
                    }
                }
            }
            queue.pop();
        }
    }
    record res(String gene,int i) {}
}