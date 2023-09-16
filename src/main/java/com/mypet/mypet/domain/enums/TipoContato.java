package com.mypet.mypet.domain.enums;

public enum TipoContato {
    PRINCIPAL(0, "CONTATO PRINCIPAL"), CONTATO2(1, "CONTATO SECUNDARIO"), CONTATO3(2, "TERCEIRO CONTATO");

    private Integer codigo;
    private String descricao;

    private TipoContato(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoContato toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(TipoContato x : TipoContato.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Tipo de contato inválido");
    }
}
