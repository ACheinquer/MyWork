public class arvoreGenerica{
    
    private class TreeNode{
        
        public TreeNode pai;    // A raiz da árvore será sempre o pai
        public TriboBarbaria Guerreiro; // Demais elementos são os guerreiros filhos
        private TreeNode[] children;
        private int nChild;     // Número de filhos

        public TreeNode(TriboBarbaria elemento){
            this.Guerreiro = elemento;
            pai = null;
            children = new TreeNode[10];
            nChild = 0;
        }

        public void addSubtree (TreeNode n){
            if(n!=null){
                if(nChild==children.length)
                    grow();
                children[nChild]=n;
                nChild++;
                n.pai=this;
            }
        }

        private void grow(){
            TreeNode [] aux = new TreeNode[children.length*2];
            for(int i=0; i<children.length; i++)
                aux[i]=children[i];
            children=aux;
        }
    
        public TreeNode getSubtree(int idx){
            if(idx>=0 && idx<nChild)
                return children[idx];
            return null;
        }

        public int getSubtreesSize(){
            return nChild;
        }
    
    }

    private TreeNode root;
    private int nElements;

    //método básico para caminhamento/busca na árvore
    private TreeNode searchNode(TriboBarbaria e, TreeNode ref){
        if(ref!=null){
            if(ref.Guerreiro==e)
                return ref;
            else{
                TreeNode aux=null;
                for(int i=0; i<ref.getSubtreesSize(); i++){
                    aux=searchNode(e, ref.getSubtree(i));
                    if(aux!=null)
                        return aux;
                }
                return null;                    
            }
        }
        else{
            return null;
        }
    }

    public boolean add(TriboBarbaria e, TriboBarbaria pai){
        if(nElements==0) // adicionando o elemento raiz
            root=new TreeNode(e);
        else{// adicionando um elemento que não é a raiz da árvore
            //tenho de encontrar o pai
            TreeNode aux = searchNode(pai, root);
            //se eu encontrei o pai
            if(aux!=null)
              //tenho de adicionar o e ao pai
              aux.addSubtree(new TreeNode(e));
            //senao
            else
              // tenho q informa q não possivel adicionar o filho
              return false;
        }
        nElements++;
        return true;
    }

    public TriboBarbaria getParent(TriboBarbaria e){
        if(e!=null){
            TreeNode aux = searchNode(e, root);
            // o elemento não existe
            if(aux==null)
                return null;
            // o elemento é raiz
            if(aux==root)
                return null;
            // o elemento não é raiz
            return aux.pai.Guerreiro;
        }
        return null;
    }

    private void printTree(TreeNode ref){
        if(ref!=null){
            System.out.printf(ref.Guerreiro+"%n" );
            for(int i=0; i<ref.getSubtreesSize(); i++)
                printTree(ref.getSubtree(i));            
        }
    }

    public void printTree(){
        if(root==null)
            System.out.print("A árvore está vazia");
        else
            printTree(root);
        System.out.println();
    }
}