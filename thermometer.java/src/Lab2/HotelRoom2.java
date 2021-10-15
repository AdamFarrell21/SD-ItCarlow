package Lab2;

public class HotelRoom2 {
	
	private int roomNumber;
	private String roomType;
	private int roomSys;
	private double rate;
	
	
	public HotelRoom2() {

	}
	
	public HotelRoom2(int newRoomNumber, String newRoomType, int newRoomSys, double newRate)
	
	{	
		roomNumber = newRoomNumber;
		roomType = newRoomType;
		setRoomSys(newRoomSys);
		setRate(newRate);
	}
	public void setRoomNumber(int newRoomNumber) {
		roomNumber = newRoomNumber;
	}
		 
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomType(String newRoomType) {
		roomType = newRoomType;
	}
	
	public String getRoomType() {
		return roomType;
		
	}

	public int getRoomSys() {
		return roomSys;
	}

	public void setRoomSys(int roomSys) {
		this.roomSys = roomSys;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}	
		 
		 
}
