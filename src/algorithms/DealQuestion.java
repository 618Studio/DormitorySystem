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
		//处理单双向选择Test ok!
		dealWant();
		
		//第一次分组，以性别为标准分界Test ok!
		male = AlgorithmsOperateDB.getQuestionResult(MALE);
		female = AlgorithmsOperateDB.getQuestionResult(FEMALE);
		
		//以相同算法得出第一个计分Test ok!
		calculateSame(male);
		calculateSame(female);
		
		//以人性化算法得出第二个计分Test ok!
		calculateCompare(male);
		calculateCompare(female);
		
		//考虑单向选择增加权重Test ok!
		addWeight();
	}
	
	private void dealWant(){
		try {
			AlgorithmsOperateDB.dealWant();
			System.out.println("1、处理双单向选择问题结束！");
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
						
						//调用比较函数计分
						int count = compare(nowPart2_3, otherPart2_3);
						
						Score score = new Score(nowSno,otherSno,count);
						AlgorithmsOperateDB.storeCompareScore(score);
						}
					}
				}
			}
		}
		System.out.println("3、处理人性化计分结束，并存入数据库！");
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
						
						//调用相同比较计分函数
						int count = same(nowPart2_3, otherPart2_3);
						
						Score score1 = new Score(nowSno,otherSno,count);	
						Score score2 = new Score(otherSno,nowSno,count);
						AlgorithmsOperateDB.storeSameScore(score1);
						AlgorithmsOperateDB.storeSameScore(score2);
					}
				}
			}
		}
		System.out.println("2、处理相同选项计分结束，并存入数据库！");
	}
	
	private void addWeight(){
		try {
			AlgorithmsOperateDB.addWeight();
			System.out.println("4、处理单向权重增加问题结束！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int compare(String nowPart2_3,String otherPart2_3){
		//根据问题进行人性化对比
		int count = 0;
		//焦躁
		if (!(nowPart2_3.charAt(0) == '1' && otherPart2_3.charAt(1) == '0')){
			count++;
		}
		//交往占据主导
		if (!(nowPart2_3.charAt(2) == '1' && otherPart2_3.charAt(2) == '1')){
			count++;
		}
		//给予帮助
		if (!(nowPart2_3.charAt(3) == '0' && otherPart2_3.charAt(3) == '0')){
			count++;
		}
		//承诺
		if (nowPart2_3.charAt(4) == '1' && otherPart2_3.charAt(4) == '1'){
			count++;
		}
		//寝室规则
		if (nowPart2_3.charAt(5) == otherPart2_3.charAt(5)){
			count++;
		}
		//个人卫生
		if (!(nowPart2_3.charAt(6) == '0' && otherPart2_3.charAt(7) == '0')){
			count++;
		}
		//熬夜
		if (!(nowPart2_3.charAt(8) == '1' && otherPart2_3.charAt(9) == '0')){
			count++;
		}
		//睡觉习惯
		if (!(nowPart2_3.charAt(10) == otherPart2_3.charAt(10))){
			count++;
		}
		//吸烟
		if(!(nowPart2_3.charAt(11) == '1' && otherPart2_3.charAt(12) == '0')){
			count++;
		}
		//醉酒
		if(!(nowPart2_3.charAt(13) == '1')){
			count++;
		}
		//异性
		if(!(nowPart2_3.charAt(14) == '1' && otherPart2_3.charAt(14) == '0')){
			count++;
		}
		return count;
	}

	private int same(String nowPart2_3,String otherPart2_3){
		int otherQues = Integer.parseInt(otherPart2_3,2);
		int nowQues = Integer.parseInt(nowPart2_3,2);
		//使用二进制亦或方式判断有多少组答案相同的问题，转化为二进制进行计算。
		int scoreSame = nowQues^otherQues;
		String s = Integer.toBinaryString(scoreSame);
		//计相同答案数
		int count = 15 - s.replace("0", "").length();
		return count;
	}
}
