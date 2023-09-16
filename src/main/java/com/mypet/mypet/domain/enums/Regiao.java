package com.mypet.mypet.domain.enums;

public enum Regiao {
   LESTE(0, "ZONA LESTE"), OESTE(1, "ZONA OESTE"), SUL(2, "ZONA SUL"),
    NORTE(3, "ZONA NORTE"), ABC(4, "SANTO ANDRÉ, SÃO CAETANO DO SUL, SÃO BERNARDO DO CAMPO, MAÚA, DIADEMA")
    , CAPITAL(5, "CIDADE DE SÃO PAULO");

    private Integer codigo;
    private String descricao;

    private Regiao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Regiao toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Regiao x : Regiao.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Região inválida");
    }
}
