package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    public Curso() {}
	
	public Curso(String titulo, String descricao, int cargaHoraria) {
		setTitulo(titulo);
		setDescricao(descricao);
		setCargaHoraria(cargaHoraria);	
	}

    public double calcularXP() {
        return XP_PADRAO * getCargaHoraria();
    }


    @Override
    public String toString() {
        return "Curso -> Titulo: " + getTitulo() + " | Descricao: " + getDescricao() + " | Carga Horaria: " + getCargaHoraria() + "h";
    }

		@Override
		public double calcularXp() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

}
