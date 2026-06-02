CREATE TABLE tb_categorias (
    categoria_id BIGSERIAL PRIMARY KEY,
    categoria_nome VARCHAR(100) NOT NULL,
    categoria_descricao VARCHAR(255) NOT NULL
);

CREATE TABLE tb_eventos (
    evento_id BIGSERIAL PRIMARY KEY,
    evento_nome VARCHAR(100) NOT NULL,
    evento_descricao VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    evento_local VARCHAR(255) NOT NULL,
    categoria_id BIGINT NOT NULL,

    FOREIGN KEY (categoria_id) REFERENCES tb_categorias(categoria_id)
);