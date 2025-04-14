public class PilhaDinamica implements IEstruturaDinamica {
   private No topo;
   private int tamanho;

   public PilhaDinamica(){
       topo = null;
       tamanho = 0;
   }

        @Override
        public void inserirElemento(Object elemento) {
            No novoNo = new No(elemento);
            if (topo == null) {
                topo = novoNo;
            } else {
                novoNo.setProx(topo);
                topo.setAnterior(novoNo);
                topo = novoNo;
            }
            tamanho++;
        }


        @Override
    public void inserirSequencia(Object[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            inserirElemento(elementos[i]);
        }
    }

    @Override
    public boolean removerElemento(Object elemento) {
    No atual = topo;
    while (atual != null){
        if (atual.getConteudo().equals(elemento)){
            if (atual.getAnterior() !=null){
                atual.getAnterior().setProx(atual.getProx());
            }else{
                topo = atual.getProx();
            }
            if(atual.getProx() != null){
                atual.getProx().setAnterior(atual.getAnterior());
            }
            tamanho--;
            return true;
        }
        atual= atual.getProx();
    }
    return false;
    }

    @Override
    public void removerSequencia(Object[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            removerElemento(elementos[i]);
            tamanho--;
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        No atual = topo;

        while (atual != null) {
            No proximo = atual.getProx();
            if (atual.getConteudo().equals(elemento)) {

                if (atual == topo) {
                    topo = atual.getProx();
                    if (topo != null) {
                        topo.setAnterior(null);
                    }
                } else {
                    No anterior = atual.getAnterior();

                    if (anterior != null) {
                        anterior.setProx(proximo);
                    }

                    if (proximo != null) {
                        proximo.setAnterior(anterior);
                    }
                }
                tamanho--;
            }
            atual = proximo;
        }
    }

    @Override
    public boolean estaVazia() {
        return topo == null;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        No atual = topo;
        while (atual != null){
            if(atual.getConteudo().equals(elemento)){
                return true;
            }
           atual = atual.getProx();
        }
        return false;
    }

    @Override
    public void ordenarCrescente() {
        if (topo == null || topo.getProx() == null) {
            System.out.println("Pilha vazia ou com apenas um elemento.");
            return;
        }
        No copiaTopo = null;
        No atual = topo;
        while (atual != null) {
            No novoNo = new No(atual.getConteudo());
            novoNo.setProx(copiaTopo);
            copiaTopo = novoNo;
            atual = atual.getProx();
        }


        boolean trocou;
        do {
            trocou = false;
            No copiaAtual = copiaTopo;

            while (copiaAtual != null && copiaAtual.getProx() != null) {
                int valorAtual = (int) copiaAtual.getConteudo();
                int valorProximo = (int) copiaAtual.getProx().getConteudo();

                if (valorAtual > valorProximo) {
                    Object temp = copiaAtual.getConteudo();
                    copiaAtual.setConteudo(copiaAtual.getProx().getConteudo());
                    copiaAtual.getProx().setConteudo(temp);
                    trocou = true;
                }
                copiaAtual = copiaAtual.getProx();
            }
        } while (trocou);

        System.out.println("Pilha ordenada em ordem CRESCENTE: ");
        No copiaExibir = copiaTopo;
        while (copiaExibir != null) {
            System.out.print(copiaExibir.getConteudo() + " ");
            copiaExibir = copiaExibir.getProx();
        }
        System.out.println();
    }



    @Override
    public void ordenarDecrescente() {
        if (topo == null) {
            System.out.println("Pilha vazia.");
            return;
        }

        Integer[] elementos = new Integer[tamanho];
        No atual = topo;
        int i = 0;
        while (atual != null) {
            elementos[i++] = (Integer) atual.getConteudo();
            atual = atual.getProx();
        }


        for (i = 0; i < elementos.length - 1; i++) {
            for (int j = i + 1; j < elementos.length; j++) {

                if (elementos[i] < elementos[j]) {
                    Integer temp = elementos[i];
                    elementos[i] = elementos[j];
                    elementos[j] = temp;
                }
            }
        }


        System.out.print("Pilha em ordem DECRESCENTE: ");
        for (Integer elem : elementos) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }


    @Override
    public int quantidadeElementos() {
        return tamanho;
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        No atual = topo;
        while (atual != null) {
            if (atual.getConteudo().equals(elementoAntigo)) {
                atual.setConteudo(elementoNovo);
                return;
            }
            atual = atual.getProx();
        }
    }

    @Override
    public void limpar() {
        topo = null;
        tamanho = 0;
    }

    @Override
    public void exibir() {
No atual = topo;
while (atual != null){
    System.out.print(atual.getConteudo() + " ");
    atual = atual.getProx();
        }
        System.out.println();
   }

    @Override
    public No obterPrimeiroElemento() {
        return topo;
    }

    @Override
    public No obterUltimoElemento() {
        No atual = topo;
        while (atual != null && atual.getProx() != null) {
            atual = atual.getProx();
        }
        return atual;
    }
    }

