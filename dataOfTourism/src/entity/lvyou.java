package entity;

public class lvyou {

 	private String name;
 	private String introduce;
 	private String longitude;
 	private String latitude;
 	private String prvince;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public lvyou(String name, String introduce, String longitude, String latitude) {
		super();
		this.name = name;
		this.introduce = introduce;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public lvyou() {
		super();
	}
	@Override
	public String toString() {
		return "lvyou [name=" + name + ", introduce=" + introduce + ", longitude=" + longitude + ", latitude="
				+ latitude + "]";
	}
	public lvyou(String name, String introduce, String longitude, String latitude, String prvince) {
		super();
		this.name = name;
		this.introduce = introduce;
		this.longitude = longitude;
		this.latitude = latitude;
		this.prvince = prvince;
	}
	public String getPrvince() {
		return prvince;
	}
	public void setPrvince(String prvince) {
		this.prvince = prvince;
	}
 	

}
