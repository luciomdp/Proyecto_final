package backend;

import proyecto_final.Equipo;

 public class Resultados {
	private Equipo e1;
    private Equipo e2;
    private int golesE1;
    private int golesE2;

    public Resultados(Equipo equipo1, Equipo equipo2, int golesE1, int golesE2) {
        this.e1 = equipo1;
        this.e2 = equipo2;
        this.golesE1 = golesE1;
        this.golesE2 = golesE2;
    }

    public String getE1() {
        return e1.getNombre();
    }

    public void setE1(Equipo e1) {
        this.e1 = e1;
    }

    public String getE2() {
        return e2.getNombre();
    }

    public void setE2(Equipo e2) {
        this.e2 = e2;
    }

    public int getGolesE1() {
        return golesE1;
    }

    public void setGolesE1(int golesE1) {
        this.golesE1 = golesE1;
    }

    public int getGolesE2() {
        return golesE2;
    }

    public void setGolesE2(int golesE2) {
        this.golesE2 = golesE2;
    }


}
