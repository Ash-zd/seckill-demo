package com.ashzd.apiplatform.mapper;

import com.ashzd.apiplatform.entity.ApiCollectionInfo;
import com.ashzd.apiplatform.entity.ApiCollectionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiCollectionInfoMapper {
    long countByExample(ApiCollectionInfoExample example);

    int deleteByExample(ApiCollectionInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApiCollectionInfo record);

    int insertSelective(ApiCollectionInfo record);

    List<ApiCollectionInfo> selectByExampleWithBLOBs(ApiCollectionInfoExample example);

    List<ApiCollectionInfo> selectByExample(ApiCollectionInfoExample example);

    ApiCollectionInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApiCollectionInfo record, @Param("example") ApiCollectionInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") ApiCollectionInfo record, @Param("example") ApiCollectionInfoExample example);

    int updateByExample(@Param("record") ApiCollectionInfo record, @Param("example") ApiCollectionInfoExample example);

    int updateByPrimaryKeySelective(ApiCollectionInfo record);

    int updateByPrimaryKeyWithBLOBs(ApiCollectionInfo record);

    int updateByPrimaryKey(ApiCollectionInfo record);
}