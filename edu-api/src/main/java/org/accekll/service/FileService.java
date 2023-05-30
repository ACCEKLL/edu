package org.accekll.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.accekll.pojo.FileInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileService extends IService<FileInfo> {

     boolean save(MultipartFile entity, String moduleUrl);

}
