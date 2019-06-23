
package estruturadadoslista;


public class VetorGenericoLista <T>{
    private T[] elementos;
    private int tamanho;
    
    //construtor da classe vetor
    public VetorGenericoLista(int tamanho){
      elementos = (T[]) new Object[tamanho];
      this.tamanho = 0;
    }
    //Adicionar elemento no final da lista
    public boolean adiciona(T elemento){
        aumentaCapacidade();
        if(this.elementos.length>this.tamanho){
            this.elementos[tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        else{
            return false;
        }
    }
    //Adicionar um elemento a uma posição específica do vetor
    public boolean adiciona(int posicao, T elemento){
        aumentaCapacidade();
        if(!(posicao>=0 && posicao<this.tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
        for(int i=this.tamanho-1;i>=posicao;i--){
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }
    //Remover o elemento do array
    public void removeElemento(int posicao){
        if(!(posicao>=0 && posicao<this.tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
        for(int i=posicao;i<this.tamanho-1;i++){
            this.elementos[i] = this.obterElemento(i+1);
        }
        this.tamanho--;
    }
    //Aumentar a capacidade do array
    private void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            T[] novoVetor = (T[]) new Object[this.elementos.length*2];
            for(int i=0;i<this.tamanho;i++){
                novoVetor [i] = this.elementos[i];
            }
            this.elementos = novoVetor;
        }
    }
    //Obter elemento da lista
    public T obterElemento(int posicao){
        if(!(posicao>=0 && posicao<this.tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.elementos[posicao];
    }
    //
    public int buscaElemento(T elemento){
        for(int i=0;i<this.tamanho;i++){
            if(this.elementos[i].equals(elemento))
                return i;
        }
        return -1;
    }
    @Override
    public String toString() {
        //[A, B, C, D, ...]
        String retorno = "[";
        for(int i=0;i<this.tamanho-1;i++){
            retorno+=this.elementos[i]+", ";
        }
        retorno+=this.elementos[this.tamanho-1]+"]";
        return retorno;
    }
}
