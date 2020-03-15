package definitions;

public class Processo {
    private static String lastProcessoId;

    public static void setLatsProcessoId(String processoId){
        lastProcessoId = processoId;
    }

    public static String getLastProcessoId(){
        return lastProcessoId;
    }
}
