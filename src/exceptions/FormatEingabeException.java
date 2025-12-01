package exceptions;

public class FormatEingabeException extends NumberFormatException {

	public FormatEingabeException() {
		super();
	}
	public FormatEingabeException(String s) {
		super(s);
	}
}
