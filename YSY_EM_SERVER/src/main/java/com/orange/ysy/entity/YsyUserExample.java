package com.orange.ysy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YsyUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YsyUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNull() {
            addCriterion("is_vip is null");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNotNull() {
            addCriterion("is_vip is not null");
            return (Criteria) this;
        }

        public Criteria andIsVipEqualTo(Byte value) {
            addCriterion("is_vip =", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotEqualTo(Byte value) {
            addCriterion("is_vip <>", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThan(Byte value) {
            addCriterion("is_vip >", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_vip >=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThan(Byte value) {
            addCriterion("is_vip <", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThanOrEqualTo(Byte value) {
            addCriterion("is_vip <=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipIn(List<Byte> values) {
            addCriterion("is_vip in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotIn(List<Byte> values) {
            addCriterion("is_vip not in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipBetween(Byte value1, Byte value2) {
            addCriterion("is_vip between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotBetween(Byte value1, Byte value2) {
            addCriterion("is_vip not between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andWxNoIsNull() {
            addCriterion("wx_no is null");
            return (Criteria) this;
        }

        public Criteria andWxNoIsNotNull() {
            addCriterion("wx_no is not null");
            return (Criteria) this;
        }

        public Criteria andWxNoEqualTo(String value) {
            addCriterion("wx_no =", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoNotEqualTo(String value) {
            addCriterion("wx_no <>", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoGreaterThan(String value) {
            addCriterion("wx_no >", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoGreaterThanOrEqualTo(String value) {
            addCriterion("wx_no >=", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoLessThan(String value) {
            addCriterion("wx_no <", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoLessThanOrEqualTo(String value) {
            addCriterion("wx_no <=", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoLike(String value) {
            addCriterion("wx_no like", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoNotLike(String value) {
            addCriterion("wx_no not like", value, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoIn(List<String> values) {
            addCriterion("wx_no in", values, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoNotIn(List<String> values) {
            addCriterion("wx_no not in", values, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoBetween(String value1, String value2) {
            addCriterion("wx_no between", value1, value2, "wxNo");
            return (Criteria) this;
        }

        public Criteria andWxNoNotBetween(String value1, String value2) {
            addCriterion("wx_no not between", value1, value2, "wxNo");
            return (Criteria) this;
        }

        public Criteria andUserLevelIsNull() {
            addCriterion("user_level is null");
            return (Criteria) this;
        }

        public Criteria andUserLevelIsNotNull() {
            addCriterion("user_level is not null");
            return (Criteria) this;
        }

        public Criteria andUserLevelEqualTo(Short value) {
            addCriterion("user_level =", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotEqualTo(Short value) {
            addCriterion("user_level <>", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelGreaterThan(Short value) {
            addCriterion("user_level >", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("user_level >=", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelLessThan(Short value) {
            addCriterion("user_level <", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelLessThanOrEqualTo(Short value) {
            addCriterion("user_level <=", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelIn(List<Short> values) {
            addCriterion("user_level in", values, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotIn(List<Short> values) {
            addCriterion("user_level not in", values, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelBetween(Short value1, Short value2) {
            addCriterion("user_level between", value1, value2, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotBetween(Short value1, Short value2) {
            addCriterion("user_level not between", value1, value2, "userLevel");
            return (Criteria) this;
        }

        public Criteria andInviteNoIsNull() {
            addCriterion("invite_no is null");
            return (Criteria) this;
        }

        public Criteria andInviteNoIsNotNull() {
            addCriterion("invite_no is not null");
            return (Criteria) this;
        }

        public Criteria andInviteNoEqualTo(Integer value) {
            addCriterion("invite_no =", value, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoNotEqualTo(Integer value) {
            addCriterion("invite_no <>", value, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoGreaterThan(Integer value) {
            addCriterion("invite_no >", value, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("invite_no >=", value, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoLessThan(Integer value) {
            addCriterion("invite_no <", value, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoLessThanOrEqualTo(Integer value) {
            addCriterion("invite_no <=", value, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoIn(List<Integer> values) {
            addCriterion("invite_no in", values, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoNotIn(List<Integer> values) {
            addCriterion("invite_no not in", values, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoBetween(Integer value1, Integer value2) {
            addCriterion("invite_no between", value1, value2, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteNoNotBetween(Integer value1, Integer value2) {
            addCriterion("invite_no not between", value1, value2, "inviteNo");
            return (Criteria) this;
        }

        public Criteria andInviteIdIsNull() {
            addCriterion("invite_id is null");
            return (Criteria) this;
        }

        public Criteria andInviteIdIsNotNull() {
            addCriterion("invite_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviteIdEqualTo(String value) {
            addCriterion("invite_id =", value, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdNotEqualTo(String value) {
            addCriterion("invite_id <>", value, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdGreaterThan(String value) {
            addCriterion("invite_id >", value, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdGreaterThanOrEqualTo(String value) {
            addCriterion("invite_id >=", value, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdLessThan(String value) {
            addCriterion("invite_id <", value, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdLessThanOrEqualTo(String value) {
            addCriterion("invite_id <=", value, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdLike(String value) {
            addCriterion("invite_id like", value, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdNotLike(String value) {
            addCriterion("invite_id not like", value, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdIn(List<String> values) {
            addCriterion("invite_id in", values, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdNotIn(List<String> values) {
            addCriterion("invite_id not in", values, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdBetween(String value1, String value2) {
            addCriterion("invite_id between", value1, value2, "inviteId");
            return (Criteria) this;
        }

        public Criteria andInviteIdNotBetween(String value1, String value2) {
            addCriterion("invite_id not between", value1, value2, "inviteId");
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
            addCriterion("update_Time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_Time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_Time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_Time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_Time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_Time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_Time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_Time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_Time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_Time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_Time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_Time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeIsNull() {
            addCriterion("invite_time is null");
            return (Criteria) this;
        }

        public Criteria andInviteTimeIsNotNull() {
            addCriterion("invite_time is not null");
            return (Criteria) this;
        }

        public Criteria andInviteTimeEqualTo(Date value) {
            addCriterion("invite_time =", value, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeNotEqualTo(Date value) {
            addCriterion("invite_time <>", value, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeGreaterThan(Date value) {
            addCriterion("invite_time >", value, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invite_time >=", value, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeLessThan(Date value) {
            addCriterion("invite_time <", value, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeLessThanOrEqualTo(Date value) {
            addCriterion("invite_time <=", value, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeIn(List<Date> values) {
            addCriterion("invite_time in", values, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeNotIn(List<Date> values) {
            addCriterion("invite_time not in", values, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeBetween(Date value1, Date value2) {
            addCriterion("invite_time between", value1, value2, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andInviteTimeNotBetween(Date value1, Date value2) {
            addCriterion("invite_time not between", value1, value2, "inviteTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeIsNull() {
            addCriterion("vip_time is null");
            return (Criteria) this;
        }

        public Criteria andVipTimeIsNotNull() {
            addCriterion("vip_time is not null");
            return (Criteria) this;
        }

        public Criteria andVipTimeEqualTo(Date value) {
            addCriterion("vip_time =", value, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeNotEqualTo(Date value) {
            addCriterion("vip_time <>", value, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeGreaterThan(Date value) {
            addCriterion("vip_time >", value, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("vip_time >=", value, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeLessThan(Date value) {
            addCriterion("vip_time <", value, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeLessThanOrEqualTo(Date value) {
            addCriterion("vip_time <=", value, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeIn(List<Date> values) {
            addCriterion("vip_time in", values, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeNotIn(List<Date> values) {
            addCriterion("vip_time not in", values, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeBetween(Date value1, Date value2) {
            addCriterion("vip_time between", value1, value2, "vipTime");
            return (Criteria) this;
        }

        public Criteria andVipTimeNotBetween(Date value1, Date value2) {
            addCriterion("vip_time not between", value1, value2, "vipTime");
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

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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