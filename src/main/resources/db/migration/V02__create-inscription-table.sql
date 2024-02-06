CREATE TABLE inscription (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    gender VARCHAR(9) NOT NULL,
    phone VARCHAR(10),
    cellphone VARCHAR(11) NOT NULL,
    entrance_type VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    number VARCHAR(10),
    complement VARCHAR(20),
    neighborhood VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    postal_code VARCHAR(8) NOT NULL,
    state VARCHAR(32) NOT NULL,
    how_did_you_know VARCHAR(50) NOT NULL,
    course_id BIGINT NOT NULL,

    PRIMARY KEY (id)
)