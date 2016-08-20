package br.com.barcard.enumeration;

public enum SimNaoEnum {

	S("Sim"),N("N�o");

	private final String label;

	private SimNaoEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
