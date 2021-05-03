package model;

public class Resultados {
	private int id;
	private int posicao;
	private String time;
	private int nJogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int golPro;
	private int golCom;
	private int saldoGol;
	private int pontos;
	private String grupo;

	public Resultados() {

	}

	public Resultados(int id, int posicao, String time, int nJogos, int vitorias, int empates, int derrotas, int golPro,
			int golCom, int saldoGol, int pontos) {
		super();
		this.id = id;
		this.posicao = posicao;
		this.time = time;
		this.nJogos = nJogos;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
		this.golPro = golPro;
		this.golCom = golCom;
		this.saldoGol = saldoGol;
		this.pontos = pontos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getnJogos() {
		return nJogos;
	}

	public void setnJogos(int nJogos) {
		this.nJogos = nJogos;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getGolPro() {
		return golPro;
	}

	public void setGolPro(int golPro) {
		this.golPro = golPro;
	}

	public int getGolCom() {
		return golCom;
	}

	public void setGolCom(int golCom) {
		this.golCom = golCom;
	}

	public int getSaldoGol() {
		return saldoGol;
	}

	public void setSaldoGol(int saldoGol) {
		this.saldoGol = saldoGol;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
