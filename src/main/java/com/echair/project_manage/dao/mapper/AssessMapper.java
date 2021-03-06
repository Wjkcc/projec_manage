package com.echair.project_manage.dao.mapper;

import com.echair.project_manage.dao.model.Assess;
import com.echair.project_manage.dao.model.AssessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    long countByExample(AssessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    int deleteByExample(AssessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    int deleteByPrimaryKey(Long assessId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    int insert(Assess record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    int insertSelective(Assess record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    List<Assess> selectByExample(AssessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    Assess selectByPrimaryKey(Long assessId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    int updateByExampleSelective(@Param("record") Assess record, @Param("example") AssessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    int updateByExample(@Param("record") Assess record, @Param("example") AssessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    int updateByPrimaryKeySelective(Assess record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assess
     *
     * @mbg.generated Sat Aug 29 17:19:54 CST 2020
     */
    int updateByPrimaryKey(Assess record);
}