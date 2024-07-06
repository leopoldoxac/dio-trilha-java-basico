// Herança: Classe Curso herda de Conteudo
class Curso extends Conteudo {
    private int cargaHoraria;

    // Polimorfismo: Sobrescrita do método calcularXp
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    // Encapsulamento: Getter e Setter
    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }
}