package Lab2;

public class HotelRoom2 {
	
	private int roomNumber;
	private String roomType;
	private int roomFull;
	private double rate;
	
	
	public HotelRoom2() {

	}
	
	public HotelRoom2(int newRoomNumber, String newRoomType, int newRoomFull, double newRate)
	
	{	
		roomNumber = newRoomNumber;
		roomType = newRoomType;
		roomFull = newRoomFull ;
		rate = newRate;
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

	public int getRoomFull() {
		return roomFull;
	}

	public void setRoomFull(int roomFull) {
		this.roomFull = roomFull;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}	
		 
		 
}
