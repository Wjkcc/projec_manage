package com.echair.project_manage.dao.mapper;

import com.echair.project_manage.common.pojo.vo.ParticipationVO;
import com.echair.project_manage.dao.model.Participation;
import com.echair.project_manage.dao.model.ParticipationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParticipationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    long countByExample(ParticipationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    int deleteByExample(ParticipationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    int insert(Participation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    int insertSelective(Participation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    List<Participation> selectByExample(ParticipationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    Participation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    int updateByExampleSelective(@Param("record") Participation record, @Param("example") ParticipationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    int updateByExample(@Param("record") Participation record, @Param("example") ParticipationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    int updateByPrimaryKeySelective(Participation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table participation
     *
     * @mbg.generated Mon Sep 14 15:37:24 CST 2020
     */
    int updateByPrimaryKey(Participation record);

    List<ParticipationVO> projectParticipationList(@Param("projectId") long projectId);
}