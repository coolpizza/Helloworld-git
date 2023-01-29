
/*

https://codechacha.com/ko/java-sorting-comparable/

12 
junk 50 60 100
sank 80 60 50
sunyo 80 70 100
soong 50 60 90
habb 50 60 100
kang 60 80 100
dongh 80 60 100
se 70 70 70
won 70 70 90
sang 70 70 80
nsj 80 80 80
tae 50 60 90

---
dongh
sank
sunyo
nsj
won
sang
se
kang
habb
junk
soong
tae

*/
import java.util.*;

public class Main {
	static class Student implements Comparable<Student> {

    private String name;
    private int kor;
    private int eng;
    private int m;

    public Student(String name, int kor, int eng, int m) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.m = m;
    }
	/*
	-국어 점수 감소순
	-국어 점수 동일 -> 영어 점수 증가순
	-국어,영어 동일 -> 수학 점수 감소순 
    -모든 점수 같으면 이름 사전순	
	*/

    /*
    [ 정렬 기준 ]
    1) 두 번째 원소를 기준으로 내림차순 정렬
    2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
    3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
    4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬
    */

    public String getName() {
        return this.name;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Student other) {
        if (this.kor == other.kor && this.eng == other.eng && this.m == other.m) {
            return this.name.compareTo(other.name);  // 오름차순
        }
        if (this.kor == other.kor && this.eng == other.eng) {
            return Integer.compare(other.m, this.m); // 내림차순
        }
        if (this.kor == other.kor) {
            return Integer.compare(this.eng, other.eng); // 오름차순
        }
        return Integer.compare(other.kor, this.kor);  // 내림차순
    }
}



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int m = sc.nextInt();
            students.add(new Student(name, kor, eng, m));
        }

        Collections.sort(students);

        // 정렬된 학생 정보에서 이름만 출력
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
    }
}