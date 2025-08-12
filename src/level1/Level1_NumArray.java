package level1;

/*
* 문제 설명
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.
입출력 예
arr	divisor	return
[5, 9, 7, 10]	5	[5, 10]
[2, 36, 1, 3]	1	[1, 2, 3, 36]
[3,2,6]	10	[-1]
입출력 예 설명
입출력 예#1
arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

입출력 예#2
arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

입출력 예#3
3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
*
*
* ✅ 배열의 특징
고정 크기 (Fixed Size)

한 번 생성하면 크기를 변경할 수 없음.

배열 크기를 늘리거나 줄이려면 새로운 배열을 생성해야 함.

같은 타입의 데이터만 저장 가능

int[]는 오직 int 타입의 정수만 저장할 수 있음.

인덱스 접근

배열의 인덱스는 0부터 시작.

예: arr[0]은 첫 번째 요소, arr[1]은 두 번째 요소.

기본값 자동 초기화

배열 선언 후 값을 넣지 않으면, 정수형은 자동으로 0으로 초기화됨.


*
* */
import java.util.Arrays;

public class Level1_NumArray {
    public int[] solution(int[] arr, int divisor) {
        int[] filtered = Arrays.stream(arr)
                .filter(factor->factor % divisor == 0)
                .sorted()
                .toArray();
        if(filtered.length == 0){
            return new int[] {-1};
        }
        return filtered;
    }
}
