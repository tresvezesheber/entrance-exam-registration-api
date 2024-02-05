CREATE TABLE course (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    modality VARCHAR(50) NOT NULL,
    duration  VARCHAR(50) NOT NULL,
    mode VARCHAR(50) NOT NULL,
    unit VARCHAR(150) NOT NULL,
    turn VARCHAR(50) NOT NULL,
    monthly_fee VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (id)
)