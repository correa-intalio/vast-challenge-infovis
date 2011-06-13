package com.md.dm.vi.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POPULATION")
public class Population {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "ZONE_NAME")
	private String zoneName;
	@Column(name = "DENSITY")
	private Integer density;
	@Column(name = "COMMUTING_DENSITY")
	private Integer commutingDensity;

	Population() {
		// Only for RDBMS
	}

	public Population(String zoneName, Integer density, Integer commutingDensity) {
		super();
		this.zoneName = zoneName;
		this.density = density;
		this.commutingDensity = commutingDensity;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public Integer getDensity() {
		return density;
	}

	public void setDensity(Integer density) {
		this.density = density;
	}

	public Integer getCommutingDensity() {
		return commutingDensity;
	}

	public void setCommutingDensity(Integer commutingDensity) {
		this.commutingDensity = commutingDensity;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((commutingDensity == null) ? 0 : commutingDensity.hashCode());
		result = prime * result + ((density == null) ? 0 : density.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((zoneName == null) ? 0 : zoneName.hashCode());
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
		Population other = (Population) obj;
		if (commutingDensity == null) {
			if (other.commutingDensity != null)
				return false;
		} else if (!commutingDensity.equals(other.commutingDensity))
			return false;
		if (density == null) {
			if (other.density != null)
				return false;
		} else if (!density.equals(other.density))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (zoneName == null) {
			if (other.zoneName != null)
				return false;
		} else if (!zoneName.equals(other.zoneName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Population [id=" + id + ", zoneName=" + zoneName + ", density="
				+ density + ", commutingDensity=" + commutingDensity + "]";
	}
}
