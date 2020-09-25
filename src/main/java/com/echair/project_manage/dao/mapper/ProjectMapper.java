package com.echair.project_manage.dao.mapper;

import com.echair.project_manage.common.pojo.dto.ProjectDTO;
import com.echair.project_manage.common.pojo.vo.FileVO;
import com.echair.project_manage.common.pojo.vo.ProjectDetailVO;
import com.echair.project_manage.common.pojo.vo.ProjectVO;
import com.echair.project_manage.dao.model.Project;
import com.echair.project_manage.dao.model.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    long countByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int deleteByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int deleteByPrimaryKey(Long projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int insertSelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    List<Project> selectByExampleWithBLOBs(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    List<Project> selectByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    Project selectByPrimaryKey(Long projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Tue Sep 08 15:56:59 CST 2020
     */
    int updateByPrimaryKey(Project record);

    List<ProjectVO> projectList(@Param("project")ProjectDTO projectDTO);

    ProjectDetailVO getProject(@Param("projectId") long projectId);

    List<FileVO> files(@Param("projectId")long projectId);
}