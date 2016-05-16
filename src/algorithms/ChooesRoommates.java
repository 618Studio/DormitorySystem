package algorithms;

import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ChooseOperateDB;
import javaBean.Question;

public class ChooesRoommates {
	public static void main(String[] args){
		ChooesRoommates test = new ChooesRoommates();
		try {
			test.firstChoose();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void firstChoose() throws SQLException{
		for (int i=1;i<5;i++){
			ResultSet order = ChooseOperateDB.getOrder(i);
			order.last();
			int row = order.getRow();
	        order.beforeFirst();//���ع�
	        int haveFinished = 0;
			while(order.next()){
				String nowSno = order.getString("Sno");
				int sex = ChooseOperateDB.checkSex(nowSno);
				
				//��ȡ��������
				String roomNr = null;
				int roomCapacity = 0;
				ResultSet room = ChooseOperateDB.getRoom(sex);
				if (room.next()!=false){
					roomNr = room.getString("DroomNr");
					roomCapacity = room.getInt("capacity");
				}else{
					System.out.println("���޿������ң�����");
				}
				
				if(haveFinished+roomCapacity>row) break;
				
				ResultSet sameOrder = ChooseOperateDB.getSameList(nowSno);	
				ResultSet compareOrder = ChooseOperateDB.getCompareList(nowSno);
				
				if (sameOrder.next()!=false){
					String[] Sno = new String[4];
					Sno[0] = nowSno;
					int count = 1;
					
					//��ȡ�໥ѡ���ͬѧ
					String matchSno = checkMatch(nowSno);
					if(matchSno!=null && !ChooseOperateDB.checkHaveRoom(matchSno)) {
						Sno[count++] = matchSno;
					}
					
					//ѡ��һ����ͬ�㷨������ߵ�ͬѧ
					do {
						String other = sameOrder.getString("SotherNr");
						if (!ChooseOperateDB.checkHaveRoom(other) && checkSameSno(Sno, other)){
							Sno[count++] = other;
							break;
						}
					} while (sameOrder.next());
						
					//ѡ��һ���������Ի������ϸߵ�ͬѧ
					while(compareOrder.next()){
						String other = compareOrder.getString("SotherNr");
						if (!ChooseOperateDB.checkHaveRoom(other) && checkSameSno(Sno, other))
							Sno[count++] = other;
						if (count==roomCapacity) break;
					}
						
					if(count == roomCapacity){
						ChooseOperateDB.set4PeopleRoom(Sno, roomNr);
						haveFinished+=roomCapacity;
					}
				}
			}
		}
	}

	public static void secondChoose() throws SQLException{
		DealQuestion obj = new DealQuestion();
		obj.secondDealQuestion();
	}
	
	private static boolean checkSameSno(String[] sno,String nowSno){
		boolean flag = true;
		for(int i=0;i<sno.length;i++){
			if (nowSno.equals(sno[i])) flag=false;
		}
		return flag;
	}
	
	private static String checkMatch(String sno){
		ResultSet res = ChooseOperateDB.checkMatch(sno);
		String result = null;
		try {
			if (res.next()!=false){
				String sno1 = res.getString("Mno1");
				String sno2 = res.getString("Mno2");
				if(sno1.equals(sno)){
					result = sno2;
				}
				else result = sno1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
