package core.boundary.options;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by Pete on 26/08/2016.
 */
@Singleton
public class CategorisedOptionsBuilderFactory {


    private final InterfaceOptionsStore interfaceOptionsStore;

    @Inject
    public CategorisedOptionsBuilderFactory(InterfaceOptionsStore interfaceOptionsStore) {
        this.interfaceOptionsStore = interfaceOptionsStore;
    }

    public CategorisedOptionsBuilder create(){
        return new CategorisedOptionsBuilder(interfaceOptionsStore);
    }
}
