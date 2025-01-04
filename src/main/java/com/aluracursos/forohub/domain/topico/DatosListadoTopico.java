package com.aluracursos.forohub.domain.topico;

public record DatosListadoTopico(Long id, String titulo, String mensaje) {

        public DatosListadoTopico(Topico topico) {
            this(topico.getId(), topico.getTitulo(), topico.getMensaje());
        }

}

