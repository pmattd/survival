package core.translations;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static com.google.common.collect.Maps.newHashMap;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Pete on 28/05/2016.
 */
public class TranslationsTest {


    public static final String translateKey1 = "fake.translation.1";
    public static final String translateKey2 = "fake.translation.2";
    public static final String transVal1 = "hello";
    public static final String transVal2 = "goodbye";
    Translations translations;

    @Before
    public void setUp() throws Exception {
        HashMap<String,String> translationsMap = newHashMap();
        translationsMap.put(translateKey1, transVal1);
        translationsMap.put(translateKey2, transVal2);


        this.translations = new Translations(translationsMap);
    }

    @Test
    public void testGetTranslation() throws Exception {
        assertThat(translations.getTranslation(translateKey1)).isEqualTo(transVal1);
    }

    @Test(expected = NoTranslationForKeyException.class)
    public void testMissingTranslation() throws Exception {
        translations.getTranslation("missing.translation");
    }
}