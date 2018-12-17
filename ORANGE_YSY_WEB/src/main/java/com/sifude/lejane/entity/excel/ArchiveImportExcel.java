package com.sifude.lejane.entity.excel;

import java.io.Serializable;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午3:03:32
 * 类说明
 */
public class ArchiveImportExcel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6404349234740799071L;

	@Excel(name="手机号", orderNum="0")
	private String phone;
	@Excel(name="健康情况", orderNum="1")
	private String healthStatus;
	@Excel(name="疾病描述", orderNum="2")
	private String description;
	@Excel(name="低压", orderNum="3")
	private String lowPressure;
	@Excel(name="高压", orderNum="4")
	private String highPressure;
	@Excel(name="血脂", orderNum="5")
	private String booldFat;
	@Excel(name="血糖", orderNum="6")
	private String booldSugar;
	@Excel(name="消化", orderNum="7")
	private String digestion;
	@Excel(name="大小便", orderNum="8")
	private String urine;
	@Excel(name="睡眠", orderNum="9")
	private String sleep;
	@Excel(name="舌苔", orderNum="10")
	private String tongue;
	@Excel(name="手脚凉热", orderNum="11")
	private String limbsTemp;
	@Excel(name="是否抽烟", orderNum="12")
	private String isSmoke;
	@Excel(name="是否喝酒", orderNum="13")
	private String isDrink;
	@Excel(name="睡眠习惯", orderNum="14")
	private String sleepHabbit;
	@Excel(name="是否熬夜与午睡", orderNum="15")
	private String isMidnightOrNap;
	@Excel(name="饮食规律", orderNum="16")
	private String isEatWell;
	@Excel(name="运动情况", orderNum="17")
	private String isMove;
	@Excel(name="性格", orderNum="18")
	private String characteristic;
	@Excel(name="家庭住址", orderNum="19")
	private String address;
	public ArchiveImportExcel() {
	}
	public ArchiveImportExcel(ArchiveImportExcel excel) {
		this.phone = excel.getPhone();
		this.healthStatus = excel.getHealthStatus();
		this.description = excel.getDescription();
		this.lowPressure = excel.getLowPressure();
		this.highPressure = excel.getHighPressure();
		this.booldFat = excel.getBooldFat();
		this.booldSugar = excel.getBooldSugar();
		this.digestion = excel.getDigestion();
		this.urine = excel.getUrine();
		this.sleep = excel.getSleep();
		this.tongue = excel.getTongue();
		this.limbsTemp = excel.getLimbsTemp();
		this.isSmoke = excel.getIsSmoke();
		this.isDrink = excel.getIsDrink();
		this.sleepHabbit = excel.getSleepHabbit();
		this.isMidnightOrNap = excel.getIsMidnightOrNap();
		this.isEatWell = excel.getIsEatWell();
		this.isMove = excel.getIsMove();
		this.characteristic = excel.getCharacteristic();
		this.address = excel.getAddress();
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLowPressure() {
		return lowPressure;
	}
	public void setLowPressure(String lowPressure) {
		this.lowPressure = lowPressure;
	}
	public String getHighPressure() {
		return highPressure;
	}
	public void setHighPressure(String highPressure) {
		this.highPressure = highPressure;
	}
	public String getBooldFat() {
		return booldFat;
	}
	public void setBooldFat(String booldFat) {
		this.booldFat = booldFat;
	}
	public String getBooldSugar() {
		return booldSugar;
	}
	public void setBooldSugar(String booldSugar) {
		this.booldSugar = booldSugar;
	}
	public String getDigestion() {
		return digestion;
	}
	public void setDigestion(String digestion) {
		this.digestion = digestion;
	}
	public String getUrine() {
		return urine;
	}
	public void setUrine(String urine) {
		this.urine = urine;
	}
	public String getSleep() {
		return sleep;
	}
	public void setSleep(String sleep) {
		this.sleep = sleep;
	}
	public String getTongue() {
		return tongue;
	}
	public void setTongue(String tongue) {
		this.tongue = tongue;
	}
	public String getLimbsTemp() {
		return limbsTemp;
	}
	public void setLimbsTemp(String limbsTemp) {
		this.limbsTemp = limbsTemp;
	}
	public String getIsSmoke() {
		return isSmoke;
	}
	public void setIsSmoke(String isSmoke) {
		this.isSmoke = isSmoke;
	}
	public String getIsDrink() {
		return isDrink;
	}
	public void setIsDrink(String isDrink) {
		this.isDrink = isDrink;
	}
	public String getSleepHabbit() {
		return sleepHabbit;
	}
	public void setSleepHabbit(String sleepHabbit) {
		this.sleepHabbit = sleepHabbit;
	}
	public String getIsMidnightOrNap() {
		return isMidnightOrNap;
	}
	public void setIsMidnightOrNap(String isMidnightOrNap) {
		this.isMidnightOrNap = isMidnightOrNap;
	}
	public String getIsEatWell() {
		return isEatWell;
	}
	public void setIsEatWell(String isEatWell) {
		this.isEatWell = isEatWell;
	}
	public String getIsMove() {
		return isMove;
	}
	public void setIsMove(String isMove) {
		this.isMove = isMove;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
