package core.config.builder;

import core.config.xml.narrative.interaction.TextConfig;
import core.translations.Translations;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;


/**
 * Created by Pete on 30/05/2016.
 */
public class TextFactoryTest {

    TextFactory textFactory;

    @Mock
    Translations translations;

    @Mock
    TextConfig textConfig;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        textFactory = new TextFactory(translations);
    }

    @Test
    public void testBuild_defaultText() throws Exception {
        when(textConfig.getDefaultText()).thenReturn("defaultText");
        when(textConfig.getTranslationKey()).thenReturn(null);

        String text = textFactory.build(textConfig);
        assertThat(text).isEqualTo("defaultText");
    }


    @Test
    public void testBuild_translatedText() throws Exception {
        when(textConfig.getDefaultText()).thenReturn("defaultText");
        when(textConfig.getTranslationKey()).thenReturn("key");
        when(translations.getTranslation("key")).thenReturn("translatedText");

        String text = textFactory.build(textConfig);
        assertThat(text).isEqualTo("translatedText");
    }
}