package br.com.barcard.enumeration;

public enum SexoEnum {

	M("Masculino"),F("Feminino");

	private final String label;

	private SexoEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
