package com.studerb.hr.dao;

/**
 * Wrapper object around query parameters meant to control paging ability of
 * entity sets returned from controllers back to the client
 * 
 * @author studerb
 */
public class PageInfo {

    public static int SIZE = 20;
    public static int SKIP = 0;
    public static String ORDER_BY = "id";
    public static String ORDER_DIR = "ASC";

    private Integer size = SIZE;
    private Integer skip = SKIP;
    private String orderBy = ORDER_BY;
    private String orderDir = ORDER_DIR;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        if ((size == null) || (size.intValue() <= 0)) {
            this.size = SIZE;
        }
        this.size = size;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        if ((skip == null) || (skip.intValue() < 0)) {
            this.skip = SKIP;
        }
        this.skip = skip;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public void setOrderBy(String orderBy) {
        if (!orderBy.equalsIgnoreCase("ASC") && !(orderBy.equalsIgnoreCase("DESC"))) {
            this.orderBy = ORDER_BY;
        }
        this.orderBy = orderBy;
    }

    public void setOrderDir(String orderDir) {
        this.orderDir = orderDir;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderBy == null) ? 0 : orderBy.hashCode());
        result = prime * result + ((orderDir == null) ? 0 : orderDir.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((skip == null) ? 0 : skip.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PageInfo other = (PageInfo) obj;
        if (orderBy == null) {
            if (other.orderBy != null) {
                return false;
            }
        }
        else if (!orderBy.equals(other.orderBy)) {
            return false;
        }
        if (orderDir == null) {
            if (other.orderDir != null) {
                return false;
            }
        }
        else if (!orderDir.equals(other.orderDir)) {
            return false;
        }
        if (size == null) {
            if (other.size != null) {
                return false;
            }
        }
        else if (!size.equals(other.size)) {
            return false;
        }
        if (skip == null) {
            if (other.skip != null) {
                return false;
            }
        }
        else if (!skip.equals(other.skip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PageInfo [orderBy=");
        builder.append(orderBy);
        builder.append(", orderDir=");
        builder.append(orderDir);
        builder.append(", size=");
        builder.append(size);
        builder.append(", skip=");
        builder.append(skip);
        builder.append("]");
        return builder.toString();
    }

}
