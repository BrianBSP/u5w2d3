package brianpelinku.u5w2d3.payloads;

import lombok.Getter;

@Getter
public class NewBlogPayload {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private int authorId;
}
