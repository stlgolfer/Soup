package xyz.amtstl.soup.logic;

public class Suppressor {
	private static boolean isSuppressed;
	private static int continueIndex;
	
	public Suppressor(int continueI) {
		isSuppressed = true;
		continueIndex = continueI;
	}
	
	public boolean isSuppressed() {
		return isSuppressed;
	}
	
	public void setSuppression(boolean state) {
		isSuppressed = state;
	}
	
	public int getContinueIndex() {
		return continueIndex;
	}
	
	public void setContinueIndex(int index) {
		continueIndex = index;
	}
}