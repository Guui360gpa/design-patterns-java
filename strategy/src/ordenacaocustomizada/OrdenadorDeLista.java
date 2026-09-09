package ordenacaocustomizada;

import java.util.List;

import ordenacaocustomizada.tipoordenacao.OrdenacaoStrategy;

public class OrdenadorDeLista {
	
	private OrdenacaoStrategy tipoOrdenacao;

	public OrdenadorDeLista(OrdenacaoStrategy tipoOrdenacao) {
		this.tipoOrdenacao = tipoOrdenacao;
	}
	
	public void setTipoOrdenacao(OrdenacaoStrategy tipoOrdenacao) {
		this.tipoOrdenacao = tipoOrdenacao;
	}
	
	public void ordenar(List<Integer> list) {
		list.sort(tipoOrdenacao);
	}
	
	

}
