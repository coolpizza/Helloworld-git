public class CombinationExample {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e'};
        int r = 3; // 조합의 길이

        char[] output = new char[r]; // 조합을 담을 배열
        boolean[] visited = new boolean[arr.length];

        combinationDFS(arr, output, visited, 0, r, 0);
    }

    public static void combinationDFS(char[] arr, char[] output, boolean[] visited, int depth, int r, int start) {
        if (depth == r) { // r개의 원소를 모두 선택한 경우
            for (int i = 0; i < r; i++) {
                 System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combinationDFS(arr, output, visited, depth + 1, r, i + 1);
                visited[i] = false;
            }
        }
    }
}