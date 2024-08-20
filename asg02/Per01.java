package com.ict.personal;

import java.util.HashSet;


public class Per01 {

	public static void main(String[] args) {

		// 00. 5행 출력을 위한 for문 
		for (int i = 0; i < 5; i++) { 
			
			// 01. lottoNum 생성 (1부터 45까지의 범위)
			HashSet<Integer> lottoNum = new HashSet<Integer>();
			while (lottoNum.size() < 6) {
				int randomNum = (int) (Math.random() * 45) + 1; 	
				lottoNum.add(randomNum);
			}
			
			// 02. bonusNum 생성 (1부터 45까지의 범위 && lottoNum과 겹치지 않게 설정)
			int bonusNum;
            		do {
               			bonusNum = (int) (Math.random() * 45) + 1;
            		} while (lottoNum.contains(bonusNum));

			System.out.println("Lotto Set " + ( i + 1 ) + ": " + lottoNum + " + Bonus: " + bonusNum);
		}
	}
}

// [ 출력예시 ]
//  Lotto Set 1: [16, 34, 2, 19, 44, 13] + Bonus: 9
//  Lotto Set 2: [1, 35, 4, 23, 40, 9] + Bonus: 3
//  Lotto Set 3: [1, 33, 34, 41, 44, 15] + Bonus: 35
//  Lotto Set 4: [16, 19, 20, 25, 42, 12] + Bonus: 9
//  Lotto Set 5: [3, 22, 23, 9, 42, 14] + Bonus: 6

