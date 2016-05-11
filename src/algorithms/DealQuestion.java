package algorithms;

import javaBean.Question;
import javaBean.Score;
import connectDB.AlgorithmsOperateDB;

public class DealQuestion {
	private Score[] score_same;
	private Score[] score_compare;
	private static Question[][] male;
	private static Question[][] female;
	
	final static int MALE = 1;
	final static int FEMALE = 2;
	
	


	
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
		male = new Question[5][];
		female = new Question[5][];
		male[0] = null;
		female[0] = null;
		//��һ�η��飬���Ա�Ϊ��׼�ֽ�
		male = AlgorithmsOperateDB.getQuestionResult(MALE);
		female = AlgorithmsOperateDB.getQuestionResult(FEMALE);
		calculate(male);
		calculate(female);
	}
	
	private void calculate(Question[][] question){
		if (!(question[1].length<4 || question[2].length<4 || question[3].length<4 || question[4].length<4)){
			for(int i=1;i<5;i++){
				for (int j=0;j<question[i].length;j++){
					String nowSno = question[i][0].getSno();
					String part2_3_1 = question[i][0].getPart2_3();
					int nowQues = Integer.parseInt(part2_3_1,2);
					for (int k=j+1;k<question[i].length;k++){				
						String otherSno = question[i][j].getSno();
						String part2_3_2 = question[i][0].getPart2_3();
						int otherQues = Integer.parseInt(part2_3_2,2);
						//ʹ�ö��������ʽ�ж��ж��������ͬ�����⣬ת��Ϊ�����ƽ��м��㡣
						int scoreSame = nowQues^otherQues;
						score_same[i] = new Score(nowSno,otherSno,Integer.toBinaryString(scoreSame).split("1").length);						
						
						//��������������Ի��Ա�
						int count = 0;
						//����
						if (!(part2_3_1.charAt(0) == '1' && part2_3_2.charAt(1) == '0')){
							count++;
						}
						//����ռ������
						if (!(part2_3_1.charAt(2) == '1' && part2_3_2.charAt(2) == '1')){
							count++;
						}
						//�������
						if (!(part2_3_1.charAt(3) == '0' && part2_3_2.charAt(3) == '0')){
							count++;
						}
						//��ŵ
						if (part2_3_1.charAt(4) == '1' && part2_3_2.charAt(4) == '1'){
							count++;
						}
						//���ҹ���
						if (part2_3_1.charAt(5) == part2_3_2.charAt(5)){
							count++;
						}
						//��������
						if (!(part2_3_1.charAt(6) == '0' && part2_3_2.charAt(7) == '0')){
							count++;
						}
						//��ҹ
						if (!(part2_3_1.charAt(8) == '1' && part2_3_2.charAt(9) == '0')){
							count++;
						}
						//˯��ϰ��
						if (!(part2_3_1.charAt(10) == part2_3_2.charAt(10))){
							count++;
						}
						//����
						if(!(part2_3_1.charAt(11) == '1' && part2_3_2.charAt(12) == '0')){
							count++;
						}
						//���
						if(!(part2_3_1.charAt(12) == '1')){
							count++;
						}
						//����
						if(!(part2_3_1.charAt(13) == '1' && part2_3_2.charAt(13) == '0')){
							count++;
						}
						
						score_compare[i] = new Score(nowSno,otherSno,count);
					}
				}
			}
		}
	}
}
