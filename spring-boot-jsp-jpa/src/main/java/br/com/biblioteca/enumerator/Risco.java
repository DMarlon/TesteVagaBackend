package br.com.biblioteca.enumerator;

public enum Risco {
	BAIXO(1, "Baixo"),
	MEDIO(2, "Médio"),
	ALTO(3, "Alto");

	private int code;
	private String description;

	private Risco(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public static Risco getStatus(int code) {
        for(Risco status : values()) {
            if(Integer.valueOf(status.getCode()).equals(code))
            	return status;
        }

        throw new IllegalArgumentException(code+" não é um risco válido");
    }

	@Override
	public String toString() {
		return this.getDescription();
	}
}
