package br.com.fiap.calorias.dto;

public record UsuarioCadastroDTO(
        Long usuarioId,
        String nome,
        String email,
        String senha
) {
}
