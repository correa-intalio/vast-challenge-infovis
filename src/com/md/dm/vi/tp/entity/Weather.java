package com.md.dm.vi.tp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEATHER")
public class Weather {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "AVERAGE_WIND_SPEED")
	private Integer averageWindSpeed;
	@Column(name = "WIND_DIRECTION")
	private String windDirection;
	
	Weather() {
		//Only for RDBMS 
	}

	public Weather(Date date, String type, Integer averageWindSpeed,
			String windDirection) {
		super();
		this.date = date;
		this.type = type;
		this.averageWindSpeed = averageWindSpeed;
		this.windDirection = windDirection;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAverageWindSpeed() {
		return averageWindSpeed;
	}

	public void setAverageWindSpeed(Integer averageWindSpeed) {
		this.averageWindSpeed = averageWindSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
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
				+ ((averageWindSpeed == null) ? 0 : averageWindSpeed.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((windDirection == null) ? 0 : windDirection.hashCode());
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
		Weather other = (Weather) obj;
		if (averageWindSpeed == null) {
			if (other.averageWindSpeed != null)
				return false;
		} else if (!averageWindSpeed.equals(other.averageWindSpeed))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (windDirection == null) {
			if (other.windDirection != null)
				return false;
		} else if (!windDirection.equals(other.windDirection))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", date=" + date + ", type=" + type
				+ ", averageWindSpeed=" + averageWindSpeed + ", windDirection="
				+ windDirection + "]";
	}
}