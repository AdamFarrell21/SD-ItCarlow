package Lab2;

public class HotelRoomMain {
	
	public static void main(String[] args)	{

		
		
		HotelRoom2 RoomA = new HotelRoom2();
		RoomA.setRoomNumber(200);
		RoomA.setRoomType("Single");
		RoomA.setRate(100);
		RoomA.setRoomSys(1);
		
		
		HotelRoom2 roomB = new HotelRoom2();
		roomB.setRoomNumber(201);
		roomB.setRoomType("Double");
		roomB.setRate(80);
		roomB.setRoomSys(0);
		
		System.out.println("Room A");
		System.out.println("Number of room A is "+ RoomA.getRoomNumber());
		System.out.println("Room A is a "+ RoomA.getRoomType());
		System.out.println("The rate on the room is "+ RoomA.getRate());
		
		int x= RoomA.getRoomSys();
		if (x == 0) {
			System.out.println("the room is vacant");
		}
		
		else
		
		{
			System.out.println("the room is occupied");
			
		}
		
		
		System.out.println("room B");
		System.out.println("Room number is " + roomB.getRoomNumber());
		System.out.println("Room B is a " + roomB.getRoomType());
		System.out.println("Room B rate is " + roomB.getRate());
		
		int y = roomB.getRoomSys();
		if (y == 0) 
		
		{
			System.out.println("The room is vacant");
		}
		
		else
		
		{
			System.out.println("the room is occupied");
		}
	}	
}


