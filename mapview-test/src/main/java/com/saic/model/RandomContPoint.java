package com.saic.model;

import oracle.spatial.geometry.JGeometry;

public class RandomContPoint {

    private Integer id;
    private Integer continentId;
    private JGeometry geom;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContinentId() {
        return this.continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public JGeometry getGeom() {
        return this.geom;
    }

    public void setGeom(JGeometry geom) {
        this.geom = geom;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.continentId == null) ? 0 : this.continentId.hashCode());
        result = prime * result + ((this.geom == null) ? 0 : this.geom.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RandomContPoint other = (RandomContPoint) obj;
        if (this.continentId == null) {
            if (other.continentId != null)
                return false;
        }
        else if (!this.continentId.equals(other.continentId))
            return false;
        if (this.geom == null) {
            if (other.geom != null)
                return false;
        }
        else if (!this.geom.equals(other.geom))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RandomPoint [continentId=").append(this.continentId).append(", geom=").append(this.geom).append(", id=").append(this.id).append("]");
        return builder.toString();
    }

}
