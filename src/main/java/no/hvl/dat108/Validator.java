package no.hvl.dat108;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class Validator {

    public static final String ANY_LETTER = "[a-zA-Z������]";
    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-Z������0-9]";
    public static final String THREE_TIMES = "{3}";
    public static final String ZERO_OR_MORE_TIMES = "*";

    /**
     * 
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     * 
     *         Et gyldig brukernavn best�r av 4 eller flere tegn. Lovlige tegn
     *         er bokstaver (sm� og store) inkl. de norske bokstavene, og tall.
     *         Brukernavnet kan ikke begynne med et tall.
     */
    public static boolean isValidPassword(String username) {

        if (username == null) {
            return false;
        }
        return username.matches("^" + ANY_LETTER 
                + ANY_LETTER_OR_DIGIT + THREE_TIMES 
                + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES + "$");
    }

    public static String getErrorMessage(boolean requiresLoginRedirect, boolean invalidPasswordRedirect){
        return (requiresLoginRedirect == true) ? ("You need to log in.")
        : ("Invalid password.");    }

    public static String cleanInput(String input){
        return Jsoup.clean(input, Whitelist.none());
    }

    public static boolean isInvalid(String s){
        return (s.length() == 0 || s == null || isWhitespace(s));
    }

    private static boolean isWhitespace(String s){
        for(int i = 0; i < s.length(); i++){
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}






