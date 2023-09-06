CREATE TABLE person
(
    person_id          INT AUTO_INCREMENT NOT NULL,
    national_id_number VARCHAR(15)        NOT NULL,
    first_name         VARCHAR(50)        NOT NULL,
    last_name          VARCHAR(50)        NOT NULL,
    birth_date         date               NOT NULL,
    gender             VARCHAR(15)        NOT NULL,
    email              VARCHAR(150)       NULL,
    email_promotion    BIT(1)             NOT NULL,
    phone_number       VARCHAR(15)        NOT NULL,
    photo              VARBINARY(8000)    NULL,
    created_date       datetime           NOT NULL,
    modified_date      datetime           NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY (person_id)
);

CREATE TABLE person
(
    person_id          INT AUTO_INCREMENT NOT NULL,
    national_id_number VARCHAR(15)        NOT NULL,
    first_name         VARCHAR(50)        NOT NULL,
    last_name          VARCHAR(50)        NOT NULL,
    birth_date         date               NOT NULL,
    gender             VARCHAR(15)        NOT NULL,
    email              VARCHAR(150)       NULL,
    email_promotion    BIT(1) DEFAULT 0   NULL,
    phone_number       VARCHAR(15)        NOT NULL,
    photo_url          VARCHAR(1000)      NULL,
    created_date       datetime           NOT NULL,
    modified_date      datetime           NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY (person_id)
);

ALTER TABLE person
    ADD CONSTRAINT uc_person_national_id_number UNIQUE (national_id_number);

CREATE TABLE `role`
(
    role_id       INT AUTO_INCREMENT NOT NULL,
    role_name     VARCHAR(50)        NOT NULL,
    `description` VARCHAR(255)       NOT NULL,
    modified_date datetime           NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (role_id)
);

CREATE TABLE employee
(
    employee_id      BIGINT AUTO_INCREMENT NOT NULL,
    person_id        INT                   NULL,
    job_title        VARCHAR(50)           NOT NULL,
    marital_status   VARCHAR(50)           NOT NULL,
    hire_date        date                  NOT NULL,
    salaried_flag    BIT(1)                NOT NULL,
    vacation_hours   INT                   NOT NULL,
    sick_leave_hours INT                   NOT NULL,
    current_flag     BIT(1)                NOT NULL,
    modified_date    datetime              NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (employee_id)
);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (person_id);

CREATE TABLE department
(
    department_id INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(50)        NOT NULL,
    group_name    VARCHAR(50)        NOT NULL,
    modified_date datetime           NOT NULL,
    CONSTRAINT pk_department PRIMARY KEY (department_id)
);

CREATE TABLE employee_account
(
    employee_account_id INT AUTO_INCREMENT NOT NULL,
    employee_id         BIGINT             NOT NULL,
    role_id             INT                NOT NULL,
    username            VARCHAR(50)        NOT NULL,
    password_hash       VARCHAR(150)       NOT NULL,
    password_salt       VARCHAR(50)        NOT NULL,
    created_date        datetime           NOT NULL,
    modified_date       datetime           NOT NULL,
    CONSTRAINT pk_employee_account PRIMARY KEY (employee_account_id)
);

ALTER TABLE employee_account
    ADD CONSTRAINT uc_employee_account_username UNIQUE (username);

ALTER TABLE employee_account
    ADD CONSTRAINT FK_EMPLOYEE_ACCOUNT_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employee (employee_id);

ALTER TABLE employee_account
    ADD CONSTRAINT FK_EMPLOYEE_ACCOUNT_ON_ROLE FOREIGN KEY (role_id) REFERENCES `role` (role_id);

CREATE TABLE employee_department_history
(
    department_id INT      NOT NULL,
    employee_id   BIGINT   NOT NULL,
    start_date    date     NOT NULL,
    end_date      date     NULL,
    modified_date datetime NOT NULL,
    CONSTRAINT pk_employee_department_history PRIMARY KEY (department_id, employee_id, start_date)
);

ALTER TABLE employee_department_history
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT_HISTORY_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES department (department_id);

ALTER TABLE employee_department_history
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT_HISTORY_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employee (employee_id);

CREATE TABLE post
(
    post_id       INT AUTO_INCREMENT NOT NULL,
    post_title    VARCHAR(255)       NOT NULL,
    post_brief    VARCHAR(500)       NULL,
    post_content  BLOB               NULL,
    img_url       VARCHAR(1000)      NOT NULL,
    author_id     INT                NOT NULL,
    modified_date datetime           NOT NULL,
    CONSTRAINT pk_post PRIMARY KEY (post_id)
);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES employee_account (employee_account_id);

