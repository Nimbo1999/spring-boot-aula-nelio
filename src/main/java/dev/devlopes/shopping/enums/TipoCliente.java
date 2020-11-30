package dev.devlopes.shopping.enums;

public enum TipoCliente {
    
    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int code;
    private String descricao;

    private TipoCliente(int code, String descricao) {
        this.code = code;
        this.descricao = descricao;
    }

    public int getCode() {
        return code;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer code) {

        if (code == null) return null;

        for (TipoCliente x : TipoCliente.values()) {
            if ( code.equals(x.getCode()) ) return x;
        }

        throw new IllegalArgumentException("Não existe um tipoPessoa para o code " + code);

    }

}
