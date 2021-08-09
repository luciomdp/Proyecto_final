package backend;

public class PartidoZona extends Partido{
	private int GolE1, GolE2;
	
	private static final long serialVersionUID = 1584061224750984258L;

	public PartidoZona(Equipo a, Equipo b) {
		super(a, b);
		this.GolE1 = 0;
        this.GolE2 = 0;
	}
	
	public void simulacion() {

    }

    public int getGolE1() {
        return GolE1;
    }

    public void setGolE1(int golE1) {
        GolE1 = golE1;
    }

    public int getGolE2() {
        return GolE2;
    }

    public void setGolE2(int golE2) {
        GolE2 = golE2;
    }
}