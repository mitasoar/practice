package org.hair_studio.model;

public class Designer {

	private String name;
	private String part1;
	private String part2;
	private String part3;
	private String part4;
	private String part5;
	private String part6;
	private String part7;
	private String part8;
	private String part9;
	private String part10;
	private String part11;
	private String part12;
	private String part13;
	private String part14;
	private String part15;
	private String part16;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPart1() {
		return part1;
	}

	public void setPart1(String part1) {
		this.part1 = part1;
	}

	public String getPart2() {
		return part2;
	}

	public void setPart2(String part2) {
		this.part2 = part2;
	}

	public String getPart3() {
		return part3;
	}

	public void setPart3(String part3) {
		this.part3 = part3;
	}

	public String getPart4() {
		return part4;
	}

	public void setPart4(String part4) {
		this.part4 = part4;
	}

	public String getPart5() {
		return part5;
	}

	public void setPart5(String part5) {
		this.part5 = part5;
	}

	public String getPart6() {
		return part6;
	}

	public void setPart6(String part6) {
		this.part6 = part6;
	}

	public String getPart7() {
		return part7;
	}

	public void setPart7(String part7) {
		this.part7 = part7;
	}

	public String getPart8() {
		return part8;
	}

	public void setPart8(String part8) {
		this.part8 = part8;
	}

	public String getPart9() {
		return part9;
	}

	public void setPart9(String part9) {
		this.part9 = part9;
	}

	public String getPart10() {
		return part10;
	}

	public void setPart10(String part10) {
		this.part10 = part10;
	}

	public String getPart11() {
		return part11;
	}

	public void setPart11(String part11) {
		this.part11 = part11;
	}

	public String getPart12() {
		return part12;
	}

	public void setPart12(String part12) {
		this.part12 = part12;
	}

	public String getPart13() {
		return part13;
	}

	public void setPart13(String part13) {
		this.part13 = part13;
	}

	public String getPart14() {
		return part14;
	}

	public void setPart14(String part14) {
		this.part14 = part14;
	}

	public String getPart15() {
		return part15;
	}

	public void setPart15(String part15) {
		this.part15 = part15;
	}

	public String getPart16() {
		return part16;
	}

	public void setPart16(String part16) {
		this.part16 = part16;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Designer other = (Designer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Designer [name=" + name + ", part1=" + part1 + ", part2=" + part2 + ", part3=" + part3 + ", part4="
				+ part4 + ", part5=" + part5 + ", part6=" + part6 + ", part7=" + part7 + ", part8=" + part8 + ", part9="
				+ part9 + ", part10=" + part10 + ", part11=" + part11 + ", part12=" + part12 + ", part13=" + part13
				+ ", part14=" + part14 + ", part15=" + part15 + ", part16=" + part16 + "]";
	}

}
