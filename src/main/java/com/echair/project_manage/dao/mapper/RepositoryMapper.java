package com.echair.project_manage.dao.mapper;

import com.echair.project_manage.dao.model.Repository;
import com.echair.project_manage.dao.model.RepositoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepositoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    long countByExample(RepositoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int deleteByExample(RepositoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int insert(Repository record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int insertSelective(Repository record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    List<Repository> selectByExample(RepositoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    Repository selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int updateByExampleSelective(@Param("record") Repository record, @Param("example") RepositoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int updateByExample(@Param("record") Repository record, @Param("example") RepositoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int updateByPrimaryKeySelective(Repository record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table repository
     *
     * @mbg.generated Sat Aug 29 17:19:55 CST 2020
     */
    int updateByPrimaryKey(Repository record);
}