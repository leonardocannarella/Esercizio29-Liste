public class Festa {
    private Nodo head;
    private int elementi;

    public Festa() {
        head = null;
        elementi=0;
    }

    public Festa(Invitato[] in)
    {
        int lunghezza = in.length;
        int i = lunghezza-1;

        inserisciListaAlContrario(in, i);
    }

    private void inserisciListaAlContrario(Invitato[] in, int i)
    {
        inserisciInTesta(in[i]);
        i--;
        while(i>=0)
        {
            inserisciInCoda(in[i]);
            i--;
        }
    }

    private Nodo getLinkPosizione(int posizione) throws FestaException {
        int n = 1;
        Nodo p = head;

        if (head==null)
            throw new FestaException("Lista vuota");

        if ((posizione>elementi) || (posizione<1))
            throw new FestaException("Posizione errata");

        while ((p.getLink()!=null) && (n<posizione)) {
            p = p.getLink();
            n++;
        }
    return p;
    }

    private Nodo creaNodo(Invitato persona, Nodo link) {
        Nodo nuovoNodo = new Nodo(persona);
        nuovoNodo.setLink(link);
        return nuovoNodo;
    }

    public int getElementi() {
        return elementi;
    }

    public void inserisciInTesta(Invitato persona) {
        Nodo p = creaNodo(persona, head);
        head = p;
        elementi++;

        return;
    }

    public void inserisciInCoda(Invitato persona) {
        if (head==null)
            inserisciInTesta(persona);
        else {
            try {
                Nodo p = getLinkPosizione(elementi);        //Conserva il penultimo
                p.setLink(creaNodo(persona, null));     //Lo fa puntare all'ultimo, che a sua volta punta a niente
                elementi++;
            }
            catch (FestaException exception){
            }

            return;
        }
    }

    public void inserisciInPosizione(Invitato persona, int posizione) throws FestaException {
        if (posizione<=1)
            inserisciInTesta(persona);
        else {
            if (elementi<posizione)
                inserisciInCoda(persona);
            else {
                Nodo p = getLinkPosizione(posizione-1);
                p.setLink(creaNodo(persona, p.getLink()));
                elementi++;
            }
        }
        return;
    }

    public void eliminaInTesta() throws FestaException {
        if (head==null)
            throw new FestaException("Lista vuota");
        head=head.getLink();
        elementi--;
        return;
    }

    public void eliminaInCoda() throws FestaException {
        if (head==null)
            throw new FestaException("Lista vuota");
        Nodo p = getLinkPosizione(elementi-1);
        p.setLink(null);
        elementi--;
        return;
    }

    public void eliminaInPosizione(int posizione) throws FestaException {
        if (posizione==1)
            eliminaInTesta();
        else
            if (elementi<=posizione)
                eliminaInCoda();
            else {
                Nodo ps = getLinkPosizione(posizione);
                Nodo pp = getLinkPosizione(posizione-1);
                pp.setLink(ps.getLink());
                elementi--;
            }
            return;
    }

    public void lastFirst(){
        if(head==null)
            return; //lista vuota
        if(head.getLink()==null)
            return;//lista con un solo elemento

        Nodo n1=head;                   //Conserva il primo elemento (ORIGINALE)
        head=head.getLink();            //Elimina il primo elemento e il secondo diventa head
        Nodo n2=head;                   //Questo punta al primo elemento (ATTUALE)
        Nodo n3=head;                   //Anche questo punta al primo elemento (ATTUALE)

        n1.setLink(null);               //Elemento originale non punta a niente per la sua destinazione in coda
        while (n2.getLink()!=null){
            n3=n2;
            n2=n2.getLink();
        }
        n3.setLink(n1);
        n2.setLink(head);
        head=n2;
    }

    public void ourLastFirst() throws FestaException{
        if(head==null)
            return; //lista vuota
        if(head.getLink()==null)
            return;//lista con un solo elemento

        Nodo n1=head;                   //Conserva il primo elemento (ORIGINALE)
        eliminaInTesta();
        Nodo n2=getLinkPosizione(elementi);
        eliminaInCoda();

        inserisciInTesta(n2.getInfo());
        inserisciInCoda(n1.getInfo());
    }

    public String isSublist(Festa f)
    {
        //TODO Metodo da scrivere
        return "";
    }


    public int shuffle(int k, int h){
        if(k==h) //stessa posizione
            return 0;
        if (head==null)//lista vuota
            return -1;
        if (head.getLink()==null) //un solo elemento nella lista
            return -1;
        if (k>elementi)
            return -1; //K è maggiore degli elementi della lista
        if(((k==1)&&(h==elementi))||((k==elementi)&&(h==1)))
        {
            System.out.println("Chiamata la lastFirst()");
            lastFirst();
            return 1;
        }
        //individuazione del K-esimo nodo
        Nodo n1=head;
        Nodo n2=head;
        int p=1;

        while (p<k){
            n2=n1;
            n1=n1.getLink();
            p++;
        }

        if (p==1)//primo elemento della lista
            head=head.getLink();
        else
            n2.setLink(n1.getLink()); //si stacca l'elemento in posizione K


        //si individua la posizione h

        if(h<=1){
            n1.setLink(head);
            head=n1;
        }
        else if (h>=elementi){//inserimento in coda
            n2=head;
            while (n2.getLink()!=null)
                n2=n2.getLink();
            n2.setLink(n1);
            n1.setLink(null);
        }
        else{
            n2=head;
            p=1;
            while (p<h-1){
                n2=n2.getLink();
                p++;
            }
            n1.setLink(n2.getLink());
            n2.setLink(n1);
        }
        return 1;
    }

    private String visita(Nodo p) {
        if (p==null)
            return "";
        return p.getInfo().toString()+"\n"+visita(p.getLink());
    }

    public String elenco() {
        return visita(head);
    }

    public String toString() {
        Nodo p = head;
        String lista = new String("head->");

        if (p==null)
            return lista+"null";

        while (p!=null) {
            lista = lista+"["+p.getInfo().toString()+"|";

            if (p.getLink()==null)
                lista = lista+"null]";
            else
                lista = lista+"+]->";
                p = p.getLink();
        }
        return lista;
    }
}