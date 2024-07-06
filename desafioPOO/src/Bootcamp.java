import java.time.LocalDate;
import java.util.*;

class Bootcamp {
    private String nome;
    private String descricao;
    private LocalDate dataInicial = LocalDate.now();
    private LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public void inscreverDev(Dev dev) {
        devsInscritos.add(dev);
        dev.inscreverBootcamp(this);
    }

    // Encapsulamento: Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataInicial() { return dataInicial; }
    public LocalDate getDataFinal() { return dataFinal; }
    public Set<Dev> getDevsInscritos() { return devsInscritos; }
    public Set<Conteudo> getConteudos() { return conteudos; }
}