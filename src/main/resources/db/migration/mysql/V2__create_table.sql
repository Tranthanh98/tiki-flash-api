CREATE TABLE user
(
    id           VARCHAR(255) NOT NULL,
    created_date datetime     NOT NULL,
    name         VARCHAR(255) NOT NULL,
    avatar       VARCHAR(255) NULL,
    email        VARCHAR(255) NOT NULL,
    phone        VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE video
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime     NOT NULL,
    name         VARCHAR(255) NOT NULL,
    title        VARCHAR(255) NULL,
    size         BIGINT       NOT NULL,
    extension    VARCHAR(10)  NOT NULL,
    user_id      VARCHAR(255) NOT NULL,
    s3key        VARCHAR(255) NOT NULL,
    is_active    BIT(1)       NOT NULL,
    total_view   INT          NOT NULL,
    CONSTRAINT pk_video PRIMARY KEY (id)
);

CREATE TABLE video_comment
(
    id           BIGINT       NOT NULL,
    created_date datetime     NOT NULL,
    user_id      VARCHAR(255) NOT NULL,
    video_id     BIGINT       NOT NULL,
    CONSTRAINT pk_video_comment PRIMARY KEY (id)
);

CREATE TABLE video_like
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    created_date datetime     NOT NULL,
    user_id      VARCHAR(255) NOT NULL,
    video_id     BIGINT       NOT NULL,
    CONSTRAINT pk_video_like PRIMARY KEY (id)
);