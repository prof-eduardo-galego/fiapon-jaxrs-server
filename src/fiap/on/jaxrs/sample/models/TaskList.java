package fiap.on.jaxrs.sample.models;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaskList {

	private List<Task> result;

	public TaskList() {
		super();
	}

	public TaskList(List<Task> result) {
		this();
		this.result = result;
	}

	public List<Task> getResult() {
		return result;
	}

	public void setResult(List<Task> result) {
		this.result = result;
	}

}