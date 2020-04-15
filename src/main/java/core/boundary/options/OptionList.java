package core.boundary.options;

import core.gamestate.actions.Action;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;

public class OptionList<T extends DisplayableOption> {

	private Optional<String> header;
	private List<T> options;

	public OptionList(Optional<String> header, List<T> options){
		this.options = options;
		this.header = header;
	}

	public static OptionList emptyList(){
		return new OptionList(Optional.empty(),newArrayList());
	}

	public Optional<String> getHeader() {
		return header;
	}

	public List<T> getOptions() {
		return options;
	}

	public boolean isEmpty(){
		return options.size() == 0;
	}


	public static class Builder {

		private List<ExecutableOption> executableOptionList;
		private String header;

		public Builder(){
			this.executableOptionList = newArrayList();
			this.header = "";
		}

		public OptionList<ExecutableOption> build(){
			return new OptionList<>(Optional.of(header), executableOptionList);
		}


		public Builder withOption(String text, Action action){
			executableOptionList.add(new ExecutableOption(text, action));
			return this;
		}
	}

}
