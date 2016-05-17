package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

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
		DiskFileUpload diskFileUpload = new DiskFileUpload();
		
		try{
			List<FileItem> list = diskFileUpload.parseRequest(request);
			for(FileItem fileItem: list)
			{
				File remoteFile = new File(new String(fileItem.getName().getBytes(),"UTF-8"));
				file1 = new File(this.getServletContext().getRealPath("temp"),
						remoteFile.getName());
				file1.getParentFile().mkdirs();
				file1.createNewFile();
				InputStream ins  = fileItem.getInputStream();
				OutputStream ous = new FileOutputStream(file1);
				try{
					byte[] buffer = new byte[1024];
					int len = 0;
					while((len=ins.read(buffer))>-1)
					{
						ous.write(buffer, 0, len);
						
					}
				}finally{
					ous.close();
					ins.close();
				}
				
				
			}
		}
		catch(IOException e)
		{
			
		}
		catch(FileUploadException ex)
		{
			
		}
		
	}

}
