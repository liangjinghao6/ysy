package com.orange.ysy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YsyGoodsCategoryExample {
    /**
     * ysy_goods_category
     */
    protected String orderByClause;

    /**
     * ysy_goods_category
     */
    protected boolean distinct;

    /**
     * ysy_goods_category
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     *
     * @mbg.generated 2019-01-11
     */
    public YsyGoodsCategoryExample() {
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
     * ysy_goods_category 2019-01-11
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryNoIsNull() {
            addCriterion("category_no is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNoIsNotNull() {
            addCriterion("category_no is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNoEqualTo(Integer value) {
            addCriterion("category_no =", value, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoNotEqualTo(Integer value) {
            addCriterion("category_no <>", value, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoGreaterThan(Integer value) {
            addCriterion("category_no >", value, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_no >=", value, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoLessThan(Integer value) {
            addCriterion("category_no <", value, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoLessThanOrEqualTo(Integer value) {
            addCriterion("category_no <=", value, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoIn(List<Integer> values) {
            addCriterion("category_no in", values, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoNotIn(List<Integer> values) {
            addCriterion("category_no not in", values, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoBetween(Integer value1, Integer value2) {
            addCriterion("category_no between", value1, value2, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNoNotBetween(Integer value1, Integer value2) {
            addCriterion("category_no not between", value1, value2, "categoryNo");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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

        public Criteria andCategoryIconIsNull() {
            addCriterion("category_icon is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIconIsNotNull() {
            addCriterion("category_icon is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIconEqualTo(String value) {
            addCriterion("category_icon =", value, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconNotEqualTo(String value) {
            addCriterion("category_icon <>", value, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconGreaterThan(String value) {
            addCriterion("category_icon >", value, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconGreaterThanOrEqualTo(String value) {
            addCriterion("category_icon >=", value, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconLessThan(String value) {
            addCriterion("category_icon <", value, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconLessThanOrEqualTo(String value) {
            addCriterion("category_icon <=", value, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconLike(String value) {
            addCriterion("category_icon like", value, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconNotLike(String value) {
            addCriterion("category_icon not like", value, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconIn(List<String> values) {
            addCriterion("category_icon in", values, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconNotIn(List<String> values) {
            addCriterion("category_icon not in", values, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconBetween(String value1, String value2) {
            addCriterion("category_icon between", value1, value2, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIconNotBetween(String value1, String value2) {
            addCriterion("category_icon not between", value1, value2, "categoryIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIsNull() {
            addCriterion("category_url is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIsNotNull() {
            addCriterion("category_url is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlEqualTo(String value) {
            addCriterion("category_url =", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotEqualTo(String value) {
            addCriterion("category_url <>", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlGreaterThan(String value) {
            addCriterion("category_url >", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlGreaterThanOrEqualTo(String value) {
            addCriterion("category_url >=", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLessThan(String value) {
            addCriterion("category_url <", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLessThanOrEqualTo(String value) {
            addCriterion("category_url <=", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlLike(String value) {
            addCriterion("category_url like", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotLike(String value) {
            addCriterion("category_url not like", value, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlIn(List<String> values) {
            addCriterion("category_url in", values, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotIn(List<String> values) {
            addCriterion("category_url not in", values, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlBetween(String value1, String value2) {
            addCriterion("category_url between", value1, value2, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryUrlNotBetween(String value1, String value2) {
            addCriterion("category_url not between", value1, value2, "categoryUrl");
            return (Criteria) this;
        }

        public Criteria andCategoryImgIsNull() {
            addCriterion("category_img is null");
            return (Criteria) this;
        }

        public Criteria andCategoryImgIsNotNull() {
            addCriterion("category_img is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryImgEqualTo(String value) {
            addCriterion("category_img =", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgNotEqualTo(String value) {
            addCriterion("category_img <>", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgGreaterThan(String value) {
            addCriterion("category_img >", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgGreaterThanOrEqualTo(String value) {
            addCriterion("category_img >=", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgLessThan(String value) {
            addCriterion("category_img <", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgLessThanOrEqualTo(String value) {
            addCriterion("category_img <=", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgLike(String value) {
            addCriterion("category_img like", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgNotLike(String value) {
            addCriterion("category_img not like", value, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgIn(List<String> values) {
            addCriterion("category_img in", values, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgNotIn(List<String> values) {
            addCriterion("category_img not in", values, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgBetween(String value1, String value2) {
            addCriterion("category_img between", value1, value2, "categoryImg");
            return (Criteria) this;
        }

        public Criteria andCategoryImgNotBetween(String value1, String value2) {
            addCriterion("category_img not between", value1, value2, "categoryImg");
            return (Criteria) this;
        }
    }

    /**
     * ysy_goods_category
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * ysy_goods_category 2019-01-11
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