package com.echair.project_manage.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MasterExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public MasterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIdIsNull() {
            addCriterion("version_id is null");
            return (Criteria) this;
        }

        public Criteria andVersionIdIsNotNull() {
            addCriterion("version_id is not null");
            return (Criteria) this;
        }

        public Criteria andVersionIdEqualTo(Integer value) {
            addCriterion("version_id =", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotEqualTo(Integer value) {
            addCriterion("version_id <>", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThan(Integer value) {
            addCriterion("version_id >", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("version_id >=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThan(Integer value) {
            addCriterion("version_id <", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThanOrEqualTo(Integer value) {
            addCriterion("version_id <=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdIn(List<Integer> values) {
            addCriterion("version_id in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotIn(List<Integer> values) {
            addCriterion("version_id not in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdBetween(Integer value1, Integer value2) {
            addCriterion("version_id between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("version_id not between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andOperationDocIsNull() {
            addCriterion("operation_doc is null");
            return (Criteria) this;
        }

        public Criteria andOperationDocIsNotNull() {
            addCriterion("operation_doc is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDocEqualTo(String value) {
            addCriterion("operation_doc =", value, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocNotEqualTo(String value) {
            addCriterion("operation_doc <>", value, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocGreaterThan(String value) {
            addCriterion("operation_doc >", value, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocGreaterThanOrEqualTo(String value) {
            addCriterion("operation_doc >=", value, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocLessThan(String value) {
            addCriterion("operation_doc <", value, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocLessThanOrEqualTo(String value) {
            addCriterion("operation_doc <=", value, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocLike(String value) {
            addCriterion("operation_doc like", value, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocNotLike(String value) {
            addCriterion("operation_doc not like", value, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocIn(List<String> values) {
            addCriterion("operation_doc in", values, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocNotIn(List<String> values) {
            addCriterion("operation_doc not in", values, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocBetween(String value1, String value2) {
            addCriterion("operation_doc between", value1, value2, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andOperationDocNotBetween(String value1, String value2) {
            addCriterion("operation_doc not between", value1, value2, "operationDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocIsNull() {
            addCriterion("database_doc is null");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocIsNotNull() {
            addCriterion("database_doc is not null");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocEqualTo(String value) {
            addCriterion("database_doc =", value, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocNotEqualTo(String value) {
            addCriterion("database_doc <>", value, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocGreaterThan(String value) {
            addCriterion("database_doc >", value, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocGreaterThanOrEqualTo(String value) {
            addCriterion("database_doc >=", value, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocLessThan(String value) {
            addCriterion("database_doc <", value, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocLessThanOrEqualTo(String value) {
            addCriterion("database_doc <=", value, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocLike(String value) {
            addCriterion("database_doc like", value, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocNotLike(String value) {
            addCriterion("database_doc not like", value, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocIn(List<String> values) {
            addCriterion("database_doc in", values, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocNotIn(List<String> values) {
            addCriterion("database_doc not in", values, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocBetween(String value1, String value2) {
            addCriterion("database_doc between", value1, value2, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andDatabaseDocNotBetween(String value1, String value2) {
            addCriterion("database_doc not between", value1, value2, "databaseDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocIsNull() {
            addCriterion("api_doc is null");
            return (Criteria) this;
        }

        public Criteria andApiDocIsNotNull() {
            addCriterion("api_doc is not null");
            return (Criteria) this;
        }

        public Criteria andApiDocEqualTo(String value) {
            addCriterion("api_doc =", value, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocNotEqualTo(String value) {
            addCriterion("api_doc <>", value, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocGreaterThan(String value) {
            addCriterion("api_doc >", value, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocGreaterThanOrEqualTo(String value) {
            addCriterion("api_doc >=", value, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocLessThan(String value) {
            addCriterion("api_doc <", value, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocLessThanOrEqualTo(String value) {
            addCriterion("api_doc <=", value, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocLike(String value) {
            addCriterion("api_doc like", value, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocNotLike(String value) {
            addCriterion("api_doc not like", value, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocIn(List<String> values) {
            addCriterion("api_doc in", values, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocNotIn(List<String> values) {
            addCriterion("api_doc not in", values, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocBetween(String value1, String value2) {
            addCriterion("api_doc between", value1, value2, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andApiDocNotBetween(String value1, String value2) {
            addCriterion("api_doc not between", value1, value2, "apiDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocIsNull() {
            addCriterion("acceptance_doc is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocIsNotNull() {
            addCriterion("acceptance_doc is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocEqualTo(String value) {
            addCriterion("acceptance_doc =", value, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocNotEqualTo(String value) {
            addCriterion("acceptance_doc <>", value, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocGreaterThan(String value) {
            addCriterion("acceptance_doc >", value, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocGreaterThanOrEqualTo(String value) {
            addCriterion("acceptance_doc >=", value, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocLessThan(String value) {
            addCriterion("acceptance_doc <", value, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocLessThanOrEqualTo(String value) {
            addCriterion("acceptance_doc <=", value, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocLike(String value) {
            addCriterion("acceptance_doc like", value, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocNotLike(String value) {
            addCriterion("acceptance_doc not like", value, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocIn(List<String> values) {
            addCriterion("acceptance_doc in", values, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocNotIn(List<String> values) {
            addCriterion("acceptance_doc not in", values, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocBetween(String value1, String value2) {
            addCriterion("acceptance_doc between", value1, value2, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDocNotBetween(String value1, String value2) {
            addCriterion("acceptance_doc not between", value1, value2, "acceptanceDoc");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table version_master
     *
     * @mbg.generated do_not_delete_during_merge Thu Sep 24 15:15:01 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table version_master
     *
     * @mbg.generated Thu Sep 24 15:15:01 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}