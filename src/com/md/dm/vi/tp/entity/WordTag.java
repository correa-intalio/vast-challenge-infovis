package com.md.dm.vi.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WORDTAG")
public class WordTag {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "WORD")
	private String word;
	@Column(name = "COUNT")
	private int count;

	WordTag() {
		// Only for RDBMS
	}

	public WordTag(String word) {
		super();
		this.word = word;
		count = 0;
	}

	public Long getId() {
		return id;
	}

	public String getWord() {
		return word;
	}

	public void increment() {
		count = count + 1;
	}

	public int getCount() {
		return count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		WordTag other = (WordTag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WordTag [id=" + id + ", word=" + word + "]";
	}
}
