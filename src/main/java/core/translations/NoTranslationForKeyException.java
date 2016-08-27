package core.translations;

/**
 * Created by Pete on 30/05/2016.
 */
public class NoTranslationForKeyException extends RuntimeException {
    public NoTranslationForKeyException(String translationKey) {
        super(translationKey);
    }
}
