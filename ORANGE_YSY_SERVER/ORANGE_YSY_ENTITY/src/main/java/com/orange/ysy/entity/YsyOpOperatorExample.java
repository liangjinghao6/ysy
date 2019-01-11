package com.orange.ysy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YsyOpOperatorExample {
    /**
     * ysy_op_operator
     */
    protected String orderByClause;

    /**
     * ysy_op_operator
     */
    protected boolean distinct;

    /**
     * ysy_op_operator
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public YsyOpOperatorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    /**
     * ysy_op_operator 2019-01-11
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

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("operator_id like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("operator_id not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNull() {
            addCriterion("is_lock is null");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNotNull() {
            addCriterion("is_lock is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockEqualTo(Boolean value) {
            addCriterion("is_lock =", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotEqualTo(Boolean value) {
            addCriterion("is_lock <>", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThan(Boolean value) {
            addCriterion("is_lock >", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_lock >=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThan(Boolean value) {
            addCriterion("is_lock <", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThanOrEqualTo(Boolean value) {
            addCriterion("is_lock <=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockIn(List<Boolean> values) {
            addCriterion("is_lock in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotIn(List<Boolean> values) {
            addCriterion("is_lock not in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockBetween(Boolean value1, Boolean value2) {
            addCriterion("is_lock between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_lock not between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsStopIsNull() {
            addCriterion("is_stop is null");
            return (Criteria) this;
        }

        public Criteria andIsStopIsNotNull() {
            addCriterion("is_stop is not null");
            return (Criteria) this;
        }

        public Criteria andIsStopEqualTo(Boolean value) {
            addCriterion("is_stop =", value, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopNotEqualTo(Boolean value) {
            addCriterion("is_stop <>", value, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopGreaterThan(Boolean value) {
            addCriterion("is_stop >", value, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_stop >=", value, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopLessThan(Boolean value) {
            addCriterion("is_stop <", value, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopLessThanOrEqualTo(Boolean value) {
            addCriterion("is_stop <=", value, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopIn(List<Boolean> values) {
            addCriterion("is_stop in", values, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopNotIn(List<Boolean> values) {
            addCriterion("is_stop not in", values, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopBetween(Boolean value1, Boolean value2) {
            addCriterion("is_stop between", value1, value2, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsStopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_stop not between", value1, value2, "isStop");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireIsNull() {
            addCriterion("is_pwd_expire is null");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireIsNotNull() {
            addCriterion("is_pwd_expire is not null");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireEqualTo(Boolean value) {
            addCriterion("is_pwd_expire =", value, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireNotEqualTo(Boolean value) {
            addCriterion("is_pwd_expire <>", value, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireGreaterThan(Boolean value) {
            addCriterion("is_pwd_expire >", value, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_pwd_expire >=", value, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireLessThan(Boolean value) {
            addCriterion("is_pwd_expire <", value, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireLessThanOrEqualTo(Boolean value) {
            addCriterion("is_pwd_expire <=", value, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireIn(List<Boolean> values) {
            addCriterion("is_pwd_expire in", values, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireNotIn(List<Boolean> values) {
            addCriterion("is_pwd_expire not in", values, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pwd_expire between", value1, value2, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andIsPwdExpireNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pwd_expire not between", value1, value2, "isPwdExpire");
            return (Criteria) this;
        }

        public Criteria andPwdDurationIsNull() {
            addCriterion("pwd_duration is null");
            return (Criteria) this;
        }

        public Criteria andPwdDurationIsNotNull() {
            addCriterion("pwd_duration is not null");
            return (Criteria) this;
        }

        public Criteria andPwdDurationEqualTo(Short value) {
            addCriterion("pwd_duration =", value, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationNotEqualTo(Short value) {
            addCriterion("pwd_duration <>", value, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationGreaterThan(Short value) {
            addCriterion("pwd_duration >", value, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationGreaterThanOrEqualTo(Short value) {
            addCriterion("pwd_duration >=", value, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationLessThan(Short value) {
            addCriterion("pwd_duration <", value, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationLessThanOrEqualTo(Short value) {
            addCriterion("pwd_duration <=", value, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationIn(List<Short> values) {
            addCriterion("pwd_duration in", values, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationNotIn(List<Short> values) {
            addCriterion("pwd_duration not in", values, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationBetween(Short value1, Short value2) {
            addCriterion("pwd_duration between", value1, value2, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdDurationNotBetween(Short value1, Short value2) {
            addCriterion("pwd_duration not between", value1, value2, "pwdDuration");
            return (Criteria) this;
        }

        public Criteria andPwdTimeIsNull() {
            addCriterion("pwd_time is null");
            return (Criteria) this;
        }

        public Criteria andPwdTimeIsNotNull() {
            addCriterion("pwd_time is not null");
            return (Criteria) this;
        }

        public Criteria andPwdTimeEqualTo(Date value) {
            addCriterion("pwd_time =", value, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeNotEqualTo(Date value) {
            addCriterion("pwd_time <>", value, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeGreaterThan(Date value) {
            addCriterion("pwd_time >", value, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pwd_time >=", value, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeLessThan(Date value) {
            addCriterion("pwd_time <", value, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeLessThanOrEqualTo(Date value) {
            addCriterion("pwd_time <=", value, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeIn(List<Date> values) {
            addCriterion("pwd_time in", values, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeNotIn(List<Date> values) {
            addCriterion("pwd_time not in", values, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeBetween(Date value1, Date value2) {
            addCriterion("pwd_time between", value1, value2, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andPwdTimeNotBetween(Date value1, Date value2) {
            addCriterion("pwd_time not between", value1, value2, "pwdTime");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeIsNull() {
            addCriterion("is_pwd_change is null");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeIsNotNull() {
            addCriterion("is_pwd_change is not null");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeEqualTo(Boolean value) {
            addCriterion("is_pwd_change =", value, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeNotEqualTo(Boolean value) {
            addCriterion("is_pwd_change <>", value, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeGreaterThan(Boolean value) {
            addCriterion("is_pwd_change >", value, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_pwd_change >=", value, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeLessThan(Boolean value) {
            addCriterion("is_pwd_change <", value, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_pwd_change <=", value, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeIn(List<Boolean> values) {
            addCriterion("is_pwd_change in", values, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeNotIn(List<Boolean> values) {
            addCriterion("is_pwd_change not in", values, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pwd_change between", value1, value2, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsPwdChangeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pwd_change not between", value1, value2, "isPwdChange");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireIsNull() {
            addCriterion("is_account_expire is null");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireIsNotNull() {
            addCriterion("is_account_expire is not null");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireEqualTo(Boolean value) {
            addCriterion("is_account_expire =", value, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireNotEqualTo(Boolean value) {
            addCriterion("is_account_expire <>", value, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireGreaterThan(Boolean value) {
            addCriterion("is_account_expire >", value, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_account_expire >=", value, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireLessThan(Boolean value) {
            addCriterion("is_account_expire <", value, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireLessThanOrEqualTo(Boolean value) {
            addCriterion("is_account_expire <=", value, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireIn(List<Boolean> values) {
            addCriterion("is_account_expire in", values, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireNotIn(List<Boolean> values) {
            addCriterion("is_account_expire not in", values, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireBetween(Boolean value1, Boolean value2) {
            addCriterion("is_account_expire between", value1, value2, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andIsAccountExpireNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_account_expire not between", value1, value2, "isAccountExpire");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIsNull() {
            addCriterion("account_time is null");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIsNotNull() {
            addCriterion("account_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTimeEqualTo(Date value) {
            addCriterion("account_time =", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotEqualTo(Date value) {
            addCriterion("account_time <>", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeGreaterThan(Date value) {
            addCriterion("account_time >", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("account_time >=", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeLessThan(Date value) {
            addCriterion("account_time <", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeLessThanOrEqualTo(Date value) {
            addCriterion("account_time <=", value, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeIn(List<Date> values) {
            addCriterion("account_time in", values, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotIn(List<Date> values) {
            addCriterion("account_time not in", values, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeBetween(Date value1, Date value2) {
            addCriterion("account_time between", value1, value2, "accountTime");
            return (Criteria) this;
        }

        public Criteria andAccountTimeNotBetween(Date value1, Date value2) {
            addCriterion("account_time not between", value1, value2, "accountTime");
            return (Criteria) this;
        }

        public Criteria andSkinIsNull() {
            addCriterion("skin is null");
            return (Criteria) this;
        }

        public Criteria andSkinIsNotNull() {
            addCriterion("skin is not null");
            return (Criteria) this;
        }

        public Criteria andSkinEqualTo(Short value) {
            addCriterion("skin =", value, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinNotEqualTo(Short value) {
            addCriterion("skin <>", value, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinGreaterThan(Short value) {
            addCriterion("skin >", value, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinGreaterThanOrEqualTo(Short value) {
            addCriterion("skin >=", value, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinLessThan(Short value) {
            addCriterion("skin <", value, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinLessThanOrEqualTo(Short value) {
            addCriterion("skin <=", value, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinIn(List<Short> values) {
            addCriterion("skin in", values, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinNotIn(List<Short> values) {
            addCriterion("skin not in", values, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinBetween(Short value1, Short value2) {
            addCriterion("skin between", value1, value2, "skin");
            return (Criteria) this;
        }

        public Criteria andSkinNotBetween(Short value1, Short value2) {
            addCriterion("skin not between", value1, value2, "skin");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(Short value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(Short value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(Short value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(Short value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(Short value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(Short value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<Short> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<Short> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(Short value1, Short value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(Short value1, Short value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
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

        public Criteria andRecordStatusIsNull() {
            addCriterion("record_status is null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIsNotNull() {
            addCriterion("record_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecordStatusEqualTo(Short value) {
            addCriterion("record_status =", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotEqualTo(Short value) {
            addCriterion("record_status <>", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThan(Short value) {
            addCriterion("record_status >", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("record_status >=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThan(Short value) {
            addCriterion("record_status <", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusLessThanOrEqualTo(Short value) {
            addCriterion("record_status <=", value, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusIn(List<Short> values) {
            addCriterion("record_status in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotIn(List<Short> values) {
            addCriterion("record_status not in", values, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusBetween(Short value1, Short value2) {
            addCriterion("record_status between", value1, value2, "recordStatus");
            return (Criteria) this;
        }

        public Criteria andRecordStatusNotBetween(Short value1, Short value2) {
            addCriterion("record_status not between", value1, value2, "recordStatus");
            return (Criteria) this;
        }
    }

    /**
     * ysy_op_operator
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * ysy_op_operator 2019-01-11
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