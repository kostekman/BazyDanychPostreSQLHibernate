package edu.agh.bazyprojekt.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Region {
    private short regionId;
    private String regionDescription;
    private Collection<Territory> territories;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regionid")
    public short getRegionId() {
        return regionId;
    }

    public void setRegionId(short regionid) {
        this.regionId = regionid;
    }

    @Basic
    @Column(name = "regiondescription")
    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regiondescription) {
        this.regionDescription = regiondescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (regionId != region.regionId) return false;
        if (regionDescription != null ? !regionDescription.equals(region.regionDescription) : region.regionDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) regionId;
        result = 31 * result + (regionDescription != null ? regionDescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "region")
    public Collection<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(Collection<Territory> territoriesByRegionid) {
        this.territories = territoriesByRegionid;
    }
}
