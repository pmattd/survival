package core.boundary.options;

import core.gamestate.actions.Action;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;

public class OptionList<T extends DisplayableOption> {

	private Optional<String> header;
	private List<T> options;

	public OptionList(List<T> options) {
		this.options = options;
		this.header = Optional.empty();
	}


	public OptionList(String header, List<T> options) {
		this.options = options;
		//todo optional of nullable is a bit shit
		this.header = Optional.of(header);
	}

	public static OptionList empty() {
        return new OptionList<>(newArrayList());
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
		}

		public OptionList<ExecutableOption> build(){
			return new OptionList<>(executableOptionList);
		}

		public Builder withHeader(String header){
			this.header = header;
			return this;
		}

		public Builder withOption(String text, Action action){
			executableOptionList.add(new ExecutableOption(text, action));
			return this;
		}
	}

}
