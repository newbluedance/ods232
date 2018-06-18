package com.ninetowns.modules.webservice;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import com.ninetowns.modules.entity.User;
import com.ninetowns.utils.MD5;
import org.antlr.grammar.v3.ANTLRParser.exceptionGroup_return;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
/**
 * @FileName :
 * @Author : 宋崇浩
 * @Create Date   :
 * @Email : SongChongHao@ninetowns.com
 * @Last Modified :
 * @Description :
 */
public class AnalysisMsg {

	/** 8 位 UCS 转换格式 */
	 public static final String UTF_8 = "UTF-8";
	 
	/**
	 * 去除字符串中的回车、
	 *     \n 回车(\u000a) 
	 *     \t 水平制表符(\u0009) 
	 *     \s 空格(\u0008)
	 *     \r 换行(\u000d)
	 */
    public static String replaceBlank(String str) 
    {
        String dest = "";
        if (str!=null) 
        {
           Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	       Matcher m = p.matcher(str);
           dest = m.replaceAll("");
        }
        return dest;
    }
    /**
     * 根据传入的字符串进行相应字符转义
     * @param str 需要转义的字符串
     * @return 转义好的字符串
     */
    public String xmlTransMeaning(String str) 
    {
		if (str == null) 
		{
			return str = "";
		}
		String tempStr = repleceString(str, "&", "&amp;");
		tempStr = repleceString(tempStr, ">", "&gt;");
		tempStr = repleceString(tempStr, "<", "&lt;");
		tempStr = repleceString(tempStr, "\"", "&quot;");
		tempStr = repleceString(tempStr, "'", "&apos;");
		return tempStr;
	}
    
    public String xmlTransMe(String str) 
    {
		if (str == null) 
		{
			return str = "";
		}
		String tempStr = repleceString(str, "%20", " ");
		return tempStr;
	}
    
    /**
     * 转义字符串
     * @param str 需要转义的字符串
     * @param source 需要转义的字符
     * @param dest 转义好的字符
     * @return 转义好的字符串
     */
    public String repleceString(String str, String source, String dest) 
    {
		String tempStr = str;
		int pos = 0;
		String tempStr2 = "";
		for (;;) 
		{
			pos = tempStr.indexOf(source);
			if (pos > -1) 
			{
				tempStr2 += tempStr.substring(0, pos);
				tempStr2 += dest;
				tempStr = tempStr.substring(pos + source.length(), tempStr
						.length());
				continue;
			} 
			else 
			{
				tempStr2 += tempStr;
				break;
			}
		}
		return tempStr2;
	}
    
