-- 1. Eliminar columnas incorrectas
ALTER TABLE topicos DROP COLUMN autor;
ALTER TABLE topicos DROP COLUMN curso;

-- 2. Agregar columnas correctas
ALTER TABLE topicos ADD COLUMN usuario_id BIGINT;
ALTER TABLE topicos ADD COLUMN curso_id BIGINT;

-- 3. Crear claves foráneas
ALTER TABLE topicos
ADD CONSTRAINT fk_topicos_usuario
FOREIGN KEY (usuario_id)
REFERENCES usuarios(id)
ON DELETE SET NULL;

ALTER TABLE topicos
ADD CONSTRAINT fk_topicos_curso
FOREIGN KEY (curso_id)
REFERENCES cursos(id)
ON DELETE SET NULL;
