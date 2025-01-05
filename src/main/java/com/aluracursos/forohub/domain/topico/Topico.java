package com.aluracursos.forohub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titulo;
        private String mensaje;
        private LocalDateTime fechacreacion;
        private Boolean status;
        private String curso;

        //Lo que sigue se debería implementar con otras tablas...
        //private String autor;
        //private String respuestas;
        //... y también el curso


        public Topico() {
        }

        public Topico(Long id, String titulo, String mensaje, LocalDateTime fechacreacion, Boolean status, String curso) {
                this.id = id;
                this.titulo = titulo;
                this.mensaje = mensaje;
                this.fechacreacion = fechacreacion;
                this.status = status;
                this.curso = curso;
        }

        public Topico(String titulo, String mensaje, String curso) {
                //this.status = true;
                //this.fechacreacion = LocalDateTime.now();

                this.titulo = titulo;
                this.mensaje = mensaje;
                this.curso = curso;
        }

        //public void actualizarTopico(Topico topico) {
        //        if (titulo != null) {
        //                this.titulo = titulo;
        //        }
        //        if (mensaje != null) {
        //                this.mensaje = mensaje;
        //        }
        //        if (curso != null) {
        //                this.curso = curso;
        //        }
        //}

        public void actualizarTopico(Topico topicoActualizado) {
                if (topicoActualizado.getTitulo() != null) {
                        this.titulo = topicoActualizado.getTitulo();
                }
                if (topicoActualizado.getMensaje() != null) {
                        this.mensaje = topicoActualizado.getMensaje();
                }
                if (topicoActualizado.getCurso() != null) {
                        this.curso = topicoActualizado.getCurso();
                }
        }

        public void desactivarTopico() {
                this.status = false;
        }

        public Topico(Topico topico) {
        }

        public Long getId() {
                return id;
        }

        public String getTitulo() {
                return titulo;
        }

        public String getMensaje() {
                return mensaje;
        }

        public LocalDateTime getFechacreacion() {
                return fechacreacion;
        }

        public Boolean getStatus() {
                return status;
        }

        public String getCurso() {
                return curso;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public void setMensaje(String mensaje) {
                this.mensaje = mensaje;
        }

        public void setFechacreacion(LocalDateTime fechacreacion) {
                this.fechacreacion = fechacreacion;
        }

        public void setStatus(Boolean status) {
                this.status = status;
        }

        public void setCurso(String curso) {
                this.curso = curso;
        }
}