    /**
     * 根据传入的XML格式报文内容生成本地XML格式文件
     * @param xml 传入的XML格式报文
     */
    public void saveXml(String xml, String entcode, String type)
    {
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			File filepath = new File("c:/dpa_xml/wpent/" + sdf.format(new Date()));
		    if(!filepath.exists()){
		    	filepath.mkdirs();
		    }
		    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String filename = filepath + "/" + sdf1.format(new Date()).replace("-", "").replace(":", "").replace(" ", "") + "_" + entcode + "-" + type + ".xml";
            //将document中的内容写入文件中--默认为UTF-8格式，指定为"GB2312"
            OutputFormat format = OutputFormat.createCompactFormat();
            format.setEncoding("GBK");
            XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)),format);
            Document doc = DocumentHelper.parseText(xml);
            writer.write(doc);
            writer.close();
		}
		catch(Exception ex)
		{
            ex.printStackTrace();
        }
	}
    /**
     * 判断传入的字符串是否为纯数字
     * @param str 传入的需要判为其是否为纯数字的字符串
     * @return 当前传入的字符串是否为纯数字
     */
    public boolean isNum(String str)
    {
		Pattern pattern = Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence)str);
		return matcher.matches();
	}
    
    public boolean formattingDate(String user, String sign) 
    {
    	String pwd = new MD5().getMD5ofStr(user + format());
    	String addpwd = new MD5().getMD5ofStr(user + getAnyDay(format(), 1));
    	String oldpwd = new MD5().getMD5ofStr(user + getAnyDay(format(), -1));
    	boolean isRes = false;
    	if (sign.equals(pwd))
    	{
    		isRes = true;
    	}
    	else if (sign.equals(addpwd))
    	{
    		isRes = true;
    	}
    	else if (sign.equals(oldpwd))
    	{
    		isRes = true;
    	}
    	return isRes;
    }

    /**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd HH
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	
	/**
	 * 得到一个时间延后或前移几小时的时间,nowdate为时间,delay为前移或后延的小时数
	 */
	public static String getAnyDay(String nowdate, int delay) {
		try 
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
			Date d = strToDate(nowdate);
			long myTime = (d.getTime() / 1000) + delay * 60 * 60;
			d.setTime(myTime * 1000);
			return format.format(d);
		} 
		catch (Exception e) 
		{
			return null;
		}
	}
    
	/**
	 * @description 获取当前时间的yyyy-MM-dd HH的时间格式
	 * @param
	 * @return current_time
	 */
	public static String format()
	{
		Date date = new Date();
		SimpleDateFormat si = new SimpleDateFormat("yyyyMMddHH");
		String current_time = si.format(date);
		return current_time;
	}
	
	public static String formatToDate()
	{
		Date date = new Date();
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current_time = si.format(date);
		return current_time;
	}
	
	public static String formatToDates(Date date)
	{
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
		String current_time = si.format(date);
		return current_time;
	}
	
	public String formatDate(String strDate) throws Exception
	{
		if (null == strDate || strDate.length() == 0)
		{
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sf.parse(strDate);
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current_time = si.format(date);
		return current_time;
	}
	
	/**
	 * 将字符编码转换成UTF-8码
	 * @param str 需要编码的字符串
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String toUTF_8(String str) throws UnsupportedEncodingException
	{
		return this.changeCharset(str, UTF_8);
	}
	
	public String toUTF8(String str) throws UnsupportedEncodingException
	{
		if (null != str)
		{
			byte[] temp = str.getBytes("utf-8");//这里写原编码方式
            String newStr = new String(temp,"utf-8");//这里写转换后的编码方式
			return newStr;
		}
		return null;
	}
	
	public String toGBK(String str) throws UnsupportedEncodingException
	{
		return this.changeCharset(str, "GBK");
	}
	 
	 /**
	  * 字符串编码转换的实现方法
	  * @param str  待转换编码的字符串
	  * @param newCharset 目标编码
	  * @return
	  * @throws UnsupportedEncodingException
	  */
	public String changeCharset(String str, String newCharset) throws UnsupportedEncodingException 
	{
		if (str != null)
		{
			//用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			//用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}
	
	/**
     * 从HttpURLConnection中得到文件长度，此HttpURLConnection为已经开启连接后的状态
     * @param hc
     * @return long
     */
    private static long getFileLength(HttpURLConnection hc)
    {
        long nFileLength = -1;
        for (int i = 1;; i++){
            String sHeader = hc.getHeaderFieldKey(i);
            if (sHeader != null){
                if (sHeader.equals("Content-Length")){
                    nFileLength = Long.parseLong(hc.getHeaderField(sHeader));
                    break;
                }
            } else {
                break;
            }
        }
        return nFileLength;
    }
    
    public static void uploadFiles(String fileName, String sUrl)
    {
    	// 定义httpURLConnection,初始为null
        HttpURLConnection hc = null;
        URL url = null;
        long beginPos = 0;
        long fileLength = 0;
        int num = 0;
        boolean isFinish = false;
        boolean isFirst = true;
        while (!isFinish && num <= 3) {
            try {
                url = new URL(sUrl);
                hc = (HttpURLConnection) url.openConnection();
                // 定义从beginPos位置处开始
                hc.setRequestProperty("User-Agent", "Java/1.4.2");
                hc.setRequestProperty("RANGE", "bytes=" + String.valueOf(beginPos) + "-");
                // 定义输入流
                InputStream instream = hc.getInputStream();
                if (isFirst) {
                    fileLength = getFileLength(hc);
                    isFirst = false;
                }
                // 创建这个文件输出流
                RandomAccessFile ras = new RandomAccessFile(fileName, "rw");
                ras.seek(beginPos);
                // 定义一个大小为1024的字节数组
                byte[] buf = new byte[1024];
                int len = instream.read(buf, 0, 1024);
                // 循环读入字节，然后写到文件输出流中
                while (len > 0) {
                    beginPos += len;
                    ras.write(buf, 0, len);
                    len = instream.read(buf, 0, 1024);
                }
                ras.close();
                if (beginPos >= fileLength) {
                    isFinish = true;
                }
            } catch (MalformedURLException e) {
                System.err.println("出错啦:" + e.getMessage());
            } catch (IOException e) {
                System.err.println("IO出错啦:" + e.getMessage());
            } finally {
                num++;
                hc.disconnect();
            }
        }
    }
    
    public static int uploadFiles2(String fileName, String sUrl)
    {
    	// 定义httpURLConnection,初始为null
        HttpURLConnection hc = null;
        URL url = null;
        long beginPos = 0;
        long fileLength = 0;
        int num = 0;
        boolean isFinish = false;
        boolean isFirst = true;
        while (!isFinish && num <= 3) 
        {
            try 
            {
                url = new URL(sUrl);
                hc = (HttpURLConnection) url.openConnection();
                // 定义从beginPos位置处开始
                hc.setRequestProperty("User-Agent", "Java/1.4.2");
                hc.setRequestProperty("RANGE", "bytes=" + String.valueOf(beginPos) + "-");
                // 定义输入流
                InputStream instream = hc.getInputStream();
                if (isFirst) {
                    fileLength = getFileLength(hc);
                    isFirst = false;
                }
                // 创建这个文件输出流
                RandomAccessFile ras = new RandomAccessFile(fileName, "rw");
                ras.seek(beginPos);
                // 定义一个大小为1024的字节数组
                byte[] buf = new byte[1024];
                int len = instream.read(buf, 0, 1024);
                // 循环读入字节，然后写到文件输出流中
                while (len > 0) 
                {
                    beginPos += len;
                    ras.write(buf, 0, len);
                    len = instream.read(buf, 0, 1024);
                }
                ras.close();
                if (beginPos >= fileLength) 
                {
                    isFinish = true;
                }
                
                return 0;
            } 
            catch (MalformedURLException e) 
            {
                System.err.println("出错啦:" + e.getMessage());
                return 1;
            } 
            catch (IOException e) 
            {
                System.err.println("IO出错啦:" + e.getMessage());
                return 1;
            } 
            finally 
            {
                num++;
                hc.disconnect();
            }
        }
        
		return 0;
    }
    
    /**
     * 解压到指定目录
     * @author isea533
     */
    public static void upCompresFile(String zipFileName, String outputDirectory) throws Exception
    {
    	ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));
    	ZipEntry z;
    	while ((z = in.getNextEntry()) != null)
    	{
    		System.out.println("正在解压 " + z.getName());
    		if (z.isDirectory())
    		{
    			String name = z.getName();
    			name = name.substring(0, name.length() - 1);
    			File f = new File(outputDirectory + File.separator + name);
    			f.mkdir();
    			System.out.println("创建目录 " + outputDirectory + File.separator + name);
    		}
    		else
    		{
    			File f = new File(outputDirectory + File.separator + z.getName());
    			f.createNewFile();
    			FileOutputStream out = new FileOutputStream(f);
    			int b;
    			while ((b = in.read()) != -1)
    			{
    				out.write(b);
    			}
    			out.close();
    		}
    	}
    	in.close();
	}
    
    public static String getFileName(String url) {
        String filename = "";
        boolean isok = false;
        // 从UrlConnection中获取文件名称
        try {
            URL myURL = new URL(url);
            URLConnection conn = myURL.openConnection();
            if (conn == null) {
                return null;
            }
            Map<String, List<String>> hf = conn.getHeaderFields();
            if (hf == null) {
                return null;
            }
            Set<String> key = hf.keySet();
            if (key == null) {
                return null;
            }
            for (String skey : key) {
                List<String> values = hf.get(skey);
                for (String value : values) {
                    String result;
                    try {
                        result = new String(value.getBytes("ISO-8859-1"), "GBK");
                        int location = result.indexOf("filename");
                        if (location >= 0) {
                            result = result.substring(location + "filename".length());
                            filename = result.substring(result.indexOf("=") + 1);
                            isok = true;
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                if (isok) {
                    break;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 从路径中获取
        if (filename == null || "".equals(filename)) {
            filename = url.substring(url.lastIndexOf("/") + 1);
        }
        return filename;
    }
    
 	/**
 	 * 复制文件
 	 * @param sourceFile 源文件
 	 * @param targetFile 目标文件
 	 * @throws IOException
 	 */
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
    
    
   
    public static String createResUserXML(String rtncode, String rtnmsg, String loginname, String errorinfno)
	{
		StringBuffer xml = new StringBuffer(2048);
		xml.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
		xml.append("<ReturnData>");
			xml.append("<Result>");
				xml.append("<RtnCode>").append(rtncode).append("</RtnCode>");
				xml.append("<RtnMsg>").append(rtnmsg).append("</RtnMsg>");
			xml.append("</Result>");
			if ("1".equals(rtncode))
			{
				xml.append("<ErrorList>");
					xml.append("<Error>");
						xml.append("<LoginName>").append(loginname).append("</LoginName>");
						xml.append("<ErrorInfo>").append(errorinfno).append("</ErrorInfo>");
					xml.append("</Error>");
				xml.append("</ErrorList>");
			}
		xml.append("</ReturnData>");
		return xml.toString();
	}
    
    public static String createResOrgXML(String rtncode, String rtnmsg, String deptcode, String errorinfno)
	{
		StringBuffer xml = new StringBuffer(2048);
		xml.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
		xml.append("<ReturnData>");
			xml.append("<Result>");
				xml.append("<RtnCode>").append(rtncode).append("</RtnCode>");
				xml.append("<RtnMsg>").append(rtnmsg).append("</RtnMsg>");
			xml.append("</Result>");
			if ("1".equals(rtncode))
			{
				xml.append("<ErrorList>");
					xml.append("<Error>");
						xml.append("<DataPk>").append(deptcode).append("</DataPk>");
						xml.append("<ErrorInfo>").append(errorinfno).append("</ErrorInfo>");
					xml.append("</Error>");
				xml.append("</ErrorList>");
			}
		xml.append("</ReturnData>");
		return xml.toString();
	}
    
    public static Date dateFormat(String format) throws Exception 
    {
    	if (null == format || format.length() == 0)
		{
			return new Date();
		}
		Date date = null;
		try
		{
			date = new SimpleDateFormat("yyyyMMddHHmmss").parse(format);
		}
		catch (Exception e)
		{
			System.out.println("日期不符合规范或日期输入格式错误。");
		}
		return date;
	}
	
    public static void main(String[] args) throws Exception{
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	System.out.println(formatDate(""));
//    	System.out.println(formatDate("2014-07-07 25:12:22"));
//    	System.out.println(getAnyDay("2014070711" , 1));
//    	String str = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><RequestData><updateModel>A</updateModel><updateDate>2015-01-04 17:54:23</updateDate><UserList><UserEntity><userId>songchonghao</userId></UserEntity></UserList></RequestData>";
//    	userAnalysis(str);
//    	Date date = dateFormat("");
    	Date date = dateFormat("20140302120000");
    	
    	System.out.println("格式化好的日期时间格式：" + simpleDateFormat.format(date));
    }
}
