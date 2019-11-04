

public class BinaryTreeOfInteger {

    // Classe interna Node
    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        private Integer element;
        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    
    // Atributos da arvore binaria
    private int count; //total de elementos da arvore
    private Node root; //referencia para o nodo raiz da arvore

    
    // Metodos da arvore binaria
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void setRoot(Integer element) {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        root.element = element;
    }

    public boolean addRoot(Integer element) {
        if (root != null) {
            return false;
        }
        Node node = new Node(element);
        root = node;
        count++;
        return true;
    }
    
    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    private Node searchNodeRef(Integer element, Node target) {
        Node res = null;
        if (target != null) {
            if (target.element.equals(element)) {
                res = target;
            } else {
                res = searchNodeRef(element, target.left);
                if (res == null) {
                    res = searchNodeRef(element, target.right);
                }
            }
        }
        return res;
    }
    

    ////////////////////////////////////////////////////
    // Implemente os metodos abaixo considerando os 
    // comentarios javadoc.
    ////////////////////////////////////////////////////
    
    /**
     * Insere um elemento a esquerda de outro elemento (pai). 
     * Caso ja tenha um elemento a esquerda do pai, ou caso o 
     * elemento pai nao seja encontrado na arvore, a insercao  
     * nao e realizada.
     * @param element elemento a ser inserido
     * @param father pai do elemento a ser inserido.
     * @return true se o elemento for inserido e false caso
     * contrario.
     */
    public boolean addLeft(Integer element, Integer father) {
        Node aux = searchNodeRef(father, root);
        if(aux == null || aux.left != null){
            return false;
        }

        Node n = new Node(element);
        aux.left = n;
        n.father = aux;
        count++;
        return true;
    }
    
    /**
     * Insere um elemento a direita de outro elemento (pai). 
     * Caso ja tenha um elemento a direita do pai, ou caso o 
     * elemento pai nao seja encontrado na arvore, a insercao  
     * nao e realizada.
     * @param element elemento a ser inserido
     * @param father pai do elemento a ser inserido.
     * @return true se o elemento for inserido e false caso
     * contrario.
     */    
    public boolean addRight(Integer element, Integer father) {
        Node aux = searchNodeRef(father, root);
        if(aux == null || aux.right != null){
            return false;
        }

        Node n = new Node(element);
        aux.right = n;
        n.father = aux;
        count++;
        return true;
    }    
    
