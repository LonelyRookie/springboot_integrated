package com.hcc.springboot_integrated.controller;

import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName FileUploadController
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/8 14:41
 * @Version 1.0
 **/
@RestController
public class FileUploadController {

    @PostMapping("upload")
    public Map<String, Object> fileUpload(MultipartFile filename) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String originalFilename = filename.getOriginalFilename();

        if (originalFilename != null) {
            String path = "C:\\Users\\hcc\\Desktop\\";
            String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File new_file = new File(path + newFilename);
            filename.transferTo(new_file);//将数据写入磁盘
            map.put("msg", "ok");
            return map;
        }
        return map;
    }
}
