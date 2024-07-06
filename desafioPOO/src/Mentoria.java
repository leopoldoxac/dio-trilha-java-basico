import java.time.LocalDate;

// Herança: Classe Mentoria herda de Conteudo
class Mentoria extends Conteudo {
    private LocalDate data;

    // Polimorfismo: Sobrescrita do método calcularXp
    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    // Encapsulamento: Getter e Setter
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}