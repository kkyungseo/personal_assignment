package team01;

import java.util.Random;		// 컴퓨터가 랜덤으로 숫자 생성하도록 Random 이용  
import java.util.Scanner;		// 사용자가 입력한 숫자를 입력받도록 Scanner 이용 

public class baseball01 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    Random random = new Random();
	    
	    	// 사용자가 컴퓨터를 이기는 횟수가 3번이 되기 전까지 실행되도록 함  
	        // winCount : 이기는 횟수  
	    
	        int winCount = 0;

	        // 컴퓨터가 1부터 9까지의 무작위 숫자를 생성 
	        // 컴퓨터의 랜덤 숫자에서 중복 제거 
	        // ( 중복된 숫자가 발견되면 i 값을 1 감소시켜 
	        //   외부 for 루프의 다음 반복에서 현재 i 값에 대해 새로운 무작위 숫자를 다시 생성 )

	        while (winCount < 3) {
	            int[] com = new int[3];
	            for (int i = 0; i < com.length; i++) {
	                com[i] = random.nextInt(9) + 1;
	                for (int j = 0; j < i; j++) {
	                    if (com[i] == com[j]) {
	                        i--;
	                        break;
	                    }
	                }
	            }
	            
	            System.out.println("게임을 시작합니다.");
	            System.out.println();

	            // 사용자의 세 개의 숫자를 입력 
	            
	            int[] user = new int[3];
	            
	            System.out.print("첫 번째 숫자를 입력하세요: ");
	            user[0] = scanner.nextInt();
	            System.out.print("두 번째 숫자를 입력하세요: ");
	            user[1] = scanner.nextInt();
	            System.out.print("세 번째 숫자를 입력하세요: ");
	            user[2] = scanner.nextInt();

	            int strike = 0;
	            int ball = 0;
	            int out = 0;

	            // strike, ball, out의 횟수 계산
	            // 한 세트가 3회, 배열 인덱스가 이동하면서 순환되도록 3으로 나눈 나머지값으로 for문 작성   
	            
	            for (int i = 0; i < com.length; i++) {
	                if (com[i] == user[i]) {
	                    strike++;
	                } else if (com[i] == user[(i + 1) % 3] || com[i] == user[(i + 2) % 3]) {
	                    ball++;
	                } else {
	                    out++;
	                }
	            }

	            // strike, ball, out의 결과 출력
	            System.out.println();
	            System.out.println("사용자의 숫자 : " + user[0] + user[1] + user[2]);
	            System.out.println("컴퓨터의 숫자 : " + com[0] + com[1] + com[2]);
	            System.out.println("결과: " + strike + " Strike, " + ball + " Ball, " + out + " Out");
	            System.out.println();
	            
	            // 사용자의 승패여부 확인  
	            if (strike == 3) {
	                winCount++;
	                System.out.println("사용자가 이겼습니다. 사용자의 승리 횟수: " + winCount);
	                System.out.println();
	            } else {
	                System.out.println("사용자가 졌습니다. 다시 시도하세요.");
	                System.out.println();
	            }
	        }

	        System.out.println("게임을 종료합니다.");
	        System.out.println("지금까지 총 " + winCount + "번 이겼습니다.");
	        scanner.close();
	    }
	}

