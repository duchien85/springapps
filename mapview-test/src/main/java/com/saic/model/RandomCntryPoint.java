package com.saic.model;

import oracle.spatial.geometry.JGeometry;

public class RandomCntryPoint {

    private Integer id;
    private Integer countryId;
    private JGeometry geom;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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
        result = prime * result + ((this.countryId == null) ? 0 : this.countryId.hashCode());
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
        RandomCntryPoint other = (RandomCntryPoint) obj;
        if (this.countryId == null) {
            if (other.countryId != null)
                return false;
        }
        else if (!this.countryId.equals(other.countryId))
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
        builder.append("RandomPoint [countryId=").append(this.countryId).append(", geom=").append(this.geom).append(", id=").append(this.id).append("]");
        return builder.toString();
    }

}
