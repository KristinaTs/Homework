
public class InvalidDataException extends Exception {

	private static final long serialVersionUID = -7743416448022878405L;

	public InvalidDataException() {
		super();
	}

	public InvalidDataException(String message) {

		super(message);

	}

	public InvalidDataException(Throwable cause) {

		super(cause);

	}

	public InvalidDataException(String message, Throwable cause) {

		super(message, cause);
	}



}

