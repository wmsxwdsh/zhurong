package com.zhurong.solution.project2utf8;
  
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.ByteOrderMarkDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;
  
/**
 * *****************************************************************
 * Created on 2017年4月23日 上午3:46:06
 * @author LZG (mailto:liuzhongguochn@gmail.com)
 * 功能说明： 开源项目cpdetector实现文件编码检测
 ******************************************************************
 */
public class EncodeDetector {
  
	//测试
	public static void main(String[] args) {
		String filePath = "F:\\mars2project\\feima\\src\\com\\core\\HtmlUtils.java";
		File file = new File(filePath);
		
		String fileEncode = getLocalFileEncode(file);
		System.out.println(fileEncode);
	}
	
    /**
     * 获取本地文件的编码格式
     * @param localFile 要判断的文件
     */
    public static String getLocalFileEncode(File localFile) {
  
        /*
         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。
         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。
         */
        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();
        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。
        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
        codepageDetector.add(new ByteOrderMarkDetector());  
        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定
        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定
        Charset charset = null;
        try {
            charset = codepageDetector.detectCodepage(localFile.toURI().toURL());
            if (charset != null){
                return charset.name();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      
    /**
     * 获得远程URL文件的编码格式
     * @param url 远程文件的URL路径
     */
    public static String getURLFileEncode(URL url) {
  
        /*
         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。
         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。
         */
        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();
        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。
        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定
        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定
        Charset charset = null;
        try {
            charset = codepageDetector.detectCodepage(url);
            if (charset != null){
                return charset.name();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      
    /**
     * 获得文件流的编码格式
     * @param inputStream 文件流
     */
    public static String getInputStreamEncode(InputStream inputStream) {
  
        /*
         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。
         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。
         */
        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();
        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。
        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定
        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定
        Charset charset = null;
        try {
            charset = codepageDetector.detectCodepage(inputStream, 0);
            if (charset != null){
                return charset.name();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      
    /**
     * 获得字符串的编码格式
     * @param stringValue 要判断的字符串
     */
    public static String getStringEncode(String stringValue) {
  
        /*
         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。
         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。
         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。
         */
        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();
        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。
        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定
        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定
        try {
            InputStream inputStream = new ByteArrayInputStream(stringValue.getBytes());
            Charset charset = codepageDetector.detectCodepage(inputStream, 3);
            if (charset != null){
                return charset.name();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}