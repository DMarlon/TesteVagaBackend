package br.com.biblioteca.enumerator;

public enum Status {
	EM_ANALISE(1, "Em análise"),
	ANALISE_REALIZADA(2, "Análise realizada"),
	ANALISE_APROVADA(3, "Análise aprovada"),
	INICIANDO(4, "Iniciando"),
	PLANEJAMENTO(5, "Planejado"),
	EM_ANDAMENTO(6, "Em andamento"),
	ENCERRADO(7, "Encerrado"),
	CANCELADO(8, "Cancelado");

	private int code;
	private String description;

	private Status(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public static Status getStatus(int code) {
        for(Status status : values()) {
            if(Integer.valueOf(status.getCode()).equals(code))
            	return status;
        }

        throw new IllegalArgumentException(code+" não é um status válido!");
    }

	@Override
	public String toString() {
		return this.getDescription();
	}
}
