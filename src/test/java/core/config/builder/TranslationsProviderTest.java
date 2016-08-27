package core.config.builder;

import core.config.xml.Configuration;
import core.config.xml.translations.TranslationConfig;
import core.config.xml.translations.AllTranslationsConfig;
import core.translations.Translations;
import main.providers.TranslationsProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 28/05/2016.
 */
public class TranslationsProviderTest {

    TranslationsProvider translationsProvider;

    @Mock
    TranslationConfig translationConfig;


    @Mock
    AllTranslationsConfig allTranslationsConfig;

    @Mock
    Configuration configuration;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        translationsProvider = new TranslationsProvider(configuration);
    }

    @Test
    public void testGet() throws Exception {
        when(configuration.getAllTranslationsConfig()).thenReturn(allTranslationsConfig);

        when(allTranslationsConfig.getTranslationConfigs()).thenReturn(asList(translationConfig));
        when(translationConfig.getKey()).thenReturn("key");
        when(translationConfig.getTranslation()).thenReturn("translation");
        Translations translations = translationsProvider.get();
        assertThat(translations.getTranslation("key")).isEqualToIgnoringCase("translation");
    }
}