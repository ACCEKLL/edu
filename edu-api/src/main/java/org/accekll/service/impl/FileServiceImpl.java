package org.accekll.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.accekll.mapper.FileMapper;
import org.accekll.pojo.FileInfo;
import org.accekll.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: ZKL
 * @CreateTime: 2023/5/30 22:31
 * @Description: todo 文件上传
 **/
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileInfo> implements FileService {

    @Override
    public boolean save(MultipartFile entity, String moduleUrl) {
//        super.save()
        return false;
    }
}
