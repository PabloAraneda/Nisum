package cl.nisum.rest.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionesEntreda {

	public static boolean validaEmail(String email) {
		
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	}
}
