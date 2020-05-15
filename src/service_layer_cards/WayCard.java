package service_layer_cards;

public class WayCard extends Card{

	private boolean right, left, up, down;
	
	
	private WayCardType wayCardType;
	
	public WayCard(int wayCardNumType) {
		super();
		
		super.cardType = CardType.WAYCARD;

		setType(wayCardNumType);
	}
	
	
	protected void setType(int wayCardNumType) {
		switch (wayCardNumType) {
		case 1: initType_1(); this.wayCardType = WayCardType.TYPE_1; break;
		case 2: initType_2(); this.wayCardType = WayCardType.TYPE_2; break;
		case 3: initType_3(); this.wayCardType = WayCardType.TYPE_3; break;
		case 4: initType_4(); this.wayCardType = WayCardType.TYPE_4; break;
		case 5: initType_5(); this.wayCardType = WayCardType.TYPE_5; break;
		case 6: initType_6(); this.wayCardType = WayCardType.TYPE_6; break;
		case 7: initType_7(); this.wayCardType = WayCardType.TYPE_7; break;
		}
	}
	
	public WayCard() {
		right = false;
		left = false;
		up = false;
		down = false;
	};

	public WayCardType getWayCardType() {
		return wayCardType;
	}
	
	public boolean isRight() {
		return right;
	}
	public boolean isLeft() {
		return left;
	}
	public boolean isUp() {
		return up;
	}
	public boolean isDown() {
		return down;
	}
	public String getOrientations() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("UP: ");
		sb.append(up);
		sb.append(" DOWN: ");
		sb.append(down);
		sb.append(" RIGHT: ");
		sb.append(right);
		sb.append(" LEFT: ");
		sb.append(left);
		
		return sb.toString();
	}
	
	private void initType_1() {
		right = true;
		left = false;
		up = true;
		down = false;
	}
	private void initType_2() {
		right = true;
		left = true;
		up = true;
		down = true;
	}
	private void initType_3() {
		left = true;
		right = true;
		up = false;
		down = false;
	}
	private void initType_4() {
		down = true;
		right = true;
		up = false;
		left = false;
	}
	private void initType_5() {
		left = true;
		right = true;
		down = true;
		up = false;
	}
	private void initType_6() {
		up = true;
		down = true;
		left = false;
		right = false;
	}
	private void initType_7() {
		up = true;
		down = true;
		right = true;
		left = false;
	}
	
	public boolean canConnectTo(WayCard otherCard, Orientation o) {
		if(this.down && otherCard.isUp() && o == Orientation.DOWN) { 
			//System.out.println("this.down && otherCard.isUp()");
			return true;}
		if(this.up && otherCard.isDown() && o == Orientation.UP) { 
			//System.out.println("this.up && otherCard.isDown()");
			return true;}
		if(this.right && otherCard.isLeft() && o == Orientation.RIGHT){ 
			//System.out.println("this.right && otherCard.isLeft()");
			return true;}
		if(this.left && otherCard.isRight() && o == Orientation.LEFT) { 
			//System.out.println("this.left && otherCard.isRight()");
			return true;}

		return false;
		
	}
}
