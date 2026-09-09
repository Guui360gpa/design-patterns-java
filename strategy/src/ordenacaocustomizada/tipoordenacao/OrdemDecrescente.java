package ordenacaocustomizada.tipoordenacao;

public class OrdemDecrescente implements OrdenacaoStrategy{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}
