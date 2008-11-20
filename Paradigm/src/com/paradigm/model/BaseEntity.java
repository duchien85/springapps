package com.paradigm.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.UUID;
import java.io.Serializable;

/**
 * @author Travis Klotz
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String guid = UUID.randomUUID().toString();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseEntity)) {
            return false;
        }

        BaseEntity that = (BaseEntity) o;

        if (!guid.equals(that.guid)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return guid.hashCode();
    }
}
