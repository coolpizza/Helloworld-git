/*
https://www.acmicpc.net/problem/16967
https://suhyeokeee.tistory.com/199
https://velog.io/@jihwan0319/%EB%B0%B0%EC%97%B4-%EB%B3%B5%EC%9B%90%ED%95%98%EA%B8%B0-%EB%B0%B1%EC%A4%80-16967
https://leesh111112.tistory.com/502

2 4 1 1
1 2 3 4 0
5 7 9 11 4
0 5 6 7 8

-->
1 2 3 4
5 6 7 8



*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    
    static int a[][];
    static int b[][];
    static int h,w,x,y;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] input = br.readLine().split(" ");
        
        // 원래 a 배열의 크기
         h = Integer.parseInt(input[0]);
         w = Integer.parseInt(input[1]);
        
        // 추가된 a 배열의 크기
         x = Integer.parseInt(input[2]);
         y = Integer.parseInt(input[3]);
        
        
        a = new int[1001][1001];
        b = new int[1001][1001];
        
        
        for(int i=0; i<h+x; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<w+y; j++) {
                b[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        
        for(int i=0; i<h+x; i++) {
            for(int j=0; j<w+y; j++) {
                int num = b[i][j];
                if(num ==0) {
                    continue;
                }
                
                
                if(isRange(i,j) && isRange(i-x,j-y)) {
                    a[i][j] = num-a[i-x][j-y];
                }
                
                if(isRange(i,j) && !isRange(i-x,j-y)) {
                    a[i][j] = num;
                }
                if(!isRange(i,j) && isRange(i-x,j-y)) {
                    a[i-x][j-y] = num;
                }
                
                
            }
        }
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static boolean isRange(int x, int y) {
        if(x>=0 && y>=0 && x<h && y<w) {
            return true;
        }
        return false;
    }
}