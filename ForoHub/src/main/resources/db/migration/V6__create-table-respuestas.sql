CREATE TABLE respuestas (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    solucion BOOLEAN DEFAULT FALSE,
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,

    CONSTRAINT fk_respuesta_topico FOREIGN KEY (topico_id) REFERENCES topicos(id) ON DELETE CASCADE,
    CONSTRAINT fk_respuesta_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE
);
