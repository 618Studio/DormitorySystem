package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.csvreader.CsvReader;

import algorithms.ChooesRoommates;
import hibernate.BaseDAO;
import hibernate.Dormitory;
import hibernate.Students;


/**
 * Servlet implementation class GetFiles
 */
@SuppressWarnings("deprecation")
@WebServlet("/GetFiles")
public class GetFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**+
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		File file1 = null ,file2 = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(10*1024); //最大缓存  

		ServletFileUpload  fileUpload = new ServletFileUpload (factory);
		
		try{
			
			List<FileItem> list = fileUpload.parseRequest(request);
			
			//读取寝室csv文件
			FileItem fileItem1 = list.get(0);
			File remoteFile = new File(new String(fileItem1.getName().getBytes(),"UTF-8"));
			file1 = new File(this.getServletContext().getRealPath("temp"),
					remoteFile.getName());
			file1.getParentFile().mkdirs();
			file1.createNewFile();
			InputStream ins  = fileItem1.getInputStream();
			OutputStream ous = new FileOutputStream(file1);
			try{
				byte[] buffer = new byte[1024];
				int len = 0;
				while((len=ins.read(buffer))>-1)
				{
					ous.write(buffer, 0, len);
					
				}
				System.out.println("文件上传成功"+this.getServletContext().getRealPath("temp")+"\\"+
						remoteFile.getName());
			}finally{
				ous.close();
				ins.close();
			}
			
			//读取学生csv文件
			FileItem fileItem2 = list.get(1);
			remoteFile = new File(new String(fileItem2.getName().getBytes(),"UTF-8"));
			file2 = new File(this.getServletContext().getRealPath("temp"),
					remoteFile.getName());
			file2.getParentFile().mkdirs();
			file2.createNewFile();
			ins  = fileItem2.getInputStream();
			ous = new FileOutputStream(file2);
			try{
				byte[] buffer = new byte[1024];
				int len = 0;
				while((len=ins.read(buffer))>-1)
				{
					ous.write(buffer, 0, len);
					
				}
				System.out.println("文件上传成功"+this.getServletContext().getRealPath("temp")+"\\"+
						remoteFile.getName());
			}finally{
				ous.close();
				ins.close();
			}
			
			//创建Hibernate Session
			BaseDAO<Students> stu_DAO = new BaseDAO<Students>();
			BaseDAO<Dormitory> dor_DAO = new BaseDAO<Dormitory>();
			
		
			//ChooesRoommates.clearAllData();
			
			System.out.println("sss");	
			//读取寝室CSV文件，存入数据库
			CsvReader reader = new CsvReader(file1.getAbsolutePath(),',',Charset.forName("UTF-8"));
			reader.readHeaders() ;
			
			while(reader.readRecord()){
				Dormitory dor = new Dormitory();
			
				String droomNr = (String)reader.get(0);
				dor.setDroomNr(droomNr);
				
				int capacity = Integer.parseInt((String)reader.get(1));
				
				dor.setCapacity(capacity);
				
				dor.setFinish(0);
				
				int sex = Integer.parseInt((String)reader.get(3));
				dor.setSex(sex);
				
				String orientation = (String)reader.get(4);
				dor.setOrientation(orientation); 
				
				dor_DAO.create(dor);
			}		
			reader.close();
			
			
			//读取学生CSV文件，存入数据库
			reader = new CsvReader(file2.getAbsolutePath(),',',Charset.forName("utf-8"));
			reader.readHeaders() ;
			
			while(reader.readRecord()){
				Students stu = new Students();
				String sno= (String)reader.get(0);
				stu.setSno(sno);
				
			
				String sname = (String)reader.get(1);
				stu.setSname(sname);
				
				String sgender = (String)reader.get(2);
				stu.setSgender(sgender);
				stu.setSpassword("123456");
				stu_DAO.create(stu);
			}
			reader.close();
			
			
			
			//删除两个文件
			file1.delete();
			file2.delete();
			
			
		}
		catch(IOException e)
		{
			
		}
		catch(FileUploadException ex)
		{
			
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<h1 style=\"color:green;text-align:center;margin-top:50px;\">Upload Successfully！</h1>");
		out.println("		<div style=\"color:green;text-align:center;font-size:16px;\"><a href=\"admin.jsp\">Back</a></div>");
		out.println("	</body>");
		out.println("</html>");
		
		
	}

}