CREATE TABLE comment
(
    comment_id    BIGINT AUTO_INCREMENT NOT NULL,
    post_id       INT                   NOT NULL,
    author_name   VARCHAR(255)          NOT NULL,
    author_email  VARCHAR(255)          NOT NULL,
    comments      VARCHAR(2000)         NULL,
    created_date  datetime              NOT NULL,
    is_approved   BIT DEFAULT 0         NULL,
    modified_date datetime              NOT NULL,
    CONSTRAINT pk_comment PRIMARY KEY (comment_id)
);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_POST FOREIGN KEY (post_id) REFERENCES post (post_id);

CREATE TABLE category
(
    category_id   INT AUTO_INCREMENT NOT NULL,
    category_name VARCHAR(50)        NOT NULL,
    `description` VARCHAR(255)       NULL,
    modified_date datetime           NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (category_id)
);

CREATE TABLE subcategory
(
    subcategory_id   INT AUTO_INCREMENT NOT NULL,
    category_id      INT                NOT NULL,
    subcategory_name VARCHAR(50)        NOT NULL,
    `description`    VARCHAR(255)       NULL,
    modified_date    datetime           NOT NULL,
    CONSTRAINT pk_subcategory PRIMARY KEY (subcategory_id)
);

ALTER TABLE subcategory
    ADD CONSTRAINT FK_SUBCATEGORY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (category_id);

CREATE TABLE post_category_subcategory
(
    post_id        INT      NOT NULL,
    category_id    INT      NOT NULL,
    subcategory_id INT      NOT NULL,
    modified_date  datetime NOT NULL,
    CONSTRAINT pk_post_category_subcategory PRIMARY KEY (post_id, category_id, subcategory_id)
);

ALTER TABLE post_category_subcategory
    ADD CONSTRAINT FK_POST_CATEGORY_SUBCATEGORY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (category_id);

ALTER TABLE post_category_subcategory
    ADD CONSTRAINT FK_POST_CATEGORY_SUBCATEGORY_ON_POST FOREIGN KEY (post_id) REFERENCES post (post_id);

ALTER TABLE post_category_subcategory
    ADD CONSTRAINT FK_POST_CATEGORY_SUBCATEGORY_ON_SUBCATEGORY FOREIGN KEY (subcategory_id) REFERENCES subcategory (subcategory_id);

CREATE TABLE credit_card
(
    credit_card_id BIGINT AUTO_INCREMENT NOT NULL,
    card_type      VARCHAR(50)           NOT NULL,
    card_number    VARCHAR(25)           NOT NULL,
    exp_month      INT                   NOT NULL,
    exp_year       INT                   NOT NULL,
    modified_date  datetime              NOT NULL,
    CONSTRAINT pk_credit_card PRIMARY KEY (credit_card_id)
);

CREATE TABLE customer_account
(
    customer_account_id BIGINT AUTO_INCREMENT NOT NULL,
    customer_id         BIGINT                NULL,
    username            VARCHAR(50)           NOT NULL,
    password_hash       VARCHAR(150)          NOT NULL,
    password_salt       VARCHAR(50)           NOT NULL,
    created_date        datetime              NOT NULL,
    modified_date       datetime              NOT NULL,
    CONSTRAINT pk_customer_account PRIMARY KEY (customer_account_id)
);

ALTER TABLE customer_account
    ADD CONSTRAINT uc_customer_account_username UNIQUE (username);

ALTER TABLE customer_account
    ADD CONSTRAINT FK_CUSTOMER_ACCOUNT_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

CREATE TABLE customer_type
(
    customer_type_id INT AUTO_INCREMENT NOT NULL,
    name             VARCHAR(50)        NOT NULL,
    `description`    VARCHAR(255)       NULL,
    modified_date    datetime           NOT NULL,
    CONSTRAINT pk_customer_type PRIMARY KEY (customer_type_id)
);

CREATE TABLE customer_credit_card
(
    customer_account_id BIGINT           NOT NULL,
    credit_card_id      BIGINT           NOT NULL,
    is_primary          BIT(1) DEFAULT 0 NULL,
    modified_date       datetime         NOT NULL,
    CONSTRAINT pk_customer_credit_card PRIMARY KEY (customer_account_id, credit_card_id)
);

