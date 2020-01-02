package com.example.person.utils;

import com.example.person.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description   文件操作工具类
 * @Author  caicheng
 * @Date 2019/8/3$
 **/
@Slf4j
public class FileUtil {

    /**
     * 文件上传
     * @param savePath
     * @param request
     * @return
     * @throws IOException
     */
    public static Map<String,Object> upload(String savePath,MultipartHttpServletRequest request) throws IOException {
        log.info(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort());
        MultipartFile file = request.getFiles("file").get(0);
        String originalFileName = file.getOriginalFilename();
        //文件名后缀
        String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + suffix;
        FileUtils.writeByteArrayToFile(new File(savePath + fileName), file.getBytes(), false);

        Map<String,Object> out = new HashMap<>();
        out.put("oldFileNameSuffix",originalFileName );
        out.put("newFilePath",savePath + fileName );
        log.info( "uploaduploadupload=== "+ out);
        return out;
    }

    /**
     * 文件下载  zip|rar|7z|mp4|png|jpg|txt|csv  等等类型文件
     * @param filePath
     * @param fileName
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void download(String filePath,String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        File file = new File(filePath);
        fileName = (fileName == null) ? filePath.substring(filePath.lastIndexOf("/") + 1) : fileName;
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");

        //2不同浏览器对编码识别判断
//		if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
//			fileName = new String(fileName.getBytes("GBK"), "ISO8859-1");
//		} else {//firefox、chrome、safari、opera
        fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
//		}
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];

        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            // 创建输出流
            os = response.getOutputStream();
            // 创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            // 循环将输入流中的内容读取到缓冲区当中
            while ((len = bis.read(buffer)) > 0) {
                // 输出缓冲区的内容到浏览器，实现文件下载
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 文件存储通用方法
     * @param input     输入流
     * @param fileName  文件名称  如  XXX.doc   XXX.jpg
     * @param path      存储路径
     * @return success  成功标志位
     */
    public static boolean saveFile(InputStream input, String fileName, String path) {
        boolean success = true;

        OutputStream os = null;
        try {
            // 2、保存到临时文件
            // 10K的数据缓冲
            byte[] bs = new byte[10240];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = input.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }
}
