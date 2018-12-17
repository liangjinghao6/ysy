package com.sifude.lejane.entity.mvo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sifude.lejane.entity.UsrArchives;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午5:59:13 类说明
 */
public class UsrArchivesDMvo extends UsrArchives {

	private Integer habId;
	
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

	@JsonIgnore
    private Date createTime;

	public Integer getHabId() {
		return habId;
	}

	public void setHabId(Integer habId) {
		this.habId = habId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
