package algorithms;

import javaBean.Question;
import javaBean.Score;

import java.sql.SQLException;

import connectDB.AlgorithmsOperateDB;

public class DealQuestion {
	private static Question[][] male;
	private static Question[][] female;
	
	final static int MALE = 1;
	final static int FEMALE = 2;
	
	/*
	public static void main(String args[]){
		String a = "101010101010101";
		String b = "111110101010101";
		int anow = Integer.parseInt(a,2);
		int bnow = Integer.parseInt(b,2);
		int score = anow^bnow;
		String s = Integer.toBinaryString(score);
		int count = 15 - s.replace("0", "").length();
		System.out.println(count);
	}
	*/
	
	public static void main(String args[]){
		DealQuestion test = new DealQuestion();
		
		test.mainAlgorthms();
	}
	
	public DealQuestion(){
		male = new Question[5][];
		female = new Question[5][];
		male[0] = null;
		female[0] = null;		
	}
	
	public void mainAlgorthms(){
		//����˫��ѡ��Test ok!
		dealWant();
		
		//��һ�η��飬���Ա�Ϊ��׼�ֽ�Test ok!
		male = AlgorithmsOperateDB.getQuestionResult(MALE);
		female = AlgorithmsOperateDB.getQuestionResult(FEMALE);
		
		//����ͬ�㷨�ó���һ���Ʒ�Test ok!
		calculateSame(male);
		calculateSame(female);
		
		//�����Ի��㷨�ó��ڶ����Ʒ�Test ok!
		calculateCompare(male);
		calculateCompare(female);
		
		//���ǵ���ѡ������Ȩ��Test ok!
		addWeight();
	}
	
	private void dealWant(){
		try {
			AlgorithmsOperateDB.dealWant();
			System.out.println("1������˫����ѡ�����������");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void calculateCompare(Question[][] question){
		for(int i=1;i<5;i++){
			if (question[i].length>4){
				for (int j=0;j<question[i].length;j++){
					String nowSno = question[i][j].getSno();
					String nowPart2_3 = question[i][j].getPart2_3();			
					for (int k=0;k<question[i].length;k++){		
						if (k!=j){
						String otherSno = question[i][k].getSno();
						String otherPart2_3 = question[i][k].getPart2_3();
						
						//���ñȽϺ����Ʒ�
						int count = compare(nowPart2_3, otherPart2_3);
						
						Score score = new Score(nowSno,otherSno,count);
						AlgorithmsOperateDB.storeCompareScore(score);
						}
					}
				}
			}
		}
		System.out.println("3���������Ի��Ʒֽ��������������ݿ⣡");
	}
	
	private void calculateSame(Question[][] question){
		for(int i=1;i<5;i++){
			if (question[i].length>4){
				for (int j=0;j<question[i].length;j++){
					String nowSno = question[i][j].getSno();
					String nowPart2_3 = question[i][j].getPart2_3();				
					for (int k=j+1;k<question[i].length;k++){			
						String otherSno = question[i][k].getSno();
						//if (nowSno.equals(otherSno)) break;
						String otherPart2_3 = question[i][k].getPart2_3();
						
						//������ͬ�ȽϼƷֺ���
						int count = same(nowPart2_3, otherPart2_3);
						
						Score score1 = new Score(nowSno,otherSno,count);	
						Score score2 = new Score(otherSno,nowSno,count);
						AlgorithmsOperateDB.storeSameScore(score1);
						AlgorithmsOperateDB.storeSameScore(score2);
					}
				}
			}
		}
		System.out.println("2��������ͬѡ��Ʒֽ��������������ݿ⣡");
	}
	
	private void addWeight(){
		try {
			AlgorithmsOperateDB.addWeight();
			System.out.println("4��������Ȩ���������������");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int compare(String nowPart2_3,String otherPart2_3){
		//��������������Ի��Ա�
		int count = 0;
		//����
		if (!(nowPart2_3.charAt(0) == '1' && otherPart2_3.charAt(1) == '0')){
			count++;
		}
		//����ռ������
		if (!(nowPart2_3.charAt(2) == '1' && otherPart2_3.charAt(2) == '1')){
			count++;
		}
		//�������
		if (!(nowPart2_3.charAt(3) == '0' && otherPart2_3.charAt(3) == '0')){
			count++;
		}
		//��ŵ
		if (nowPart2_3.charAt(4) == '1' && otherPart2_3.charAt(4) == '1'){
			count++;
		}
		//���ҹ���
		if (nowPart2_3.charAt(5) == otherPart2_3.charAt(5)){
			count++;
		}
		//��������
		if (!(nowPart2_3.charAt(6) == '0' && otherPart2_3.charAt(7) == '0')){
			count++;
		}
		//��ҹ
		if (!(nowPart2_3.charAt(8) == '1' && otherPart2_3.charAt(9) == '0')){
			count++;
		}
		//˯��ϰ��
		if (!(nowPart2_3.charAt(10) == otherPart2_3.charAt(10))){
			count++;
		}
		//����
		if(!(nowPart2_3.charAt(11) == '1' && otherPart2_3.charAt(12) == '0')){
			count++;
		}
		//���
		if(!(nowPart2_3.charAt(13) == '1')){
			count++;
		}
		//����
		if(!(nowPart2_3.charAt(14) == '1' && otherPart2_3.charAt(14) == '0')){
			count++;
		}
		return count;
	}

	private int same(String nowPart2_3,String otherPart2_3){
		int otherQues = Integer.parseInt(otherPart2_3,2);
		int nowQues = Integer.parseInt(nowPart2_3,2);
		//ʹ�ö��������ʽ�ж��ж��������ͬ�����⣬ת��Ϊ�����ƽ��м��㡣
		int scoreSame = nowQues^otherQues;
		String s = Integer.toBinaryString(scoreSame);
		//����ͬ����
		int count = 15 - s.replace("0", "").length();
		return count;
	}
}
