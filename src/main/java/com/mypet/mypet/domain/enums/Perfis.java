package com.mypet.mypet.domain.enums;

public enum Perfis {
    ADMIN(0, "ROLE_ADMIN"), TUTOR(1, "ROLE_TUTOR"), FUNCIONARIO(2, "ROLE_FUNCIONARIO");

    private Integer codigo;
    private String descricao;

    private Perfis(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfis toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Perfis x : Perfis.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil inválido");
    }
}