    /**
     * Conta o total de nodos da subarvore cuja raiz esta sendo passada por 
     * parametro.
     * @param n referencia para o nodo a partir do qual sera feita a contagem
     * @return 
     */
    private int countNodes(Node n) {
        int subcount = 0;
        if(n != null){      
            subcount++;
            subcount = subcount + countNodes(n.left);
            subcount = subcount + countNodes(n.right);
        }
        return subcount;
    }
    /**
     * Metodo publico para testar countNodes
     */
    public void testaCountNodes(){
        System.out.println(countNodes(root));
        System.out.println(countNodes(root.left));
        System.out.println(countNodes(searchNodeRef(15, root)));
        System.out.println(countNodes(searchNodeRef(17, root)));
        System.out.println(countNodes(searchNodeRef(17, root).left));
    }
    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento pre-fixada. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */
    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger lst = new LinkedListOfInteger();
        positionsPreAux(root, lst);
        return lst;
    }
    private void positionsPreAux(Node n, LinkedListOfInteger lst){
        if(n != null){
            lst.add(n.element);
            positionsPreAux(n.left, lst);
            positionsPreAux(n.right, lst);
        }
    }
    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento pos-fixada. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */
    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger lst = new LinkedListOfInteger();
        positionsPosAux(root, lst);
        return lst;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger lst){
        if(n != null){
            positionsPosAux(n.left, lst);
            positionsPosAux(n.right, lst);
            lst.add(n.element);
        }
    }
    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento central. Deve chamar um metodo auxiliar recursivo.
     * @return LinkedListOfInteger lista com os elementos da arvore
     */    
    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger lst = new LinkedListOfInteger();
        positionsCentralAux(root, lst);
        return lst;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger lst){
        if(n != null){
            positionsCentralAux(n.left, lst);
            lst.add(n.element);
            positionsCentralAux(n.right, lst);
        }
    }
    
    /** 
     * Retorna uma lista com todos os elementos da arvore na ordem de 
     * caminhamento em largura. 
     * @return LinkedListOfInteger lista com os elementos da arvore
     */  
    public LinkedListOfInteger positionsWidth() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        Queue<Node> q = new Queue<>();
        q.enqueue(root);
        Node aux;
        while(!q.isEmpty()){
            aux = q.dequeue();
            res.add(aux.element);
            if(aux.left!=null){
                q.enqueue(aux.left);
            }
            if(aux.right!=null){
                q.enqueue(aux.right);
            }   
        }
        return res;
    }
    
    /**
     * Procura pelo elemento passado por parametro e remove subarvore.
     * @param element elemento raiz da subarvore a ser removida.
     * @return true se o elemento passado por parametro for encontrado
     * e removido ou false caso contrario.
     */     
    public boolean removeBranch(Integer element) {
        Node aux = searchNodeRef(element, root);
        if(aux==null){
            return false;
        }
        count = count - countNodes(aux);
        if(aux.father.left==aux){
            aux.father.left = null;
        }
        else if(aux.father.right==aux){
            aux.father.right = null;
        }
        aux.father = null;
        return true;
    }        

    /** 
     * Retorna uma string que contem todos os elementos da arvore na ordem de 
     * caminhamento central. Deve chamar um metodo auxiliar recursivo.
     * @return String com todos os elementos da arvore
     */     
    public String strPositionsCentral() {
        String s = "";
        s = strPositionsCentralAux(root, s);
        return s;
    }

    private String strPositionsCentralAux(Node aux, String s){
        if(aux != null){
            s = strPositionsCentralAux(aux.left, s);
            s = s + aux.element + " ";
            s = strPositionsCentralAux(aux.right, s);
        }
        return s;
    }
    /**
     * Retorna o nivel do nodo no qual esta armazenado o elemento
     * passadado por parametro.
     * @param element o elemento que se quer saber o nivel.
     * @return o nivel do nodo onde esta o elemento, ou -1 se nao
     * encontrou o elemento.
     */
    public int level(Integer element) {
        Node aux = searchNodeRef(element, root);
        if(aux == null){
            return -1;
        }
        int levelNodo = 1;
        while(aux.father!=null){
            levelNodo++;
            aux = aux.father;
        }
        return levelNodo;
    }
   
    /**
     * Retorna a altura da arvore. Deve chamar um metodo auxiliar recursivo.
     * @return altura da arvore
     */
    public int height() {
        //TODO
        int h;
        if(root == null){
            h = -1;
        }
        else{
            h = heightAux(root);
        }
        return h;
    }

    private int heightAux(Node aux){
        int hAux = 1;
        int hAuxL = 0;
        int hAuxR = 0;
        if(aux.left != null){
            hAuxL = heightAux(aux.left);
        }
        if(aux.right != null){
            hAuxR = heightAux(aux.right);
        }

        if(hAuxL > hAuxR){
            hAux = hAux + hAuxL;
        }
        else{
            hAux = hAux + hAuxR;
        }
        return hAux;
    }
    
    /**
     * Verifica se o elemento passado por parametro esta armazenado em
     * um nodo folha.
     * @param element elemento a ser encontrado.
     * @return true se o elemento esta em um nodo folha, e false caso contrario.
     */    
    public boolean isExternal(Integer element) {
        //TODO
        return false;
    }

    /**
     * Verifica se o elemento passado por parametro esta armazenado em
     * um nodo interno ou galho.
     * @param element elemento a ser encontrado.
     * @return true se o elemento esta em um nodo interno, e false caso contrario.
     */       
    public boolean isInternal(Integer element) {
        //TODO
        return false;
    }

    /**
     * Verifica se o elemento passado por parametro tem um filho na 
     * subarvore da esquerda.
     * @param element elemento a ser encontrado para verificar se possui filho 
     * a esquerda.
     * @return true se o elemento tem subarvore a esquerda, e false caso contrario.
     */     
    public boolean hasLeft(Integer element) {
        //TODO
        return false;
    }

    /**
     * Verifica se o elemento passado por parametro tem um filho na 
     * subarvore da direita.
     * @param element elemento a ser encontrado para verificar se possui filho
     * a direita
     * @return true se o elemento tem subarvore a direita, e false caso contrario.
     */       
    public boolean hasRight(Integer element) {
        //TODO
        return false;
    }

    /**
     * Procura pelo elemento passado por parametro e retorna o seu filho da 
     * subarvore da esquerda.
     * @param element elemento a ser encontrado para retornar seu filho a esquerda.
     * @return referencia para o filho da subarvore da esquerda, ou null caso o 
     * elemento passado por parametro nao seja encontrado ou caso ele nao tenha
     * filho na subarvore da esquerda.
     */    
    public Integer getLeft(Integer element) {
        //TODO
        return 0;
    }

    /**
     * Procura pelo elemento passado por parametro e retorna o seu filho da 
     * subarvore da direita.
     * @param element elemento a ser encontrado para retornar seu filho a direita.
     * @return referencia para o filho da subarvore da direita, ou null caso o 
     * elemento passado por parametro nao seja encontrado ou caso ele nao tenha
     * filho na subarvore da direita.
     */        
    public Integer getRight(Integer element) {
        //TODO
        return 0;
    }

    /**
     * Procura pelo elemento passado por parametro e retorna o seu pai.
     * @param element elemento a ser encontrado para retornar seu pai.
     * @return referencia para o pai, ou null caso o elemento passado por 
     * parametro nao seja encontrado ou caso ele esteja na raiz.
     */     
    public Integer getParent(Integer element) {
        //TODO
        return 0;
    }    
    
}