ALTER TABLE customer_credit_card
    ADD CONSTRAINT FK_CUSTOMER_CREDIT_CARD_ON_CREDIT_CARD FOREIGN KEY (credit_card_id) REFERENCES credit_card (credit_card_id);

ALTER TABLE customer_credit_card
    ADD CONSTRAINT FK_CUSTOMER_CREDIT_CARD_ON_CUSTOMER_ACCOUNT FOREIGN KEY (customer_account_id) REFERENCES customer_account (customer_account_id);

CREATE TABLE customer
(
    customer_id     BIGINT AUTO_INCREMENT NOT NULL,
    customer_type   INT                   NULL,
    first_name      VARCHAR(150)          NOT NULL,
    last_name       VARCHAR(50)           NULL,
    phone_number    VARCHAR(15)           NULL,
    email           VARCHAR(150)          NULL,
    email_promotion BIT(1) DEFAULT 0      NULL,
    created_date    datetime              NOT NULL,
    modified_date   datetime              NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_email UNIQUE (email);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_phone_number UNIQUE (phone_number);

ALTER TABLE customer
    ADD CONSTRAINT FK_CUSTOMER_ON_CUSTOMER_TYPE FOREIGN KEY (customer_type) REFERENCES customer_type (customer_type_id);

CREATE TABLE customer_address
(
    customer_account_id BIGINT       NOT NULL,
    address_id          BIGINT       NOT NULL,
    address             VARCHAR(255) NOT NULL,
    address_type        VARCHAR(255) NOT NULL,
    district            VARCHAR(150) NOT NULL,
    city                VARCHAR(150) NOT NULL,
    province            VARCHAR(150) NOT NULL,
    modified_date       datetime     NOT NULL,
    CONSTRAINT pk_customer_address PRIMARY KEY (customer_account_id, address_id)
);

ALTER TABLE customer_address
    ADD CONSTRAINT FK_CUSTOMER_ADDRESS_ON_CUSTOMER_ACCOUNT FOREIGN KEY (customer_account_id) REFERENCES customer_account (customer_account_id);

CREATE TABLE brand
(
    brand_id      SMALLINT AUTO_INCREMENT NOT NULL,
    brand_name    VARCHAR(255)            NOT NULL,
    modified_date TIMESTAMP NOT NULL,
    CONSTRAINT pk_brand PRIMARY KEY (brand_id)
);

CREATE TABLE vendor
(
    vendor_id     SMALLINT AUTO_INCREMENT NOT NULL,
    vendor_name   VARCHAR(255)            NOT NULL,
    type          VARCHAR(50)             NOT NULL,
    modified_date datetime                NOT NULL,
    CONSTRAINT pk_vendor PRIMARY KEY (vendor_id)
);

CREATE TABLE product_category
(
    product_category_id SMALLINT AUTO_INCREMENT NOT NULL,
    name                VARCHAR(50)             NOT NULL,
    modified_date       TIMESTAMP NOT NULL,
    CONSTRAINT pk_product_category PRIMARY KEY (product_category_id)
);
ALTER TABLE product_category
    ADD CONSTRAINT uc_product_category_name UNIQUE (name);

CREATE TABLE product_subcategory
(
    product_subcategory_id SMALLINT AUTO_INCREMENT NOT NULL,
    category_id            SMALLINT                NOT NULL,
    name                   VARCHAR(50)             NOT NULL,
    modified_date          datetime                NOT NULL,
    CONSTRAINT pk_product_subcategory PRIMARY KEY (product_subcategory_id)
);

ALTER TABLE product_subcategory
    ADD CONSTRAINT FK_PRODUCT_SUBCATEGORY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES product_category (product_category_id);

-- CREATE TABLE product_category_subcategory
-- (
--     product_category_id    SMALLINT NOT NULL,
--     product_subcategory_id SMALLINT NOT NULL,
--     modified_date          TIMESTAMP NOT NULL,
--     CONSTRAINT pk_product_category_subcategory PRIMARY KEY (product_category_id, product_subcategory_id)
-- );
--
-- ALTER TABLE product_category_subcategory
--     ADD CONSTRAINT FK_PRODUCT_CATEGORY_SUBCATEGORY_ON_PRODUCT_CATEGORY FOREIGN KEY (product_category_id) REFERENCES product_category (product_category_id);
--
-- ALTER TABLE product_category_subcategory
--     ADD CONSTRAINT FK_PRODUCT_CATEGORY_SUBCATEGORY_ON_PRODUCT_SUBCATEGORY FOREIGN KEY (product_subcategory_id) REFERENCES product_subcategory (product_subcategory_id);

CREATE TABLE product
(
    product_id             SMALLINT AUTO_INCREMENT NOT NULL,
    brand_id               SMALLINT                NOT NULL,
    product_category_id    SMALLINT                NOT NULL,
    product_subcategory_id SMALLINT                NULL,
    product_name           VARCHAR(255)            NOT NULL,
    product_code           VARCHAR(255)            NULL,
    product_color          VARCHAR(255)            NULL,
    product_type           VARCHAR(255)            NOT NULL,
    safety_stock_level     INT                     NULL,
    unit_price             DOUBLE                  NOT NULL,
    standard_cost          DOUBLE                  NOT NULL,
    reorder_point          INT                     NULL,
    product_specification  TEXT                    NULL,
    sell_start_date        date                    NULL,
    sell_end_date          date                    NULL,
    view                   BIGINT                  NULL,
    modified_date          datetime                NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (product_id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_BRAND FOREIGN KEY (brand_id) REFERENCES brand (brand_id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRODUCT_CATEGORY FOREIGN KEY (product_category_id) REFERENCES product_category (product_category_id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRODUCT_SUBCATEGORY FOREIGN KEY (product_subcategory_id) REFERENCES product_subcategory (product_subcategory_id);

CREATE TABLE shopping_cart
(
    customer_account_id BIGINT   NOT NULL,
    product_id          SMALLINT NOT NULL,
    quantity            INT      NOT NULL,
    modified_date       datetime NOT NULL,
    CONSTRAINT pk_shopping_cart PRIMARY KEY (customer_account_id, product_id)
);

ALTER TABLE shopping_cart
    ADD CONSTRAINT FK_SHOPPING_CART_ON_CUSTOMER_ACCOUNT FOREIGN KEY (customer_account_id) REFERENCES customer_account (customer_account_id);

ALTER TABLE shopping_cart
    ADD CONSTRAINT FK_SHOPPING_CART_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

CREATE TABLE product_description
(
    product_id          SMALLINT NOT NULL,
    author_id           INT      NOT NULL,
    product_description TEXT     NOT NULL,
    modified_date       datetime NOT NULL,
    CONSTRAINT pk_product_description PRIMARY KEY (product_id, author_id)
);

ALTER TABLE product_description
    ADD CONSTRAINT FK_PRODUCT_DESCRIPTION_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES employee_account (employee_account_id);

ALTER TABLE product_description
    ADD CONSTRAINT FK_PRODUCT_DESCRIPTION_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

CREATE TABLE product_detail
(
    product_id    SMALLINT     NOT NULL,
    product_imei  VARCHAR(18)  NOT NULL,
    status        VARCHAR(255) NOT NULL,
    modified_date datetime     NOT NULL,
    CONSTRAINT pk_product_detail PRIMARY KEY (product_id, product_imei)
);

ALTER TABLE product_detail
    ADD CONSTRAINT FK_PRODUCT_DETAIL_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

CREATE TABLE product_photo
(
    product_photo_id INT AUTO_INCREMENT NOT NULL,
    product_id       SMALLINT           NULL,
    is_primary       BIT(1) DEFAULT 0   NULL,
    img_url          VARCHAR(1000)      NOT NULL,
    img_name         VARCHAR(255)       NULL,
    img_alt          VARCHAR(255)       NULL,
    caption          VARCHAR(2000)      NULL,
    img_type         VARCHAR(50)        NOT NULL,
    modified_date    datetime           NOT NULL,
    CONSTRAINT pk_product_photo PRIMARY KEY (product_photo_id)
);

ALTER TABLE product_photo
    ADD CONSTRAINT FK_PRODUCT_PHOTO_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

CREATE TABLE product_review
(
    product_review_id INT AUTO_INCREMENT NOT NULL,
    product_id        SMALLINT           NOT NULL,
    reviewer_name     VARCHAR(255)       NOT NULL,
    review_date       datetime           NOT NULL,
    reviewer_email    VARCHAR(255)       NULL,
    rating            SMALLINT           NOT NULL,
    comments          VARCHAR(2000)      NULL,
    is_approved       BIT DEFAULT 0      NOT NULL,
    modified_date     datetime           NOT NULL,
    CONSTRAINT pk_product_review PRIMARY KEY (product_review_id)
);

ALTER TABLE product_review
    ADD CONSTRAINT FK_PRODUCT_REVIEW_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

CREATE TABLE voucher
(
    voucher_id          SMALLINT AUTO_INCREMENT NOT NULL,
    name                VARCHAR(255)            NOT NULL,
    `description`       VARCHAR(255)            NOT NULL,
    discount_percentage DECIMAL(5, 2)           NOT NULL,
    modified_date       datetime                NOT NULL,
    CONSTRAINT pk_voucher PRIMARY KEY (voucher_id)
);

CREATE TABLE store
(
    store_id      SMALLINT AUTO_INCREMENT NOT NULL,
    store_name    VARCHAR(255)            NOT NULL,
    address       VARCHAR(255)            NOT NULL,
    modified_date datetime                NOT NULL,
    CONSTRAINT pk_store PRIMARY KEY (store_id)
);

CREATE TABLE store_inventory
(
    store_id      SMALLINT NOT NULL,
    product_id    SMALLINT NOT NULL,
    quantity      INT      NOT NULL,
    modified_date datetime NOT NULL,
    CONSTRAINT pk_store_inventory PRIMARY KEY (store_id, product_id)
);

ALTER TABLE store_inventory
    ADD CONSTRAINT FK_STORE_INVENTORY_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

ALTER TABLE store_inventory
    ADD CONSTRAINT FK_STORE_INVENTORY_ON_STORE FOREIGN KEY (store_id) REFERENCES Store (store_id);

CREATE TABLE special_offer
(
    special_offer_id    SMALLINT AUTO_INCREMENT NOT NULL,
    name                VARCHAR(255)            NOT NULL,
    `description`       VARCHAR(255)            NOT NULL,
    discount_percentage DOUBLE                  NOT NULL,
    type                VARCHAR(50)             NOT NULL,
    category            VARCHAR(50)             NOT NULL,
    start_date          date                    NOT NULL,
    end_date            date                    NOT NULL,
    min_quantity        INT                     NOT NULL,
    max_quantity        INT                     NOT NULL,
    modified_date       datetime                NOT NULL,
    CONSTRAINT pk_special_offer PRIMARY KEY (special_offer_id)
);

CREATE TABLE special_offer_product
(
    product_id       SMALLINT NOT NULL,
    special_offer_id SMALLINT NOT NULL,
    modified_date    datetime NOT NULL,
    CONSTRAINT pk_special_offer_product PRIMARY KEY (product_id, special_offer_id)
);

ALTER TABLE special_offer_product
    ADD CONSTRAINT FK_SPECIAL_OFFER_PRODUCT_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

ALTER TABLE special_offer_product
    ADD CONSTRAINT FK_SPECIAL_OFFER_PRODUCT_ON_SPECIAL_OFFER FOREIGN KEY (special_offer_id) REFERENCES special_offer (special_offer_id);

CREATE TABLE sales_person
(
    sale_person_id        BIGINT AUTO_INCREMENT NOT NULL,
    employee_account_id   INT                   NOT NULL,
    store_id              SMALLINT              NOT NULL,
    sales_quota           DECIMAL               NULL,
    bonus                 DECIMAL               NULL,
    commission_percentage DOUBLE                NULL,
    sales_ytd             DECIMAL               NULL,
    sales_last_year       DECIMAL               NULL,
    modified_date         datetime              NOT NULL,
    CONSTRAINT pk_sales_person PRIMARY KEY (sale_person_id)
);

ALTER TABLE sales_person
    ADD CONSTRAINT FK_SALES_PERSON_ON_EMPLOYEE_ACCOUNT FOREIGN KEY (employee_account_id) REFERENCES employee_account (employee_account_id);

ALTER TABLE sales_person
    ADD CONSTRAINT FK_SALES_PERSON_ON_STORE FOREIGN KEY (store_id) REFERENCES store (store_id);

CREATE TABLE sales_person_quota_history
(
    sale_person_id BIGINT   NOT NULL,
    quota_date     date     NOT NULL,
    sales_quota    DECIMAL  NOT NULL,
    modified_date  datetime NOT NULL,
    CONSTRAINT pk_sales_person_quota_history PRIMARY KEY (sale_person_id, quota_date)
);

ALTER TABLE sales_person_quota_history
    ADD CONSTRAINT FK_SALES_PERSON_QUOTA_HISTORY_ON_SALE_PERSON FOREIGN KEY (sale_person_id) REFERENCES sales_person (sale_person_id);

CREATE TABLE payment_method
(
    payment_method_id INT AUTO_INCREMENT NOT NULL,
    name              VARCHAR(50)        NOT NULL,
    `description`     VARCHAR(255)       NOT NULL,
    modified_date     datetime           NOT NULL,
    CONSTRAINT pk_payment_method PRIMARY KEY (payment_method_id)
);

CREATE TABLE sales_order_header
(
    order_header_id   BIGINT AUTO_INCREMENT NOT NULL,
    sales_person_id   BIGINT                NOT NULL,
    customer_id       BIGINT                NOT NULL,
    credit_card_id    BIGINT                NULL,
    payment_method_id INT                   NOT NULL,
    voucher_id        SMALLINT              NOT NULL,
    order_date        datetime              NOT NULL,
    due_date          date                  NOT NULL,
    order_status      VARCHAR(255)          NOT NULL,
    online_order_flag BIT(1) DEFAULT 0      NULL,
    sub_total         DECIMAL               NOT NULL,
    tax_amount        DECIMAL               NOT NULL,
    voucher_discount  DECIMAL               NOT NULL,
    total_due         DECIMAL               NOT NULL,
    comment           VARCHAR(2000)         NULL,
    modified_date     datetime              NOT NULL,
    CONSTRAINT pk_sales_order_header PRIMARY KEY (order_header_id)
);

ALTER TABLE sales_order_header
    ADD CONSTRAINT FK_SALES_ORDER_HEADER_ON_CREDIT_CARD FOREIGN KEY (credit_card_id) REFERENCES credit_card (credit_card_id);

ALTER TABLE sales_order_header
    ADD CONSTRAINT FK_SALES_ORDER_HEADER_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

ALTER TABLE sales_order_header
    ADD CONSTRAINT FK_SALES_ORDER_HEADER_ON_PAYMENT_METHOD FOREIGN KEY (payment_method_id) REFERENCES payment_method (payment_method_id);

ALTER TABLE sales_order_header
    ADD CONSTRAINT FK_SALES_ORDER_HEADER_ON_SALES_PERSON FOREIGN KEY (sales_person_id) REFERENCES sales_person (sale_person_id);

ALTER TABLE sales_order_header
    ADD CONSTRAINT FK_SALES_ORDER_HEADER_ON_VOUCHER FOREIGN KEY (voucher_id) REFERENCES voucher (voucher_id);

CREATE TABLE sales_order_detail
(
    sales_order_id      BIGINT   NOT NULL,
    product_id          SMALLINT NOT NULL,
    special_offer_id    SMALLINT NOT NULL,
    quantity            INT      NOT NULL,
    unit_price          DECIMAL  NOT NULL,
    unit_price_discount DECIMAL  NOT NULL,
    line_total          DECIMAL  NOT NULL,
    modified_date       datetime NOT NULL,
    CONSTRAINT pk_sales_order_detail PRIMARY KEY (sales_order_id, product_id)
);

ALTER TABLE sales_order_detail
    ADD CONSTRAINT FK_SALES_ORDER_DETAIL_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (product_id);

ALTER TABLE sales_order_detail
    ADD CONSTRAINT FK_SALES_ORDER_DETAIL_ON_SALES_ORDER FOREIGN KEY (sales_order_id) REFERENCES sales_order_header (order_header_id);

ALTER TABLE sales_order_detail
    ADD CONSTRAINT FK_SALES_ORDER_DETAIL_ON_SPECIAL_OFFER FOREIGN KEY (special_offer_id) REFERENCES special_offer (special_offer_id);

CREATE TABLE delivery
(
    delivery_id            BIGINT AUTO_INCREMENT NOT NULL,
    order_header_id        BIGINT                NOT NULL,
    shipper_id             INT                   NOT NULL,
    ship_date              date                  NULL,
    recipient_address      VARCHAR(255)          NOT NULL,
    recipient_phone_number VARCHAR(15)           NOT NULL,
    delivery_status        VARCHAR(255)          NOT NULL,
    comments               VARCHAR(255)          NULL,
    modified_date          datetime              NOT NULL,
    CONSTRAINT pk_delivery PRIMARY KEY (delivery_id)
);

ALTER TABLE delivery
    ADD CONSTRAINT FK_DELIVERY_ON_ORDER_HEADER FOREIGN KEY (order_header_id) REFERENCES sales_order_header (order_header_id);

ALTER TABLE delivery
    ADD CONSTRAINT FK_DELIVERY_ON_SHIPPER FOREIGN KEY (shipper_id) REFERENCES employee_account (employee_account_id);
