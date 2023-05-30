package org.accekll.controller;

import org.accekll.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: ZKL
 * @CreateTime: 2023/5/30 21:59
 * @Description:
 **/
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public Object uploadFile(@RequestPart MultipartFile multipartFile,
                             @RequestParam String moduleUrl){

        System.out.println(multipartFile);
        System.out.println(moduleUrl);
        fileService.save(multipartFile,moduleUrl);
        return "ok";
    }



}
