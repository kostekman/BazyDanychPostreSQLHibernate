package edu.agh.bazyprojekt.model;

import javax.persistence.*;

@Entity
@Table(name = "usstates", schema = "public", catalog = "northwind")
public class Usstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short stateId;
    private String stateName;
    private String stateAbbr;
    private String stateRegion;

    @Basic
    @Column(name = "stateid")
    public short getStateId() {
        return stateId;
    }

    public void setStateId(short stateid) {
        this.stateId = stateid;
    }

    @Basic
    @Column(name = "statename")
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String statename) {
        this.stateName = statename;
    }

    @Basic
    @Column(name = "stateabbr")
    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateabbr) {
        this.stateAbbr = stateabbr;
    }

    @Basic
    @Column(name = "stateregion")
    public String getStateRegion() {
        return stateRegion;
    }

    public void setStateRegion(String stateregion) {
        this.stateRegion = stateregion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usstate usstate = (Usstate) o;

        if (stateId != usstate.stateId) return false;
        if (stateName != null ? !stateName.equals(usstate.stateName) : usstate.stateName != null) return false;
        if (stateAbbr != null ? !stateAbbr.equals(usstate.stateAbbr) : usstate.stateAbbr != null) return false;
        if (stateRegion != null ? !stateRegion.equals(usstate.stateRegion) : usstate.stateRegion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) stateId;
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        result = 31 * result + (stateAbbr != null ? stateAbbr.hashCode() : 0);
        result = 31 * result + (stateRegion != null ? stateRegion.hashCode() : 0);
        return result;
    }
}
