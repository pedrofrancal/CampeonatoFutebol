package model;

import java.time.LocalDate;

public class Jogos {

	private String codigoTimeA;
	private String codigoTimeB;
	private String nomeTimeA;
	private String nomeTimeB;

	public String getNomeTimeA() {
		return nomeTimeA;
	}

	public void setNomeTimeA(String nomeTimeA) {
		this.nomeTimeA = nomeTimeA;
	}

	public String getNomeTimeB() {
		return nomeTimeB;
	}

	public void setNomeTimeB(String nomeTimeB) {
		this.nomeTimeB = nomeTimeB;
	}

	private int golsTimeA;
	private int golsTimeB;
	private LocalDate dataJogo;

	public Jogos() {
		super();
	}

	public String getCodigoTimeA() {
		return codigoTimeA;
	}

	public void setCodigoTimeA(String codigoTimeA) {
		this.codigoTimeA = codigoTimeA;
	}

	public String getCodigoTimeB() {
		return codigoTimeB;
	}

	public void setCodigoTimeB(String codigoTimeB) {
		this.codigoTimeB = codigoTimeB;
	}

	public int getGolsTimeA() {
		return golsTimeA;
	}

	public void setGolsTimeA(int golsTimeA) {
		this.golsTimeA = golsTimeA;
	}

	public int getGolsTimeB() {
		return golsTimeB;
	}

	public void setGolsTimeB(int golsTimeB) {
		this.golsTimeB = golsTimeB;
	}

	public LocalDate getDataJogo() {
		return dataJogo;
	}

	public void setDataJogo(LocalDate dataJogo) {
		this.dataJogo = dataJogo;
	}

}
