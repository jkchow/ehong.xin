package mblog.base.utils;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


public class LogTool {
	public static final Logger logger=Logger.getRootLogger();
	public static void info(String message){
		logger.info(message);
	}
	public static void warn(String message){
		logger.warn(message);
		
	}
	public static void error(String message){
		logger.error(message);
	}
	
	public static void print(Map data,Class className){
		Logger classlogger=null;
		if(className==null)
			classlogger=logger;
		else
			classlogger=Logger.getLogger(className);
		
		String message=JSON.toJSONString(data);
		
		//Gson gson = new  Gson();
		//String message=gson.toJson(data);
		
		classlogger.info(message);
	}
	
	public static void print(Collection data,Class className){
		Logger logger=Logger.getLogger(className);
		
		String message=JSON.toJSONString(data);
		logger.info(message);
	}
	
	public static void print(HttpSession session,Class className){
		Map data=new HashMap();
		Enumeration keys = (Enumeration) session.getAttributeNames();     
        while (keys.hasMoreElements()){  
            String key = (String) keys.nextElement();  
            data.put(key, session.getAttribute(key));     
        }
		Logger logger=Logger.getLogger(className);
		String message="session:"+JSON.toJSONString(data);
		logger.info(message);
	}
	
	public static void info(String message,Class className){
		Logger logger=Logger.getLogger(className);
		logger.info(message);
	}
	public static void warn(String message,Class className){
		Logger logger=Logger.getLogger(className);
		logger.warn(message);
	}
	public static void error(String message,Class className){
		Logger logger=Logger.getLogger(className);
		logger.error(message);
	}
	public static void error(Throwable e){
		logger.error(e.getMessage(),e);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
