package idanielsfree.profemale;

public class Categorias {

    private String descricao;
    private int foto;

    public Categorias() {

    }

    public Categorias(String descricao, int foto) {
        this.descricao = descricao;
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
