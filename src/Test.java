public class Test {
    public static void main(String[] args) {
        Invitato i1 = new Invitato("Bianchi Giovanni", 'M', "0586 854822");
        Invitato i2 = new Invitato("Rossi Marta", 'F', "0586 844853");
        Invitato i3 = new Invitato("Neri Marco", 'M', "0586 444722");
        Invitato i4 = new Invitato("Verdi Roberta", 'F', "0586 974824");

        Festa f = new Festa();

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
    }
}
