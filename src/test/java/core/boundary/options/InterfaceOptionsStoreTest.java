package core.boundary.options;

import core.translations.Translations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Pete on 27/08/2016.
 */
public class InterfaceOptionsStoreTest {

    private InterfaceOptionsStore interfaceOptionsStore;

    @Mock
    private Translations translations;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(translations.getTranslation(anyString())).thenReturn("translation");
        interfaceOptionsStore = new InterfaceOptionsStore(translations);
    }

    @Test
    public void getOption() throws Exception {
        OptionCategory optionCategory = interfaceOptionsStore.getOption(OptionCatagoryEnum.CREATEHERO);
        assertThat(optionCategory.getDescription()).isEqualTo("translation");
        assertThat(optionCategory.getOptionType()).isEqualTo(OptionCatagoryEnum.CREATEHERO);
    }


    @Test
    public void getNothingOption() throws Exception {
        Assertions.assertThrows(OptionDoesNotExistException.class,() -> {
            OptionCategory optionCategory = interfaceOptionsStore.getOption(OptionCatagoryEnum.NOTHING);
        });
    }

}