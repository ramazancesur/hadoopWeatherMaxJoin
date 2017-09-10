package settings;

public class EnumUtil {

	public EnumUtil() {

	}

	public enum OKUMATIPI {
		RESOURCE, WEB;
		public static OKUMATIPI fromInteger(int x) {
			switch (x) {
			case 0:
				return RESOURCE;
			case 1:
				return WEB;
			}
			return null;
		}
	}
}