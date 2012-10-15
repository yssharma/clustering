package vo;

public class BankDataVO {	
	
	private String id;
	private int age;
	private char sex;
	private String region;
	private float income;
	private boolean married;
	private int noOfhildren;
	private boolean car;
	private boolean saveAct;
	private boolean currentAct;
	private boolean mortgage;
	private boolean pep;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}


	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public int getNoOfhildren() {
		return noOfhildren;
	}
	public void setNoOfhildren(int noOfhildren) {
		this.noOfhildren = noOfhildren;
	}
	public boolean isCar() {
		return car;
	}
	public void setCar(boolean car) {
		this.car = car;
	}
	public boolean isSaveAct() {
		return saveAct;
	}
	public void setSaveAct(boolean saveAct) {
		this.saveAct = saveAct;
	}
	
	public boolean isCurrentAct() {
		return currentAct;
	}
	public void setCurrentAct(boolean currentAct) {
		this.currentAct = currentAct;
	}
	public boolean isMortgage() {
		return mortgage;
	}
	public void setMortgage(boolean mortgage) {
		this.mortgage = mortgage;
	}
	public boolean isPep() {
		return pep;
	}
	public void setPep(boolean pep) {
		this.pep = pep;
	}	

}
