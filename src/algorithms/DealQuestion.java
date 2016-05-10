package algorithms;

import javaBean.Question;
import javaBean.Score;
import connectDB.AlgorithmsOperateDB;

public class DealQuestion {
	private Score[] score_same;
	private Score[] score_compare;
	
	/*public static void main(String args[]){
		String a = "10101010";
		String b = "10111111";
		int anow = Integer.parseInt(a,2);
		int bnow = Integer.parseInt(b,2);
		int score = anow^bnow;
		String s = Integer.toBinaryString(score);
		
		System.out.println(s.split("1").length);
	}*/
	
	public DealQuestion(){
		score_compare = new Score[5];
		score_same = new Score[5];
		score_compare[0]=null;
		score_same[0]=null;
	}
	
	private void calculate(){
		Question[][] question = AlgorithmsOperateDB.getQuestionResult();
		if (!(question[1].length<6 || question[2].length<6 || question[3].length<6 || question[4].length<6)){
			for(int i=1;i<5;i++){
				for (int j=0;j<question[i].length;j++){
					String nowSno = question[i][0].getSno();
					int nowQues = Integer.parseInt(question[i][0].getPart2_3(),2);
					for (int k=j+1;k<question[i].length;k++){				
						String otherSno = question[i][j].getSno();
						int otherQues = Integer.parseInt(question[i][0].getPart2_3(),2);
						//使用二进制亦或方式判断有多少组答案相同的问题，转化为二进制进行计算。
						int scoreSame = nowQues^otherQues;
						score_same[i] = new Score(nowSno,otherSno,Integer.toBinaryString(scoreSame).split("1").length);						
					}
				}
			}
		}
	}
}
