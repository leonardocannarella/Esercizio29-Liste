import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws FestaException {

        Invitato i1 = new Invitato("Bianchi Giovanni", 'M', "0586 854822");
        Invitato i2 = new Invitato("Rossi Marta", 'F', "0586 844853");
        Invitato i3 = new Invitato("Neri Marco", 'M', "0586 444722");
        Invitato i4 = new Invitato("Verdi Roberta", 'F', "0586 974824");
        Invitato i5 = new Invitato("Leonardo Cannarella", 'M', "334 9086784");
        Invitato i6 = new Invitato("Mario Rossi", 'M', "345 0453672");
        Invitato i7 = new Invitato("Tizio Caio", 'M', "344 6509847");

        Invitato [] v = {i1,i2,i3,i4,i5,i6};
        Invitato [] vSub = {i1,i3,i6};

        Festa f = new Festa(v);
        Festa fSub = new Festa(vSub);

        System.out.println(f.isSublist(fSub));

        // System.out.println(f.toString());


        /*
          f.inserisciInTesta(i1);
                  f.inserisciInTesta(i2);
                  f.inserisciInCoda(i3);

                  try {
                      f.inserisciInPosizione(i4, 2);
                  } catch (FestaException exception) {
                      System.out.println(exception.getError());
                  }

                  System.out.println("Visita ricorsiva: ");
                  System.out.println(f.elenco());
                  System.out.println("------------------");
                  System.out.println(f.toString());
                  System.out.println("------------------");

                  try {
                      f.eliminaInPosizione(2);
                  } catch (FestaException exception) {
                      System.out.println(exception.getError());
                  }

                  System.out.println(f.toString());
                  System.out.println("------------------");

                  try {
                      f.eliminaInCoda();
                  } catch (FestaException exception) {
                      System.out.println(exception.getError());
                  }

                  System.out.println(f.toString());
                  System.out.println("------------------");

                  try {
                      f.eliminaInTesta();
                  } catch (FestaException exception) {
                      System.out.println(exception.getError());
                  }

                  System.out.println(f.toString());
                  System.out.println("------------------");

                  try {
                      f.eliminaInPosizione(5);
                  } catch (FestaException exception) {
                      System.out.println(exception.getError());
                  }

                  System.out.println(f.toString());
                  System.out.println("------------------");
                  try {
                      f.eliminaInPosizione(1);
                  } catch (FestaException exception) {
                      System.out.println(exception.getError());
                  }

                  System.out.println(f.toString());
                  System.out.println("------------------");

                  try {
                      f.eliminaInPosizione(1);
                  } catch (FestaException exception) {
                      System.out.println(exception.getError());
                  }

                  f.inserisciInTesta(i5);
                  f.inserisciInCoda(i6);
                  f.inserisciInPosizione(i2, 1);
                  System.out.println(f.toString());

                  System.out.println(f.shuffle(3,1));
                  System.out.println(f.toString());
              }
          */
    }
}
