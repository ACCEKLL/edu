package org.accekll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.accekll.pojo.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FileMapper extends BaseMapper<FileInfo> {
}
