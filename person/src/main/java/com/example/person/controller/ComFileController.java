package com.example.person.controller;

import com.example.person.entity.ComFile;
import com.example.person.entity.ComFileParam;
import com.example.person.entity.Response;
import com.example.person.service.ComFileService;
import com.example.person.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
* ComFileController
* Created by yec on 2019/7/29.
*/
@Slf4j
@RestController
@RequestMapping("/comFile")
public class ComFileController {

    @Resource
    private ComFileService comFileService;
    //文件上传路径: C:/upload/
    @Value("${file_savePath}")
    private String savePath;


    @PostMapping("/upload")
    public Response upload( MultipartHttpServletRequest request) throws IOException {
           return new Response().success(FileUtil.upload( savePath,request));
    }

    //附件下载   filePath  文件路径   fileName  文件名
    @GetMapping("/download")
    public void download(@RequestParam(value = "filePath")String filePath,
                         @RequestParam(value = "fileName")String fileName,HttpServletResponse response) throws UnsupportedEncodingException {
        FileUtil.download(filePath,fileName,response);
    }


    @RequestMapping("/list")
    public Response getList(int pageNum, int pageSize, ComFile comFile) throws Exception {

        List<ComFile> comFiles = comFileService.selectByCondition(comFile);
        long total = 100;  //((Page<ComFile>) comFiles).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("list", comFiles);

        return new Response().success(data);
    }

    @RequestMapping("/add")
    public Response add(ComFile comFile) throws Exception {
        comFileService.save(comFile);
        return new Response().success(comFile);
    }

    @RequestMapping("/update")
    public Response update(ComFile comFile) throws Exception {
        comFileService.update(comFile);
        return new Response().success(comFile);
    }

    @RequestMapping("/delete")
    public Response delete(ComFile comFile) throws Exception {
        comFileService.deleteByPrimaryKey(comFile.getId());
        return new Response().success(comFile);
    }

    @RequestMapping("/selectById")
    public Response selectById(String id) throws Exception {
        ComFile comFile = comFileService.selectByPrimaryKey(id);
        return new Response().success(comFile);
    }

    @PostMapping("/uploadBatch")
    public Response uploadBatch(MultipartHttpServletRequest request) throws IOException {
        List<MultipartFile> files = request.getFiles("file");
        String filePath = request.getParameter("filePath");
        for (MultipartFile file : files) {
            FileUtils.writeByteArrayToFile(new File(filePath + file.getOriginalFilename()), file.getBytes(), false);
        }
        return new Response().success();
    }

    @PostMapping("/saveParentFiles")
	public Response saveParentFiles(Integer type, String parentId, @RequestBody List<ComFile> files) throws Exception {
		comFileService.saveParentFiles(type, parentId, files);

    	return new Response().success();
	}

	@PostMapping("/listParentFiles")
	public Response listParentFiles(Integer type, String parentId) {
		return new Response().success(comFileService.listParentFiles(type, parentId));
	}


    /**
     * 批量存储多附件
     * @param params
     * @return
     */
	@PostMapping("/batchSaveParentFiles")
	@Transactional
    public Response batchSaveParentFiles(@RequestBody List<ComFileParam> params){
        params.forEach(p -> {
            try {
                comFileService.saveParentFiles(p.getType(), p.getParentId(), p.getFiles());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return new Response().success();
    }

    /**
     * 批量取出多附件
     * @param params
     * @return
     */
	@PostMapping("/batchListParentFiles")
    public Response batchListParentFiles(@RequestBody List<ComFileParam> params){
        params.forEach(e ->e.setFiles(comFileService.listParentFiles(e.getType(), e.getParentId())));
        return new Response().success(params);
    }
}
