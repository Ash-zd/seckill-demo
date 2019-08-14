package com.ashzd.seckill.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseOrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PurchaseOrderDetailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeIsNull() {
            addCriterion("purchase_order_index_code is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeIsNotNull() {
            addCriterion("purchase_order_index_code is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeEqualTo(String value) {
            addCriterion("purchase_order_index_code =", value, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeNotEqualTo(String value) {
            addCriterion("purchase_order_index_code <>", value, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeGreaterThan(String value) {
            addCriterion("purchase_order_index_code >", value, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_order_index_code >=", value, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeLessThan(String value) {
            addCriterion("purchase_order_index_code <", value, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeLessThanOrEqualTo(String value) {
            addCriterion("purchase_order_index_code <=", value, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeLike(String value) {
            addCriterion("purchase_order_index_code like", value, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeNotLike(String value) {
            addCriterion("purchase_order_index_code not like", value, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeIn(List<String> values) {
            addCriterion("purchase_order_index_code in", values, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeNotIn(List<String> values) {
            addCriterion("purchase_order_index_code not in", values, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeBetween(String value1, String value2) {
            addCriterion("purchase_order_index_code between", value1, value2, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderIndexCodeNotBetween(String value1, String value2) {
            addCriterion("purchase_order_index_code not between", value1, value2, "purchaseOrderIndexCode");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionIsNull() {
            addCriterion("product_description is null");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionIsNotNull() {
            addCriterion("product_description is not null");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionEqualTo(String value) {
            addCriterion("product_description =", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionNotEqualTo(String value) {
            addCriterion("product_description <>", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionGreaterThan(String value) {
            addCriterion("product_description >", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("product_description >=", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionLessThan(String value) {
            addCriterion("product_description <", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionLessThanOrEqualTo(String value) {
            addCriterion("product_description <=", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionLike(String value) {
            addCriterion("product_description like", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionNotLike(String value) {
            addCriterion("product_description not like", value, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionIn(List<String> values) {
            addCriterion("product_description in", values, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionNotIn(List<String> values) {
            addCriterion("product_description not in", values, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionBetween(String value1, String value2) {
            addCriterion("product_description between", value1, value2, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductDescriptionNotBetween(String value1, String value2) {
            addCriterion("product_description not between", value1, value2, "productDescription");
            return (Criteria) this;
        }

        public Criteria andProductQuantityIsNull() {
            addCriterion("product_quantity is null");
            return (Criteria) this;
        }

        public Criteria andProductQuantityIsNotNull() {
            addCriterion("product_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andProductQuantityEqualTo(Integer value) {
            addCriterion("product_quantity =", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityNotEqualTo(Integer value) {
            addCriterion("product_quantity <>", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityGreaterThan(Integer value) {
            addCriterion("product_quantity >", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_quantity >=", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityLessThan(Integer value) {
            addCriterion("product_quantity <", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("product_quantity <=", value, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityIn(List<Integer> values) {
            addCriterion("product_quantity in", values, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityNotIn(List<Integer> values) {
            addCriterion("product_quantity not in", values, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityBetween(Integer value1, Integer value2) {
            addCriterion("product_quantity between", value1, value2, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("product_quantity not between", value1, value2, "productQuantity");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceIsNull() {
            addCriterion("product_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceIsNotNull() {
            addCriterion("product_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceEqualTo(BigDecimal value) {
            addCriterion("product_unit_price =", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_unit_price <>", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("product_unit_price >", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_unit_price >=", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceLessThan(BigDecimal value) {
            addCriterion("product_unit_price <", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_unit_price <=", value, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceIn(List<BigDecimal> values) {
            addCriterion("product_unit_price in", values, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_unit_price not in", values, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_unit_price between", value1, value2, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_unit_price not between", value1, value2, "productUnitPrice");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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