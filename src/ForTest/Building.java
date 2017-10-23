package ForTest;

import Root.GameObject;
import space.SpaceContainer;
import space.SpaceHolder;

public abstract class Building extends SpaceContainer {

	@Override
	protected boolean checkSpaceconflict(SpaceHolder spaceHolder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Building clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
