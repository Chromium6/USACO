package tanktrouble;

public interface Grid {
	public int getVal(int x, int y);
	public void setVal(int x, int y, int val);
	public void readFromFile(String filePath);
}
