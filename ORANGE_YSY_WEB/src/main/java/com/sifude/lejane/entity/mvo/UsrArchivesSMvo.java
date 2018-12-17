package com.sifude.lejane.entity.mvo;

import com.sifude.lejane.entity.UsrArchives;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月30日 上午10:39:05 类说明
 */
public class UsrArchivesSMvo extends UsrArchives {
	private String phone;
	private String address;
	private Long habId;
	private Long membId;
	private Integer isSmoke;
	private Integer isDrink;
	private String sleepHabbit;
	private Integer isMidnight;
	private Integer isNap;
	private Integer isEatWell;
	private String eatDescription;
	private Integer isMove;
	private String moveDescription;
	private String characteristic;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getHabId() {
		return habId;
	}
	public void setHabId(Long habId) {
		this.habId = habId;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public Integer getIsSmoke() {
		return isSmoke;
	}
	public void setIsSmoke(Integer isSmoke) {
		this.isSmoke = isSmoke;
	}
	public Integer getIsDrink() {
		return isDrink;
	}
	public void setIsDrink(Integer isDrink) {
		this.isDrink = isDrink;
	}
	public String getSleepHabbit() {
		return sleepHabbit;
	}
	public void setSleepHabbit(String sleepHabbit) {
		this.sleepHabbit = sleepHabbit;
	}
	public Integer getIsMidnight() {
		return isMidnight;
	}
	public void setIsMidnight(Integer isMidnight) {
		this.isMidnight = isMidnight;
	}
	public Integer getIsNap() {
		return isNap;
	}
	public void setIsNap(Integer isNap) {
		this.isNap = isNap;
	}
	public Integer getIsEatWell() {
		return isEatWell;
	}
	public void setIsEatWell(Integer isEatWell) {
		this.isEatWell = isEatWell;
	}
	public String getEatDescription() {
		return eatDescription;
	}
	public void setEatDescription(String eatDescription) {
		this.eatDescription = eatDescription;
	}
	public Integer getIsMove() {
		return isMove;
	}
	public void setIsMove(Integer isMove) {
		this.isMove = isMove;
	}
	public String getMoveDescription() {
		return moveDescription;
	}
	public void setMoveDescription(String moveDescription) {
		this.moveDescription = moveDescription;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

}
