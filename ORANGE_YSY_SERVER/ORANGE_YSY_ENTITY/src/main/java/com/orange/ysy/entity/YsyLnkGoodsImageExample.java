package com.orange.ysy.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YsyLnkGoodsImageExample {
    /**
     * ysy_lnk_goods_image
     */
    protected String orderByClause;

    /**
     * ysy_lnk_goods_image
     */
    protected boolean distinct;

    /**
     * ysy_lnk_goods_image
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     *
     * @mbg.generated 2019-01-09
     */
    public YsyLnkGoodsImageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2019-01-09
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-01-09
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2019-01-09
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2019-01-09
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2019-01-09
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2019-01-09
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2019-01-09
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-01-09
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
     * @mbg.generated 2019-01-09
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2019-01-09
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
     * ysy_lnk_goods_image 2019-01-09
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

        public Criteria andGiIdIsNull() {
            addCriterion("gi_id is null");
            return (Criteria) this;
        }

        public Criteria andGiIdIsNotNull() {
            addCriterion("gi_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiIdEqualTo(String value) {
            addCriterion("gi_id =", value, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdNotEqualTo(String value) {
            addCriterion("gi_id <>", value, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdGreaterThan(String value) {
            addCriterion("gi_id >", value, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdGreaterThanOrEqualTo(String value) {
            addCriterion("gi_id >=", value, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdLessThan(String value) {
            addCriterion("gi_id <", value, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdLessThanOrEqualTo(String value) {
            addCriterion("gi_id <=", value, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdLike(String value) {
            addCriterion("gi_id like", value, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdNotLike(String value) {
            addCriterion("gi_id not like", value, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdIn(List<String> values) {
            addCriterion("gi_id in", values, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdNotIn(List<String> values) {
            addCriterion("gi_id not in", values, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdBetween(String value1, String value2) {
            addCriterion("gi_id between", value1, value2, "giId");
            return (Criteria) this;
        }

        public Criteria andGiIdNotBetween(String value1, String value2) {
            addCriterion("gi_id not between", value1, value2, "giId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(String value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(String value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(String value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(String value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(String value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLike(String value) {
            addCriterion("image_id like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotLike(String value) {
            addCriterion("image_id not like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<String> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<String> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(String value1, String value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(String value1, String value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNull() {
            addCriterion("image_type is null");
            return (Criteria) this;
        }

        public Criteria andImageTypeIsNotNull() {
            addCriterion("image_type is not null");
            return (Criteria) this;
        }

        public Criteria andImageTypeEqualTo(Short value) {
            addCriterion("image_type =", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotEqualTo(Short value) {
            addCriterion("image_type <>", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThan(Short value) {
            addCriterion("image_type >", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("image_type >=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThan(Short value) {
            addCriterion("image_type <", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeLessThanOrEqualTo(Short value) {
            addCriterion("image_type <=", value, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeIn(List<Short> values) {
            addCriterion("image_type in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotIn(List<Short> values) {
            addCriterion("image_type not in", values, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeBetween(Short value1, Short value2) {
            addCriterion("image_type between", value1, value2, "imageType");
            return (Criteria) this;
        }

        public Criteria andImageTypeNotBetween(Short value1, Short value2) {
            addCriterion("image_type not between", value1, value2, "imageType");
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
    }

    /**
     * ysy_lnk_goods_image
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * ysy_lnk_goods_image 2019-01-09
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