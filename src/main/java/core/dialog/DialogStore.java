package core.dialog;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import com.google.inject.ProvidedBy;
import com.google.inject.Singleton;

import main.providers.DialogStoreProvider;

/**
 * Created by Pete on 21/05/2016.
 */
@ProvidedBy(DialogStoreProvider.class)
@Singleton
public class DialogStore {

	private final List<Dialog> dialogs;

	public DialogStore(List<Dialog> dialogs) {
		this.dialogs = dialogs;
	}

	public Dialog getDialogById(String id){
		return dialogs.stream().filter(d -> d.getId().equals(id)).findFirst().orElseThrow(() -> new DialogNotFoundException());
	}

}
