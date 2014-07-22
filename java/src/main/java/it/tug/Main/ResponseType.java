package it.tug.Main;

public enum ResponseType {
	FAIL, OK, OTHER;

	static ResponseType getType(String type) {
		try {
			return valueOf(type);
		} catch (IllegalArgumentException e) {
			return OTHER;
		}
	}
}
