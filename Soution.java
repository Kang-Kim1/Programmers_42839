import java.util.*;
class Solution {
    HashSet<Integer> set;
    public int solution(String numbers) {
        set = new HashSet<Integer>();
        int answer = 0;
        
        recurStrBuilder(numbers, "");
        
        answer = set.size();
        return answer;
    }

    // 전체 String 조합을 만드는 재귀 메소드
    public void recurStrBuilder(String input, String prefix) {
        
        // 소수일 경우 Set에 추가
        if(!prefix.equals("")) {
            checkPrime(prefix);
        }
        int len = input.length();
        
        // prefix에 charAt(i)으로 반환된 문자가 더해진 문자열 +
        // input에서 반환된 문자가 빠진 문자열을 Args로 재귀 반복
        for(int i = 0; i < len; i++) {
            recurStrBuilder(input.substring(0, i) + input.substring(i + 1, len), prefix + input.charAt(i));
        }
    }
    
    // 소수 확인 메소드
    public void checkPrime(String num) {
        
        int numInt = Integer.parseInt(num);
        int maxToCheck = (int)Math.sqrt(numInt);
        
        // 2에 대한 예외처리 
        if(numInt == 2) {
            set.add(numInt);
            return;
        }
        
        // 2보다 작은 정수, 그리고 짝수에 대한 예외처리 
        if(numInt < 2 || numInt % 2 == 0) {
            return;
        }
        
        // 제곱근값까지만 확인하여 소수 확인
        for(int i = 3; i <= maxToCheck; i++) {
            if(numInt % i == 0) 
                return;
        }
        set.add(numInt);
    }
}
