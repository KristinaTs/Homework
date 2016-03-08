
public class Parcel extends MailObject {
	private static final int TIME_TO_DELIVER = 2000;
	private static final int OVERSIZE_LIMIT = 60;
	private static final double COEFFICIENT_FOR_PRICE = 1.5;
	private static final int NORMAL_PRICE = 2;
	private int height;
	private int width;
	private int lenght;
	private boolean isFragile;

	public Parcel(Citizen sender, Citizen receiver, int height, int width, int lenght, boolean isFragile) {
		super(sender, receiver);
		this.height = height;
		this.width = width;
		this.lenght = lenght;
		this.isFragile = isFragile;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public boolean isFragile() {
		return isFragile;
	}

	public void setFragile(boolean isFragile) {
		this.isFragile = isFragile;
	}

	@Override
	public float getTax() {
		float price = NORMAL_PRICE;
		if (overSize()) {
			price *= COEFFICIENT_FOR_PRICE;
		}
		if (isFragile()) {
			price *= COEFFICIENT_FOR_PRICE;
		}

		return price;
	}

	private boolean overSize() {

		return width > OVERSIZE_LIMIT || height > OVERSIZE_LIMIT || lenght > OVERSIZE_LIMIT;
	}

	@Override
	public float getTimeToDeliver() {
		return TIME_TO_DELIVER;
	}

}
