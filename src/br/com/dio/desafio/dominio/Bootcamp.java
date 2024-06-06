package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new LinkedHashSet<>();
    private Set<Integer> idDevs = new LinkedHashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();
    private int cargaHoraria;


    public Bootcamp() {}
	
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {    	
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public int getCargaHoraria() {

		return cargaHoraria = conteudos.stream()
				.mapToInt(conteudo -> conteudo.getCargaHoraria())
				.sum();
		
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal) && Objects.equals(devsInscritos, bootcamp.devsInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos, cargaHoraria);
    }
    
    public Set<Integer> idTodosDevs(){
    	return devsInscritos.stream()
    			.map(dev-> dev.getId())
				.collect(Collectors.toSet());
    }
    
    public void gerarCertificado(Dev dev) {
		
		if(idTodosDevs().contains(dev.getId())) {
			if(dev.conteudosInscritos.isEmpty()) {
				LocalDate dataAtual = LocalDate.now();
				DateTimeFormatter formatarData =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				System.out.printf("Certificamos que %s em " + formatarData.format(dataAtual) + ", concluiu o bootcamp %s com carga horAria de %d horas \n", dev.getNome(), this.getNome(), this.getCargaHoraria());
			} else {
				System.out.println("Para gerar o seu certificado, voce precisa concluir os seguintes conteudos: " + dev.getConteudosInscritos());
			}
		} else {
			System.out.println("Voce nao esta inscrito(a) no bootcamp");
		}
		
	}
    
    
}
