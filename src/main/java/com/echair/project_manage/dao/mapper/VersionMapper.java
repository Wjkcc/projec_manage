package com.echair.project_manage.dao.mapper;

import com.echair.project_manage.dao.model.Version;
import com.echair.project_manage.dao.model.VersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VersionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    long countByExample(VersionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int deleteByExample(VersionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int insert(Version record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int insertSelective(Version record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    List<Version> selectByExample(VersionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    Version selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int updateByExampleSelective(@Param("record") Version record, @Param("example") VersionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int updateByExample(@Param("record") Version record, @Param("example") VersionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int updateByPrimaryKeySelective(Version record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int updateByPrimaryKey(Version record);
}