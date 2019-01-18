package advnceJava;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaAsgnmnt {
	//creating connection
	 private static final String USERNAME = "sql12274592";
	 private static final String PASSWORD = "BYKrdA3mDn";
	 private static final String CONN_STRING = "jdbc:mysql://sql12.freemysqlhosting.net/sql12274592?useSSL=false";
	 	
	 public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		 Connection conct = null;
		 Connection conct2 = null;
		 
			try {
				conct = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				Statement statement = conct.createStatement();
	            ResultSet result = statement.executeQuery("SHOW fields FROM emp");
	            
	            while(result.next()) {
	                System.out.println(result.getString(1)+ " " + result.getString(2) );
	            }  
	            
	            result = statement.executeQuery("select * from emp");
                String fileContent = "<HEy There>";
                FileWriter fw = new FileWriter("info.xml");
                fw.write(fileContent);
                System.out.println(fileContent);
                fw.write("\n");
                
                while(result.next()) {   
          //entities same as database
                   fw.write("<employee>"+"\n");
                   fw.write("<empno>"+result.getInt(1)+"</empno>"+"\n");
                   fw.write("<ename>"+result.getString(2)+"</ename>"+"\n");
                   fw.write("<job>"+result.getString(3)+"</job>"+"\n");
                   fw.write("<mgr>"+result.getInt(4)+"</mgr>"+"\n");
                   fw.write("<hiredate>"+result.getDate(5)+"</hiredate>"+"\n");
                   fw.write("<sal>"+result.getInt(6)+"</sal>"+"\n");
                   fw.write("<comm>"+result.getInt(7)+"</comm>"+"\n");
                   fw.write("<deptno>"+result.getInt(8)+"</deptno>"+"\n");               
                   fw.write("</employee>"+"\n");
                                   
    			}
                
                System.out.println("</HEy There>");
                fw.write("</HEy There>");             
                int update = statement.executeUpdate("insert into emp values"+ "('"+1503+"','"+"Sumit"+"','"+
                		"Singh"+"','"+9855+"','"+"1997-06-15"+"','"+235+"','"+3898+"','"+20+"')");
                fw.close();
			}
			catch (SQLException e) {
			   System.err.println(e);
			}
			finally{
			   if(conct != null) {
				   conct.close();
			   }
			}
	        
			try {
				conct2 = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
			    Statement statement = conct2.createStatement();
		        ResultSet rslt = statement.executeQuery("SHOW fields FROM emp");
		        
		        while(rslt.next()) {
		            System.out.println(rslt.getString(1)+ " " + rslt.getString(2) );
		        }     
		        
			    rslt = statement.executeQuery("select * from emp");
		        String fileContent = "<HEy THere>";
		        FileWriter fw = new FileWriter("info2.xml");
		        fw.write(fileContent);
		        System.out.println(fileContent);
		        fw.write("\n");
		                        
			    while(rslt.next()) {
					fw.write("<employee>"+"\n");
	                fw.write("<empno>"+rslt.getInt(1)+"</empno>"+"\n");
	                fw.write("<ename>"+rslt.getString(2)+"</ename>"+"\n");
	                fw.write("<job>"+rslt.getString(3)+"</job>"+"\n");
	                fw.write("<mgr>"+rslt.getInt(4)+"</mgr>"+"\n");
	                fw.write("<hiredate>"+rslt.getDate(5)+"</hiredate>"+"\n");
	                fw.write("<sal>"+rslt.getInt(6)+"</sal>"+"\n");
	                fw.write("<comm>"+rslt.getInt(7)+"</comm>"+"\n");
	                fw.write("<deptno>"+rslt.getInt(8)+"</deptno>"+"\n");                
	                fw.write("</employee>"+"\n");                    
		                               
				}
		        System.out.println("</HEy There>");
		        fw.write("</HEy There>");         
		        fw.close();		
			} 
			catch (SQLException e) {
		        System.err.println(e);
			}
			finally{
				if(conct2!=null) {
					conct2.close();
				}
			}
	}
}

