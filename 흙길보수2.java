

/*
https://www.acmicpc.net/problem/1911  (흙길보수)

https://zzang9ha.tistory.com/174
https://kosaf04pyh.tistory.com/135

어젯밤 겨울 캠프 장소에서 월드 본원까지 이어지는, 흙으로 된 비밀길 위에 폭우가 내려서 N (1 <= N <= 10,000) 개의 물웅덩이가 생겼다. 
월드학원은 물웅덩이를 덮을 수 있는 길이 L (L은 양의 정수) 짜리 널빤지들을 충분히 가지고 있어서, 
이들로 다리를 만들어 물웅덩이들을 모두 덮으려고 한다. 
물웅덩이들의 위치와 크기에 대한 정보가 주어질 때, 모든 물웅덩이들을 덮기 위해 필요한 널빤지들의 최소 개수를 구하여라.

3 3
1 6
13 17
8 12

-->

5
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물 웅덩이 개수
        int L = sc.nextInt(); // 널빤지 길이

        Hole[] holes = new Hole[N];

        for (int i = 0; i < N; i++) {
            holes[i] = new Hole(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(holes, new Comparator<Hole>() { // start를 기준으로 정렬
            @Override
            public int compare(Hole h1, Hole h2) {
                if (h1.start > h2.start) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int boardCount = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {

            start = Math.max(start, holes[i].start); // 널빤지가 다음 웅덩이의 시작점을 넘었는지 넘지 않았는지 확인
            int t = 0; // i번째 구덩이를 덮기 위해서 필요한 널빤지의 길이
            while (t < holes[i].end - start) {
                t += L;
            }
            boardCount = boardCount + t / L; // t/L을 하면 필요한 널빤지의 길이가 나옴
            start += t; // start에서 널빤지의 길이만큼 +
        }
        System.out.println(boardCount);
    }
}

class Hole {
    int start;
    int end;

    Hole(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }
}