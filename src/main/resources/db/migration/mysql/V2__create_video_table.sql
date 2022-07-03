CREATE TABLE video
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime     NOT NULL,
    name         VARCHAR(255) NOT NULL,
    size         BIGINT       NOT NULL,
    extension    VARCHAR(10)  NOT NULL,
    user_id      VARCHAR(255) NOT NULL,
    s3key        VARCHAR(255) NOT NULL,
    CONSTRAINT pk_video PRIMARY KEY (id)
);