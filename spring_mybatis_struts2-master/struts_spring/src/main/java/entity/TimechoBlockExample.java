package entity;

import java.util.ArrayList;
import java.util.List;

public class TimechoBlockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimechoBlockExample() {
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

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBownerIsNull() {
            addCriterion("bowner is null");
            return (Criteria) this;
        }

        public Criteria andBownerIsNotNull() {
            addCriterion("bowner is not null");
            return (Criteria) this;
        }

        public Criteria andBownerEqualTo(Byte value) {
            addCriterion("bowner =", value, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerNotEqualTo(Byte value) {
            addCriterion("bowner <>", value, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerGreaterThan(Byte value) {
            addCriterion("bowner >", value, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerGreaterThanOrEqualTo(Byte value) {
            addCriterion("bowner >=", value, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerLessThan(Byte value) {
            addCriterion("bowner <", value, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerLessThanOrEqualTo(Byte value) {
            addCriterion("bowner <=", value, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerIn(List<Byte> values) {
            addCriterion("bowner in", values, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerNotIn(List<Byte> values) {
            addCriterion("bowner not in", values, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerBetween(Byte value1, Byte value2) {
            addCriterion("bowner between", value1, value2, "bowner");
            return (Criteria) this;
        }

        public Criteria andBownerNotBetween(Byte value1, Byte value2) {
            addCriterion("bowner not between", value1, value2, "bowner");
            return (Criteria) this;
        }

        public Criteria andBdescriptionIsNull() {
            addCriterion("bdescription is null");
            return (Criteria) this;
        }

        public Criteria andBdescriptionIsNotNull() {
            addCriterion("bdescription is not null");
            return (Criteria) this;
        }

        public Criteria andBdescriptionEqualTo(String value) {
            addCriterion("bdescription =", value, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionNotEqualTo(String value) {
            addCriterion("bdescription <>", value, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionGreaterThan(String value) {
            addCriterion("bdescription >", value, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("bdescription >=", value, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionLessThan(String value) {
            addCriterion("bdescription <", value, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionLessThanOrEqualTo(String value) {
            addCriterion("bdescription <=", value, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionLike(String value) {
            addCriterion("bdescription like", value, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionNotLike(String value) {
            addCriterion("bdescription not like", value, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionIn(List<String> values) {
            addCriterion("bdescription in", values, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionNotIn(List<String> values) {
            addCriterion("bdescription not in", values, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionBetween(String value1, String value2) {
            addCriterion("bdescription between", value1, value2, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBdescriptionNotBetween(String value1, String value2) {
            addCriterion("bdescription not between", value1, value2, "bdescription");
            return (Criteria) this;
        }

        public Criteria andBnameIsNull() {
            addCriterion("bname is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bname is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bname =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bname <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bname >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bname >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bname <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bname <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bname like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bname not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bname in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bname not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bname between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bname not between", value1, value2, "bname");
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