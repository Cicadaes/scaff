package com.surfilter.ps.model;

import java.util.ArrayList;
import java.util.List;

public class RDirectoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RDirectoryExample() {
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

        public Criteria andIdDirectoryIsNull() {
            addCriterion("ID_DIRECTORY is null");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryIsNotNull() {
            addCriterion("ID_DIRECTORY is not null");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryEqualTo(Long value) {
            addCriterion("ID_DIRECTORY =", value, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryNotEqualTo(Long value) {
            addCriterion("ID_DIRECTORY <>", value, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryGreaterThan(Long value) {
            addCriterion("ID_DIRECTORY >", value, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryGreaterThanOrEqualTo(Long value) {
            addCriterion("ID_DIRECTORY >=", value, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryLessThan(Long value) {
            addCriterion("ID_DIRECTORY <", value, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryLessThanOrEqualTo(Long value) {
            addCriterion("ID_DIRECTORY <=", value, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryIn(List<Long> values) {
            addCriterion("ID_DIRECTORY in", values, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryNotIn(List<Long> values) {
            addCriterion("ID_DIRECTORY not in", values, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryBetween(Long value1, Long value2) {
            addCriterion("ID_DIRECTORY between", value1, value2, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryNotBetween(Long value1, Long value2) {
            addCriterion("ID_DIRECTORY not between", value1, value2, "idDirectory");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentIsNull() {
            addCriterion("ID_DIRECTORY_PARENT is null");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentIsNotNull() {
            addCriterion("ID_DIRECTORY_PARENT is not null");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentEqualTo(Integer value) {
            addCriterion("ID_DIRECTORY_PARENT =", value, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentNotEqualTo(Integer value) {
            addCriterion("ID_DIRECTORY_PARENT <>", value, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentGreaterThan(Integer value) {
            addCriterion("ID_DIRECTORY_PARENT >", value, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_DIRECTORY_PARENT >=", value, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentLessThan(Integer value) {
            addCriterion("ID_DIRECTORY_PARENT <", value, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentLessThanOrEqualTo(Integer value) {
            addCriterion("ID_DIRECTORY_PARENT <=", value, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentIn(List<Integer> values) {
            addCriterion("ID_DIRECTORY_PARENT in", values, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentNotIn(List<Integer> values) {
            addCriterion("ID_DIRECTORY_PARENT not in", values, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentBetween(Integer value1, Integer value2) {
            addCriterion("ID_DIRECTORY_PARENT between", value1, value2, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andIdDirectoryParentNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_DIRECTORY_PARENT not between", value1, value2, "idDirectoryParent");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameIsNull() {
            addCriterion("DIRECTORY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameIsNotNull() {
            addCriterion("DIRECTORY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameEqualTo(String value) {
            addCriterion("DIRECTORY_NAME =", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameNotEqualTo(String value) {
            addCriterion("DIRECTORY_NAME <>", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameGreaterThan(String value) {
            addCriterion("DIRECTORY_NAME >", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("DIRECTORY_NAME >=", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameLessThan(String value) {
            addCriterion("DIRECTORY_NAME <", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameLessThanOrEqualTo(String value) {
            addCriterion("DIRECTORY_NAME <=", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameLike(String value) {
            addCriterion("DIRECTORY_NAME like", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameNotLike(String value) {
            addCriterion("DIRECTORY_NAME not like", value, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameIn(List<String> values) {
            addCriterion("DIRECTORY_NAME in", values, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameNotIn(List<String> values) {
            addCriterion("DIRECTORY_NAME not in", values, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameBetween(String value1, String value2) {
            addCriterion("DIRECTORY_NAME between", value1, value2, "directoryName");
            return (Criteria) this;
        }

        public Criteria andDirectoryNameNotBetween(String value1, String value2) {
            addCriterion("DIRECTORY_NAME not between", value1, value2, "directoryName");
            return (Criteria) this;
        }
    }

    /**
     */
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