import java.util.Date;

public class ObraPrivada extends Obra{
    private boolean areaRural;
    private int metragemTerreno;

    public ObraPrivada(int id, Date dataCriacao, String descricaoObra, Profissional[] profissionals, boolean areaRural, int metragemTerreno) {
        super(id, dataCriacao, descricaoObra, profissionals);
        this.areaRural = areaRural;
        this.metragemTerreno = metragemTerreno;
    }

    public boolean isAreaRural() {
        return areaRural;
    }

    public void setAreaRural(boolean areaRural) {
        this.areaRural = areaRural;
    }

    public int getMetragemTerreno() {
        return metragemTerreno;
    }

    public void setMetragemTerreno(int metragemTerreno) {
        this.metragemTerreno = metragemTerreno;
    }
}
