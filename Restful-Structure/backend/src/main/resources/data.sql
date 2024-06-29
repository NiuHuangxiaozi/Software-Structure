INSERT INTO categories (id, name)
SELECT 0, 'electronicProduct'
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 0);

INSERT INTO categories (id, name)
SELECT 1, 'furniture'
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 1);

INSERT INTO categories (id, name)
SELECT 2, 'householdItem'
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 2);

INSERT INTO categories (id, name)
SELECT 3, 'clothes'
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 3);