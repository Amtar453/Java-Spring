INSERT INTO payment_state VALUES
    ('Créé', 'Created'),
    ('Payé', 'Paid'),
    ('Envoyé', 'Shipped'),
    ('Reçu', 'Received'),
    ('Annulé', 'Cancelled');

INSERT INTO category(label_fr, label_en) VALUES
    ('Figurines', 'Figures'),
    ('Vêtements', 'Clothing'),
    ('Peluches', 'Plushies'),
    ('Accessoires', 'Accessories'),
    ('Goodies Manga', 'Manga Goodies');

INSERT INTO product(name_fr, name_en, quantityStock, unitary_price, category_id) VALUES
    ('Figurine Monkey D. Luffy - Gear 5', 'Monkey D. Luffy Figure - Gear 5', 15, 59.90, 1),
    ('Figurine Nendoroid Nezuko Kamado', 'Nendoroid Nezuko Kamado Figure', 20, 44.90, 1),
    ('Figurine Eren Yeager Titan', 'Eren Yeager Titan Form Figure', 8, 129.00, 1),
    ('Figurine Son Goku Super Saiyan Blue', 'Son Goku Super Saiyan Blue Figure', 12, 69.90, 1),
    ('Figurine Gojo Satoru', 'Gojo Satoru Figure', 10, 74.90, 1),
    ('T-shirt Naruto Akatsuki', 'Naruto Akatsuki T-shirt', 40, 24.90, 2),
    ('Hoodie Chainsaw Man Denji', 'Chainsaw Man Denji Hoodie', 25, 49.90, 2),
    ('T-shirt My Hero Academia Deku', 'My Hero Academia Deku T-shirt', 35, 22.90, 2),
    ('Casquette Attack on Titan', 'Attack on Titan Cap', 18, 19.90, 2),
    ('Peluche Pikachu', 'Pikachu Plush', 30, 19.90, 3),
    ('Peluche Totoro', 'Totoro Plush', 22, 24.90, 3),
    ('Peluche Chopper', 'Chopper Plush', 28, 21.90, 3),
    ('Porte-clés Death Note', 'Death Note Keychain', 50, 8.90, 4),
    ('Mug thermosensible Sailor Moon', 'Sailor Moon Heat-change Mug', 26, 16.90, 4),
    ('Sac banane Spy x Family Anya', 'Spy x Family Anya Fanny Pack', 16, 27.90, 4),
    ('Coque téléphone One Piece', 'One Piece Phone Case', 45, 14.90, 4),
    ('Coffret manga Jujutsu Kaisen T1-3', 'Jujutsu Kaisen Manga Box Vol 1-3', 10, 34.90, 5),
    ('Artbook Demon Slayer', 'Demon Slayer Artbook', 14, 39.90, 5),
    ('Poster A2 Attack on Titan', 'Attack on Titan A2 Poster', 60, 9.90, 5),
    ('Pin''s collector One Piece', 'One Piece Collector Pins', 33, 12.90, 5);