package edu.agh.bazyprojekt.model;

import javax.persistence.*;

@Entity
@Table(name = "territories", schema = "public", catalog = "northwind")
public class Territory {
    private String territoryId;
    private String territoryDescription;
    private Region region;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "territoryid")
    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryid) {
        this.territoryId = territoryid;
    }

    @Basic
    @Column(name = "territorydescription")
    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territorydescription) {
        this.territoryDescription = territorydescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Territory territory = (Territory) o;

        if (territoryId != null ? !territoryId.equals(territory.territoryId) : territory.territoryId != null)
            return false;
        if (territoryDescription != null ? !territoryDescription.equals(territory.territoryDescription) : territory.territoryDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = territoryId != null ? territoryId.hashCode() : 0;
        result = 31 * result + (territoryDescription != null ? territoryDescription.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "regionid", referencedColumnName = "regionid", nullable = false)
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region regionByRegionid) {
        this.region = regionByRegionid;
    }
}
