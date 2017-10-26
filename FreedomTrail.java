class Solution {
    Map< String, Map<Integer, Integer>> memo;
    public int findRotateSteps(String ring, String key) {
//         int indexRing = 0, steps = 0, indexKey = 0;
        
//         while(indexKey < key.length()-1)
//         if (ring.charAt(indexRing) == key.charAt(indexKey)){
//             steps ++;   //spell
//         else if ()
        
//         }
        memo = new HashMap<>();
        return dfs( ring, key, 0);
    }

        public  int findClockwise(String ring, char ch){
            return ring.indexOf(ch);   // find first occurence of character clockwise
        }
        public int findCounterClockwise(String ring, char ch){
            if(ring.charAt(0) == ch) return 0;
            for(int i = ring.length()-1; i>0; i--){
                if (ring.charAt(i) == ch)
                    return i;         // find first occurence of character counterclockwise
            }
            return 0;
        }
        
        // Use Depth-First Search, a recursive algorithm to find the best path
        public int dfs(String ring, String key, int index){
            if(key.length() == index) return 0;
            int steps = 0;
            char ch = key.charAt(index);
            if(memo.containsKey(ring) && memo.get(ring).containsKey(index)) return memo.get(ring).get(index);
            
            int front = findClockwise(ring, ch);   // determine how many steps it takes to go clockwise for current character in 'key'
            int back = findCounterClockwise(ring, ch); // determine how many steps it takes to go counterclockwise for current character in 'key'
            
            int forward = 1 + front + dfs(ring.substring(front) + ring.substring(0,front), key, index + 1);  // use recursion to determine complete # of clockwise steps
            int backward = 1 + ring.length() - back + dfs(ring.substring(back)+ ring.substring(0,back), key , index + 1); // use recursion to determine complete number of counterclockwise steps
            
            steps = Math.min(forward, backward);  //determine whether clockwise or counterclockwise requires the least steps
            Map<Integer, Integer> answer = memo.getOrDefault(ring, new HashMap<>());
            answer.put(index, steps);
            memo.put(ring, answer);         // use memoization to save space
            return steps;
        }
    }
