package level1;
import java.util.Scanner;

/**
 * logo
 * 코딩테스트 연습
 * 2025 프로그래머스 코드챌린지 2차 예선
 * 택배 상자 꺼내기
 *  /*
 *         Programmers. 택배 상자 꺼내기
 *         ---------------------------
 *
 *         [문제 설명]
 *         택배 상자
 *         - 1~N
 *
 *         택배 쌓기
 *         - 왼쪽에서 오른쪽으로 w개 쌓기
 *         - 그 위에 오른쪽에서 왼쪽으로 w개 쌓기
 *         - 반복
 *
 *         택배 꺼내기
 *         - 입력된 상자번호(A)를 꺼내기
 *         - 그 위에 쌓인 모든 상자부터 꺼내야 함
 *
 *         [입력]
 *         N : 창고에 있는 택배 상자의 수
 *         W : 가로로 놓는 상자 수
 *         num : 꺼내려는 상자 번호
 *
 *         [출력]
 *         꺼래려는 상자를 포함해서 총 꺼내야하는 상자의 수
 *
 *         [제한사항]
 *         2 <= N <= 100
 *         1 <= W <= 10
 *         1 <= num <= N
 *     */

public class Level1_Challenge2025_2nd_TakeOutBoxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 사용자에게 입력 받기
            System.out.print("n 값을 입력하세요 (종료하려면 'exit' 입력): ");
            String input = sc.nextLine();

            // 'exit'을 입력하면 반복 종료
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // n 값 입력 받기
            int n = Integer.parseInt(input);

            System.out.print("w 값을 입력하세요: ");
            int w = sc.nextInt();

            System.out.print("num 값을 입력하세요: ");
            int num = sc.nextInt();

            // 버퍼 비우기 (다음 줄에 입력을 제대로 받기 위함)
            sc.nextLine();

            // solution 메서드 호출 및 출력
            int answer = solution(n, w, num);
            System.out.println("결과: " + answer);
        }

        // Scanner 종료
        sc.close();
    }

    public static int solution(int n, int w, int num) {
        int answer = 1;
        // n : total / w : 가로 수 / num :  꺼내고자 하는 것
        int tHeight = (n-1) / w + 1;
        int numHeight = (num-1) / w + 1;
        // 같은 층 return 1
        if(tHeight == numHeight){
           return 1;
        }
        if (tHeight % 2 == 0) {
            // 꼭대기 층이 even <-
            if (numHeight % 2 == 0) {
                //  뽑고 싶은게 even 층 <-
                int tGap = tHeight * w - n;
                int nGap = numHeight * w - num;
                if (tGap <= nGap) {
                    answer = tHeight - numHeight + 1;
                } else {
                    answer = tHeight - numHeight;
                }
            } else {
                //  뽑고 싶은게 odd 층 <-
                int tGap = tHeight * w - n;
                int nGap = numHeight * w - num;
                int reGap = w - nGap - 1;
                int nAbGap = Math.abs(reGap);
                if (tGap > nAbGap) {
                    answer = tHeight - numHeight;
                } else {
                    answer = tHeight - numHeight + 1;
                }
            }
        } else {
            // 꼭대기 층이 odd ->
            if (numHeight % 2 == 1) {
                //  뽑고 싶은게 odd 층 ->
                int tGap = tHeight * w - n;
                int nGap = numHeight * w - num;
                if (tGap <= nGap) {
                    answer = tHeight - numHeight + 1;
                } else {
                    answer = tHeight - numHeight;
                }
            } else {
                //  뽑고 싶은게 even 층 <-
                int tGap = tHeight * w - n;
                int nGap = numHeight * w - num;
                int reGap = w - nGap - 1;
                int nAbGap = Math.abs(reGap);
                if (tGap > nAbGap) {
                    answer = tHeight - numHeight;
                } else {
                    answer = tHeight - numHeight + 1;
                }

            }
        }

        return answer;
    }
}
