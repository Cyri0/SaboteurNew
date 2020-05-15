package application;

import java.util.ArrayList;

public class MyHandElements {

	private static ArrayList<MyHandElement> mheLi = new ArrayList<MyHandElement>();
	
	public static void addElement(MyHandElement mhe) {
		mheLi.add(mhe);
	}
	
	public static void setAllDisableExcept(MyHandElement choosenMhe) {
		for (MyHandElement myHandElement : mheLi) {
			if(myHandElement != choosenMhe)
				{myHandElement.getButton().setDisable(true);
				myHandElement.getButton().setOpacity(0);
				}
		}
	}
	
	public static void setAllEnable() {
		for (MyHandElement myHandElement : mheLi) {
			{myHandElement.getButton().setDisable(false);
			myHandElement.getButton().setOpacity(1);
			}
		}
	}	
}
