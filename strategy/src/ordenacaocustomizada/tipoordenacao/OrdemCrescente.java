package ordenacaocustomizada.tipoordenacao;

public class OrdemCrescente implements OrdenacaoStrategy{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
	
	

}
