CREATE TABLE IF NOT EXISTS Pipproduct ( 
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    price DOUBLE,
    image VARCHAR(255),
    stock INT,
    quantity INT,
    maincategory VARCHAR(255),
    averagerating DOUBLE,
    ratingnumber INT,
    features VARCHAR(255),
    store VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Review ( 
    id INT AUTO_INCREMENT PRIMARY KEY,
    rating DOUBLE,
    title VARCHAR(255),
    text VARCHAR(255),
    image VARCHAR(255),
    asin VARCHAR(255),
    parentasin VARCHAR(255),
    userid VARCHAR(255)
);
