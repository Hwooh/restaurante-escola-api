package br.com.restaurante.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.restaurante.model.Frequencia;

public class FrequenciaDto {

	private Long codigo;
	
	private String status;
	
	private Integer codigoTurma;

	private Long matricula;
	
	private String dataAula;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(Integer codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getDataAula() {
		return dataAula;
	}

	public void setDataAula(String dataAula) {
		this.dataAula = dataAula;
	}

	public FrequenciaDto(Frequencia frequencia) {
		this.codigo = frequencia.getCodigo();
		this.codigoTurma = frequencia.getTurma().getNumero();
		this.matricula = frequencia.getAluno().getMatricula();
		this.status = frequencia.getStatus().toString();
		this.dataAula = frequencia.getDataAula().toString();
	}
	
	public static List<FrequenciaDto> converter(List<Frequencia> listaFrequencia) {
		return listaFrequencia.stream().map(frequencia -> new FrequenciaDto(frequencia)).collect(Collectors.toList());
	}

	public static FrequenciaDto converter(Frequencia frequencia) {
		return new FrequenciaDto(frequencia);
	}
	
	
}
