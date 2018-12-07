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

		public Criteria andIsVipIsNull() {
			addCriterion("is_vip is null");
			return (Criteria) this;
		}

		public Criteria andIsVipIsNotNull() {
			addCriterion("is_vip is not null");
			return (Criteria) this;
		}

		public Criteria andIsVipEqualTo(Boolean value) {
			addCriterion("is_vip =", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipNotEqualTo(Boolean value) {
			addCriterion("is_vip <>", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipGreaterThan(Boolean value) {
			addCriterion("is_vip >", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_vip >=", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipLessThan(Boolean value) {
			addCriterion("is_vip <", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipLessThanOrEqualTo(Boolean value) {
			addCriterion("is_vip <=", value, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipIn(List<Boolean> values) {
			addCriterion("is_vip in", values, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipNotIn(List<Boolean> values) {
			addCriterion("is_vip not in", values, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipBetween(Boolean value1, Boolean value2) {
			addCriterion("is_vip between", value1, value2, "isVip");
			return (Criteria) this;
		}

		public Criteria andIsVipNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_vip not between", value1, value2, "isVip");
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

		public Criteria andUserWxIsNull() {
			addCriterion("user_wx is null");
			return (Criteria) this;
		}

		public Criteria andUserWxIsNotNull() {
			addCriterion("user_wx is not null");
			return (Criteria) this;
		}

		public Criteria andUserWxEqualTo(String value) {
			addCriterion("user_wx =", value, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxNotEqualTo(String value) {
			addCriterion("user_wx <>", value, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxGreaterThan(String value) {
			addCriterion("user_wx >", value, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxGreaterThanOrEqualTo(String value) {
			addCriterion("user_wx >=", value, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxLessThan(String value) {
			addCriterion("user_wx <", value, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxLessThanOrEqualTo(String value) {
			addCriterion("user_wx <=", value, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxLike(String value) {
			addCriterion("user_wx like", value, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxNotLike(String value) {
			addCriterion("user_wx not like", value, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxIn(List<String> values) {
			addCriterion("user_wx in", values, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxNotIn(List<String> values) {
			addCriterion("user_wx not in", values, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxBetween(String value1, String value2) {
			addCriterion("user_wx between", value1, value2, "userWx");
			return (Criteria) this;
		}

		public Criteria andUserWxNotBetween(String value1, String value2) {
			addCriterion("user_wx not between", value1, value2, "userWx");
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

		public Criteria andInviteCodeIsNull() {
			addCriterion("invite_code is null");
			return (Criteria) this;
		}

		public Criteria andInviteCodeIsNotNull() {
			addCriterion("invite_code is not null");
			return (Criteria) this;
		}

		public Criteria andInviteCodeEqualTo(String value) {
			addCriterion("invite_code =", value, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeNotEqualTo(String value) {
			addCriterion("invite_code <>", value, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeGreaterThan(String value) {
			addCriterion("invite_code >", value, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeGreaterThanOrEqualTo(String value) {
			addCriterion("invite_code >=", value, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeLessThan(String value) {
			addCriterion("invite_code <", value, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeLessThanOrEqualTo(String value) {
			addCriterion("invite_code <=", value, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeLike(String value) {
			addCriterion("invite_code like", value, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeNotLike(String value) {
			addCriterion("invite_code not like", value, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeIn(List<String> values) {
			addCriterion("invite_code in", values, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeNotIn(List<String> values) {
			addCriterion("invite_code not in", values, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeBetween(String value1, String value2) {
			addCriterion("invite_code between", value1, value2, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andInviteCodeNotBetween(String value1, String value2) {
			addCriterion("invite_code not between", value1, value2, "inviteCode");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNull() {
			addCriterion("parent_id is null");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNotNull() {
			addCriterion("parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andParentIdEqualTo(String value) {
			addCriterion("parent_id =", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotEqualTo(String value) {
			addCriterion("parent_id <>", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThan(String value) {
			addCriterion("parent_id >", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThanOrEqualTo(String value) {
			addCriterion("parent_id >=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThan(String value) {
			addCriterion("parent_id <", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThanOrEqualTo(String value) {
			addCriterion("parent_id <=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLike(String value) {
			addCriterion("parent_id like", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotLike(String value) {
			addCriterion("parent_id not like", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdIn(List<String> values) {
			addCriterion("parent_id in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotIn(List<String> values) {
			addCriterion("parent_id not in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdBetween(String value1, String value2) {
			addCriterion("parent_id between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotBetween(String value1, String value2) {
			addCriterion("parent_id not between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeIsNull() {
			addCriterion("invited_time is null");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeIsNotNull() {
			addCriterion("invited_time is not null");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeEqualTo(Date value) {
			addCriterion("invited_time =", value, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeNotEqualTo(Date value) {
			addCriterion("invited_time <>", value, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeGreaterThan(Date value) {
			addCriterion("invited_time >", value, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("invited_time >=", value, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeLessThan(Date value) {
			addCriterion("invited_time <", value, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeLessThanOrEqualTo(Date value) {
			addCriterion("invited_time <=", value, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeIn(List<Date> values) {
			addCriterion("invited_time in", values, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeNotIn(List<Date> values) {
			addCriterion("invited_time not in", values, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeBetween(Date value1, Date value2) {
			addCriterion("invited_time between", value1, value2, "invitedTime");
			return (Criteria) this;
		}

		public Criteria andInvitedTimeNotBetween(Date value1, Date value2) {
			addCriterion("invited_time not between", value1, value2, "invitedTime");
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