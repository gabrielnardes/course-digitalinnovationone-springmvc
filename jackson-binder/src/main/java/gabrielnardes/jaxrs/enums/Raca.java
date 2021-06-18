package gabrielnardes.jaxrs.enums;

public enum Raca {
    HUMANO("humano"),
    ELFO("elfo"),
    ORC("orc"),
    ANAO("anao");

    private String value;

    Raca(String value) {
        this.value = value;
    }
}


